package part7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class GetAliens {

	public static void main(String[] args) {
		Alien alien = null;
		
		Configuration con = new Configuration()
				.configure("hibernate.cfg6.xml")
				.addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder()
				.applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		alien = (Alien)session.get(Alien.class, 102);
		tx.commit();
		session.close();
		
		System.out.println(alien);
	}

}
