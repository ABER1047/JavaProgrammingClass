public class oop3_2_1 
{
    public static void main(String[] args)
    {
        Animal animals[] = {new Cat(), new Dog(), new Cow()};
        
        for(Animal x : animals)
        {
            x.cry();
        }
    }
}

class Animal
{
    void cry()
    {
        System.out.println("울다");
    }
}

class Cat extends Animal
{
    void cry()
    {
        System.out.println("야옹");
    }
}

class Dog extends Animal
{
    void cry()
    {
        System.out.println("멍멍");
    }
}

class Cow extends Animal
{
    void cry()
    {
        System.out.println("음메");
    }
}
