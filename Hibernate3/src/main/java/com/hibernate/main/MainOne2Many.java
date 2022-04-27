package com.hibernate.main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.pojo.Learner1;
import com.hibernate.pojo.Trainer1;
public class MainOne2Many {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session ses=factory.openSession();
		Transaction tx=ses.beginTransaction();
		/*Trainer1 t=new Trainer1();
		t.setTid(1);
		t.setTname("Manish");
		t.setTsubject("Java");
		

		Learner1 l=new Learner1();
		l.setLid(11);
		l.setLname("Hari");
		l.setLcourse("Java");
		l.setTrain(t);
		
		Learner1 l2=new Learner1();
		l2.setLid(12);
		l2.setLname("Haripriya");
		l2.setLcourse("Java");
		l2.setTrain(t);
		
		Learner1 l3=new Learner1();
		l3.setLid(13);
		l3.setLname("Samyu");
		l3.setLcourse("Java");
		l3.setTrain(t);
		
		List<Learner1> list=new ArrayList<Learner1>();
		list.add(l);
		list.add(l2);
		list.add(l3);
		t.setLn(list);
		
		ses.save(t);
		ses.save(l);
		ses.save(l2);
		ses.save(l3);*/
		Query query=ses.createQuery("from Learner1");
		List<Learner1>list1=query.list();
		for (Learner1 learn:list1)
		{
			System.out.println("learn id:"+learn.getLid()+"learn name:"+learn.getLname()+"learn course:"+learn.getLcourse());
		}
		Query query1 = ses.createQuery("select count(lid) from Learner1");
		Iterator count=query1.iterate();
		System.out.println("No. of rows: "+count.next());
		
		Query query2 = ses.createQuery("select count(lname) from Learner1 where lcourse='Java'");
		Iterator count1=query2.iterate();
		System.out.println("No. of rows: "+count1.next());
		
		Query query3 = ses.createQuery("select distinct count(distinct lcourse) from Learner1");
		Iterator count2=query3.iterate();
		System.out.println("No. of rows: "+count2.next());
		
		Query query4 = ses.createQuery("select min(lid) from Learner1");
		Iterator count3=query4.iterate();
		System.out.println("Minimum id: "+count3.next());
		
		Query query5 = ses.createQuery("select max(lid) from Learner1");
		Iterator count4=query5.iterate();
		System.out.println("Maximum id: "+count4.next());
		
		Query query6 = ses.createQuery("select sum(lid) from Learner1");
		Iterator count5=query6.iterate();
		System.out.println("sum of id: "+count5.next());
		
		Query query7 = ses.createQuery("select avg(lid) from Learner1");
		Iterator count6=query7.iterate();
		System.out.println("Avg id: "+count6.next());
		
		Query query8 = ses.createQuery("from Learner1");
		query8.setFirstResult(13);
		query8.setMaxResults(12);
		List<Learner1>l=query8.list();
		for (Learner1 learn:l)
		{
			System.out.println("learn id:"+learn.getLid()+"learn name:"+learn.getLname()+"learn course:"+learn.getLcourse());
		}
		Query query9=ses.createQuery("update Learner1 set lname=:name where lid=:id");
		query9.setParameter("name", "Pavani");
		query9.setLong("id", 13);
		int result=query9.executeUpdate();
		System.out.println("Learner1 update status"+result);
		
		Query query10=ses.createQuery("delete Learner1 where lid=:id");
		query10.setLong("id", 12);
		int result1=query10.executeUpdate();
		System.out.println("Learner1 delete status"+result1);
		
		
		tx.commit();
		ses.close();
		factory.close();
	}

}
