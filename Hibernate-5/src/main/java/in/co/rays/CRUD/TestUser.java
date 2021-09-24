package in.co.rays.CRUD;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestUser {
	public static void main(String[] args) throws Exception {
		// Testadd();
		// Testupdate();
		// Testdelete();
	//	Testget();
	//	TestUpdateSingleColumn();
		fNamedQuery();
	}

	public static void Testadd() throws Exception {
		User u = new User();

		u.setFirstName("Ravi");
		u.setLastName("Rathore");
		u.setPassword(12345);
		u.setUserName("ravi.rathore");

		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();

		Session session = sessionfactory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(u);

		tx.commit();

		session.close();

		HibernateUtil.shutdown();

	}

	public static void Testupdate() throws Exception {
		User u = new User();

		u.setFirstName("Shubham");
		u.setLastName("Bairagi");
		u.setPassword(123456);
		u.setUserName("shubham.bairagi");
		u.setId(3);

		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();

		Session session = sessionfactory.openSession();

		Transaction tx = session.beginTransaction();

		session.update(u);

		tx.commit();

		session.close();

		HibernateUtil.shutdown();

	}

	public static void Testdelete() throws Exception {
		User u = new User();

		u.setId(3);

		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();

		Session session = sessionfactory.openSession();

		Transaction tx = session.beginTransaction();

		session.delete(u);

		tx.commit();

		session.close();

		HibernateUtil.shutdown();

	}

	public static void Testget() throws Exception {

		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		User u = (User) session.get(User.class, 2);

		System.out.println(u.getId());
		System.out.println(u.getFirstName());
		System.out.println(u.getLastName());
		System.out.println(u.getUserName());
		System.out.println(u.getPassword());
		session.close();
		HibernateUtil.shutdown();
	}

	public static void TestUpdateSingleColumn() throws Exception {

		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		int id = 1;
		String newName = "Ramesh";
		Transaction tx = session.beginTransaction();
		String hqlUpdate = "update User u set u.firstName = :newName where u.id = :id";

		int updatedEntities = session.createQuery(hqlUpdate).setParameter("newName", newName).setParameter("id", id)
				.executeUpdate();
		tx.commit();

		session.close();
		HibernateUtil.shutdown();
	}
	
	public static void fNamedQuery() throws Exception {

		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		Query query =  session.getNamedQuery("alluser");
		List<User> list =  query.getResultList();
		
		for (User user : list) {
			System.out.println(user.getId());
			System.out.println(user.getFirstName());
			System.out.println(user.getLastName());
			System.out.println(user.getUserName());
			System.out.println(user.getPassword());
		}
		
		
		  session.close(); HibernateUtil.shutdown();
		 
	}

}
