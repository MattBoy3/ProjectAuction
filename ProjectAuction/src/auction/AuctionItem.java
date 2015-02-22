package auction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="AuctionItem")
public class AuctionItem implements IAuctionItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AuctionItem_SEQ_GENERATOR")
	@SequenceGenerator(name="AuctionItem_SEQ_GENERATOR", sequenceName="AuctionItem_SEQ")	
	@Column(name="AUCTIONITEMID", columnDefinition="NUMBER(4,0)")	
	private int auctionItemId = 0;
	
	//TODO: bids 
	private List<Bid> bids = new ArrayList<Bid>();
	
	@Column(name="DESCRIPTION", columnDefinition="VARCHAR2(256) CONSTRAINT AuctionItem_DESCRIPTION_NN NOT NULL")	
	private String description;	
	
	@Temporal(TemporalType.DATE)
	@Column(name="ENDS", columnDefinition="DATE CONSTRAINT AuctionItem_Ends_NN NOT NULL")	
	private Date ends;

	
	@ManyToOne(targetEntity=AuctionUser.class, cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="SELLER", columnDefinition="NUMBER(4,0)")
	private IAuctionUser seller;
	
	@OneToOne(targetEntity=Bid.class, cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="SUCCESSFULBID", columnDefinition="NUMBER(4,0)")	
	private IBid successfulBid;

	public AuctionItem() {
		super();
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#add(auction.Bid)
	 */
	@Override
	public boolean add(Bid bid) {
		boolean answer;
		answer = this.getBids().add(bid);
		answer = bid.getBidder().add(this);

		return answer;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuctionItem other = (AuctionItem) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (ends == null) {
			if (other.ends != null)
				return false;
		} else if (!ends.equals(other.ends))
			return false;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#findBid(auction.AuctionUser)
	 */
	@Override
	public IBid findBid(IAuctionUser auctionUser) {
		for (IBid bid : this.getBids()) {
			if (bid.getBidder().equals(auctionUser))
				return bid;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#getAuctionItemId()
	 */
	@Override
	public int getAuctionItemId() {
		return auctionItemId;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#getBids()
	 */
	@Override
	public List<Bid> getBids() {
		return bids;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#getSeller()
	 */
	@Override
	public IAuctionUser getSeller() {
		return seller;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#getSuccessfulBid()
	 */
	@Override
	public IBid getSuccessfulBid() {
		return successfulBid;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((ends == null) ? 0 : ends.hashCode());
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#remove(auction.Bid)
	 */
	@Override
	public boolean remove(IBid bid) {
		boolean answer = false;
		if (this.getBids().contains(bid)) {
			answer = bid.getBidder().remove(this);
		}
		return answer;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setAuctionItemId(int)
	 */
	@Override
	public void setAuctionItemId(int auctionItemId) {
		this.auctionItemId = auctionItemId;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setBids(java.util.List)
	 */
	@Override
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setEnds(java.util.Date)
	 */
	@Override
	public void setEnds(Date ends) {
		this.ends = ends;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setSeller(auction.AuctionUser)
	 */
	@Override
	public void setSeller(IAuctionUser seller) {
		this.seller = seller;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#setSuccessfulBid(auction.Bid)
	 */
	@Override
	public void setSuccessfulBid(IBid successfulBid) {
		this.successfulBid = successfulBid;
	}

	/* (non-Javadoc)
	 * @see auction.IAuctionItem#toString()
	 */
	@Override
	public String toString() {
		return "AuctionItem [description=" + description + ", ends=" + ends
				+ ", seller=" + seller + "]";
	}

}
