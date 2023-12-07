import java.io.*;

public class question6_4_2
{
    public static void main(String[] args) throws IOException 
    {
        FileReader in = null;
        FileWriter out = null;

        try
        {
            in = new FileReader("sourceFile");
            out = new FileWriter("targetFile");

            int c;
            while ((c = in.read()) != -1) 
            { // EOF 검사
                out.write(c);
            }
        } 
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage()); 
        }
        finally 
        {
            try 
            {
                if (in != null) 
                {
                    in.close();
                }
                if (out != null)
                {
                    out.close();
                }
            } catch (IOException e) 
            {
                e.printStackTrace(); // 닫기 시 예외 처리
            }
        }
    }
}
