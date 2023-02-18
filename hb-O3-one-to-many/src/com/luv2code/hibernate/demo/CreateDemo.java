	package com.luv2code.hibernate.demo;
	
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
	
	public class CreateDemo {
	
		public static void main(String[] args) {
			
					//create session factory 
					SessionFactory factory =new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
					
					//create session
					Session session = factory.getCurrentSession();
					
					try {			
						
						//create the objects
						/*
						Instructor tempInstructor = 
								new Instructor("chad","Darby","darby@luv2code.com");
						
						InstructorDetail tempInstructorDetail =
								new InstructorDetail("http://www.lu2cod.com/youtube",
										"Luv 2 code !!!");
						*/
						
						Instructor tempInstructor = 
								new Instructor("youssef","Abidi","youssef@luv2code.com");
						
						InstructorDetail tempInstructorDetail =
								new InstructorDetail("http://www.youssef.com/youtube",
										"football !!!");
						
						// associate the objects
						tempInstructor.setInstructorDetail(tempInstructorDetail);
						
						//start transaction
						session.beginTransaction();
						
						//save the instructor
						System.out.println("Saving Constructor: " + tempInstructor);
						session.save(tempInstructor);
						
						//commit transaction
						session.getTransaction().commit();
						System.out.println("Done!!");
						
					}finally{
						factory.close();
					}
		}
	
	}
