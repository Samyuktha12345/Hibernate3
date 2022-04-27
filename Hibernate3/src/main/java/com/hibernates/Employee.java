package com.hibernates;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)
private int eid;
private String ename;

@ManyToMany
private List<Project> project;

public int getEid() {
	return eid;
}

public void setEid(int eid) {
	this.eid = eid;
}

public String getEname() {
	return ename;
}

public void setEname(String ename) {
	this.ename = ename;
}

public List<Project> getProject() {
	return project;
}

public void setProject(List<Project> project) {
	this.project = project;
}


}
