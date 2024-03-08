/*Kazi Shadman Sakib*/
/*Roll- 97*/
import java.util.Scanner;
public class BankSystem{
	private static int currentAccountNumber = 0;
	private static int savingsAccountNumber = 10000;
	public static int getCurrentAccountNumber(){
		return currentAccountNumber;
	}
	public static int getSavingsAccountNumber(){
		return savingsAccountNumber;
	}
	public static void main(String[] args){
		String accountName;
		int ammount;
		int accountNumber;
		int initialAmmount;
		Scanner input = new Scanner(System.in);
		CurrentAccount[] createCurrentAccount = new CurrentAccount[1000];
		SavingsAccount[] createSavingsAccount = new SavingsAccount[1000];
		while(true){
			System.out.println("Please Choose a Command");
			System.out.println("1. Create Savings Account");
			System.out.println("2. Create Current Account");
			System.out.println("3. Change Savings Interest Rate");
			System.out.println("4. Add Savings Interest Amount");
			System.out.println("5. See Number of Currently Active Accounts");
			System.out.println("6. Find Account");
			System.out.println("7. Deposit Money");
			System.out.println("8. Withdraw Money");
			System.out.println("9. Transfer Money");
			System.out.println("0. Exit");
			System.out.print("Command: ");
			int cmd = input.nextInt();
			if(cmd==0){
				break;
			}
			System.out.println();
			switch(cmd){
				case 1:
				System.out.println("Creating a Savings Account: ");
				System.out.print("Enter Account Name: ");
				accountName = input.nextLine();
				accountName = input.nextLine();
				System.out.print("Enter Initial Amount: ");
				initialAmmount = input.nextInt();
				System.out.println("Your Savings Account is Created");
				accountNumber = savingsAccountNumber++;
				System.out.println("Your Account Number is: " + accountNumber);
				createSavingsAccount[accountNumber-10000] = new SavingsAccount(accountName,accountNumber,initialAmmount);
				System.out.println();
				break;

				case 2:
				System.out.println("Creating a Current Account: ");
				System.out.print("Enter Account Name: ");
				accountName = input.nextLine();
				accountName = input.nextLine();
				System.out.print("Enter Initial Amount: ");
				initialAmmount = input.nextInt();
				System.out.println("Your Current Account is Created");
				accountNumber = currentAccountNumber++;
				System.out.println("Your Account Number is: " + accountNumber);
				createCurrentAccount[accountNumber-0] = new CurrentAccount(accountName,accountNumber,initialAmmount);
				System.out.println();
				break;

				case 3:
				System.out.print("Enter Interest Rate: ");
				double interestRate = input.nextDouble();
				SavingsAccount.interestRate = interestRate;
				System.out.println("Interest Rate Updated");
				System.out.println();
				break;

				case 4:
				System.out.print("Enter Account Number: ");
				accountNumber = input.nextInt();
				if(accountNumber>=10000 && accountNumber<=savingsAccountNumber){
					createSavingsAccount[accountNumber-10000].yearEndInterest();
					System.out.println("Updated Account Balance");
					System.out.println();
					break;
				}
				else{
					System.out.println("Invalid Account Number");
					System.out.println();
					break;
				}

				case 5:
				System.out.println("Currently Active Current Account are: " + (getCurrentAccountNumber()-0));
				System.out.println("Currently Active Savings Account are: " + (getSavingsAccountNumber()-10000));
				System.out.println();
				break;

				case 6:
				System.out.print("Enter Account Number: ");
				accountNumber = input.nextInt();
				if(accountNumber>=10000 && accountNumber<=savingsAccountNumber){
					System.out.println("Account Type:- Savings Account");
					System.out.println("Account Name: " + createSavingsAccount[accountNumber-10000].getAccountName());
					System.out.println("Account Number: " + createSavingsAccount[accountNumber-10000].getAccountNumber());
					System.out.println("Balance: " + createSavingsAccount[accountNumber-10000].getAccountBalance());
					System.out.println("Account Creation Date: " + createSavingsAccount[accountNumber-10000].getAccountCreationDate());
					System.out.println("Account Last Update: " + createSavingsAccount[accountNumber-10000].getLastUpdate());
					System.out.println();
					break;
				}
				else if(accountNumber<10000 && accountNumber<=currentAccountNumber){
					System.out.println("Account Type:- Current Account");
					System.out.println("Account Name: " + createCurrentAccount[accountNumber-0].getAccountName());
					System.out.println("Account Number: " + createCurrentAccount[accountNumber-0].getAccountNumber());
					System.out.println("Balance: " + createCurrentAccount[accountNumber-0].getAccountBalance());
					System.out.println("Account Creation Date: " + createCurrentAccount[accountNumber-0].getAccountCreationDate());
					System.out.println("Account Last Update: " + createCurrentAccount[accountNumber-0].getLastUpdate());
					System.out.println();
					break;
				}
				else{
					System.out.println("Account Does Not Exist");
					System.out.println();
					break;
				}

				case 7:
				System.out.print("Enter Account Number: ");
				accountNumber = input.nextInt();
				System.out.print("Enter Amount: ");
				ammount = input.nextInt();
				if(accountNumber<10000 && accountNumber<=currentAccountNumber){
					createCurrentAccount[accountNumber-0].deposit(ammount);
					break;
				}
				else if(accountNumber>=10000 && accountNumber<=savingsAccountNumber){
					createSavingsAccount[accountNumber-10000].deposit(ammount);
					break;
				}
				else{
					System.out.println("Account Does Not Exist");
					System.out.println();
					break;
				}

				case 8:
				System.out.print("Enter Account Number: ");
				accountNumber = input.nextInt();
				System.out.print("Enter Amount: ");
				ammount = input.nextInt();
				if(accountNumber<10000 && accountNumber<=currentAccountNumber){
					createCurrentAccount[accountNumber-0].withdraw(ammount);
					break;
				}
				else if(accountNumber>=10000 && accountNumber<=savingsAccountNumber){
					createSavingsAccount[accountNumber-10000].withdraw(ammount);
					break;
				}
				else{
					System.out.println("Account Does Not Exist");
					System.out.println();
					break;
				}

				case 9:
				System.out.print("Enter Your Account Number: ");
				int myAccountNumber = input.nextInt();
				System.out.print("Enter Receiver Account Number: ");
				int receiverAccountNumber = input.nextInt();
				System.out.print("Enter Amount: ");
				ammount = input.nextInt();
				if(myAccountNumber<10000 && myAccountNumber<=currentAccountNumber){
					if(receiverAccountNumber>=10000 && receiverAccountNumber<=savingsAccountNumber){
						createCurrentAccount[myAccountNumber-0].transfer(ammount,createSavingsAccount[receiverAccountNumber-10000]);
						break;
					}
					else if(receiverAccountNumber<10000 && receiverAccountNumber<=currentAccountNumber){
						createCurrentAccount[myAccountNumber-0].transfer(ammount,createCurrentAccount[receiverAccountNumber-0]);
						break;
					}
					else{
						System.out.println("Receiver Account Does Not Exist");
						System.out.println();
						break;
					}
				}
				else if(myAccountNumber>=10000 && myAccountNumber<=savingsAccountNumber){
					if(receiverAccountNumber<10000 && receiverAccountNumber<=currentAccountNumber){
						createSavingsAccount[myAccountNumber-10000].transfer(ammount,createCurrentAccount[receiverAccountNumber-0]);
						break;
					}
					else if(receiverAccountNumber>=10000 && receiverAccountNumber<=savingsAccountNumber){
						createSavingsAccount[myAccountNumber-10000].transfer(ammount,createSavingsAccount[receiverAccountNumber-10000]);
						break;
					}
					else{
						System.out.println("Receiver Account Does Not Exist");
						System.out.println();
						break;
					}
				}
				else{
					System.out.println("Account Does Not Exist");
					System.out.println();
					break;
				}

				default: 
				System.out.println("Invalid Operation");
				break;
			}
		}
	}
}