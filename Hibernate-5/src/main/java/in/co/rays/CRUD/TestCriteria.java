package in.co.rays.CRUD;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestCriteria {
			public static void main(String[] args) throws Exception {
				SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
				Session session = sessionfactory.openSession();
				
				CriteriaBuilder builder = session.getCriteriaBuilder();
				
				CriteriaQuery<User> query =  builder.createQuery(User.class);
				
				Root<User> root =  query.from(User.class);
				
			//	query.select(root).where(builder.equal(root.get("id"), 1));
				
				Query q =  session.createQuery(query);
				
				List<User> list = q.getResultList();
				
				Iterator<User> it =  list.iterator();
				
				while (it.hasNext()) {
					User user = (User) it.next();
					
					System.out.println(user.getId());
					System.out.println(user.getFirstName());
					System.out.println(user.getLastName());
					System.out.println(user.getUserName());
					System.out.println(user.getPassword());
					
				}
			}
}
