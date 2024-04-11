import java.io.*;
import java.util.*;

public class question_3_7 
{
    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            
            System.out.print("문자열 입력 : ");
            System.out.print(sc.nextLine());
            
            Scanner sc_file = new Scanner(new File("C:\\Users\\1047a\\OneDrive\\바탕 화면\\수업자료\\자바프로그래밍\\test_file.txt"));
            System.out.print(sc_file.nextLine());
        }
        
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
