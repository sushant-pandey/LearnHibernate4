package part7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class PersistAliens {

	public static void main(String[] args) {
		Alien alien1 = 
				new Alien(101, 
						new AlienName("first101", "last101", "mid101"),
						"Color1");
		
		Alien alien2 = 
				new Alien(102, 
						new AlienName("first102", "last102", "mid102"),
						"Color2");
		
		Alien alien3 = 
				new Alien(103, 
						new AlienName("first103", "last103", "mid103"),
						"Color3");
		
		Configuration con = new Configuration()
				.configure("hibernate.cfg7.xml")
				.addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder()
				.applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(alien1);
		session.save(alien2);
		session.save(alien3);
		tx.commit();
		session.close();
	}

}
