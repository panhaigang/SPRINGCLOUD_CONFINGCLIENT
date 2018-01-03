package cn.et.works.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.works.dao.Dept1Mapper;
import cn.et.works.dao.Emp2Mapper;
import cn.et.works.entity.Dept1;
import cn.et.works.entity.Dept1Example;
import cn.et.works.entity.Emp2;
import cn.et.works.entity.Emp2Example;
import cn.et.works.entity.TreeNode;
import cn.et.works.service.Dept1Service;
import cn.et.works.utils.PageTools;



@Service
public class Dept1ServiceImpl implements Dept1Service {
	@Autowired
	Dept1Mapper dept;
	
	@Autowired
	Emp2Mapper emp;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.EmpService#queryEmp(java.lang.String)
	 */
	
	
	public List<TreeNode> queryTreeNode(Integer id){
		Dept1Example de=new Dept1Example();
		de.createCriteria().andPidEqualTo(id);
		List<Dept1> deptlist=dept.selectByExample(de);
		List<TreeNode> treelist=new ArrayList<TreeNode>();
		for(Dept1 d:deptlist){
			TreeNode tn=new TreeNode();
			tn.setId(d.getId());
			tn.setText(d.getDname());
			//�жϴ˽ڵ����Ƿ����ӽڵ�
			if(queryTreeNode(d.getId()).size()==0){
				tn.setState("open");	
			}
			treelist.add(tn);
		}
		return treelist;
	}
	
	public PageTools queryEmp2(Integer id,String ename,Integer page,Integer rows){
		
		Emp2Example ee=new Emp2Example();
		if(id!=null){
			ee.createCriteria().andDeptidEqualTo(id);
		}
		//��ѯ�ܼ�¼
		int total=queryEmpCount(ee);
		
		
		String name1 = null;
		if(ename==null||ename==""){
			
		}else{
			try {
				name1 = URLDecoder.decode(ename, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(name1==null){
			name1="";
		}
		
		ee.createCriteria().andEnameLike("%"+name1+"%");
		
		
		
		
		/**
		 * page   ��ǰҳ
		 * queryEmpCount(ename)  �ܼ�¼��
		 * rows   ÿҳ��ʾ������
		 */
		PageTools pts=new PageTools(page,total,rows);
		//���뿪ʼλ�� �� ÿ����ʾ������
		RowBounds rb=new RowBounds(pts.getStartIndex()-1, rows);
		//��Ҫ����һ��example��rowBounds����
		List<Emp2> list=emp.selectByExampleWithRowbounds(ee, rb);
		
		pts.setRows(list);
		return pts;
	}
	
	//��ѯ��ݿ���ܼ�¼��
	public int queryEmpCount(Emp2Example ee){
		return emp.countByExample(ee);
	}
	
	
	
	public List<Map> queryDept1(){
		List<Map> l=new ArrayList<Map>();
		Dept1Example de=new Dept1Example();
		List<Dept1> list=dept.selectByExample(de);
		for(Dept1 d:list){
			Map map=new HashMap();
			map.put("id", d.getId());
			map.put("text", d.getDname());
			l.add(map);
		}
		return l;
	}
}