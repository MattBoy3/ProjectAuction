package auction;

import java.util.List;

public interface IAuctionUser {

	public abstract boolean add(AuctionItem auctionItem);

	public abstract boolean add(Bid bid);

	public abstract boolean equals(Object obj);

	public abstract List<AuctionItem> getAuctions();

	public abstract int getAuctionUserId();

	public abstract List<Bid> getBids();

	public abstract String getEmail();

	public abstract IName getName();

	public abstract String getPassword();

	public abstract String getUsername();

	public abstract int hashCode();

	public abstract boolean remove(IAuctionItem auctionItem);

	public abstract boolean remove(IBid bid);

	public abstract void setAuctions(List<AuctionItem> auctions);

	public abstract void setAuctionUserId(int auctionUserId);

	public abstract void setBids(List<Bid> bids);

	public abstract void setEmail(String email);

	public abstract void setName(IName name);

	public abstract void setPassword(String password);

	public abstract void setUsername(String username);

}