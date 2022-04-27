package com.namedqueries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernates.Employee;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session ses=factory.openSession();
		Transaction tx=ses.beginTransaction();
		
		Employee1 e1=new Employee1();
		e1.setEid(1);
		e1.setEname("Samyuktha");
		e1.setEsal(45000);
		e1.setEcity("Hyderabad");
		e1.setEdeg("Junior Engineer");
		
		Employee1 e2=new Employee1();
		e2.setEid(2);
		e2.setEname("Hari");
		e2.setEsal(65000);
		e2.setEcity("Secunderabad");
		e2.setEdeg("Senior Engineer");
		
		List<Employee1>list1=new ArrayList<Employee1>();
		list1.add(e1);
		list1.add(e2);
		 ses.save(e1);
		 ses.save(e2);
		
	/*TypedQuery query=ses.getNamedQuery("findEmployee1ByName");
		query.setParameter("name","Samyuktha");
		List<Employee1> employees=query.getResultList();
		Iterator<Employee1>Itr=employees.iterator();
		while(Itr.hasNext()) {
			Employee1 e=Itr.next();
			System.out.println(e);
		}*/
		/* Query query=ses.getNamedQuery("findEmployee1ByID");
		 query.setInteger("ID", 2);
		 List<Employee1>list=query.list();
		 for(int i=0;i<list.size();i++) {
			 System.out.println("Name:"+list.get(i).getEname());
		 }
		 System.out.println(">>>>>"+list.size());
		 if(!list.isEmpty()) {
			 Employee1 e=(Employee1)list.get(0);
			 System.out.println(e);
		 }*/
		tx.commit();
		ses.close();
		factory.close();
	}

}
