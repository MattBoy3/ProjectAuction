package auction;

import java.util.Date;
import java.util.List;

public interface IAuctionItem {

	public abstract boolean add(Bid bid);

	public abstract boolean equals(Object obj);

	public abstract IBid findBid(IAuctionUser auctionUser);

	public abstract int getAuctionItemId();

	public abstract List<Bid> getBids();

	public abstract String getDescription();

	public abstract IAuctionUser getSeller();

	public abstract IBid getSuccessfulBid();

	public abstract int hashCode();

	public abstract boolean remove(IBid bid);

	public abstract void setAuctionItemId(int auctionItemId);

	public abstract void setBids(List<Bid> bids);

	public abstract void setDescription(String description);

	public abstract void setEnds(Date ends);

	public abstract void setSeller(IAuctionUser seller);

	public abstract void setSuccessfulBid(IBid successfulBid);

	public abstract String toString();

}