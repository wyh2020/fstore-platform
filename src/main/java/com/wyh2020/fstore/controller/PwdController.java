package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.base.controller.BaseController;
import com.wyh2020.fstore.base.response.CentreCutPageResponse;
import com.wyh2020.fstore.base.response.CentreListResponse;
import com.wyh2020.fstore.base.response.ResponseEntity;
import com.wyh2020.fstore.base.util.CopyUtil;
import com.wyh2020.fstore.base.util.UUIDUtil;
import com.wyh2020.fstore.condition.pwd.PwdCondition;
import com.wyh2020.fstore.exception.GateWayException;
import com.wyh2020.fstore.form.pwd.PwdCreateForm;
import com.wyh2020.fstore.form.pwd.PwdQueryForm;
import com.wyh2020.fstore.form.pwd.PwdUpdateForm;
import com.wyh2020.fstore.po.pwd.PwdPo;
import com.wyh2020.fstore.service.PwdService;
import com.wyh2020.fstore.vo.pwd.PwdVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/od/pwd")
@Api(value = "/od/pwd", description = "")
public class PwdController extends BaseController {

	@Autowired
	private PwdService pwdService;

	@ApiOperation(value = "查询",notes = "查询",httpMethod = "GET")
	@RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<PwdVo> query(@ApiParam(value = "", required = true)@RequestParam String id) throws GateWayException {
		PwdPo po = pwdService.queryWithValid(id);
		PwdVo vo = CopyUtil.transfer(po, PwdVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询数量",notes = "查询数量",httpMethod = "GET")
	@RequestMapping(value = "/queryCount", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<Integer> queryCount(@ModelAttribute@Valid PwdQueryForm form) throws GateWayException {
		PwdCondition condition = this.getConditionByQueryForm(form);
		int count = pwdService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询列表",notes = "查询列表",httpMethod = "GET")
	@RequestMapping(value = "/queryList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreListResponse<PwdVo>> queryList(@ModelAttribute@Valid PwdQueryForm form) throws GateWayException {
		PwdCondition condition = this.getConditionByQueryForm(form);
		List<PwdPo> poList = pwdService.queryList(condition);
		List<PwdVo> voList = CopyUtil.transfer(poList, PwdVo.class);
		return getSuccessResult(getListResponse(voList));
	}

	@ApiOperation(value = "查询列表(带分页)",notes = "查询列表(带分页)",httpMethod = "GET")
	@RequestMapping(value = "/queryPageList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreCutPageResponse<PwdVo>> queryPageList(@ModelAttribute@Valid PwdQueryForm form) throws GateWayException {
		PwdCondition condition = this.getConditionByQueryForm(form);
		List<PwdVo> voList = new ArrayList<>();
		int count = pwdService.queryCount(condition);
		if (count > 0) {
			List<PwdPo> poList = pwdService.queryList(condition);
			voList = CopyUtil.transfer(poList, PwdVo.class);
		}
		return getSuccessResult(getPageResponse(form, count, voList));
	}

	@ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<PwdVo> add(@ModelAttribute@Valid PwdCreateForm form) throws GateWayException {
		PwdPo po = CopyUtil.transfer(form, PwdPo.class);
		po.setId(UUIDUtil.getUUID());
		pwdService.insert(po);
		PwdVo vo = CopyUtil.transfer(po, PwdVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改",notes = "修改",httpMethod = "POST")
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity update(@ModelAttribute@Valid PwdUpdateForm form) throws GateWayException {
		PwdPo po = CopyUtil.transfer(form, PwdPo.class);
		pwdService.update(po);
		return getSuccessResult();
	}

	@ApiOperation(value = "删除",notes = "删除",httpMethod = "POST")
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity delete(@ApiParam(value = "", required = true)@RequestParam String id) throws GateWayException {
		pwdService.delete(id);
		return getSuccessResult();
	}

	/**
	 * PwdQueryForm转换为PwdCondition
	 *
	 * @param form
	 * @return
	 */
	private PwdCondition getConditionByQueryForm(PwdQueryForm form) {
		PwdCondition condition = CopyUtil.transfer(form, PwdCondition.class);
		return condition;
	}

}