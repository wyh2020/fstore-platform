package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.base.controller.BaseController;
import com.wyh2020.fstore.base.response.ResponseEntity;
import com.wyh2020.fstore.bo.count.CountAllBo;
import com.wyh2020.fstore.bo.count.CountUserAndGoodBo;
import com.wyh2020.fstore.condition.good.GoodCondition;
import com.wyh2020.fstore.condition.shop.ShopCondition;
import com.wyh2020.fstore.condition.trade.TradeCondition;
import com.wyh2020.fstore.condition.user.UserCondition;
import com.wyh2020.fstore.exception.GateWayException;
import com.wyh2020.fstore.po.good.GoodPo;
import com.wyh2020.fstore.po.user.UserPo;
import com.wyh2020.fstore.service.GoodService;
import com.wyh2020.fstore.service.ShopService;
import com.wyh2020.fstore.service.TradeService;
import com.wyh2020.fstore.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author hzh
 */
@RestController
@RequestMapping("/od/count")
@Api(value = "/od/count", description = "统计")
public class CountController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private GoodService goodService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private TradeService tradeService;

	@ApiOperation(value = "统计性别、菜系",notes = "统计性别、菜系",httpMethod = "GET")
	@RequestMapping(value = "/countUserAndGood", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CountUserAndGoodBo> countUserAndGood() throws GateWayException {
		UserCondition condition = new UserCondition();
		List<UserPo> userPoList = userService.queryList(condition);
		Map<Integer, Long> userMapResult = new HashMap<Integer, Long>();
		Map<Integer, Long> goodMapResult = new HashMap<Integer, Long>();

		if(!CollectionUtils.isEmpty(userPoList)){
			userMapResult = userPoList.stream().collect(Collectors.groupingBy(c -> (c.getSex()!=null ? c.getSex() : 3), Collectors.counting()));
		}
		GoodCondition goodCondition = new GoodCondition();
		List<GoodPo> goodPoList = goodService.queryList(goodCondition);
		if(!CollectionUtils.isEmpty(goodPoList)){
			goodMapResult = goodPoList.stream().collect(Collectors.groupingBy(c -> c.getType(), Collectors.counting()));
		}
		CountUserAndGoodBo countUserAndGoodBo = new CountUserAndGoodBo();
		countUserAndGoodBo.setUserMap(userMapResult);
		countUserAndGoodBo.setGoodMap(goodMapResult);
		return getSuccessResult(countUserAndGoodBo);
	}


	@ApiOperation(value = "统计总用户数、总店铺数、总订单数、总菜品数",notes = "查询",httpMethod = "GET")
	@RequestMapping(value = "/countAll", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	ResponseEntity<CountAllBo> countAll() throws GateWayException {
		UserCondition condition = new UserCondition();
		int countUser = userService.queryCount(condition);
		GoodCondition goodCondition = new GoodCondition();
		int countGood = goodService.queryCount(goodCondition);
		ShopCondition shopCondition = new ShopCondition();
		int countShop = shopService.queryCount(shopCondition);
		TradeCondition tradeCondition = new TradeCondition();
		int countTrade = tradeService.queryCount(tradeCondition);

		CountAllBo countAllBo = new CountAllBo();
		countAllBo.setCountUser(countUser);
		countAllBo.setCountGood(countGood);
		countAllBo.setCountShop(countShop);
		countAllBo.setCountTrade(countTrade);
		return getSuccessResult(countAllBo);
	}


}