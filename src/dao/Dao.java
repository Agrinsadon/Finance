package dao;

import entity.Account;
import entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");

	public <T> void saveEntity(T entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}

	public void updateAccountBalance(Long accountId, Double newBalance) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Account account = em.find(Account.class, accountId);
		if (account != null) {
			account.setBalance(newBalance);
			em.merge(account);
		}
		em.getTransaction().commit();
		em.close();
	}

	public Category findCategoryByDescription(String description) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.createQuery("SELECT c FROM Category c WHERE c.categoryDescription = :description", Category.class)
					.setParameter("description", description)
					.getSingleResult();
		} finally {
			em.close();
		}
	}


	public static void close() {
		if (emf != null) {
			emf.close();
		}
	}
}
