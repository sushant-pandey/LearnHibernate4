package part5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AlienClient {

	public static void main(String[] args) {
		Alien alien = new Alien();
		alien.setAlienId(101);
		alien.setAlienName("Alien1");
		alien.setAlienColor("Color1");
		
		Configuration con = new Configuration()
				.configure("hibernate.cfg3.xml")
				.addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder()
				.applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(alien);
		tx.commit();
		session.close();
	}

}
