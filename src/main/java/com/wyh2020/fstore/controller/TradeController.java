package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.base.constants.Constants;
import com.wyh2020.fstore.base.controller.BaseController;
import com.wyh2020.fstore.base.response.CentreCutPageResponse;
import com.wyh2020.fstore.base.response.CentreListResponse;
import com.wyh2020.fstore.base.response.ResponseEntity;
import com.wyh2020.fstore.base.util.CopyUtil;
import com.wyh2020.fstore.bo.trade.TradeBo;
import com.wyh2020.fstore.condition.evaluate.EvaluateCondition;
import com.wyh2020.fstore.condition.good.GoodCondition;
import com.wyh2020.fstore.condition.trade.TradeCondition;
import com.wyh2020.fstore.entity.JwtUser;
import com.wyh2020.fstore.exception.GateWayException;
import com.wyh2020.fstore.form.trade.TradeCreateForm;
import com.wyh2020.fstore.form.trade.TradeQueryForm;
import com.wyh2020.fstore.form.trade.TradeUpdateForm;
import com.wyh2020.fstore.po.good.GoodPo;
import com.wyh2020.fstore.po.shop.ShopPo;
import com.wyh2020.fstore.po.trade.TradePo;
import com.wyh2020.fstore.service.*;
import com.wyh2020.fstore.util.DateUtil;
import com.wyh2020.fstore.vo.trade.TradeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/od/trade")
@Api(value = "/od/trade", description = "")
public class TradeController extends BaseController {

	@Autowired
	private TradeService tradeService;
	@Autowired
	private CartService cartService;
	@Autowired
	private GoodService goodService;
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private ShopService shopService;

	@ApiOperation(value = "查询",notes = "查询",httpMethod = "GET")
	@RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<TradeVo> query(@ApiParam(value = "订单编号", required = true)@RequestParam String tradeno) throws GateWayException {
		TradePo po = tradeService.queryWithValid(tradeno);
		TradeVo vo = CopyUtil.transfer(po, TradeVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询数量",notes = "查询数量",httpMethod = "GET")
	@RequestMapping(value = "/queryCount", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<Integer> queryCount(@ModelAttribute@Valid TradeQueryForm form) throws GateWayException {
		TradeCondition condition = this.getConditionByQueryForm(form);
		int count = tradeService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询列表",notes = "查询列表",httpMethod = "GET")
	@RequestMapping(value = "/queryList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreListResponse<TradeVo>> queryList(@ModelAttribute@Valid TradeQueryForm form) throws GateWayException {
		TradeCondition condition = this.getConditionByQueryForm(form);
		List<TradePo> poList = tradeService.queryList(condition);
		List<TradeVo> voList = CopyUtil.transfer(poList, TradeVo.class);
		return getSuccessResult(getListResponse(voList));
	}

	@ApiOperation(value = "查询列表(带分页)",notes = "查询列表(带分页)",httpMethod = "GET")
	@RequestMapping(value = "/queryPageList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreCutPageResponse<TradeBo>> queryPageList(@ModelAttribute@Valid TradeQueryForm form) throws GateWayException {
		TradeCondition condition = this.getConditionByQueryForm(form);
		List<TradeVo> voList = new ArrayList<>();
		List<TradeBo> boList = new ArrayList<>();
		int count = tradeService.queryCount(condition);
		if (count > 0) {
			List<TradePo> poList = tradeService.queryList(condition);
			voList = CopyUtil.transfer(poList, TradeVo.class);
			if (!CollectionUtils.isEmpty(voList)) {
				voList.stream().forEach(c -> {
					GoodCondition goodCondition = new GoodCondition();
					goodCondition.setGoodidList(Arrays.asList(c.getGoodids().split(",")));
					List<GoodPo> goodPoList = goodService.queryList(goodCondition);
					TradeBo tradeBo = CopyUtil.transfer(c, TradeBo.class);
					EvaluateCondition evaluateCondition = new EvaluateCondition();
					evaluateCondition.setTradeno(tradeBo.getTradeno());
					int count1 = evaluateService.queryCount(evaluateCondition);
					tradeBo.setEvaluateState(count1 > 0 ? Constants.EvaluateState.Evaluated : Constants.EvaluateState.UnEvaluate);
					tradeBo.setGoodList(goodPoList);
					ShopPo shopPo = shopService.queryWithValid(c.getShopcode());
					tradeBo.setShopPo(shopPo);
					boList.add(tradeBo);
				});
			}
		}
		return getSuccessResult(getPageResponse(form, count, boList));
	}

	@ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<TradeVo> add(@RequestBody@Valid TradeCreateForm form, BindingResult result, HttpServletRequest request) throws GateWayException {
		TradePo po = CopyUtil.transfer(form, TradePo.class);
		JwtUser jwtUser = this.checkLogin(request);
		String userCode = jwtUser.getUserCode();
		String tradeNo = "T" + DateUtil.getCurrentDate("yyyyMMddhhmmss") + tradeService.queryTradeNo();
		po.setTradeno(tradeNo);
		// 计算价格
		GoodCondition condition = new GoodCondition();
		condition.setGoodidList(Arrays.asList(form.getGoodids().split(",")));
		List<GoodPo> poList = goodService.queryList(condition);
		BigDecimal totalPrice = BigDecimal.ZERO;
		String sums = "";
		for(GoodPo goodPo: poList){
			totalPrice = totalPrice.add(goodPo.getPrice().multiply(BigDecimal.valueOf(form.getGoodsMap().get(goodPo.getGoodid()))));
			sums = sums + (StringUtils.isNotBlank(sums) ? (","+form.getGoodsMap().get(goodPo.getGoodid())) : form.getGoodsMap().get(goodPo.getGoodid()).toString());
		}
//		Double d = poList.stream().mapToDouble(c -> c.getPrice().doubleValue()).sum();
		System.out.println(totalPrice);
		po.setPrice(totalPrice);
		po.setSums(sums);
		po.setState(Constants.TradeState.UnPay);
		po.setUsercode(userCode);
		po.setCreater(userCode);
		po.setCreatetime(new Date());
		tradeService.insert(po);
		TradeVo vo = CopyUtil.transfer(po, TradeVo.class);
		// 删除购物车相应的数据
		String[] list = form.getCartids().split(",");
		cartService.deleteList(list);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改",notes = "修改",httpMethod = "POST")
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity update(@RequestBody@Valid TradeUpdateForm form, BindingResult result, HttpServletRequest request) throws GateWayException {
		TradePo po = CopyUtil.transfer(form, TradePo.class);
		JwtUser jwtUser = this.checkLogin(request);
		String userCode = jwtUser.getUserCode();
		po.setUpdater(userCode);
		po.setUpdatetime(new Date());
		tradeService.update(po);
		return getSuccessResult();
	}

	@ApiOperation(value = "删除",notes = "删除",httpMethod = "POST")
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity delete(@ApiParam(value = "订单编号", required = true)@RequestParam String tradeno) throws GateWayException {
		tradeService.delete(tradeno);
		return getSuccessResult();
	}

	/**
	 * TradeQueryForm转换为TradeCondition
	 *
	 * @param form
	 * @return
	 */
	private TradeCondition getConditionByQueryForm(TradeQueryForm form) {
		TradeCondition condition = CopyUtil.transfer(form, TradeCondition.class);
		return condition;
	}

}