package com.bharat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bharat.hibernate.demo.entity.Course;
import com.bharat.hibernate.demo.entity.Instructor;
import com.bharat.hibernate.demo.entity.InstructorDetails;
import com.bharat.hibernate.demo.entity.Review;
import com.bharat.hibernate.demo.entity.Student;

public class CreatCourseAndStudentDemo {

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
			Course tempCourse = new Course("Crack the cube in 2 hours!");
			Student tempStudent1 = new Student("Jhon", "Doe", "jhondoe@spring.com");
			Student tempStudent2 = new Student("Amber", "Public", "ab@spring.com");
			tempCourse.add(tempStudent1);
			tempCourse.add(tempStudent2);
			session.save(tempCourse);
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.getTransaction().commit();
			System.out.println("\n\nDone");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}


