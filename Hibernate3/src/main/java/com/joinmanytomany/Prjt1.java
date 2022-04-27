package com.joinmanytomany;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity

public class Prjt1 {
@Id
@Column(name="p_Id")
private int p_Id;
@Column(name="p_Title")
private String p_Title;

@ManyToMany(mappedBy = "proj")
//private List<Emp1> emp;
private Set<Emp1> emp;

public int getP_Id() {
	return p_Id;
}

public void setP_Id(int p_Id) {
	this.p_Id = p_Id;
}

public String getP_Title() {
	return p_Title;
}

public void setP_Title(String p_Title) {
	this.p_Title = p_Title;
}

public Set<Emp1> getEmp() {
	return emp;
}

public void setEmp(Set<Emp1> emp) {
	this.emp = emp;
}


}
