import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{
    private String password;
    private IAccount accounts;
    private IAccount checking;
    private IAccount savings;
    private IAccount credit;
    private List<String> transactions;
    private BankStatement bankStatement;

    /**
     * Default constructor
     * calls super class AccountAbstract default constructor
     */
    public Customer() {
        super();
    }

    /**
     *  @param firstName
     * @param lastName
     * @param dateOfBirth
     * @param identificationNumber
     * @param address
     * @param phoneNumber
     * @param email
     * @param password
     * @param checkingAccountNum
     * @param savingAccountNum
     * @param creditAccountNum
     * @param checkingBalance
     * @param savingBalance
     * @param creditBalance
     *
     */
    public Customer(String firstName, String lastName, String dateOfBirth, long identificationNumber,
                    String address, String phoneNumber, String email, String password,
                    long checkingAccountNum, long savingAccountNum, long creditAccountNum, double checkingBalance,
                    double savingBalance, double creditBalance, double creditMax) {
        super(firstName, lastName, dateOfBirth, identificationNumber, address, phoneNumber, email);
        this.password = password;
        this.checking = new Checking(checkingAccountNum, checkingBalance);
        this.savings = new Savings(savingAccountNum, savingBalance);
        this.credit = new Credit(creditAccountNum, creditBalance, creditMax);
        this.transactions = new ArrayList<String>();
        this.bankStatement = new BankStatement(this);
    }

    //min info for new user
    public Customer(String firstName, String lastName, String dateOfBirth, long identificationNumber,
                    String address, String phoneNumber, String email, String password,
                    long savingAccountNum, double savingBalance) {
        super(firstName, lastName, dateOfBirth, identificationNumber, address, phoneNumber, email);
        this.password = password;
        this.checking = null;
        this.savings = new Savings(savingAccountNum, savingBalance);
        this.credit = null;
        this.transactions = new ArrayList<String>();
        this.bankStatement = new BankStatement(this);
    }

    /**
     *
     * @return name of account, account number and current account balance for all accounts
     */
    public String printAllInfo() {

        if(checking == null && credit == null)
            return "(BANK MANAGER) "+getFullName() + "'s account info: " +
                    savings.getBalanceDetails();
        else if (checking==null)
            return "(BANK MANAGER) "+getFullName() + "'s account info: " +
                    savings.getBalanceDetails() + ", " +
                    credit.getBalanceDetails();
        else if(credit == null)
            return "(BANK MANAGER) "+getFullName() + "'s account info: " +
                    checking.getBalanceDetails() + ", " +
                    savings.getBalanceDetails();
        else return "(BANK MANAGER) "+getFullName() + "'s account info: " +
                    checking.getBalanceDetails() + ", " +
                    savings.getBalanceDetails() + ", " +
                    credit.getBalanceDetails();
    }

    /**
     *
     * @param transferAmount
     * @param srcAccountString
     * @param destAccountString
     * @return whether or not the transaction was successful
     */
    public boolean transfer(double transferAmount, String srcAccountString, String destAccountString) {
        boolean transferSuccessful = true;
        IAccount sourceAccount = findAccount(srcAccountString);
        IAccount destAccount = findAccount(destAccountString);
        if(sourceAccount == destAccount || sourceAccount.getBalance() < transferAmount)
            return false;
        boolean sourceWithdraw = sourceAccount.withdraw(transferAmount);
        boolean destDeposit = destAccount.deposit(transferAmount);
        return sourceWithdraw && destDeposit;
    }

    /**
     *
     * @param account
     * @return the specified account
     * Ex: input = "Checking" will return the corresonding Customer's checking account object
     */
    public IAccount findAccount(String account) {
        switch(account){
            case "CHECKING":
                return getChecking();
            case "SAVING":
                return getSavings();
            case "CREDIT":
                return getCredit();
            default:
                return null;
        }
    }

    public void addTransactions(String currTransaction) {
        transactions.add(currTransaction);
    }

    public List<String> getTransactions() {
        return this.transactions;
    }

    /**
     *
     * @return the customer's credit account
     */
    public IAccount getCredit() {
        return credit;
    }
    /**
     * {@link Customer#getCredit()}
     */
    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    /**
     *
     * @return customer's checking account
     */
    public IAccount getChecking() {
        return checking;
    }

    /**
     * {@link Customer#getChecking()}
     */
    public void setChecking(Checking checking) {
        this.checking = checking;
    }

    /**
     *
     * @return customer's saving account
     */
    public IAccount getSavings() {
        return savings;
    }

    /**
     * {@link Customer#getSavings()}
     */
    public void setSavings(Savings saving) {
        this.savings = saving;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BankStatement getBankStatement() {
        return this.bankStatement;
    }
}
