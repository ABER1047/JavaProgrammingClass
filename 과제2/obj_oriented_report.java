import java.util.*;

public class obj_oriented_report 
{
    public static void main(String[] args) 
    {
        Account hong; // reference variable declaration
        hong = new Account("홍길동", 1000); // creates an object named “hong”
        hong.showAccount(); // send a message to “hong” (invokes a hong’s method)
        hong.deposit(10000); System.out.print("입금 10000: "); hong.showAccount();
        hong.withdraw(5000); System.out.print("출금  5000: "); hong.showAccount();
        hong.deposit(20000); System.out.print("입금 20000: "); hong.showAccount();
        System.out.println();

        // creates an object “kim” and send messages
        Account kim = new Account("김부자", 2000); 
        kim.showAccount();
        kim.deposit(20000); System.out.print("입금 20000: "); kim.showAccount(); 
        kim.withdraw(7000); System.out.print("출금  7000: "); kim.showAccount();
        kim.deposit(40000); System.out.print("입금 40000: "); kim.showAccount(); 
        System.out.println();
    } // End of main
}

class Account
{
    private static long last_account_num = 0L;
    private long account_num;
    private long left; 
    private String name;

    Account(String name, long deposit) 
    {
        account_num = nextAccountNumber();
        this.name = name;
        left = deposit;
    }

    private static long nextAccountNumber() 
    { 
        return ++ last_account_num; 
    }

    public long getBalance() 
    { 
        return left; 
    }

    public void deposit(long deposit) 
    { 
        left += deposit; 
    }

    public long withdraw(long draw) 
    {
        return (left >= draw) ? (left -= draw) : 0L;
    }

    public void showAccount()
    {
        System.out.printf("%10d%10s%10d%n", account_num, name, left);
    }
}

