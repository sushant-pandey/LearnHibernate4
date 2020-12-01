package part20;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class PersistLaptop {

	public static void main(String[] args) {
				
		Configuration con = new Configuration()
				.configure("hibernate.cfg20A.xml")
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder()
				.applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Random random = new Random();
		for(int i = 1; i <= 50; i++) {
			int rollNum = 1000+i;
			String name = "Brand_" + rollNum;
			int price = random.nextInt(2000);
			Laptop laptop = new Laptop(rollNum, name, price);
			session.save(laptop);
		}
				
		tx.commit();
		session.close();
		sf.close();
	}

}
