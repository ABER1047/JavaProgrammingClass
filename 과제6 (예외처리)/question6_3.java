import java.io.*;

public class question6_3 
{
    public static void main(String args[])
    {
        try (FileInputStream in = new FileInputStream(args[0]); FileOutputStream out = new FileOutputStream(args[1]))
        {
            int c;
            while ((c = in.read()) != -1) 
            { 
                out.write(c); 
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage()); 
        }
        catch (FileNotFoundException e) 
        { 
            System.out.println(e.getMessage()); 
        }
        catch (IOException e) 
        { 
            System.out.println(e.getStackTrace());
        }//in, out은 자동으로 close
    }
}
