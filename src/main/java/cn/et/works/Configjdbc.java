package cn.et.works;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;


@Configuration
public class Configjdbc {
	
	
	@Value("${username1}")
	private String username1;
	
	@Value("${password}")
	private String password;
	
	@Value("${driverClass}")
	private String driverClass;
	
	
	@Value("${url}")
	private String url;
	
	
	
	
	@Bean
	public DataSource myDataSource(){
		DruidDataSource dds=new DruidDataSource();
		dds.setUrl(url);
		dds.setPassword(password);
		dds.setUsername(username1);
		dds.setDriverClassName(driverClass);
		return dds;
	}
	
}