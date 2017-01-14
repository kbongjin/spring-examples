package com.bong.jpa.repository;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bong.jpa.domain.Project;
import com.bong.jpa.domain.User;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes=BongApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRepositoryTest {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectRepositoryTest.class);
	

	@Autowired
	private ProjectRepository repo;
	
	@Autowired
	private UserRepository userRepo;

	@Test
	public void testFirst() {
		
		User user = userRepo.save(new User("name", "idkbj", "passwd"));
		
		Project project = repo.save(new Project("aaa", null));
		
		Set<User> members = new HashSet<User>();
		members.add(user);
		
		project.setMembers(members);
		
		try {
			Thread.sleep(500);
		} catch (Exception e) {}
		
	}
	
	/*@Test
	public void testSecond() {
		log.info("-----------projects---------------");
		
		for (Project project : repo.findAll()) {
			log.info(project.toString());
		}
		
		log.info("-----------users---------------");
		
		List<User> users = userRepo.findAll();
		if (users.isEmpty()) {
			log.info("users is empty.");
		} else {
			for (User user : users) {
				log.info(user.toString());
			}
		}
	}*/

}
