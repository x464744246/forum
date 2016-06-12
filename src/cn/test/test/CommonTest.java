package cn.test.test;

import org.springframework.context.ApplicationContext;

import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;

public class CommonTest extends UnitilsTestNG {

	@SpringApplicationContext("file:D:\\study\\ReadyFoJavaee\\Base1\\src\\applicationContext.xml")
    private ApplicationContext applicationContext;
	
	public ApplicationContext getAApplicationContext(){
		return applicationContext;
	}
	public void setApplicationContext(ApplicationContext applicationContext) {

		this.applicationContext = applicationContext ;

	}

}