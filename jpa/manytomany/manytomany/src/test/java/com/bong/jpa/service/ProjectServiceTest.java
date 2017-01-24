package com.bong.jpa.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bong.jpa.domain.Project;
import com.bong.jpa.domain.User;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes=BongApplication.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectServiceTest.class);

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
	private ProjectService service;

	/**
	 * ManyToMany create,update,delete test case.
	 */
	@Test
	public void testCUD() {
		
		log.debug("########### CREATE test ##################");
		
		service.saveWithUser(new Project(null, "aaa"), new User(null, "name", "idkbj", "passwd"));
		
		service.printResult();
		
		log.debug("########### UPDATE test ##################");
		
		service.saveWithUser(new Project(1, "bbb"), new User(1, "ccc", "idkbj", "passwd"));
		//service.save(new Project(1, "bbb"));// delete from project_member 도 처리됨.
		
		service.printResult();
		
		log.debug("########### DELETE test ##################");
		
		service.delete(1);//delete from project_member 도 처리됨.
		
		service.printResult();
	}

}
