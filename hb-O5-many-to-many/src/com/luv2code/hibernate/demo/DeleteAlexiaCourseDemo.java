	package com.luv2code.hibernate.demo;
	
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;
	
	public class DeleteAlexiaCourseDemo {
	
		public static void main(String[] args) {
			
					//create session factory 
					SessionFactory factory =new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
					
					//create session
					Session session = factory.getCurrentSession();
					
					try {			
						
						//start transaction
						session.beginTransaction();
						
						//get the student youssef from db
						int theId=2;
						Student tempStudent = session.get(Student.class, theId);
						System.out.println("\nLoaded student: " + tempStudent);
						System.out.println("\nCourses: " +tempStudent.getCourses());
						
						//get the java collection course from db
						int courseId=10;
						Course tempCourse =session.get(Course.class, courseId);
						
						//delete the Course
						System.out.println("\n\nDeleting course : "+ tempCourse);
						session.delete(tempCourse);
						
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
