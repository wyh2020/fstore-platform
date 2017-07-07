package com.wyh2020.fstore.base.repository.impl;

import com.wyh2020.fstore.base.entity.BaseEntity;
import com.wyh2020.fstore.base.repository.BaseRepositoryEnhance;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.io.Serializable;

/**
 * Created with wyh.
 * Date: 2017/7/5
 * Time: 下午2:39
 */
public class BaseRepositoryImpl<T extends BaseEntity, ID extends Serializable> extends SimpleMongoRepository<T, ID> implements BaseRepositoryEnhance<T, ID> {

    private final MongoOperations mongoOperations;

    public BaseRepositoryImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
        this.mongoOperations = mongoOperations;
    }

//    @Override
//    public T softDelete(ID id) {
//        return null;
//    }
}
