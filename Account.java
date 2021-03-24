/**
 * An Absract class that will represent the basic functionalities of a bank Account
 * @author Elijah Pele
 * @version 3.0
 * @since March 03, 2021
 */
public abstract class Account implements IAccount{
    private double startingBalance;
    private double balance;
    private long accountID;
    private String accountType;

    public Account() {}

    /**
     *
     * @param accID an identification unique to an account.
     * @param amount the amount of money that is being assigned to this account.
     */
    public Account(long accID, double amount) {
        this.startingBalance = amount;
        this.balance = amount;
        this.accountID = accID;
    }

    //refactor
    /**
     * @param depositAmount
     * @return if deposit was successful
     * @author Daniel Moreno
     *
     * deposit adds money into corresponding bank account
     */
    public boolean deposit(double depositAmount) {
        boolean depositSuccessful = true;
        double currBalance = getBalance();
        if(depositAmount <= 0) {
            return false;
        }
        double updatedBalance = currBalance + depositAmount;
        setBalance(updatedBalance);
        return depositSuccessful;

    }

    /**
     *
     * @param withdrawAmount
     * @return if the withdraw was successful
     * @author Daniel Moreno
     *
     * withdraw takes out money from bank account
     * cannot take out more money than the current account balance
     */
    public boolean withdraw(double withdrawAmount) {
        boolean withdrawSuccessful = true;
        double currBalance = getBalance();
        if (currBalance < withdrawAmount) {
            return false;
        }
        double updatedBalance = currBalance - withdrawAmount;
        setBalance(updatedBalance);
        return withdrawSuccessful;
    }

    /**
     * Returns the amount that an account was initialized at.
     * @return startingBalance
     */
    public double getStartingBalance() {
        return this.startingBalance;
    }

    /**
     * Returns the balance in the account
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance to equal the given amount for the account.
     * @param balance the new balance for the account.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Returns the accounts ID
     * @return accountID
     */
    public long getAccountID() {
        return accountID;
    }

    /**
     * Sets the accounts ID
     * @param accountID the unique identification number for the account.
     */
    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    /**
     * Returns the current balance on the account
     * @return balance
     */
    public double inquire() {
        return this.getBalance();
    }

    /**
     * Returns the accounts type and account ID
     * @return accountDetails
     */
    public abstract String getAccDetails();

    /**
     * Returns the accounts type, account ID, and balance.
     * @return balnaceDetails
     */
    public abstract String getBalanceDetails();

    /**
     * Returns the type account that this is classified as.
     * @return accountType
     */
    public String getType() {
        return this.accountType;
    }
    /**
     * Sets the type of Account that this account will be classifies as
     * @param s The account type
     */
    public void setAccountType(String s) {
        this.accountType =s;
    }
}
