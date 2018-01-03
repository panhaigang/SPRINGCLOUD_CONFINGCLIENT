package cn.et.works.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.works.dao.EmpMapper;
import cn.et.works.entity.Emp;
import cn.et.works.entity.EmpExample;
import cn.et.works.service.EmpService;
import cn.et.works.utils.PageTools;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmpMapper emp;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.EmpService#queryEmp(java.lang.String)
	 */
	public PageTools queryEmp1(String ename,Integer page,Integer rows){
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
		
		EmpExample ee=new EmpExample();
		ee.createCriteria().andEnameLike("%"+name1+"%");
		int total=queryEmpCount(ee);
		
		/**
		 * page   ��ǰҳ
		 * queryEmpCount(ename)  �ܼ�¼��
		 * rows   ÿҳ��ʾ������
		 */
		PageTools pts=new PageTools(page,total,rows);
		//���뿪ʼλ�� �� ÿ����ʾ������
		RowBounds rb=new RowBounds(pts.getStartIndex()-1, rows);
		//��Ҫ����һ��example��rowBounds����
		List<Emp> list=emp.selectByExampleWithRowbounds(ee, rb);
		
		
		pts.setRows(list);
		return pts;
	}
	
	
	//��ѯ��ݿ���ܼ�¼��
	public int queryEmpCount(EmpExample ee){
		return emp.countByExample(ee);
		
	}
	
	
	public void saveEmp(Emp s) {
		emp.insertSelective(s);
	}


	public void deleteEmp(Integer empno) {
		emp.deleteByPrimaryKey(empno);
	}


	public void updateEmp(Emp s) {
		emp.updateByPrimaryKey(s);
		
	}
}