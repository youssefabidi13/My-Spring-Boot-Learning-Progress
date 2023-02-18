	package com.luv2code.hibernate.demo;
	
	import java.util.List;

import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	
	import com.luv2code.hibernate.demo.entity.Student;
	
	public class QueryStudentDemo {
	
		public static void main(String[] args) {
			
					//create session factory 
					SessionFactory factory =new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
					
					//create session
					Session session = factory.getCurrentSession();
					
					try {	
						
						//start transaction
						session.beginTransaction();
						
						//query the student
						List<Student> theStudents=session.createQuery("from Student").getResultList();
						
						//display the student
						displayStudents(theStudents);
						
						//query students : lastname='maradona'
						theStudents=session.createQuery("from Student s where s.lastName='maradona'").getResultList();
						
						//display the student
						System.out.println("maradona last name");
						displayStudents(theStudents);
						
						//query students where email like'%etu.uae.ac.ma'
						theStudents=session.createQuery("from Student s where s.email like '%etu.uae.ac.ma'").getResultList();
						
						//display the student
						System.out.println("%etu.uae.ac.ma");
						displayStudents(theStudents);
						//commit transaction
						session.getTransaction().commit();
						System.out.println("Done!!");
						
					}finally{
						factory.close();
					}
		}

		private static void displayStudents(List<Student> theStudents) {
			//display the student
			for(Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
		}
	
	}
