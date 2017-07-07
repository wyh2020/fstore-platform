package com.wyh2020.fstore.service;

import com.wyh2020.fstore.entity.Customer;
import com.wyh2020.fstore.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with wyh.
 * Date: 2017/7/5
 * Time: 下午8:15
 */
@Service
public class CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    public void insertCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public void dropCustomerCollection() {
        customerRepository.deleteAll();
    }

    public List<Customer> findByNameAndAddressNumberAndAccountsAccountName(String name, String number, String accountName) {
        return customerRepository.findByNameAndAddressNumberAndAccountsAccountName(name, number,accountName);
    }

    public List<Customer> search(String keyword, String direction, String sort, int page, int size) {
        return customerRepository.search(keyword, direction, sort, page, size);
    }

}
