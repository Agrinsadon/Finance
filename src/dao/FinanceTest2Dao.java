package dao;

import entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FinanceTest2Dao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinanceTest2PU");

    public Transaction getTransactionById(Long transactionId) {
        EntityManager em = emf.createEntityManager();
        Transaction transaction = em.find(Transaction.class, transactionId);
        em.close();
        return transaction;
    }


    public static void close() {
        if (emf != null) {
            emf.close();
        }
    }
}
