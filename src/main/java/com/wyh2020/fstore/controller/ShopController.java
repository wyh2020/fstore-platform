package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.base.controller.BaseController;
import com.wyh2020.fstore.base.response.CentreCutPageResponse;
import com.wyh2020.fstore.base.response.CentreListResponse;
import com.wyh2020.fstore.base.response.ResponseEntity;
import com.wyh2020.fstore.base.util.CopyUtil;
import com.wyh2020.fstore.base.util.UUIDUtil;
import com.wyh2020.fstore.condition.shop.ShopCondition;
import com.wyh2020.fstore.exception.GateWayException;
import com.wyh2020.fstore.form.shop.ShopCreateForm;
import com.wyh2020.fstore.form.shop.ShopQueryForm;
import com.wyh2020.fstore.form.shop.ShopUpdateForm;
import com.wyh2020.fstore.po.shop.ShopPo;
import com.wyh2020.fstore.service.ShopService;
import com.wyh2020.fstore.vo.shop.ShopVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/od/shop")
@Api(value = "/od/shop", description = "")
public class ShopController extends BaseController {

	@Autowired
	private ShopService shopService;

	@ApiOperation(value = "查询",notes = "查询",httpMethod = "GET")
	@RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<ShopVo> query(@ApiParam(value = "门店编号", required = true)@RequestParam String shopcode) throws GateWayException {
		ShopPo po = shopService.queryWithValid(shopcode);
		ShopVo vo = CopyUtil.transfer(po, ShopVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询数量",notes = "查询数量",httpMethod = "GET")
	@RequestMapping(value = "/queryCount", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<Integer> queryCount(@ModelAttribute@Valid ShopQueryForm form) throws GateWayException {
		ShopCondition condition = this.getConditionByQueryForm(form);
		int count = shopService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询列表",notes = "查询列表",httpMethod = "GET")
	@RequestMapping(value = "/queryList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreListResponse<ShopVo>> queryList(@ModelAttribute@Valid ShopQueryForm form) throws GateWayException {
		ShopCondition condition = this.getConditionByQueryForm(form);
		List<ShopPo> poList = shopService.queryList(condition);
		List<ShopVo> voList = CopyUtil.transfer(poList, ShopVo.class);
		return getSuccessResult(getListResponse(voList));
	}

	@ApiOperation(value = "查询列表(带分页)",notes = "查询列表(带分页)",httpMethod = "GET")
	@RequestMapping(value = "/queryPageList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreCutPageResponse<ShopVo>> queryPageList(@ModelAttribute@Valid ShopQueryForm form) throws GateWayException {
		ShopCondition condition = this.getConditionByQueryForm(form);
		List<ShopVo> voList = new ArrayList<>();
		int count = shopService.queryCount(condition);
		if (count > 0) {
			List<ShopPo> poList = shopService.queryList(condition);
			voList = CopyUtil.transfer(poList, ShopVo.class);
		}
		return getSuccessResult(getPageResponse(form, count, voList));
	}

	@ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<ShopVo> add(@ModelAttribute@Valid ShopCreateForm form) throws GateWayException {
		ShopPo po = CopyUtil.transfer(form, ShopPo.class);
		po.setShopcode(UUIDUtil.getUUID());
		shopService.insert(po);
		ShopVo vo = CopyUtil.transfer(po, ShopVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改",notes = "修改",httpMethod = "POST")
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity update(@ModelAttribute@Valid ShopUpdateForm form) throws GateWayException {
		ShopPo po = CopyUtil.transfer(form, ShopPo.class);
		shopService.update(po);
		return getSuccessResult();
	}

	@ApiOperation(value = "删除",notes = "删除",httpMethod = "POST")
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity delete(@ApiParam(value = "门店编号", required = true)@RequestParam String shopcode) throws GateWayException {
		shopService.delete(shopcode);
		return getSuccessResult();
	}

	/**
	 * ShopQueryForm转换为ShopCondition
	 *
	 * @param form
	 * @return
	 */
	private ShopCondition getConditionByQueryForm(ShopQueryForm form) {
		ShopCondition condition = CopyUtil.transfer(form, ShopCondition.class);
		return condition;
	}

}