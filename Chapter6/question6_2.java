import java.io.*;

public class question6_2 
{
    public static void main(String args[])
    {
        FileInputStream in = null;
        FileOutputStream out = null;
        
        try 
        {
            in  = new FileInputStream(args[0]);
            out = new FileOutputStream(args[1]);
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
        }
        finally 
        {
            try 
            {
                if (in != null) in.close(); if (out != null) out.close();
            } 
            catch (IOException e)
            {
            }
        }
    }
}
