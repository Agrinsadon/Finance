package test;

import dao.FinanceTest2Dao;
import entity.Transaction;

import java.util.Scanner;

public class FinanceTest2 {

    public static void main(String[] args) {
        FinanceTest2Dao dao = new FinanceTest2Dao();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the transaction ID: ");
        Long transactionId = scanner.nextLong();

        Transaction transaction = dao.getTransactionById(transactionId);

        if (transaction != null) {
            System.out.println("Transaction Description: " + transaction.getDescription());

            if (transaction.getSourceAccount() != null) {
                System.out.println("Source Account: " + transaction.getSourceAccount().getAccountName());
            } else {
                System.out.println("Source Account: None");
            }

            if (transaction.getDestinationAccount() != null) {
                System.out.println("Destination Account: " + transaction.getDestinationAccount().getAccountName());
            } else {
                System.out.println("Destination Account: None");
            }

            if (transaction.getCategory() != null) {
                System.out.println("Category: " + transaction.getCategory().getCategoryDescription());
            } else {
                System.out.println("Category: None");
            }
        } else {
            System.out.println("Transaction not found.");
        }

        FinanceTest2Dao.close();
    }
}
