import java.util.*;


public class obj_oriented_report2
{
    public static void main(String[] args) 
    {
		Bank bank = new Bank();
		bank.run();
	}
}


class Bank 
{
	private Screen scr;
	private Keyboard kbd;
	private Account_ acc1, acc2;
    
    

	public Bank() 
    {
		scr = new Screen();
		kbd = new Keyboard();

		acc1 = new Account_("홍길동", 10000);
		acc2 = new Account_("홍판서", 50000);
	}
    
    public Account_ get_acc(int index)
    {
        return acc_list.get(index);
    }

	// main control
	public void run() 
    { 
        while(true) 
        {
            char command = getCommand();
            if (command == '6') 
            {
                break;
            }

            switch (command) 
            {
            case '1' : new InquiryControl().getBalance(acc1, scr); break;
            case '2' : new DepositControl().deposit(acc1, scr, kbd); break;
            case '3' : new WithdrawControl().withdraw(acc1, scr, kbd); break;
            case '4' : new TransferControl().transfer(acc1, scr, kbd, acc2); break;
            case '5' : new OpenControl().open(acc1, scr, kbd, acc2); break;
            default : break;
            }
        }
	    System.out.println("Terminated...");
	} // End of run()
    
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

		// get user request
		scr.displayPrompt("\n\t\t번호를 입력하시오: ");
		return kbd.getRequest();
	}
} // end of class Bank

// Boundary Classes
class Keyboard 
{
	private Scanner kbd = new Scanner(System.in);

	char getRequest() 
    { 
        return kbd.next().charAt(0); 
    }
	int getAmount() 
    { 
        return kbd.nextInt(); 
    }
	String getName() 
    { 
        return kbd.next(); 
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

// Entity Classes
class Account_ 
{
   	private static int lastNumber = 0;
    
	private int number;
	private int balance;
	private String owner;

   	Account_(String name, int amount) 
    {
		number = nextAccount_Number();
		owner = name;
		balance = amount;
   	}
    
    public int get_acc_num()
    {
        return number;
    }
    
    public String get_owner()
    {
        return owner;
    }

	private static int nextAccount_Number() 
    {  
		return ++lastNumber; 
	}

	public int getBalance() 
    { 
		return balance; 
	}

   	public void deposit(int amount) 
    { 
		balance += amount; 
	}

   	public boolean withdraw(long amount) 
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

// Control Classes
class InquiryControl 
{
	public void getBalance(Account_ acc, Screen scr) 
    {
		scr.displayMessage("잔고가 " + acc.getBalance() + " 입니다.");
	}
}

class DepositControl 
{
	public void deposit(Account_ acc, Screen scr, Keyboard kbd) 
    {

		scr.displayPrompt("입금할 금액을 입력하시오: ");
		int amount = kbd.getAmount();

		acc.deposit(amount);
		scr.displayMessage("잔고가 " + acc.getBalance() + " 입니다.");
	}
}

class WithdrawControl 
{
	public void withdraw(Account_ acc, Screen scr, Keyboard kbd) 
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

class TransferControl
{
    public void transfer(Account_ acc, Screen scr, Keyboard kbd, Account_ acc2)
    {
        //계좌 번호 받기
        scr.displayPrompt("입금할 계좌를 입력하시오: ");
        int amount = kbd.getAmount();

        //입력한 계좌번호가 현재 계좌와 동일한지 체크
        if (acc.get_acc_num() == amount)
        {
            scr.displayPrompt("현재 계좌와 동일한 계좌는 입금할 수 없습니다.");
        }
        else
        {
            scr.displayPrompt("입금할 금액을 입력하시오: ");
            
            
            //보낼 돈 금액
            int to_send = kbd.getAmount();
            if (acc.withdraw(to_send))
            {
                scr.displayMessage("'"+acc2.get_owner()+"'님의 계좌로"+to_send+"원을 송금하고 남은 잔고는 " + acc.getBalance() + " 입니다.");
                acc2.deposit(to_send);
            }
            else
            {
                scr.displayMessage("잔고가 부족합니다.");
            }
        }
    }
}

class OpenControl
{
    public void open(Account_ acc, Screen scr, Keyboard kbd, Account_ acc2)
    {
        //계좌 번호 받기
        scr.displayPrompt("입금할 계좌를 입력하시오: ");
        int amount = kbd.getAmount();

        //입력한 계좌번호가 현재 계좌와 동일한지 체크
        if (acc.get_acc_num() == amount)
        {
            scr.displayMessage("'"+acc.get_owner()+"'님의 계좌의 남은 잔고는"+ acc.getBalance() + "원 입니다.");
        }
        else
        {
            scr.displayMessage("'"+acc2.get_owner()+"'님의 계좌의 남은 잔고는"+ acc2.getBalance() + "원 입니다.");
        }
    }
}