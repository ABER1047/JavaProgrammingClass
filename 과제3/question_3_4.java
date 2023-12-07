import java.util.*;

public class question_3_4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("몸무게 : ");
        float weight = sc.nextFloat();
        
        System.out.print("키 : ");
        float height = sc.nextFloat();
        
        System.out.print("BMI : ");
        System.out.printf("%.3f",((height-110)/weight));
    }
}