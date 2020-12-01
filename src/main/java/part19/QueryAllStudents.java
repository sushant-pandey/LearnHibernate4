package part19;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class QueryAllStudents {

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
		
		//SQL Query goes here
		
		SQLQuery query = session1.createSQLQuery("select * from STUDENT_DETAILS");
		query.addEntity(Student.class);
		List<Student> listOfStudents = query.list();
		
		for(Student s : listOfStudents) {
			System.out.println(s);
		}
		
		tx1.commit();
		session1.close();
		
		
		sf.close();
	}

}
