package com.wyh2020.fstore.entity.support;

import com.wyh2020.fstore.base.entity.BaseEntity;
import lombok.Data;

/**
 * Created with wyh.
 * Date: 2017/7/5
 * Time: 下午2:53
 */
@Data
public class Address extends BaseEntity {

    private String number;

    private String street;

    private String town;

    private String postcode;

}
