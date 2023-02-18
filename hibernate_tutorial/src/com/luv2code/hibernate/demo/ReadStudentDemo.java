	package com.luv2code.hibernate.demo;
	
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	
	import com.luv2code.hibernate.demo.entity.Student;
	
	public class ReadStudentDemo {
	
		public static void main(String[] args) {
			
					//create session factory 
					SessionFactory factory =new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
					
					//create session
					Session session = factory.getCurrentSession();
					
					try {			
						//create a student object 
						System.out.println("Creating new object");
						Student tempStudent =new Student("Neymar","Junior","Neymar.Junior@etu.uae.ac.ma");
						
						//start transaction
						session.beginTransaction();
						
						//save the student object
						System.out.println("Saving the student");
						System.out.println(tempStudent);

						session.save(tempStudent);
						
						//commit transaction
						session.getTransaction().commit();
						
						//My new Code
						
						//find out the student's id :primary Key
						System.out.println("Saved Student. Generated Id: "+tempStudent.getId());
						
						//now get a new session and start transaction
						session=factory.getCurrentSession();
						session.beginTransaction();
						
						//retrieve student based on the id: primary key
						 System.out.println("\nGetting student with id: " + tempStudent.getId());
						 Student myStudent =session.get(Student.class, tempStudent.getId());
						 System.out.println("Get complete: " + myStudent);
						 
						//commit transaction
						session.getTransaction().commit();
						System.out.println("Done!!");
						
					}finally{
						factory.close();
					}
		}
	
	}
