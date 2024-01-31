public class nested_class 
{
    public static void main(String args[])
    {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.test(2);
    }
}


class OuterClass
{
    private int x = 0;
    class InnerClass
    {
        private int x = 1;
        
        public void test(int x)
        {
            System.out.println("arg x : "+x);
            System.out.println("InnerClass x : "+this.x);
            System.out.println("OuterClass x : "+OuterClass.this.x);
        }
    }
}