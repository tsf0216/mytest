package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerService {
	/**
	 * 根据条件查询客户列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<Customer> findCustomerListByQueryVo(QueryVo vo);

	/**
	 * 根据条件查询客户列表总数
	 * 
	 * @param vo
	 * @return
	 */
	public Integer findCustomerCountByQueryVo(QueryVo vo);

	/**
	 * 根据ID查询客户信息
	 * 
	 * @param id
	 * @return
	 */
	public Customer findCustomerById(Long id);

	/**
	 * 根据客户ID修改客户信息
	 * 
	 * @param customer
	 */
	public void updateCustomerById(Customer customer);

	/**
	 * 根据ID删除客户信息
	 * 
	 * @param id
	 */
	public void deleteCustomerById(Long id);

}
