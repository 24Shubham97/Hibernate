package in.co.rays.inheritance.TablePerSubClass;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import in.co.rays.inheritance.TablePerClass.Cash;
import in.co.rays.inheritance.TablePerClass.Cheque;
import in.co.rays.inheritance.TablePerClass.CreditCardPayment;

public class InheritanceTest1 {
	public static void main(String[] args) {
		CreditCardPayment1 creditcard = new CreditCardPayment1();
		//	creditcard.setId(1);
			creditcard.setAmount(50000);
			creditcard.setCcType("VISA");
			Cash1 cash = new Cash1();
			cash.setAmount(45000);
			
			Cheque1 cheque = new Cheque1();
			cheque.setAmount(60000);
			cheque.setChequeNo(12345);
			
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
