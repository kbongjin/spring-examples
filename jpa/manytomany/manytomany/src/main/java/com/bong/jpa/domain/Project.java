/**
 * 
 */
package com.bong.jpa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * <pre>
 * 
 * 
 * 
 * </pre>
 * @author Bongjin Kwon
 *
 */
@Entity
public class Project {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ProjectMember", joinColumns = {@JoinColumn(name = "projectId")}, inverseJoinColumns = {@JoinColumn(name = "userId")})
	private Set<User> members;

	/**
	 * 
	 */
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}
	
	public void addMember(User user) {
		if (this.members == null) {
			this.members = new HashSet<User>();
		}
		members.add(user);
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", members=" + members + "]";
	}

}
