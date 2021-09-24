package in.co.rays.CRUD;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="User")
@NamedQuery(name="alluser", query="from User" )
public class User {
		@Id
		@GeneratedValue(generator = "increment")
		@GenericGenerator(name = "increment", strategy="increment")
		@Column(name = "ID")
		private int id;
		
		@Column(name = "FIRSTNAME")
		private String firstName;
		
		@Column(name = "LASTNAME")
		private String lastName;
		
		@Column(name = "USERNAME")
		private String userName;
		
		@Column(name = "PASSWORD")
		private int password;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String string) {
			this.firstName = string;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public int getPassword() {
			return password;
		}

		public void setPassword(int password) {
			this.password = password;
		}
		
}
