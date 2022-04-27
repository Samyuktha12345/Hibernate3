package com.hibernates;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session ses=factory.openSession();
		Transaction tx=ses.beginTransaction();
		
		Employee e1=new Employee();
		Employee e2=new Employee();
		
		//e1.setEid(1); Generation type if we use ,have to not provide id
		e1.setEname("Ram");
		
		
		//e2.setEid(2);
		e2.setEname("Charan");
		
		Project p1=new Project();
		Project p2=new Project();
		
		p1.setPid(11);
		p1.setPname("IOT");
		
		
		p2.setPid(12);
		p2.setPname("JFS");
		
		
		List<Employee>list1=new ArrayList<Employee>();
		List<Project>list2=new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		list2.add(p1);
		list2.add(p2);
		
		e1.setProject(list2);
		p2.setEmployee(list1);
		
		ses.save(e1);
		ses.save(e2);
		ses.save(p1);
		ses.save(p2);
		tx.commit();
		ses.close();
		factory.close();
	}

}
