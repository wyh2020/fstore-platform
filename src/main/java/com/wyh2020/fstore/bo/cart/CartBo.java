package com.wyh2020.fstore.bo.cart;

import com.wyh2020.fstore.po.shop.ShopPo;
import com.wyh2020.fstore.vo.cart.CartVo;
import lombok.Data;

import java.util.List;

@Data
public class CartBo {
	/**
	 * 门店编号
	*/
	private String shopcode;
	/**
	 * 店铺信息
	 */
	private ShopPo shopPo;

	/**
	 * CartVo
	 */
	private List<CartVo> cartVoList;

}