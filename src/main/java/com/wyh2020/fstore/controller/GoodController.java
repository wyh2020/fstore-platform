package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.base.constants.Constants;
import com.wyh2020.fstore.base.controller.BaseController;
import com.wyh2020.fstore.base.response.CentreCutPageResponse;
import com.wyh2020.fstore.base.response.CentreListResponse;
import com.wyh2020.fstore.base.response.ResponseEntity;
import com.wyh2020.fstore.base.util.CopyUtil;
import com.wyh2020.fstore.base.util.UUIDUtil;
import com.wyh2020.fstore.condition.good.GoodCondition;
import com.wyh2020.fstore.entity.JwtUser;
import com.wyh2020.fstore.exception.GateWayException;
import com.wyh2020.fstore.form.good.GoodCreateForm;
import com.wyh2020.fstore.form.good.GoodQueryForm;
import com.wyh2020.fstore.form.good.GoodUpdateForm;
import com.wyh2020.fstore.po.good.GoodPo;
import com.wyh2020.fstore.po.shop.ShopPo;
import com.wyh2020.fstore.service.GoodService;
import com.wyh2020.fstore.service.ShopService;
import com.wyh2020.fstore.vo.good.GoodVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/od/good")
@Api(value = "/od/good", description = "")
public class GoodController extends BaseController {

	@Autowired
	private GoodService goodService;
	@Autowired
	private ShopService shopService;

	@ApiOperation(value = "查询",notes = "查询",httpMethod = "GET")
	@RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<GoodVo> query(@ApiParam(value = "菜品编号", required = true)@RequestParam String goodid) throws GateWayException {
		GoodPo po = goodService.queryWithValid(goodid);
		GoodVo vo = CopyUtil.transfer(po, GoodVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "查询数量",notes = "查询数量",httpMethod = "GET")
	@RequestMapping(value = "/queryCount", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<Integer> queryCount(@ModelAttribute@Valid GoodQueryForm form) throws GateWayException {
		GoodCondition condition = this.getConditionByQueryForm(form);
		int count = goodService.queryCount(condition);
		return getSuccessResult(count);
	}

	@ApiOperation(value = "查询列表",notes = "查询列表",httpMethod = "GET")
	@RequestMapping(value = "/queryList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreListResponse<GoodVo>> queryList(@ModelAttribute@Valid GoodQueryForm form) throws GateWayException {
		GoodCondition condition = this.getConditionByQueryForm(form);
		List<GoodPo> poList = goodService.queryList(condition);
		List<GoodVo> voList = CopyUtil.transfer(poList, GoodVo.class);
		return getSuccessResult(getListResponse(voList));
	}

	@ApiOperation(value = "查询列表(带分页)",notes = "查询列表(带分页)",httpMethod = "GET")
	@RequestMapping(value = "/queryPageList", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CentreCutPageResponse<GoodVo>> queryPageList(@ModelAttribute@Valid GoodQueryForm form, BindingResult result, HttpServletRequest request) throws GateWayException {
		GoodCondition condition = this.getConditionByQueryForm(form);
		JwtUser jwtUser = this.checkLogin(request);
		String userCode = jwtUser.getUserCode();
		ShopPo shopPo = shopService.queryByUserCode(userCode);
		Integer userType = jwtUser.getUserType();

		if(userType.equals(Constants.UserType.SHOP)){
			condition.setShopcode(shopPo.getShopcode());
		}
		List<GoodVo> voList = new ArrayList<>();
		int count = goodService.queryCount(condition);
		if (count > 0) {
			List<GoodPo> poList = goodService.queryList(condition);
			voList = CopyUtil.transfer(poList, GoodVo.class);
		}
		return getSuccessResult(getPageResponse(form, count, voList));
	}

	@ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<GoodVo> add(@RequestBody@Valid GoodCreateForm form, BindingResult result, HttpServletRequest request) throws GateWayException {
		GoodPo po = CopyUtil.transfer(form, GoodPo.class);
		JwtUser jwtUser = this.checkLogin(request);
		String creater = jwtUser.getUserCode();
		po.setGoodid(UUIDUtil.getUUID());

		String userCode = jwtUser.getUserCode();
		ShopPo shopPo = shopService.queryByUserCode(userCode);
		po.setShopcode(shopPo.getShopcode());
		po.setCreater(creater);
		po.setCreatetime(new Date());
		goodService.insert(po);
		GoodVo vo = CopyUtil.transfer(po, GoodVo.class);
		return getSuccessResult(vo);
	}

	@ApiOperation(value = "修改",notes = "修改",httpMethod = "POST")
	@RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity update(@RequestBody@Valid GoodUpdateForm form,  BindingResult result, HttpServletRequest request) throws GateWayException {
		GoodPo po = CopyUtil.transfer(form, GoodPo.class);
		JwtUser jwtUser = this.checkLogin(request);
		String userCode = jwtUser.getUserCode();
		po.setUpdater(userCode);
		po.setUpdatetime(new Date());
		goodService.update(po);
		return getSuccessResult();
	}

	@ApiOperation(value = "删除",notes = "删除",httpMethod = "POST")
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity delete(@ApiParam(value = "菜品编号", required = true)@RequestBody GoodUpdateForm form) throws GateWayException {
		goodService.delete(form.getGoodid());
		return getSuccessResult();
	}

	/**
	 * GoodQueryForm转换为GoodCondition
	 *
	 * @param form
	 * @return
	 */
	private GoodCondition getConditionByQueryForm(GoodQueryForm form) {
		GoodCondition condition = CopyUtil.transfer(form, GoodCondition.class);
		return condition;
	}

}