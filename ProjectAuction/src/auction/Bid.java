package auction;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="BID")
public class Bid implements IBid {
	
									//TODO: type? -> DECIMAL
	@Column(name="AMOUNT", columnDefinition="VARCHAR2(256) CONSTRAINT Bid_AMOUNT_NN NOT NULL")	
	private float amount;
	
	@ManyToOne(targetEntity=AuctionUser.class, cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="BIDDER", columnDefinition="NUMBER(4,0)")
	private IAuctionUser bidder;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATETIME", columnDefinition="DATE CONSTRAINT BID_DATETIME_NN NOT NULL")
	private Date datetime;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BID_SEQ_GENERATOR")
	@SequenceGenerator(name="BID_SEQ_GENERATOR", sequenceName="Bid_SEQ")
	protected int id;
	
	@ManyToOne(targetEntity=AuctionItem.class, cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	@JoinColumn(name="ITEM", columnDefinition="NUMBER(4,0)")	
	private IAuctionItem item;

	public Bid() {
		super();
	}

	/* (non-Javadoc)
	 * @see auction.IBid#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bid other = (Bid) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (bidder == null) {
			if (other.bidder != null)
				return false;
		} else if (!bidder.equals(other.bidder))
			return false;
		if (datetime == null) {
			if (other.datetime != null)
				return false;
		} else if (!datetime.equals(other.datetime))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#getAmount()
	 */
	@Override
	public float getAmount() {
		return amount;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#getBidder()
	 */
	@Override
	public IAuctionUser getBidder() {
		return bidder;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#getDatetime()
	 */
	@Override
	public Date getDatetime() {
		return datetime;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#getId()
	 */
	@Override
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#getItem()
	 */
	@Override
	public IAuctionItem getItem() {
		return item;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((bidder == null) ? 0 : bidder.hashCode());
		result = prime * result
				+ ((datetime == null) ? 0 : datetime.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#setAmount(float)
	 */
	@Override
	public void setAmount(float amount) {
		this.amount = amount;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#setBidder(auction.IAuctionUser)
	 */
	@Override
	public void setBidder(IAuctionUser bidder) {
		this.bidder = bidder;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#setDatetime(java.util.Date)
	 */
	@Override
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#setItem(auction.IAuctionItem)
	 */
	@Override
	public void setItem(IAuctionItem item) {
		this.item = item;
	}

	/* (non-Javadoc)
	 * @see auction.IBid#toString()
	 */
	@Override
	public String toString() {
		return "Bid [bidder=" + bidder.getName() + "]";
	}
}
