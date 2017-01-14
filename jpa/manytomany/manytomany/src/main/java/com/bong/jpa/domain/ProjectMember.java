/**
 * 
 */
package com.bong.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * <pre>
 * 
 * 
 * </pre>
 * @author Bongjin Kwon
 *
 */
@Entity
@IdClass(value = ProjectMemberId.class)
public class ProjectMember {
	
	@Id
	private Integer projectId;
	
	@Id
	private Integer userId;
	

	/**
	 * 
	 */
	public ProjectMember() {
		// TODO Auto-generated constructor stub
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ProjectMember [projectId=" + projectId + ", userId=" + userId + "]";
	}

}
