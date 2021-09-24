package in.co.rays.mapping;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestAssoicationO2O {
	public static void main(String[] args) {
		
	
			Employee e = new Employee();
			e.setName("Rahul");
			Address a = new Address();
			a.setAddress("Indore");
			
			e.setAddress(a);
			a.setEmployee(e);
			
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			
			Session session = sessionfactory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			session.save(e);
			
			System.out.println("One to One Mapping!!!");
			
			tx.commit();
			
			session.close();
			   
}
}