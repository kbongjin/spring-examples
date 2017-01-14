package com.bong.jpa.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bong.jpa.domain.Project;
import com.bong.jpa.domain.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {

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
	 * ManyToMany save test case.
	 */
	@Test
	public void testSaveWithUser() {
		service.saveWithUser(new Project("aaa", null), new User("name", "idkbj", "passwd"));
		
		service.pringResult();
	}

}
