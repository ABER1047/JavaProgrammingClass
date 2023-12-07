public class oop3_2_4 
{
    public static void main(String[] args)
    {
        // IAccount: 참조변수의 선언타입 – 호출가능한 메소드를 결정함
        IAccount hong, kim; 

        // NormalAccount: 참조변수의 실제타입 – 실제 호출될 클래스를 결정함
        hong = new NormalAccount(1000); hong.showAccount();

        hong.deposit(10000); System.out.print("입금 10000: "); hong.showAccount();
        hong.withdraw(5000); System.out.print("출금 5000: "); hong.showAccount();
        hong.withdraw(9000); System.out.print("출금 9000: "); hong.showAccount();
        System.out.println();
        // MinusAccount: 참조변수의 실제타입 – 실제 호출될 클래스를 결정함
        kim = new MinusAccount(2000, 50000); kim.showAccount();

        kim.deposit(20000); System.out.print("입금 20000: "); kim.showAccount(); 
        kim.withdraw(7000); System.out.print("출금 7000: "); kim.showAccount();
        kim.withdraw(50000);System.out.print("출금 50000: "); kim.showAccount();
    }
}

public interface IAccount 
{ // Define account’s interface
   	public abstract long getAccNum();
   	public abstract long getBalance();
   	public abstract void deposit(long amount);
   	public abstract void withdraw(long amount);

	public void showAccount(); // For test
}


abstract class Account implements IAccount
{ //코드 공유를 위해
	private static long last_number = 0;

	// 객체의 상태
	private long account_num;
	private long left_money;

	public Account(long amount) 
    { 
        account_num = nextAccNum(); 
        left_money = amount; 
    }

	// 객체의 인터페이스
	public long getAccNum() 
    { 
        return account_num; 
    }
	public long getBalance() 
    { 
        return left_money; 
    }

	public abstract void deposit(long amount);  //계좌에 따라 입금 방법이 다름
	public abstract void withdraw(long amount); //계좌에 따라 출금 방법이 다름
    
    // For subclasses
	protected void minusBalance(long amount)	
    { 
        left_money -= amount; 
    }
	protected void plusBalance(long amount)	
    { 
        left_money += amount; 
    }
	protected static long nextAccNum() 		
    { 
        return ++last_number; 
    }

	public void showAccount() 
    {   // For test
	    System.out.printf("%04d-%04d %10d%n", account_num/1000, account_num%10000, left_money);
	}
} 



class MinusAccount extends Account
{
	private long max_limit; // 추가

   	public MinusAccount(long amount, long limit) 
    { //생성자 
	 	super(amount); 
        max_limit = limit;
   	}

	// 추상메소드 구현
   	public void deposit(long amount) 
    { 
		plusBalance(amount); 
	} 	
    
   	public void withdraw(long amount) 
    {
		if ((getBalance() + max_limit) >= amount)
			minusBalance(amount);
	}
}

class NormalAccount extends Account 
{
   	public NormalAccount(long amount) 
    { //생성자 
		super(amount); 
	}

	// 추상메소드 구현
   	public void deposit(long amount) 
    { 
		plusBalance(amount); 
	} 	

   	public void withdraw(long amount) 
    {
		if (getBalance() >= amount) 
			minusBalance(amount); 
	}
}




class SavingAccount extends Account
{
    public SavingAccount(long amount)
    {
        super(amount);
    }

    @Override
    public void deposit(long amount)
    {
        plusBalance(amount);
    }

    @Override
    public void withdraw(long amount)
    {
        if (getBalance() >= amount)
            minusBalance(amount);
        else
            System.out.println("잔액이 부족합니다.");
    }
}
