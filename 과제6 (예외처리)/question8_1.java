public class question8_1 
{
    static int temperature = 10000;

    class TemperatureException extends Exception 
    {
        private int temperature;

        TemperatureException() 
        {
            super("제어 불가");
        }

        TemperatureException(String msg) 
        {
            super(msg);
        }

        void setTemperature(int t) 
        {
            temperature = t;
        }

        int getTemperature() 
        {
            return temperature;
        }
    }

    public static void main(String[] args) 
    {
        try 
        {
            reactor_monitoring();
            return;
        } 
        catch (TemperatureException e) 
        {
            System.out.println(e.getMessage());
            System.out.println(e.getTemperature());
            System.out.println("원자로 셧다운");
        }
    }

    static void reactor_monitoring() throws TemperatureException 
    {
        while (true) 
        {
            if (temperature > 15000) 
            {
                TemperatureException e = new question8_1().new TemperatureException();
                e.setTemperature(temperature);
                throw e;
            } 
            else if (temperature > 12000) 
            {
                temperature += control();
                System.out.println("경고: " + temperature);
            } 
            else 
            {
                System.out.println();
                System.out.println("정상: " + temperature);
                temperature += mutate();
            }
        }
    }

    static int mutate() 
    {
        int amount;
        amount = (int) (Math.random() * 1000);
        return amount;
    }

    static int control() 
    {
        int temp = 0;
        switch ((int) (Math.random() * 3)) 
        {
            case 0:
                temp = -500;
                break;
            case 1:
                temp = 0;
                break;
            case 2:
                temp = 500;
                break;
        }
        return temp;
    }
}
