public class oop3_2_2
{
    public static void main(String[] args)
    {
        Animal1 animals[] = {new Cat1(), new Dog1(), new Cow1()};
        
        for(Animal1 x : animals)
        {
            hear(x);
        }
    }
    
    static void hear(Animal1 a)
    {
        System.out.println(a.cry());
    }
}


public interface Animal1
{
    public abstract String cry();
}

class Cat1 implements Animal1
{
    public String cry()
    {
        return "야옹";
    }
}

class Dog1 implements Animal1
{
    public String cry()
    {
        return "멍멍";
    }
}

class Cow1 implements Animal1
{
    public String cry()
    {
        return "음메";
    }
}
