package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;

import cn.itcast.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {
	// 客户来源
	@Value("${CUSTOMER_SOURCE_TYPE}")
	private String CUSTOMER_SOURCE_TYPE;
	// 客户行业
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	// 客户级别
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;

	@Autowired
	private BaseDictService baseDictService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping("list")
	public String list(Model model, QueryVo vo) throws Exception {
		if (vo.getCustName() != null) {
			vo.setCustName(new String(vo.getCustName().getBytes("iso-8859-1"), "utf-8"));
		}
		// 查询高级搜索下拉框数据
		// 查询客户来源
		List<BaseDict> sourceList = baseDictService.findBaseDictByTypeCode(CUSTOMER_SOURCE_TYPE);
		// 查询客户行业
		List<BaseDict> industryList = baseDictService.findBaseDictByTypeCode(CUSTOMER_INDUSTRY_TYPE);
		// 查询客户等级
		List<BaseDict> levelList = baseDictService.findBaseDictByTypeCode(CUSTOMER_LEVEL_TYPE);

		// 设置分页初始化值
		if (vo.getStart() == null) {
			vo.setStart((vo.getPage() - 1) * vo.getSize());
		}
		// 客户列表查询
		List<Customer> customerList = customerService.findCustomerListByQueryVo(vo);
		Integer count = customerService.findCustomerCountByQueryVo(vo);
		// 客户列表分页
		Page<Customer> page = new Page<Customer>();
		// 列表总数
		page.setTotal(count);
		// 当前页面
		page.setPage(vo.getPage());
		// 每页显示多少条
		page.setSize(vo.getSize());
		// 查询客户列表的集合
		page.setRows(customerList);

		// 查询的客户列表返回页面
		model.addAttribute("page", page);
		// 把查询的下拉框数据传到页面
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);

		// 回显查询条件
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		return "customer";

	}

	/**
	 * 根据客户ID查询客户信息回显页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Long id) {
		// 根据ID查询客户信息
		Customer customer = customerService.findCustomerById(id);

		return customer;
	}

	@RequestMapping("update")
	@ResponseBody
	public String update(Customer customer) {

		// 修改客户
		customerService.updateCustomerById(customer);

		return "OK";

	}

	@RequestMapping("delete")
	@ResponseBody
	public String delete(Long id) {
		// 根据iD删除客户信息
		customerService.deleteCustomerById(id);

		return "OK";
	}
}
