package in.co.rays.inheritance.TablePerClass;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestInheritance {
	public static void main(String[] args) {
		CreditCardPayment creditcard = new CreditCardPayment();
	//	creditcard.setId(1);
		creditcard.setAmount(50000);
		creditcard.setCcType("VISA");
		Cash cash = new Cash();
		cash.setAmount(45000);
		
		Cheque cheque = new Cheque();
		cheque.setAmount(60000);
		cheque.setchequeNo(12345);
		
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionfactory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(creditcard);
		session.save(cash);
		session.save(cheque);
		System.out.println("inserted");
		tx.commit();

		session.close();

		
	}
}
