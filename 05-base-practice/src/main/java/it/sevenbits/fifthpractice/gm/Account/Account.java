package it.sevenbits.fifthpractice.gm.Account;


import java.util.UUID;

/**
 * User's information
 */
public class Account implements Comparable<Account> {
    private final String id;
    private long balance;

    /**
     * Constructor
     * @param balance - start user's balance
     */
    public Account(final long balance) {
        id = UUID.randomUUID().toString();
        this.balance = balance;
    }

    /**
     * Add balance to user
     * @param value - new income
     * @throws Exception - thread's exception
     */
    public void addToBalance(final long value) throws Exception {
        long balance = this.balance;
        Thread.sleep(1);
        this.balance = balance + value;
    }

    @Override
    public int compareTo(final Account account) {
        return Long.compare(balance, account.balance);
    }

    @Override
    public String toString() {
        return String.format("Account id: %s with balance %s", id, balance);
    }
}