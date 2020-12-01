package part12;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class PersistStudent {

	public static void main(String[] args) {
		//Creating the student objects
		Student student1 = 
				new Student(101, "Student1", 80);
		Student student2 = 
				new Student(102, "Student2", 90);
		
		//Creating the laptop objects
		Laptop laptop1 =
				new Laptop(10001, "Brand1");
		Laptop laptop2 =
				new Laptop(10002, "Brand2");
		Laptop laptop3 =
				new Laptop(10003, "Brand3");
		
		//Assigning laptops to students
		student1.getStudentLaptops().add(laptop1);
		student1.getStudentLaptops().add(laptop2);
		student2.getStudentLaptops().add(laptop3);
		
		laptop1.getStudent().add(student1);
		laptop2.getStudent().add(student1);
		laptop3.getStudent().add(student2);
		
		Configuration con = new Configuration()
				.configure("hibernate.cfg8.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder()
				.applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//Save laptop entries in table
		session.save(laptop1);
		session.save(laptop2);
		session.save(laptop3);
		
		//Save Student entries in table
		session.save(student1);
		session.save(student2);
		
		tx.commit();
		session.close();
	}

}
