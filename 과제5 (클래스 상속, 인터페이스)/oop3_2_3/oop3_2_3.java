import java.util.*;

class Keyboard 
{
	private Scanner kbd = new Scanner(System.in);

	char getSelection() 
    { 
        return (kbd.next().charAt(0)); 
    }
	int getAmount() 	
    { 
        return (kbd.nextInt()); 
    }
	String getName() 	
    { 
        return (kbd.next()); 
    }
}

class Screen 
{
	void displayMessage(String m) 
    { 
        System.out.println(m); 
    }
	void displayPrompt(String m) 
    { 
        System.out.print(m); 
    }
}




interface IAccount 
{
	abstract int getAccountNumber();
	abstract int getBalance();
	abstract void deposit(int amount);
	abstract boolean withdraw(int amount);
}

class Account implements IAccount 
{ 
	protected int accountNumber;	// (cf) private variable
	protected int balance;		// 	  + public getter/setter

	public Account(int number, int amount)  
    {
		accountNumber = number; 
        balance = amount;
	}

	public int getAccountNumber() 	
    { 
        return accountNumber; 
    } 
	public int getBalance() 		
    { 
        return balance; 
    }
	public void deposit(int amount)
    {
        balance += amount; 
    }
	public boolean withdraw(int amount) 
    { 
		if (amount <= balance) 
        { 
			balance -= amount; 
            return true;
		} 
        else
        { 
			return false; 
        }
	}
}




class NormalAccount extends Account 
{
   	public NormalAccount(int number ,int amount) 
    { //생성자 
		super(number,amount); 
    }
}

class MinusAccount extends Account 
{
	private int creditAmount;

	public MinusAccount(int number, int amount, int creditAmount) 
    {
		super(number, amount); 
		this.creditAmount = creditAmount;
	}

	public boolean withdraw(int amount) 
    { //재정의
		if (amount <= balance+creditAmount ) 
        { 
			balance -= amount; return true;
		} 
        else 
        { 
			return false; 
        }
	}
}




class WithdrawControl 
{
	public void execute(IAccount acc, Screen scr, Keyboard kbd) 
    {
		scr.displayPrompt("출금할 금액을 입력하시오: ");
		int amount = kbd.getAmount();
		if (acc.withdraw(amount))
        {
			scr.displayMessage("잔고가 " + acc.getBalance() + " 입니다.");
        }
		else
        {
			scr.displayMessage("잔고가 부족합니다.");
        }
	}
}



class DepositControl 
{
	public void execute(IAccount acc, Screen scr, Keyboard kbd)
    {
		scr.displayPrompt("입금할 금액을 입력하시오: ");
		int amount = kbd.getAmount();
		acc.deposit(amount);
		scr.displayMessage("잔고가 " + acc.getBalance() + " 입니다.");
	}
}
class InquiryControl 
{
	public void execute(IAccount acc, Screen scr) 
    {
		scr.displayMessage("잔고가 " + acc.getBalance() + " 입니다.");
	}
}


class Bank 
{
	private Screen scr;
	private Keyboard kbd;
	private IAccount acc1, acc2;

	public Bank() 
    {
		scr = new Screen();
		kbd = new Keyboard();

		acc1 = new NormalAccount(1, 10000);
		acc2 = new MinusAccount(2, 50000, 10000);
	}

	// main control
	public void run() 
    { 
		while (true) 
        {
			char command = getCommand();
			if (command == '6') break;

			switch (command) 
            {
                case '1' : new InquiryControl().execute(acc2, scr); 		break;
                case '2' : new DepositControl().execute(acc2, scr, kbd); 	break;
                case '3' : new WithdrawControl().execute(acc2, scr, kbd);	break;
                //case '4': new TransferControl().execute(acc2, acc2, scr, kbd); break;
                //case '5' : new OpenControl().execute(scr, kbd); 				break;
                default : break;
			}
		}
		System.out.println("Terminated...");
	}
    
	private char getCommand() 
    { // helper method
		// display menu
		System.out.println("\n\n\t\tM e n u");
		System.out.println("\t\t\t (1) Balance Inquiry");
		System.out.println("\t\t\t (2) Deposit");
		System.out.println("\t\t\t (3) Withdraw");
		System.out.println("\t\t\t (4) Account Transfer");
		System.out.println("\t\t\t (5) Account Opening");
		System.out.println("\t\t\t (6) Terminate");

		// get user selection
		scr.displayPrompt("\n\t\t번호를 입력하시오: ");
	    return kbd.getSelection();
	}
}


public class oop3_2_3 
{
	public static void main(String[] args) 
    {
		Bank bank = new Bank();
		bank.run();
	}
}