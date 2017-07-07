package com.wyh2020.fstore.repository;

import com.wyh2020.fstore.entity.Customer;

import java.util.List;

/**
 * Created with wyh.
 * Date: 2017/7/5
 * Time: 下午2:58
 */
public interface CustomerRepositoryEnhance {

    public List<Customer> search(String keyword, String direction, String sort, int page, int size);

}
