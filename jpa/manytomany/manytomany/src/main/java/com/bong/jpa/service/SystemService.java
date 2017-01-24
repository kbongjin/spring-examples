/**
 * 
 */
package com.bong.jpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bong.jpa.domain.ASystem;
import com.bong.jpa.domain.SubSystem;
import com.bong.jpa.repository.SubSystemRepository;
import com.bong.jpa.repository.SystemRepository;

/**
 * <pre>
 * 
 * 
 * 
 * </pre>
 * @author Bongjin Kwon
 *
 */
@Service
public class SystemService {
	
	private static final Logger log = LoggerFactory.getLogger(SystemService.class);
	
	@Autowired
	private SystemRepository systemRepo;
	
	@Autowired
	private SubSystemRepository subRepo;

	/**
	 * 
	 */
	public SystemService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public void saveWithSubSystem(ASystem system, SubSystem sub) {
		
		subRepo.save(sub);
		
		system.addSubSystem(sub);
		
		systemRepo.saveAndFlush(system);
	}
	
	@Transactional
	public void delete(Integer sysId) {
		systemRepo.delete(sysId);
	}
	
	public void printResult() {
		
		log.info("#######################-systems--######################");
		
		for (ASystem system : systemRepo.findAll()) {
			log.info(system.toString());
		}
		
		log.info("---------------sub systems-----------");
		
		for (SubSystem sub : subRepo.findAll()) {
			log.info(sub.toString());
		}
		
	}

}
