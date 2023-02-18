package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory 
		SessionFactory factory =new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			//create few students object 
			System.out.println("Creating new object");
			Student tempStudent1 =new Student("Youssef","ABIDI1","youssef.abidi1@etu.uae.ac.ma");
			Student tempStudent2 =new Student("Youssef","Messi","youssef.messi@etu.uae.ac.ma");
			Student tempStudent3 =new Student("Youssef","maradona","youssef.maradona@etu.uae.ac.ma");

			//start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}finally{
			factory.close();
		}
	}

}
