package lesson30.task1;

import java.util.Date;

public class Transaction implements Comparable<Transaction> {
    private long id;
    private Date dataCreated;
    private Date dataConfirmed;
    private TransactionType type;
    private int amount;
    private String description;

    public Transaction(long id, Date dataCreated, Date dataConfirmed, TransactionType type, int amount, String description) {
        this.id = id;
        this.dataCreated = dataCreated;
        this.dataConfirmed = dataConfirmed;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public Date getDataCreated() {
        return dataCreated;
    }

    public Date getDataConfirmed() {
        return dataConfirmed;
    }

    public TransactionType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Transaction tr) {
        return tr.dataCreated.compareTo(this.dataCreated);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", dataCreated=" + dataCreated +
                ", dataConfirmed=" + dataConfirmed +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}

