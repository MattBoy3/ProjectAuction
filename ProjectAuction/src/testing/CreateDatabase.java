package testing;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import database.DaoFactory;

public class CreateDatabase {
	public static void main(String... args) {
		DaoFactory daoFactory = DaoFactory.getINSTANCE();
		
		EntityManager em = daoFactory.getEm();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		//TODO populate database
		tx.commit();
		
		daoFactory.closeEm();
		daoFactory.closeEntityManagerFactory();
	
		return;
	}
}
