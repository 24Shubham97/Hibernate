package in.co.rays.inheritance;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.GenerationType;
@MappedSuperclass
public class Payment {
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int id;
			
			@Column(name = "amount")
			private int amount;

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public int getAmount() {
				return amount;
			}

			public void setAmount(int amount) {
				this.amount = amount;
			}

			
			
}
