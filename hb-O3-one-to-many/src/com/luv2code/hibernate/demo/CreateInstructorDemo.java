	package com.luv2code.hibernate.demo;
	
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
	
	public class CreateInstructorDemo {
	
		public static void main(String[] args) {
			
					//create session factory 
					SessionFactory factory =new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
					
					//create session
					Session session = factory.getCurrentSession();
					
					try {			
						
						//create the objects
					
						Instructor tempInstructor = 
								new Instructor("Susan","Public","susan.public@luv2code.com");
						
						InstructorDetail tempInstructorDetail =
								new InstructorDetail("http://www.susan.com/youtube",
										"Gamers !!!");
						
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
						//add clean up code
						session.close();
						factory.close();
					}
		}
	
	}
