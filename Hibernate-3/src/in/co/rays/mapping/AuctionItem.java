package in.co.rays.mapping;

import java.util.Set;

public class AuctionItem {
		private int id;
		private String description;
		private Set<Bid> bids;
		 
		public AuctionItem() {}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Set<Bid> getBids() {
			return bids;
		}

		public void setBids(Set<Bid> bids) {
			this.bids = bids;
		}
		
		
}
