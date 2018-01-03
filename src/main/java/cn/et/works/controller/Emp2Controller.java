package cn.et.works.controller;



import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.et.works.entity.Emp2;
import cn.et.works.entity.Result;
import cn.et.works.service.Emp2Service;



@RestController
public class Emp2Controller {
	@Autowired
	Emp2Service emp2;
	
	
	
	//增加
	@RequestMapping(value="saveEmp2",method=RequestMethod.POST)
		public Result saveEmp(Emp2 e){
			Result r=new Result();
			r.setCode(1);
			try {
				emp2.saveEmp(e);
			} catch (Exception e1) {
				r.setCode(0);
				r.setMessage(e1);
			}
			return r;
		}
	
	
	
	//删除
	@RequestMapping(value="deleteEmp2/{empno}",method=RequestMethod.DELETE)
	public Result deleteEmp(@PathVariable String empno){
		String arr[]=empno.split(",");
		Result r=new Result();
		r.setCode(1);
		try {
			/*String a=null;
			a.toString();*/
			for(int i=0;i<arr.length;i++){
				emp2.deleteEmp(Integer.parseInt(arr[i]));
			}
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	
	//修改
	@RequestMapping(value="updateEmp2/{empno}",method=RequestMethod.PUT)
	public Result updateEmp(@PathVariable Integer empno,Emp2 e) throws ParseException{
		e.setId(empno);
		Result r=new Result();
		r.setCode(1);
		try {
			emp2.updateEmp(e);
		} catch (Exception e1) {
			r.setCode(0);
			r.setMessage(e1);
		}
		return r;
	}
	
}