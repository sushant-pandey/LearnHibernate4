package part9;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class PersistStudent {

	public static void main(String[] args) {
		Student student1 = 
				new Student(101, "Student1", 80);
		
		Laptop laptop1 =
				new Laptop(10001, "Brand1");
		
		student1.setStudentLaptop(laptop1);
		
		
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
		session.save(student1);
		session.save(laptop1);
		
		tx.commit();
		session.close();
	}

}
