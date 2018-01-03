package cn.et.works.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.et.works.entity.TreeNode;
import cn.et.works.service.Dept1Service;
import cn.et.works.utils.PageTools;



@RestController
public class Dept1Controller {
	@Autowired
	Dept1Service dept1;
	
	
	//节点
	@ResponseBody
	@RequestMapping("queryDept11")
	public List<TreeNode> queryDept1(Integer id){
		if(id==null){
			id=0;
		}
		return dept1.queryTreeNode(id);
	}
	
	
	//数据
	@ResponseBody
	@RequestMapping("queryEmp2")
	public PageTools queryEmp(Integer id,String ename,Integer page,Integer rows){
		return dept1.queryEmp2(id,ename,page,rows);
	}
	
	
	//下拉框
	@ResponseBody
	@RequestMapping("queryDept")
	public List<Map> queryDept(){
		return dept1.queryDept1();
	}
}