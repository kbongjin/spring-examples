/**
 * 
 */
package com.bong.jpa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
public class ASystem {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@OneToMany(mappedBy = "system")
	private Set<SubSystem> subSystems;

	/**
	 * 
	 */
	public ASystem() {
		// TODO Auto-generated constructor stub
	}

	public ASystem(Integer id, String name) {
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

	public Set<SubSystem> getSubSystems() {
		return subSystems;
	}

	public void setSubSystems(Set<SubSystem> subSystems) {
		this.subSystems = subSystems;
	}
	
	public void addSubSystem(SubSystem subSystem) {
		if (this.subSystems == null) {
			this.subSystems = new HashSet<SubSystem>();
		}
		this.subSystems.add(subSystem);
	}

	@Override
	public String toString() {
		return "ASystem [id=" + id + ", name=" + name + ", subSystems=" + subSystems + "]";
	}

}
