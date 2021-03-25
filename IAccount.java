/**
 * Interface is subset of Abstract class
 * @author Elijah Pele
 * @version 3.0
 * @since March 03, 2021
 */
public interface IAccount{
    //refactor
    public boolean withdraw(double amount);
    public boolean deposit(double amount);

    public double inquire();
    public double getStartingBalance();
    public double getBalance();
    public void setBalance(double balance);
    public long getAccountID();
    public void setAccountID(long accountID);

    public  String getAccDetails();
    public String getBalanceDetails();
    public String getType();
    public void setAccountType(String s);
}
