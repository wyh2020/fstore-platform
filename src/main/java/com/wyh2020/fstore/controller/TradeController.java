package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.base.controller.BaseController;
import com.wyh2020.fstore.base.response.CentreCutPageResponse;
import com.wyh2020.fstore.base.response.CentreListResponse;
import com.wyh2020.fstore.base.response.ResponseEntity;
import com.wyh2020.fstore.base.util.CopyUtil;
import com.wyh2020.fstore.base.util.UUIDUtil;
import com.wyh2020.fstore.condition.trade.TradeCondition;
import com.wyh2020.fstore.exception.GateWayException;
import com.wyh2020.fstore.form.trade.TradeCreateForm;
import com.wyh2020.fstore.form.trade.TradeQueryForm;
import com.wyh2020.fstore.form.trade.TradeUpdateForm;
import com.wyh2020.fstore.po.trade.TradePo;
import com.wyh2020.fstore.service.TradeService;
import com.wyh2020.fstore.vo.trade.TradeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/od/trade")
@Api(value = "/od/trade", description = "")
public class TradeController extends BaseController {

	@Autowired
	private TradeService tradeService;

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
	ResponseEntity<CentreCutPageResponse<TradeVo>> queryPageList(@ModelAttribute@Valid TradeQueryForm form) throws GateWayException {
		TradeCondition condition = this.getConditionByQueryForm(form);
		List<TradeVo> voList = new ArrayList<>();
		int count = tradeService.queryCount(condition);
		if (count > 0) {
			List<TradePo> poList = tradeService.queryList(condition);
			voList = CopyUtil.transfer(poList, TradeVo.class);
		}
		return getSuccessResult(getPageResponse(form, count, voList));
	}

	@ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<TradeVo> add(@ModelAttribute@Valid TradeCreateForm form) throws GateWayException {
		TradePo po = CopyUtil.transfer(form, TradePo.class);
		po.setTradeno(UUIDUtil.getUUID());
		tradeService.insert(po);
		TradeVo vo = CopyUtil.transfer(po, TradeVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改",notes = "修改",httpMethod = "POST")
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity update(@ModelAttribute@Valid TradeUpdateForm form) throws GateWayException {
		TradePo po = CopyUtil.transfer(form, TradePo.class);
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