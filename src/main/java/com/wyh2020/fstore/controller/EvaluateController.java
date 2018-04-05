package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.base.controller.BaseController;
import com.wyh2020.fstore.base.response.CentreCutPageResponse;
import com.wyh2020.fstore.base.response.CentreListResponse;
import com.wyh2020.fstore.base.response.ResponseEntity;
import com.wyh2020.fstore.base.util.CopyUtil;
import com.wyh2020.fstore.base.util.UUIDUtil;
import com.wyh2020.fstore.condition.evaluate.EvaluateCondition;
import com.wyh2020.fstore.entity.JwtUser;
import com.wyh2020.fstore.exception.GateWayException;
import com.wyh2020.fstore.form.evaluate.EvaluateCreateForm;
import com.wyh2020.fstore.form.evaluate.EvaluateQueryForm;
import com.wyh2020.fstore.form.evaluate.EvaluateUpdateForm;
import com.wyh2020.fstore.po.evaluate.EvaluatePo;
import com.wyh2020.fstore.po.trade.TradePo;
import com.wyh2020.fstore.service.EvaluateService;
import com.wyh2020.fstore.service.TradeService;
import com.wyh2020.fstore.vo.evaluate.EvaluateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/od/evaluate")
@Api(value = "/od/evaluate", description = "")
public class EvaluateController extends BaseController {

	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private TradeService tradeService;

	@ApiOperation(value = "查询",notes = "查询",httpMethod = "GET")
	@RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<EvaluateVo> query(@ApiParam(value = "评价编号", required = true)@RequestParam String id) throws GateWayException {
		EvaluatePo po = evaluateService.queryWithValid(id);
		EvaluateVo vo = CopyUtil.transfer(po, EvaluateVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询数量",notes = "查询数量",httpMethod = "GET")
	@RequestMapping(value = "/queryCount", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<Integer> queryCount(@ModelAttribute@Valid EvaluateQueryForm form) throws GateWayException {
		EvaluateCondition condition = this.getConditionByQueryForm(form);
		int count = evaluateService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询列表",notes = "查询列表",httpMethod = "GET")
	@RequestMapping(value = "/queryList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreListResponse<EvaluateVo>> queryList(@ModelAttribute@Valid EvaluateQueryForm form) throws GateWayException {
		EvaluateCondition condition = this.getConditionByQueryForm(form);
		List<EvaluatePo> poList = evaluateService.queryList(condition);
		List<EvaluateVo> voList = CopyUtil.transfer(poList, EvaluateVo.class);
		return getSuccessResult(getListResponse(voList));
	}

	@ApiOperation(value = "查询列表(带分页)",notes = "查询列表(带分页)",httpMethod = "GET")
	@RequestMapping(value = "/queryPageList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreCutPageResponse<EvaluateVo>> queryPageList(@ModelAttribute@Valid EvaluateQueryForm form) throws GateWayException {
		EvaluateCondition condition = this.getConditionByQueryForm(form);
		List<EvaluateVo> voList = new ArrayList<>();
		int count = evaluateService.queryCount(condition);
		if (count > 0) {
			List<EvaluatePo> poList = evaluateService.queryList(condition);
			voList = CopyUtil.transfer(poList, EvaluateVo.class);
		}
		return getSuccessResult(getPageResponse(form, count, voList));
	}

	@ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<EvaluateVo> add(@RequestBody@Valid EvaluateCreateForm form, BindingResult result, HttpServletRequest request) throws GateWayException {
		EvaluatePo po = CopyUtil.transfer(form, EvaluatePo.class);
		JwtUser jwtUser = this.checkLogin(request);
		String tradeno = form.getTradeno();
		if(StringUtils.isBlank(tradeno)){
			return getFailResult("没有订单需要评价！");
		}
		TradePo tradePo = tradeService.query(tradeno);
		String userCode = jwtUser.getUserCode();
		po.setId(UUIDUtil.getUUID());
		po.setUsercode(userCode);
		po.setCreater(userCode);
		po.setShopcode(tradePo.getShopcode());
		po.setGoodids(tradePo.getGoodids());
		po.setPrice(tradePo.getPrice());
		po.setCreatetime(new Date());
		evaluateService.insert(po);
		EvaluateVo vo = CopyUtil.transfer(po, EvaluateVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改",notes = "修改",httpMethod = "POST")
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity update(@ModelAttribute@Valid EvaluateUpdateForm form) throws GateWayException {
		EvaluatePo po = CopyUtil.transfer(form, EvaluatePo.class);
		evaluateService.update(po);
		return getSuccessResult();
	}

	@ApiOperation(value = "删除",notes = "删除",httpMethod = "POST")
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity delete(@ApiParam(value = "评价编号", required = true)@RequestParam String id) throws GateWayException {
		evaluateService.delete(id);
		return getSuccessResult();
	}

	/**
	 * EvaluateQueryForm转换为EvaluateCondition
	 *
	 * @param form
	 * @return
	 */
	private EvaluateCondition getConditionByQueryForm(EvaluateQueryForm form) {
		EvaluateCondition condition = CopyUtil.transfer(form, EvaluateCondition.class);
		return condition;
	}

}