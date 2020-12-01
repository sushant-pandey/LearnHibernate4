package part18;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class RollNum107A {

	public static void main(String[] args) {
		Configuration con = new Configuration()
				.configure("hibernate.cfg18B.xml")
				.addAnnotatedClass(Student.class);
		ServiceRegistry reg = new ServiceRegistryBuilder()
				.applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		
		//Session 1 begins here
		Session session1 = sf.openSession();
		
		Transaction tx1 = session1.beginTransaction();
		
		Query q1 = session1.createQuery("select rollNum, studentName, marks from Student where rollNum = 107");
		q1.setCacheable(true);
		Object[] arrO = (Object[])q1.uniqueResult();
		for(Object o : arrO) {
			System.out.println(o);
		}
		
		tx1.commit();
		session1.close();
		
		
		sf.close();
	}

}
