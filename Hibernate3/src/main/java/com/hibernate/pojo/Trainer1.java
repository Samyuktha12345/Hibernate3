package com.hibernate.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer1 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;
	private String tname;
	private String tsubject;
	@OneToMany(mappedBy="train")
	private List<Learner1>ln;
	public Trainer1(int tid, String tname, String tsubject, List<Learner1> ln) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tsubject = tsubject;
		this.ln = ln;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsubject() {
		return tsubject;
	}
	public void setTsubject(String tsubject) {
		this.tsubject = tsubject;
	}
	public List<Learner1> getLn() {
		return ln;
	}
	public void setLn(List<Learner1> ln) {
		this.ln = ln;
	}
	public Trainer1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
