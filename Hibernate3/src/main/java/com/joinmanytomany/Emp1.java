package com.joinmanytomany;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Emp1 {
@Id
@Column(name="e_Id")
private int e_Id;
@Column(name="e_Name")
private String e_Name;

@ManyToMany(fetch=FetchType.LAZY,cascade = {CascadeType.ALL})
@JoinTable(name="Emp1_Prjt1",joinColumns= {
		@JoinColumn(name = "e_Id") },   
inverseJoinColumns = { @JoinColumn(name = "p_Id") }) 
//private List<Prjt1> proj;
private Set<Prjt1> proj;

public int getE_Id() {
	return e_Id;
}

public void setE_Id(int e_Id) {
	this.e_Id = e_Id;
}

public String getE_Name() {
	return e_Name;
}

public void setE_Name(String e_Name) {
	this.e_Name = e_Name;
}

public Set<Prjt1> getProj() {
	return proj;
}

public void setProj(Set<Prjt1> proj) {
	this.proj = proj;
}




}
