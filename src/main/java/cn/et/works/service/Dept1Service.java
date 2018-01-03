package cn.et.works.service;

import java.util.List;
import java.util.Map;

import cn.et.works.entity.TreeNode;
import cn.et.works.utils.PageTools;



public interface Dept1Service {
	public List<TreeNode> queryTreeNode(Integer id);
	
	public PageTools queryEmp2(Integer id,String ename,Integer page,Integer rows);
	
	public List<Map> queryDept1();
	
	
}