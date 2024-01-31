import java.io.*;
import java.util.*;

public class string_num_calculator 
{
    public static void main(String args[]) throws IOException, FileNotFoundException
    {
        Map<String, Integer> map = new LinkedHashMap<>();
        
        String file = "C:\\Users\\1047a\\OneDrive\\바탕 화면\\수업자료\\자바프로그래밍\\기말고사정리\\tmp\\tmp.txt";

        BufferedReader br = new BufferedReader(new FileReader(file));
        
        try
        {
            String str = br.readLine();
            while(str != null)
            {
                String split_str[] = str.split(" ");
                for(int i = 0; i < split_str.length; i++)
                {
                    String key = split_str[i];
                    int num = 1;
                    if (map.containsKey(key))
                    {
                        num = map.get(key)+1;
                    }
                    map.put(key,num);
                    System.out.println(key+" : "+num);
                }
                str = br.readLine();
            }
        }
        finally
        {
            br.close();
        }
    }
}
