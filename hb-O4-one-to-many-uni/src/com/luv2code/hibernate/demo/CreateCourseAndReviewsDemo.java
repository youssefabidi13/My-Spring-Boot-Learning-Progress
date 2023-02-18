	package com.luv2code.hibernate.demo;
	
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
	
	public class CreateCourseAndReviewsDemo {
	
		public static void main(String[] args) {
			
					//create session factory 
					SessionFactory factory =new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
					
					//create session
					Session session = factory.getCurrentSession();
					
					try {			
						
						//start transaction
						session.beginTransaction();
						
						//create a course
						Course tempCourse = new Course("Java - Collection");
						
						//add some review
						tempCourse.addReview(new Review("Great course ... love it"));
						tempCourse.addReview(new Review("well Job"));
						tempCourse.addReview(new Review("it's good what the hell"));

						//save the course and leverage the cascade all :-)
						System.out.println("Saving course ......");
						session.save(tempCourse);
						System.out.println(tempCourse.getReviews());
						
						session.save(tempCourse);
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
