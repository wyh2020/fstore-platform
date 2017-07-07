package com.wyh2020.fstore.controller;

import com.wyh2020.fstore.entity.Customer;
import com.wyh2020.fstore.entity.support.Account;
import com.wyh2020.fstore.entity.support.Address;
import com.wyh2020.fstore.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with wyh.
 * Date: 2017/7/5
 * Time: 下午8:16
 */
@RestController
@RequestMapping(value = "/customer")
@Api(value = "CustomerController", description = "测试连接mongodb接口")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCustomer() {
        Customer customer = new Customer();

        Account account = new Account();
        account.setAccountName("王勇华的账户信息");

        Address address = new Address();
        address.setNumber("Number1");
        address.setPostcode("编号00001");
        address.setStreet("藤田街");
        address.setTown("县城A");

        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        customer.setName("王勇华");
        customer.setAccounts(accounts);
        customer.setAddress(address);
        customerService.insertCustomer(customer);
        return "增加成功";
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Object findAllCustomerDetail() {
        return customerService.findAllCustomers();
    }



    @RequestMapping(value = "/get_by/{name}/{number}/{accountName}", method = RequestMethod.GET)
    public Object findByNameAndAddressNumberAndAccountsAccountName(@PathVariable String name, @PathVariable String number, @PathVariable String accountName) {
        return customerService.findByNameAndAddressNumberAndAccountsAccountName(name, number, accountName);
    }


    @RequestMapping(value = "/search_by", method = RequestMethod.GET)
    public List<Customer> search(@RequestParam(value= "query", defaultValue = "") String keyword,
                                 @RequestParam(value= "direction", defaultValue = "DESC") String direction,
                                 @RequestParam(value = "sort", defaultValue = "name") String sort,
                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "size", defaultValue = "30") int size) {

        return customerService.search(keyword, direction, sort, page, size);
    }


}
