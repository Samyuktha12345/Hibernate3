package com.hibernate.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Learner1 {
	@Id
	private int lid;
	private String lname;
	private String lcourse;
	@ManyToOne
	private Trainer1 train;
	public Learner1(int lid, String lname, String lcourse, Trainer1 train) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.lcourse = lcourse;
		this.train = train;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLcourse() {
		return lcourse;
	}
	public void setLcourse(String lcourse) {
		this.lcourse = lcourse;
	}
	public Trainer1 getTrain() {
		return train;
	}
	public void setTrain(Trainer1 train) {
		this.train = train;
	}
	public Learner1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
