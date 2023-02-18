	package com.luv2code.hibernate.demo;
	
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	
	import com.luv2code.hibernate.demo.entity.Student;
	
	public class updateStudentDemo {
	
		public static void main(String[] args) {
			
					//create session factory 
					SessionFactory factory =new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
					
					//create session
					Session session = factory.getCurrentSession();
					
					try {			
						
						int studentId =1;
						
						//now get a new session and start transaction
						session=factory.getCurrentSession();
						session.beginTransaction();
						
						//retrieve student based on the id: primary key
						 System.out.println("\nGetting student with id: " + studentId);
						 Student myStudent =session.get(Student.class, studentId);
						 System.out.println("Updating student ...");
						 myStudent.setFirstName("Demaria");
						 
						//commit transaction
						session.getTransaction().commit();
						System.out.println("Done!!");
						
						//New Code
						session=factory.getCurrentSession();
						session.beginTransaction();
						System.out.println("Update all student");
						session.createQuery("update Student set email='poo@gmail.com'").executeUpdate();
						//commit transaction
						session.getTransaction().commit();
						System.out.println("Done!!");
						
					}finally{
						factory.close();
					}
		}
	
	}
