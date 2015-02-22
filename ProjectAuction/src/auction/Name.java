package auction;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Embeddable
public class Name implements IName {
		
	@Column(name="firstName", columnDefinition="VARCHAR2(256) CONSTRAINT Name_Firstname_NN NOT NULL")	
	private String firstName;
	
	@Column(name="lastName", columnDefinition="VARCHAR2(256) CONSTRAINT Name_Lastname_NN NOT NULL")		
	private String lastName;

	@Column(name="initials", columnDefinition="VARCHAR2(2) CONSTRAINT Name_Initial_NN NOT NULL")			
	private String initials;
		
	
	public Name() {
		super();
	}

	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/* (non-Javadoc)
	 * @see auction.IName#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see auction.IName#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}

	/* (non-Javadoc)
	 * @see auction.IName#getLastName()
	 */
	@Override
	public String getLastName() {
		return lastName;
	}
	
	/* (non-Javadoc)
	 * @see auction.IName#getFirstName()
	 */
	@Override
	public String getInitial() {
		return initials;
	}

	/* (non-Javadoc)
	 * @see auction.IName#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see auction.IName#setFirstName(java.lang.String)
	 */
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/* (non-Javadoc)
	 * @see auction.IName#setLastName(java.lang.String)
	 */
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/* (non-Javadoc)
	 * @see auction.IName#toString()
	 */
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
