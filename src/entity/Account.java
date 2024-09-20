package entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private String accountName;
    private Double balance;

    @OneToMany(mappedBy = "sourceAccount")
    private List<Transaction> transactionsPaidFrom;

    @OneToMany(mappedBy = "destinationAccount")
    private List<Transaction> transactionsPaidTo;

    // Getters and Setters
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionsPaidFrom() {
        return transactionsPaidFrom;
    }

    public void setTransactionsPaidFrom(List<Transaction> transactionsPaidFrom) {
        this.transactionsPaidFrom = transactionsPaidFrom;
    }

    public List<Transaction> getTransactionsPaidTo() {
        return transactionsPaidTo;
    }

    public void setTransactionsPaidTo(List<Transaction> transactionsPaidTo) {
        this.transactionsPaidTo = transactionsPaidTo;
    }
}
