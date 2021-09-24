package in.co.rays.inheritance;

import javax.persistence.Entity;

@Entity
public class Cheque extends Payment {
	
	private int chequeNo;

	public int getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}
	
	

}
