import java.util.function.*;

public class lambda_test 
{
    @FunctionalInterface
    public interface LambdaClass
    {
        public void lambda_func(int x);
    }
    
    
    
    public static void main(String[] args)
    {
        LambdaClass lambda_class;
        lambda_class = (x) -> {
            System.out.println("Hello"+x);
        };
        lambda_class.lambda_func(1);
    }    
}
