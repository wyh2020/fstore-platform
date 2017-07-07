package com.wyh2020.fstore.repository;

import com.wyh2020.fstore.base.repository.BaseRepository;
import com.wyh2020.fstore.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with wyh.
 * Date: 2017/7/5
 * Time: 下午3:01
 */
@Repository
public interface CustomerRepository extends BaseRepository<Customer, String>, CustomerRepositoryEnhance {

    List<Customer> findByNameAndAddressNumberAndAccountsAccountName(
            String name, String number, String accountName);

}
