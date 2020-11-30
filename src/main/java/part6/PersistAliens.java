package part6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class PersistAliens {

	public static void main(String[] args) {
		Alien alien1 = new Alien();
		alien1.setAlienId(101);
		alien1.setAlienName("Alien1");
		alien1.setAlienColor("Color1");
		
		Alien alien2 = new Alien();
		alien2.setAlienId(102);
		alien2.setAlienName("Alien2");
		alien2.setAlienColor("Color2");
		
		Alien alien3 = new Alien();
		alien3.setAlienId(103);
		alien3.setAlienName("Alien3");
		alien3.setAlienColor("Color3");
		
		Configuration con = new Configuration()
				.configure("hibernate.cfg6.xml")
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
