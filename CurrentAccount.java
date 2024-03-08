/*Kazi Shadman Sakib*/
/*Roll- 97*/
import java.util.*;
public class CurrentAccount extends BankAccount{
	public CurrentAccount(String accountName,int accountNumber){
		super(accountName,accountNumber);
	}
	public CurrentAccount(String accountName,int accountNumber,int balance){
		super(accountName,accountNumber,balance);
	}
	public void withdraw(int ammount){
		if(getAccountBalance()>=ammount){
			Date withdrawDate = new Date();
			int accountBalance = getAccountBalance() - ammount;
			setAccountBalance(accountBalance);
			System.out.println("Dear Sir, your A/C " + getAccountNumber() + " debited by BDT " + ammount + " on " + withdrawDate);
			System.out.println();
		}
		else{
			System.out.println("Dear Sir, your A/C " + getAccountNumber() + " could not withdraw BDT " + ammount);
			System.out.println();
		}
	}
}