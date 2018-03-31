package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.base.controller.BaseController;
import com.wyh2020.fstore.base.response.CentreCutPageResponse;
import com.wyh2020.fstore.base.response.CentreListResponse;
import com.wyh2020.fstore.base.response.ResponseEntity;
import com.wyh2020.fstore.base.util.CopyUtil;
import com.wyh2020.fstore.base.util.UUIDUtil;
import com.wyh2020.fstore.condition.cart.CartCondition;
import com.wyh2020.fstore.exception.GateWayException;
import com.wyh2020.fstore.form.cart.CartCreateForm;
import com.wyh2020.fstore.form.cart.CartQueryForm;
import com.wyh2020.fstore.form.cart.CartUpdateForm;
import com.wyh2020.fstore.po.cart.CartPo;
import com.wyh2020.fstore.service.CartService;
import com.wyh2020.fstore.vo.cart.CartVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/od/cart")
@Api(value = "/od/cart", description = "")
public class CartController extends BaseController {

	@Autowired
	private CartService cartService;

	@ApiOperation(value = "查询",notes = "查询",httpMethod = "GET")
	@RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CartVo> query(@ApiParam(value = "编号", required = true)@RequestParam String id) throws GateWayException {
		CartPo po = cartService.queryWithValid(id);
		CartVo vo = CopyUtil.transfer(po, CartVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询数量",notes = "查询数量",httpMethod = "GET")
	@RequestMapping(value = "/queryCount", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<Integer> queryCount(@ModelAttribute@Valid CartQueryForm form) throws GateWayException {
		CartCondition condition = this.getConditionByQueryForm(form);
		int count = cartService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询列表",notes = "查询列表",httpMethod = "GET")
	@RequestMapping(value = "/queryList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreListResponse<CartVo>> queryList(@ModelAttribute@Valid CartQueryForm form) throws GateWayException {
		CartCondition condition = this.getConditionByQueryForm(form);
		List<CartPo> poList = cartService.queryList(condition);
		List<CartVo> voList = CopyUtil.transfer(poList, CartVo.class);
		return getSuccessResult(getListResponse(voList));
	}

	@ApiOperation(value = "查询列表(带分页)",notes = "查询列表(带分页)",httpMethod = "GET")
	@RequestMapping(value = "/queryPageList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreCutPageResponse<CartVo>> queryPageList(@ModelAttribute@Valid CartQueryForm form) throws GateWayException {
		CartCondition condition = this.getConditionByQueryForm(form);
		List<CartVo> voList = new ArrayList<>();
		int count = cartService.queryCount(condition);
		if (count > 0) {
			List<CartPo> poList = cartService.queryList(condition);
			voList = CopyUtil.transfer(poList, CartVo.class);
		}
		return getSuccessResult(getPageResponse(form, count, voList));
	}

	@ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CartVo> add(@ModelAttribute@Valid CartCreateForm form) throws GateWayException {
		CartPo po = CopyUtil.transfer(form, CartPo.class);
		po.setId(UUIDUtil.getUUID());
		cartService.insert(po);
		CartVo vo = CopyUtil.transfer(po, CartVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改",notes = "修改",httpMethod = "POST")
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity update(@ModelAttribute@Valid CartUpdateForm form) throws GateWayException {
		CartPo po = CopyUtil.transfer(form, CartPo.class);
		cartService.update(po);
		return getSuccessResult();
	}

	@ApiOperation(value = "删除",notes = "删除",httpMethod = "POST")
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity delete(@ApiParam(value = "编号", required = true)@RequestParam String id) throws GateWayException {
		cartService.delete(id);
		return getSuccessResult();
	}

	/**
	 * CartQueryForm转换为CartCondition
	 *
	 * @param form
	 * @return
	 */
	private CartCondition getConditionByQueryForm(CartQueryForm form) {
		CartCondition condition = CopyUtil.transfer(form, CartCondition.class);
		return condition;
	}

}