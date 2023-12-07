public class question6_5 
{
    public static void main(String args[])
    {
        System.out.println(mX(2,0));
    }
    
    static int mX(int x, int y) 
    {
        try
        {
            x /= y;
        } 
        catch (Exception e)
        {
            x /= (y+1);
        }
    
        return x;
    }
}
