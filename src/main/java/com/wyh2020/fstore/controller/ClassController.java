package com.wyh2020.fstore.controller;


import com.wyh2020.fstore.base.controller.BaseController;
import com.wyh2020.fstore.base.response.CentreCutPageResponse;
import com.wyh2020.fstore.base.response.CentreListResponse;
import com.wyh2020.fstore.base.response.ResponseEntity;
import com.wyh2020.fstore.base.util.CopyUtil;
import com.wyh2020.fstore.condition.classs.ClassCondition;
import com.wyh2020.fstore.exception.GateWayException;
import com.wyh2020.fstore.form.classs.ClassCreateForm;
import com.wyh2020.fstore.form.classs.ClassQueryForm;
import com.wyh2020.fstore.form.classs.ClassUpdateForm;
import com.wyh2020.fstore.po.classs.ClassPo;
import com.wyh2020.fstore.service.ClassService;
import com.wyh2020.fstore.vo.classs.ClassVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/od/class")
@Api(value = "/od/class", description = "")
public class ClassController extends BaseController {

	@Autowired
	private ClassService classService;

	@ApiOperation(value = "查询",notes = "查询",httpMethod = "GET")
	@RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<ClassVo> query(@ApiParam(value = "ID ", required = true)@RequestParam Integer id) throws GateWayException {
		ClassPo po = classService.queryWithValid(id);
		ClassVo vo = CopyUtil.transfer(po, ClassVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询数量",notes = "查询数量",httpMethod = "GET")
	@RequestMapping(value = "/queryCount", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<Integer> queryCount(@ModelAttribute@Valid ClassQueryForm form) throws GateWayException {
		ClassCondition condition = this.getConditionByQueryForm(form);
		int count = classService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询列表",notes = "查询列表",httpMethod = "GET")
	@RequestMapping(value = "/queryList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreListResponse<ClassVo>> queryList(@ModelAttribute@Valid ClassQueryForm form) throws GateWayException {
		ClassCondition condition = this.getConditionByQueryForm(form);
		List<ClassPo> poList = classService.queryList(condition);
		List<ClassVo> voList = CopyUtil.transfer(poList, ClassVo.class);
		return getSuccessResult(getListResponse(voList));
	}

	@ApiOperation(value = "查询列表(带分页)",notes = "查询列表(带分页)",httpMethod = "GET")
	@RequestMapping(value = "/queryPageList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreCutPageResponse<ClassVo>> queryPageList(@ModelAttribute@Valid ClassQueryForm form) throws GateWayException {
		ClassCondition condition = this.getConditionByQueryForm(form);
		List<ClassVo> voList = new ArrayList<>();
		int count = classService.queryCount(condition);
		if (count > 0) {
			List<ClassPo> poList = classService.queryList(condition);
			voList = CopyUtil.transfer(poList, ClassVo.class);
		}
		return getSuccessResult(getPageResponse(form, count, voList));
	}

	@ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<ClassVo> add(@RequestBody@Valid ClassCreateForm form) throws GateWayException {
		ClassPo po = CopyUtil.transfer(form, ClassPo.class);
		po.setState(1);
		classService.insert(po);
		ClassVo vo = CopyUtil.transfer(po, ClassVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改",notes = "修改",httpMethod = "POST")
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity update(@RequestBody@Valid ClassUpdateForm form) throws GateWayException {
		ClassPo po = CopyUtil.transfer(form, ClassPo.class);
		classService.update(po);
		return getSuccessResult();
	}

	@ApiOperation(value = "删除",notes = "删除",httpMethod = "POST")
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity delete(@ApiParam(value = "ID ", required = true)@RequestParam Integer id) throws GateWayException {
		classService.delete(id);
		return getSuccessResult();
	}

	/**
	 * ClassQueryForm转换为ClassCondition
	 *
	 * @param form
	 * @return
	 */
	private ClassCondition getConditionByQueryForm(ClassQueryForm form) {
		ClassCondition condition = CopyUtil.transfer(form, ClassCondition.class);
		return condition;
	}

}