package com.joinmanytomany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
		Prjt1 p1=new Prjt1();
		p1.setP_Id(1);
		p1.setP_Title("GSM");
		
		Prjt1 p2=new Prjt1();
		p2.setP_Id(2);
		p2.setP_Title("Mobile");
		
		Emp1 e1=new Emp1();
		e1.setE_Id(101);
		e1.setE_Name("Samyuktha");
		
		Emp1 e2=new Emp1();
		e2.setE_Id(102);
		e2.setE_Name("Samyu");
		
		//List<Emp1>list1=new ArrayList<Emp1>();
		//List<Prjt1>list2=new ArrayList<Prjt1>();
		
		//list1.add(e1);
		//list1.add(e2);
		//list2.add(p1);
		//list2.add(p2);
		
		//e1.setProj(list2);
		//p2.setEmp(list1);
		Set<Emp1>set1=new HashSet<Emp1>();
		Set<Prjt1>set2=new HashSet<Prjt1>();
		
		set1.add(e1);
		set1.add(e2);
		set2.add(p1);
		set2.add(p2);
		
		e1.setProj(set2);
		p2.setEmp(set1);
		
		ses.save(e1);
		ses.save(e2);
		ses.save(p1);
		ses.save(p2);
		tx.commit();
		ses.close();
		factory.close();
		
	}
}
