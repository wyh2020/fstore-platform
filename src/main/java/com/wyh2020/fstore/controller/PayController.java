package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.base.controller.BaseController;
import com.wyh2020.fstore.base.response.CentreCutPageResponse;
import com.wyh2020.fstore.base.response.CentreListResponse;
import com.wyh2020.fstore.base.response.ResponseEntity;
import com.wyh2020.fstore.base.util.CopyUtil;
import com.wyh2020.fstore.base.util.UUIDUtil;
import com.wyh2020.fstore.condition.pay.PayCondition;
import com.wyh2020.fstore.exception.GateWayException;
import com.wyh2020.fstore.form.pay.PayCreateForm;
import com.wyh2020.fstore.form.pay.PayQueryForm;
import com.wyh2020.fstore.form.pay.PayUpdateForm;
import com.wyh2020.fstore.po.pay.PayPo;
import com.wyh2020.fstore.service.PayService;
import com.wyh2020.fstore.vo.pay.PayVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/od/pay")
@Api(value = "/od/pay", description = "")
public class PayController extends BaseController {

	@Autowired
	private PayService payService;

	@ApiOperation(value = "查询",notes = "查询",httpMethod = "GET")
	@RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<PayVo> query(@ApiParam(value = "支付记录编号", required = true)@RequestParam String id) throws GateWayException {
		PayPo po = payService.queryWithValid(id);
		PayVo vo = CopyUtil.transfer(po, PayVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询数量",notes = "查询数量",httpMethod = "GET")
	@RequestMapping(value = "/queryCount", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<Integer> queryCount(@ModelAttribute@Valid PayQueryForm form) throws GateWayException {
		PayCondition condition = this.getConditionByQueryForm(form);
		int count = payService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询列表",notes = "查询列表",httpMethod = "GET")
	@RequestMapping(value = "/queryList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreListResponse<PayVo>> queryList(@ModelAttribute@Valid PayQueryForm form) throws GateWayException {
		PayCondition condition = this.getConditionByQueryForm(form);
		List<PayPo> poList = payService.queryList(condition);
		List<PayVo> voList = CopyUtil.transfer(poList, PayVo.class);
		return getSuccessResult(getListResponse(voList));
	}

	@ApiOperation(value = "查询列表(带分页)",notes = "查询列表(带分页)",httpMethod = "GET")
	@RequestMapping(value = "/queryPageList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreCutPageResponse<PayVo>> queryPageList(@ModelAttribute@Valid PayQueryForm form) throws GateWayException {
		PayCondition condition = this.getConditionByQueryForm(form);
		List<PayVo> voList = new ArrayList<>();
		int count = payService.queryCount(condition);
		if (count > 0) {
			List<PayPo> poList = payService.queryList(condition);
			voList = CopyUtil.transfer(poList, PayVo.class);
		}
		return getSuccessResult(getPageResponse(form, count, voList));
	}

	@ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<PayVo> add(@ModelAttribute@Valid PayCreateForm form) throws GateWayException {
		PayPo po = CopyUtil.transfer(form, PayPo.class);
		po.setId(UUIDUtil.getUUID());
		payService.insert(po);
		PayVo vo = CopyUtil.transfer(po, PayVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改",notes = "修改",httpMethod = "POST")
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity update(@ModelAttribute@Valid PayUpdateForm form) throws GateWayException {
		PayPo po = CopyUtil.transfer(form, PayPo.class);
		payService.update(po);
		return getSuccessResult();
	}

	@ApiOperation(value = "删除",notes = "删除",httpMethod = "POST")
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity delete(@ApiParam(value = "支付记录编号", required = true)@RequestParam String id) throws GateWayException {
		payService.delete(id);
		return getSuccessResult();
	}

	/**
	 * PayQueryForm转换为PayCondition
	 *
	 * @param form
	 * @return
	 */
	private PayCondition getConditionByQueryForm(PayQueryForm form) {
		PayCondition condition = CopyUtil.transfer(form, PayCondition.class);
		return condition;
	}

}