package test;

import dao.Dao;
import entity.Account;
import entity.Category;
import entity.Transaction;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FinanceTest {

    public static void main(String[] args) {
        Dao dao = new Dao();

        List<String> categoryDescriptions = Arrays.asList("Food", "Leisure", "School", "Gifts", "Internal Transfer");
        for (String description : categoryDescriptions) {
            Category category = new Category();
            category.setCategoryDescription(description);
            dao.saveEntity(category);
        }

        Category giftsCategory = dao.findCategoryByDescription("Gifts");

        Account savingsAccount = new Account();
        savingsAccount.setAccountName("Savings Account");
        savingsAccount.setBalance(400.00);
        dao.saveEntity(savingsAccount);

        Account wallet = new Account();
        wallet.setAccountName("Wallet");
        wallet.setBalance(14.50);
        dao.saveEntity(wallet);

        Transaction giftTransaction = new Transaction();
        giftTransaction.setAmount(100.00);
        giftTransaction.setDescription("Gift from Agha Agrin");
        giftTransaction.setTimestamp(LocalDateTime.now());
        giftTransaction.setDestinationAccount(savingsAccount);
        giftTransaction.setCategory(giftsCategory);
        dao.saveEntity(giftTransaction);

        savingsAccount.setBalance(savingsAccount.getBalance() + 100.00);
        dao.updateAccountBalance(savingsAccount.getAccountId(), savingsAccount.getBalance());

        Category internalTransferCategory = dao.findCategoryByDescription("Internal Transfer");

        Transaction transferTransaction = new Transaction();
        transferTransaction.setAmount(40.00);
        transferTransaction.setDescription("Internal Transfer from Savings to Wallet");
        transferTransaction.setTimestamp(LocalDateTime.now());
        transferTransaction.setSourceAccount(savingsAccount);
        transferTransaction.setDestinationAccount(wallet);
        transferTransaction.setCategory(internalTransferCategory);
        dao.saveEntity(transferTransaction);

        savingsAccount.setBalance(savingsAccount.getBalance() - 40.00);
        wallet.setBalance(wallet.getBalance() + 40.00);
        dao.updateAccountBalance(savingsAccount.getAccountId(), savingsAccount.getBalance());
        dao.updateAccountBalance(wallet.getAccountId(), wallet.getBalance());

        Category foodCategory = dao.findCategoryByDescription("Food");

        Transaction spendTransaction = new Transaction();
        spendTransaction.setAmount(8.40);
        spendTransaction.setDescription("Pub Spending");
        spendTransaction.setTimestamp(LocalDateTime.now());
        spendTransaction.setSourceAccount(wallet);
        spendTransaction.setCategory(foodCategory);
        dao.saveEntity(spendTransaction);

        wallet.setBalance(wallet.getBalance() - 8.40);
        dao.updateAccountBalance(wallet.getAccountId(), wallet.getBalance());

        Dao.close();
    }
}
