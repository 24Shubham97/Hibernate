package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import in.co.rays.User;

public class Test {
	public static void main(String[] args) throws Exception {
	//	 Testadd();
		// Testupdate();
		// Testdelete();
		// Testget();
		// Testlist();
		// TestArray();
		// TestCriteria();
		// TestCriteriaAdvance();
	//	TestProjection();
	//	TestProjection();
		//TestProjection2();
	//	TestProjection3();
		 Authenticate("rahul123@gmail.com","12345");
		 TestMerge();
	}

	private static void TestMerge() {
		User user = new User();

		user.setId(2);
		user.setFname("Roshani");
		user.setLname("Pal");

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		Transaction tx = session.beginTransaction();

		session.update(user);
		System.out.println("updated");
		tx.commit();

		session.close();

	}

	}

	public static User Authenticate(String login,String pwd) throws Exception {
		User u = new User();
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		
		Session session =  sessionfactory.openSession();
		Query q = session.createQuery("from User where username = ? and password = ?");
		
		q.setString(0, login);
		q.setString(1, pwd);
		List list = q.list();
		
		if(list.size() == 1) {
			 u = (User) list.get(0);
			u.getUsername();
			System.out.println(u.getFname());
			
		}else {
			throw new Exception("login.invalid.User");
		}
		session.close();
		
			
		return u;
		}
		
		

	
	private static void Testadd() {
		User user = new User();

		user.setFname("Rahul");
		user.setLname("Bairagi");
		user.setUsername("rahul123@gmail.com");
		user.setPassword("12345");

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(user);
		System.out.println("inserted");
		tx.commit();

		session.close();

	}

	private static void Testupdate() {
		User user = new User();

		user.setId(2);
		user.setFname("Roshani");
		user.setLname("Pal");

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		Transaction tx = session.beginTransaction();

		session.update(user);
		System.out.println("updated");
		tx.commit();

		session.close();

	}

	private static void Testdelete() {
		User user = new User();

		user.setId(3);

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		Transaction tx = session.beginTransaction();

		session.delete(user);
		System.out.println("deleted");
		tx.commit();

		session.close();

	}

	private static void Testget() {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		User usr = (User) session.get(User.class, 2);
		// Transaction tx = session.beginTransaction();

		System.out.println(usr.getId());
		System.out.println(usr.getFname());
		System.out.println(usr.getLname());
		
	//	session.evict(usr);    // evict do the clear indivisual object from the cache.
		
		  session.clear(); // clear do the all clear object from the cache.
		  sessionfactory.close();
		  
		  SessionFactory sessionfactory1 = new Configuration().configure().buildSessionFactory();
		  Session session1 = sessionfactory1.openSession();
		  User usr1 = (User) session1.get(User.class, 2);
		  
		  System.out.println(usr1.getId());
		  System.out.println(usr1.getFname());
		  System.out.println(usr1.getLname());
		 
		
		// tx.commit();

		session.close();

	}

	private static void Testlist() {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		Query q = session.createQuery("from User");

		List list = q.list();

		Iterator<User> it = list.iterator();

		while (it.hasNext()) {
			User user = (User) it.next();
			System.out.println(user.getId());
			System.out.println(user.getFname());
			System.out.println(user.getLname());
		}
		session.close();

	}

	private static void TestArray() {

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		Query q = session.createQuery("select p.id,p.fname from User p");

		List list = q.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			Object[] ob = (Object[]) it.next();
			System.out.println(ob[0]);
			System.out.println(ob[1]);

		}
		session.close();

	}

	private static void TestCriteria() {
//		User user = new User();

		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		Criteria crit = session.createCriteria(User.class);

		List<User> list = crit.list();

		Iterator<User> it = list.iterator();

		while (it.hasNext()) {
			User user = (User) it.next();
			System.out.println(user.getId());
			System.out.println(user.getFname());
			System.out.println(user.getLname());

		}
		// Transaction tx = session.beginTransaction();

		// tx.commit();

		session.close();

	}

	private static void TestCriteriaAdvance() {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		Criteria crit = session.createCriteria(User.class);

		crit.add(Restrictions.like("lname", "Bai%"));
//	crit.add(Restrictions.eq("id", 5));

		List<User> list = crit.list();

		Iterator<User> it = list.iterator();

		while (it.hasNext()) {
			User user = (User) it.next();
			System.out.println(user.getId());
			System.out.println(user.getFname());
			System.out.println(user.getLname());

		}
		
		{

		}

	}

	private static void TestProjection() {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		Criteria crit = session.createCriteria(User.class);
		
		ProjectionList p = Projections.projectionList();
		
		p.add(Projections.property("id"));
		p.add(Projections.property("fname"));
		
		crit.setProjection(p);
		
		List list = crit.list();
		
		Iterator it = list.iterator();
		Object[] array; 
		
		while (it.hasNext()) {
			array= (Object[])it.next();
			
			System.out.println(array[0]);
			System.out.println(array[1]);
		}
	}
	
	private static void TestProjection3() {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		Criteria crit = session.createCriteria(User.class);
		
		crit.add(Restrictions.or(Restrictions.like("id", 5), Restrictions.like("fname","Shubham")));
		
		List list = crit.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			User user = (User) it.next();
			System.out.println(user.getId());
			System.out.println(user.getFname());
			System.out.println(user.getLname());
			

		}
		
	}

	private static void TestProjection2() {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		Criteria crit = session.createCriteria(User.class);
		
		ProjectionList p = Projections.projectionList();
		
		p.add(Projections.count("id"));
		p.add(Projections.groupProperty("fname"));
		crit.setProjection(p);
		
		List list = crit.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			Object user = (Object) it.next();
			System.out.println(user);
			

		}
		
		
		
	}


}
