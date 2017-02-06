package com.bong.jpa.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bong.jpa.domain.ASystem;
import com.bong.jpa.domain.SubSystem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(SystemServiceTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Autowired
	private SystemService service;

	/**
	 * OneToMany create,update,delete test case.
	 */
	@Test
	public void testCUD() {
		log.debug("########### CREATE test ##################");
		
		service.saveWithSubSystem(new ASystem(null, "system"), new SubSystem(null, "sub"));
		
		service.printResult();
		
		try{
			Thread.sleep(500);
		} catch(Exception e){}
	}
	
	@Test
	public void testCU() {
		
		//service.saveWithSubSystem(new ASystem(null, "system"), new SubSystem(null, "sub"));
		
		service.save(new ASystem(null, "system2"));
		
		service.save(new ASystem(1, "system3"));
		
		service.save(new SubSystem(1, "sub2"));
		
		service.printResult();
	}

}
