	package com.luv2code.hibernate.demo;
	
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;
	
	public class AddCoursesForYoussefDemo {
	
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
						int theId=1;
						Student tempStudent = session.get(Student.class, theId);
						System.out.println("\nLoaded student: " + tempStudent);
						System.out.println("\nCourses: " +tempStudent.getCourses());
						
						//create more courses
						Course tempCourse1 = new Course("JavaScript");
						Course tempCourse2 = new Course("Angular");
						Course tempCourse3 = new Course("Jenkins");


						//add student to courses
						tempStudent.addCourse(tempCourse1);
						tempStudent.addCourse(tempCourse2);
						tempStudent.addCourse(tempCourse3);

						//save the courses
						System.out.println("\n\nSaving the courses");
						session.save(tempCourse1);
						session.save(tempCourse2);
						session.save(tempCourse3);
						
						
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
