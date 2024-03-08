/*Kazi Shadman Sakib*/
/*Roll- 97*/
import java.util.*;
public abstract class BankAccount{
	private String accountName;
	private int accountNumber;
	private int accountBalance;
	private Date accountCreationDate;
	private Date lastUpdate;
	protected BankAccount(String accountName,int accountNumber){
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.accountBalance = 0;
		accountCreationDate = new Date();
		lastUpdate = new Date();
	}
	protected BankAccount(String accountName,int accountNumber,int accountBalance){
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		accountCreationDate = new Date();
		lastUpdate = new Date();
	}
	protected void deposit(int ammount){
		Date depositDate = new Date();
		this.accountBalance = accountBalance+ammount;
		System.out.println("Dear Sir, your A/C " + getAccountNumber() + " credited by BDT " + ammount + " on " + depositDate);
		System.out.println();
	}
	protected void transfer(int ammount,SavingsAccount account){
		Date transferDate = new Date();
		if(accountBalance>=ammount){
			accountBalance = accountBalance - ammount;
			account.deposit(ammount);
			System.out.println("Dear Sir, your A/C " + getAccountNumber() + " debited by BDT " + ammount + " on " + transferDate + ". Fund transfered to " + account.getAccountNumber());
			System.out.println();
		}
		else{
			System.out.println("Dear Sir, your A/C " + getAccountNumber() + " could not transfer BDT " + ammount + " to the A/C " + account.getAccountNumber());
			System.out.println();
		}
	}
	protected void transfer(int ammount,CurrentAccount account){
		Date transferDate = new Date();
		if(accountBalance>=ammount){
			accountBalance = accountBalance - ammount;
			account.deposit(ammount);
			System.out.println("Dear Sir, your A/C " + getAccountNumber() + " debited by BDT " + ammount + " on " + transferDate + ". Fund transfered to " + account.getAccountNumber());
			System.out.println();
		}
		else{
			System.out.println("Dear Sir, your A/C " + getAccountNumber() + " could not transfer BDT " + ammount + " to the A/C " + account.getAccountNumber());
			System.out.println();
		}
	}
	protected abstract void withdraw(int ammount);
	protected String getAccountName(){
		return accountName;
	}
	protected int getAccountNumber(){
		return accountNumber;
	}
	protected void setAccountBalance(int accountBalance){
		this.accountBalance = accountBalance;
	}
	protected int getAccountBalance(){
		return accountBalance;
	}
	protected Date getAccountCreationDate(){
		return accountCreationDate;
	}
	protected void setLastUpdate(Date lastUpdate){
		this.lastUpdate = lastUpdate;
	}
	protected Date getLastUpdate(){
		return lastUpdate;
	}
}