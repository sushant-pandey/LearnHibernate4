package part15;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class GetStudentAndLaptops {

	public static void main(String[] args) {
		Configuration con = new Configuration()
				.configure("hibernate.cfg13.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder()
				.applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		
		//Session 1 begins here
		Session session1 = sf.openSession();
		
		Transaction tx1 = session1.beginTransaction();
		
		Student student1 = (Student)session1.get(Student.class, 101);
		
		System.out.println(student1);
		
		tx1.commit();
		session1.close();
		
		//Session 2 begins here
		Session session2 = sf.openSession();
		
		Transaction tx2 = session2.beginTransaction();
		
		Student student2 = (Student)session2.get(Student.class, 101);
		
		System.out.println(student2);
		
		tx2.commit();
		session2.close();
		
		sf.close();
	}

}
