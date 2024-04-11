import java.io.*;

public class question6_6_1 
{
    public static void main(String args[])
    {
        int a = 1, b = 0, c = 0;
        try
        {
            c = a/b;
        }
        catch(ArithmeticException e)
        {
            e.printStackTrace();
        }
    }
}
