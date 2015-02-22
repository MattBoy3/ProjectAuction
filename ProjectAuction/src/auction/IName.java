package auction;

public interface IName {

	public abstract boolean equals(Object obj);

	public abstract String getFirstName();

	public abstract String getLastName();

	public abstract int hashCode();

	public abstract void setFirstName(String firstName);

	public abstract void setLastName(String lastName);

	public abstract String toString();

	public abstract String getInitial();

}