public class question10_4 
{
    public static void main(String[] args)
    {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(10,30.5);
        
        System.out.println("distance : "+p1.distance(p2));
    }
}


class MyPoint {
    private double x;
    private double y;

    public MyPoint() 
    {
        this(0, 0);
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(MyPoint point) {
        return Math.sqrt(Math.pow(point.getX() - x, 2) + Math.pow(point.getY() - y, 2));
    }

    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }
}
