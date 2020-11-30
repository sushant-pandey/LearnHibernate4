package part1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AlienClient {

	public static void main(String[] args) {
		Alien alien = new Alien();
		alien.setAlienId(101);
		alien.setAlienName("Alien1");
		alien.setAlienColor("Green");
		
		Configuration con = new Configuration().configure("hibernate.cfg1.xml").addAnnotatedClass(Alien.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(alien);
		tx.commit();
	}

}
