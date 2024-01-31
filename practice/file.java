import java.io.*;
import java.util.*;

public class file 
{
    public static void main(String args[]) throws IOException, FileNotFoundException
    {
        String file = "C:\\Users\\1047a\\OneDrive\\바탕 화면\\수업자료\\자바프로그래밍\\기말고사정리\\tmp\\tmp.txt";

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(new FileReader(file));
        //BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        //FileWriter fw = new FileWriter(file);
        try
        {
            String str = br.readLine();
            while(str != null)
            {
                System.out.println(str);
                str = br.readLine();
            }
            
            System.out.println("===============================");
            
            int input = fr.read();
            while(input != -1)
            {
                System.out.print((char) input);
                input = fr.read();
            }
        }
        finally
        {
            br.close();
            //fw.close();
        }
    }
}
