package cn.et.works.service;

import cn.et.works.entity.Emp;
import cn.et.works.utils.PageTools;

public interface EmpService {

	//��ѯ
	public abstract PageTools queryEmp1(String ename,Integer page,Integer rows);

	//����
	public abstract void saveEmp(Emp emp);
	
	//ɾ��
	public abstract void deleteEmp(Integer empno);
	
	//�޸�
	public abstract void updateEmp(Emp emp);
}