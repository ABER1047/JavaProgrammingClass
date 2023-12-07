import java.util.*;

public class question10_1 
{
    public static void main(String[] args)
    {
        Time t1 = new Time();
        Time t2 = new Time(555550000);
        System.out.println(t1.getHour()+":"+t1.getMinute()+":"+t1.getSecond());
        System.out.println(t2.getHour()+":"+t2.getMinute()+":"+t2.getSecond());
    }
}


class Time
{
    private long hour, minute, second;

    public Time() 
    {
        long elapsedTime = System.currentTimeMillis();
        setTime(elapsedTime);
    }

    public Time(long elapsedTime) 
    {
        setTime(elapsedTime);
    }

    public Time(long hour, long minute, long second) 
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public long getHour() {
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    public long getSecond() {
        return second;
    }

    public void setTime(long elapsedTime) 
    {
        long totalSeconds = elapsedTime / 1000;
        long totalMinutes = totalSeconds / 60;
        long totalHours = totalMinutes / 60;
        
        this.second = totalSeconds % 60;
        this.minute = totalMinutes % 60;
        this.hour = totalHours % 24;
    }
}