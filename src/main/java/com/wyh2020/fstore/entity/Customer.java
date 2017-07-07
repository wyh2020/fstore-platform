package com.wyh2020.fstore.entity;

import com.wyh2020.fstore.base.entity.BaseEntity;
import com.wyh2020.fstore.entity.support.Account;
import com.wyh2020.fstore.entity.support.Address;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created with wyh.
 * Date: 2017/7/5
 * Time: 下午2:52
 */
@Data
@Document
public class Customer extends BaseEntity {

    private String name;

    private List<Account> accounts;

    private Address address;

}
