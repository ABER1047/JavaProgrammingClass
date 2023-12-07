import java.util.*;
import java.lang.*;

public class question_3_6 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("반지름 : ");
        int r = sc.nextInt();
        
        System.out.print("면적 : "+((Math.pow(r, 2))*(Math.PI))+" / 둘례 : "+(r*2*(Math.PI)));
    }
}
