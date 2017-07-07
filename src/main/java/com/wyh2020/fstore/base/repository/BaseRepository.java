package com.wyh2020.fstore.base.repository;

import com.wyh2020.fstore.base.entity.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created with wyh.
 * Date: 2017/7/5
 * Time: 上午11:41
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable> extends MongoRepository<T, ID>, BaseRepositoryEnhance<T, ID> {

}
