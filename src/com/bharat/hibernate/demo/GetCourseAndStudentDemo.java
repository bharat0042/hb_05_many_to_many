package com.bharat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bharat.hibernate.demo.entity.Course;
import com.bharat.hibernate.demo.entity.Instructor;
import com.bharat.hibernate.demo.entity.InstructorDetails;
import com.bharat.hibernate.demo.entity.Review;
import com.bharat.hibernate.demo.entity.Student;

public class GetCourseAndStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(InstructorDetails.class)
				                                    .addAnnotatedClass(Instructor.class)
				                                    .addAnnotatedClass(Course.class)
				                                    .addAnnotatedClass(Review.class)
				                                    .addAnnotatedClass(Student.class)
				                                    .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int theId = 2;
			Student theStudent = session.get(Student.class, theId);
			System.out.println("\n\n");
			System.out.println(theStudent);
			System.out.println("\n\n");
			System.out.println(theStudent.getCourse());
			session.getTransaction().commit();
			System.out.println("\n\nDone");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}


