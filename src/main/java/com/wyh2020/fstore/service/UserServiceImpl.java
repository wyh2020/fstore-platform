package com.wyh2020.fstore.service;

import com.wyh2020.fstore.pojo.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created with wyh.
 * Date: 2017/7/4
 * Time: 下午5:47
 */
@Repository("UserServiceImpl")
public class UserServiceImpl implements UserService{

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(User user, String collectionName) {
        mongoTemplate.insert(user, collectionName);
    }

    @Override
    public User findOne(Map<String, Object> params, String collectionName) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(params.get("id"))), User.class,collectionName);
    }

    @Override
    public List<User> findAll(Map<String, Object> params, String collectionName) {
        List<User> result = mongoTemplate.find(new Query(Criteria.where("age").lt(params.get("maxAge"))), User.class,collectionName);
        return result;      }

    @Override
    public void update(Map<String, Object> params, String collectionName) {
        mongoTemplate.upsert(new Query(Criteria.where("id").is(params.get("id"))), new Update().set("name", params.get("name")), User.class,collectionName);
    }

    @Override
    public void createCollection(String collectionName) {
        mongoTemplate.createCollection(collectionName);
    }

    @Override
    public void remove(Map<String, Object> params, String collectionName) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(params.get("id"))),User.class,collectionName);
    }
}
