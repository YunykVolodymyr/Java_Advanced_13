package ua.yunyk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	private static SessionFactory sessiionFactory;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		sessiionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessiionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Obj obj = new Obj("1email", "1password", "1firstName", "1lastName", "1role");
		
		Integer id = (Integer) session.save(obj);
		transaction.commit();
		session.close();
		System.out.println(id);
		
		
	}	
	
}
