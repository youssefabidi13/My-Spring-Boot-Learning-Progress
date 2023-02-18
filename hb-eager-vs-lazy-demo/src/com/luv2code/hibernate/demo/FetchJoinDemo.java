	package com.luv2code.hibernate.demo;
	
	import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
	
	public class FetchJoinDemo {
	
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
						
						//start transaction
						session.beginTransaction();
						
						//option2: Hibernate query with HQL
						int theId=1;
						Query<Instructor> query= 
								session.createQuery("select i from Instructor i "
											+"JOIN FETCH i.courses "
											+ "where i.id=:theInstructorId",
										Instructor.class);
						
						//set parameter on query
						query.setParameter("theInstructorId", theId);
						
						//execute query and get instructor
						Instructor tempInstructor =query.getSingleResult();
						System.out.println("luv2code: Instructor: " + tempInstructor);
						
						//commit transaction
						session.getTransaction().commit();
						
						//add clean up code
						session.close();			
						System.out.println("\nluv2code: The session is closed!\n");
						
						//get courses for the instructor$
						System.out.println("luv2code: Courses: " +tempInstructor.getCourses());
						System.err.println("Doneeeeee");
				
						
					}finally{
						//add clean up code
						session.close();
						factory.close();
					}
		}
	
	}
