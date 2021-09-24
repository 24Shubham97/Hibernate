package in.co.rays.inheritance;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.co.rays.CRUD.HibernateUtil;

public class TestInheritance {
			public static void main(String[] args) throws Exception {
				
				CreditCard creditcard = new CreditCard();
				creditcard.setAmount(50000);
				creditcard.setCcType("Rupay");
				
				Cash cash = new Cash();
				cash.setAmount(25000);
				
				Cheque cheque = new Cheque();
				cheque.setAmount(15000);
				cheque.setChequeNo(12345);
				
				SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
				
				Session session = sessionfactory.openSession();
				
				Transaction tx = session.beginTransaction();
				
				session.save(creditcard);
				session.save(cash);
				session.save(cheque);
				System.out.println("inserted");
				
				tx.commit();
				
				session.close();
				
				HibernateUtil.shutdown();
				
				
			}
}
