/**
 * 
 */
package com.bong.jpa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bong.jpa.domain.Project;
import com.bong.jpa.domain.ProjectMember;
import com.bong.jpa.domain.User;
import com.bong.jpa.repository.ProjecMemberRepository;
import com.bong.jpa.repository.ProjectRepository;
import com.bong.jpa.repository.UserRepository;

/**
 * <pre>
 * 
 * </pre>
 * @author Bongjin Kwon
 *
 */
@Service
public class ProjectService {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectService.class);
	
	@Autowired
	private ProjectRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProjecMemberRepository prjMemberRepo;

	/**
	 * 
	 */
	public ProjectService() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ManyToMany save 예시.
	 * 
	 * @see {@link ProjectServiceTest}
	 * 
	 * @param project
	 * @param user
	 */
	@Transactional
	public void saveWithUser(Project project, User user){
		
		userRepo.save(user);
		
		log.info("user saved!!!");
		
		project.addMember(user);//insert into project_member
		
		//repo.save(project);// insert into project_member 가 commit 이후에 실행됨.
		repo.saveAndFlush(project);// insert into project_member 가 commit 이전에 실행됨.
		
		log.info("saved!!!");
		
	}
	
	@Transactional
	public void save(Project project){
		
		repo.save(project);
		
		log.info("saved!!!");
		
	}
	
	@Transactional
	public void delete(Integer projectId) {
		repo.delete(projectId);
	}
	
	
	
	public void pringResult() {
		
		log.info("#######################-projects--######################");
		
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
		
		log.info("-----------members---------------");
		List<ProjectMember> members = prjMemberRepo.findAll();
		if (members.isEmpty()) {
			log.info("members is empty.");
		} else {
			for (ProjectMember member : members) {
				log.info(member.toString());
			}
		}
	}

}
