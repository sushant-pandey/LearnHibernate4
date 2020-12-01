package part18;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class PersistStudent {

	public static void main(String[] args) {
				
		Configuration con = new Configuration()
				.configure("hibernate.cfg18A.xml")
				.addAnnotatedClass(Student.class);
		ServiceRegistry reg = new ServiceRegistryBuilder()
				.applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Random random = new Random();
		for(int i = 1; i <= 50; i++) {
			int rollNum = 100+i;
			String name = "Name_" + rollNum;
			int marks = random.nextInt(100);
			Student student = new Student(rollNum, name, marks);
			session.save(student);
		}
				
		tx.commit();
		session.close();
		sf.close();
	}

}
