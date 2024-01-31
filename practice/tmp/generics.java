import java.util.*;

public class generics
{
    public static void main(String args[])
    {
        GenericClass<String> ins1 = new GenericClass<>();
        ins1.set("Hello");
        System.out.println(ins1.get());
        
        GenericClass<Integer> ins2 = new GenericClass<>();
        ins2.set(321);
        System.out.println(ins2.get());
        
        //Integer와 String이 다른 element이므로, genericMethod에 <E>가 없을 경우 컴파일 오류 발생
        System.out.println(ins2.genericMethod(ins1.get()));
    }
}

class GenericClass<E>
{
    private E ele;
    
    public void set(E arg0)
    {
        ele = arg0;
    }
    
    public E get()
    {
        return ele;
    }
    
    public <E> E genericMethod(E arg0)
    {
        return arg0;
    }
}