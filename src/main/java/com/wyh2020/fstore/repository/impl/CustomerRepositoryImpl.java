package com.wyh2020.fstore.repository.impl;

import com.wyh2020.fstore.entity.Customer;
import com.wyh2020.fstore.repository.CustomerRepositoryEnhance;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with wyh.
 * Date: 2017/7/5
 * Time: 下午3:04
 */
public class CustomerRepositoryImpl implements CustomerRepositoryEnhance {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<Customer> search(String keyword, String direction, String sort, int page, int size) {
        Query query = new Query();
        Criteria c = new Criteria();
        query.addCriteria(Criteria.where("name").is(keyword));
        query.with(new Sort(Sort.Direction.valueOf(direction), sort));
        query.with(new PageRequest(page - 1, size));
        return mongoTemplate.find(query, Customer.class);
    }
}
