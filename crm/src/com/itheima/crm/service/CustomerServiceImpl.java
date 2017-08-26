package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.CustomerMapper;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

/** 
* @author lijin E-mail: lijin1@itcast.cn 
* @date   2017年8月21日 上午11:02:38 
* 类说明 
*/
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<Customer> findCustomerListByQueryVo(QueryVo vo) {
		List<Customer> list = customerMapper.findCustomerListByQueryVo(vo);
		return list;
	}

	@Override
	public Integer findCustomerCountByQueryVo(QueryVo vo) {
		Integer count = customerMapper.findCustomerCountByQueryVo(vo);
		return count;
	}

	@Override
	public Customer findCustomerById(Long id) {
		Customer customer = customerMapper.findCustomerById(id);
		return customer;
	}

	@Override
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
	}

	@Override
	public void deleteCustomerById(Long id) {
		customerMapper.deleteCustomerById(id);
		
	}

}
