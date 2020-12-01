package part19;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class FewColumns {

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
		
		SQLQuery query = session1.createSQLQuery("select STUDENT_MARKS, STUDENT_NAME from STUDENT_DETAILS");
		//Align result to entity map
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List listOfStudents = query.list();
		
		for(Object s : listOfStudents) {
			Map m = (Map)s;
			System.out.println(m.get("STUDENT_NAME") + ":" + m.get("STUDENT_MARKS") );
		}
		
		tx1.commit();
		session1.close();
		
		
		sf.close();
	}

}
