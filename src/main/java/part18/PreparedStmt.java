package part18;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class PreparedStmt {

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
		int num = 125;
		Query q1 = session1.createQuery("select sum(s.marks) from Student s where s.rollNum > :num");
		q1.setParameter("num", num);
		q1.setCacheable(true);
		List<Object> larrO = q1.list();
		for(Object arrO : larrO) {			
				System.out.println(arrO);			
		}
		
		
		tx1.commit();
		session1.close();
		
		
		sf.close();
	}

}
