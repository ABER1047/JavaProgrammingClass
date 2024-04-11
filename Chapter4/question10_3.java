public class question10_3 
{
    public static void main(String[] args)
    {
        MyInteger num1 = new MyInteger(7);
        MyInteger num2 = new MyInteger(10);

        System.out.println("num1 is prime? " + num1.isPrime());
        System.out.println("num1 is odd? " + num1.isOdd());
        System.out.println("num1 equals 7? " + num1.equals(7));

        System.out.println("num2 is even? " + num2.isEven());
        System.out.println("num2 is prime? " + MyInteger.isPrime(10));
        System.out.println("num2 equals num1? " + num2.equals(num1));

        char[] chars = {'1', '2', '3', '4', '5'};
        System.out.println("Parsed int value: " + MyInteger.parseInt(chars));

        String str = "6789";
        System.out.println("Parsed int value: " + MyInteger.parseInt(str));
    }
}

class MyInteger 
{
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 != 0;
    }

    public boolean isPrime() {
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(int otherValue) {
        return value == otherValue;
    }

    public boolean equals(MyInteger other) {
        return value == other.getValue();
    }

    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }

    public static boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(MyInteger myInteger) {
        return myInteger.isEven();
    }

    public static boolean isOdd(MyInteger myInteger) {
        return myInteger.isOdd();
    }

    public static boolean isPrime(MyInteger myInteger) {
        return myInteger.isPrime();
    }

    public static int parseInt(char[] chars) {
        String str = new String(chars);
        return Integer.parseInt(str);
    }

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
