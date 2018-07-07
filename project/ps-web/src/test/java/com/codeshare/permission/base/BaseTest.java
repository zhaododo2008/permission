package com.codeshare.permission.base;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;




@ContextConfiguration(locations = {
		"classpath*:spring-datasource-test.xml",
		"classpath*:config/spring/spring-log.xml",
		"classpath*:config/spring/spring-dal.xml",
		"classpath*:config/spring/spring-tx.xml",
		"classpath*:spring-impl-test.xml"})
public class BaseTest extends AbstractTestNGSpringContextTests {

	@Test
	public void testBase() throws Exception {
		System.out.println("11");
	}
}
