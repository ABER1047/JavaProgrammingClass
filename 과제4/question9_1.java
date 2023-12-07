import java.util.*;

public class question9_1
{
    public static void main(String[] args)
    {
        Rectangle rec1 = new Rectangle(4,40);
        Rectangle rec2 = new Rectangle(3.5,35.9);
        
        System.out.println("첫번째 사각형 - 넓이 : "+rec1.getArea()+" / 겉넓이 : "+rec1.getPerimeter());
        System.out.println("두번째 사각형 - 넓이 : "+rec2.getArea()+" / 겉넓이 : "+rec2.getPerimeter());
    }
}


class Rectangle
{
    private double width, height;
    
    public Rectangle()
    {
        width = 1;
        height = 1;
    }
    
    public Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }
    
    public double getArea()
    {
        return (width*height);
    }
    
    public double getPerimeter()
    {
        return (2*(width+height));
    }
}

