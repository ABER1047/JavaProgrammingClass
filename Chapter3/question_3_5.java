import java.util.*;

public class question_3_5 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("시간 입력(sec) : ");
        int input = sc.nextInt();
        
        int hour = input/3600;
        int min = input/60-hour*60;
        int sec = input-hour*3600-min*60;
        
        System.out.print(hour+"시 "+min+"분 "+sec+"초");
    }
}
