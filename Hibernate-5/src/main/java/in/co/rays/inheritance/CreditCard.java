package in.co.rays.inheritance;

import javax.persistence.Entity;

@Entity
public class CreditCard extends Payment {
			private String ccType;

			public String getCcType() {
				return ccType;
			}

			public void setCcType(String ccType) {
				this.ccType = ccType;
			}
			
			
}
