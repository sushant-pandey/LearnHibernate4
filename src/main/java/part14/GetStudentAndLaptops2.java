package part14;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class GetStudentAndLaptops2 {

	public static void main(String[] args) {
		Configuration con = new Configuration()
				.configure("hibernate.cfg13.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder()
				.applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Student student1 = (Student)session.get(Student.class, 101);
		
		System.out.println(student1);
		
		for(Laptop l : student1.getStudentLaptops()) {
			System.out.println(l);
		}
		
		tx.commit();
		session.close();
	}

}
