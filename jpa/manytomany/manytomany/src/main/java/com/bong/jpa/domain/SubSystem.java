package com.bong.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SubSystem {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer systemId;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "systemId", insertable = false, updatable = false)
	private ASystem system;

	public SubSystem() {
		// TODO Auto-generated constructor stub
	}
	
	public SubSystem(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public ASystem getSystem() {
		return system;
	}

	public void setSystem(ASystem system) {
		this.system = system;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SubSystem [id=" + id + ", systemId=" + systemId + ", name=" + name + "]";
	}

}
