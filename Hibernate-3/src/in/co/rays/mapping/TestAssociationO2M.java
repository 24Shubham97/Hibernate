package in.co.rays.mapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestAssociationO2M {
			public static void main(String[] args) {
				AuctionItem item = new AuctionItem();
				
		//		item.setDescription("Pen");
				item.setDescription("Car");
				
				Bid bid1 = new Bid();
				bid1.setAmount(1000);
				
				Bid bid2 = new Bid();
				bid2.setAmount(2000);
				
				Bid bid3 = new Bid();
				bid3.setAmount(5000);
				
				Set<Bid> bids = new HashSet<Bid>();
				
				bids.add(bid1);
				bids.add(bid2);
				bids.add(bid3);
				
				item.setBids(bids);
				
				
				
				SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
				
				Session session = sessionfactory.openSession();
				
				Transaction tx = session.beginTransaction();
				
				session.save(item);
				System.out.println("One to many Associaton");
				tx.commit();
				
				session.close();
				
				
				
			}
}
