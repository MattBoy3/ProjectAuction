package auction;

import java.util.Date;

public interface IBid {

	public abstract boolean equals(Object obj);

	public abstract float getAmount();

	public abstract IAuctionUser getBidder();

	public abstract Date getDatetime();

	public abstract int getId();

	public abstract IAuctionItem getItem();

	public abstract int hashCode();

	public abstract void setAmount(float amount);

	public abstract void setBidder(IAuctionUser bidder);

	public abstract void setDatetime(Date datetime);

	public abstract void setId(int id);

	public abstract void setItem(IAuctionItem item);

	public abstract String toString();

}