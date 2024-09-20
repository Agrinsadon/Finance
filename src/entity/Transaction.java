package entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private Double amount;
    private String description;
    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sourceAccountId")
    private Account sourceAccount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destinationAccountId")
    private Account destinationAccount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
