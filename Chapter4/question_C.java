import java.util.*;

public class question_C 
{
    public static void main(String[] args)
    {
        Calendar cal = Calendar.getInstance();
        
        Program program1 = new Program("프로그램1", 10, 12);
        Program program2 = new Program("프로그램2", 14, 16);
        Program program3 = new Program("프로그램3", 18, 20);
            
        RadioStation station1 = new RadioStation("방송국1", program1);
        RadioStation station2 = new RadioStation("방송국2", program2);
        RadioStation station3 = new RadioStation("방송국3", program3);

        
        RadioStation station[] = { station1, station2, station3 };
        
        Radio radio = new Radio();
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("라디오를 킬까요? (0,1) : ");
            int tmp = sc.nextInt();
            if (tmp == 1)
            {
                radio.turnOn();
                break;
            }
            else if (tmp == 0)
            {
                radio.turnOff();
                break;
            }
        }
        
        if (radio.isOn())
        {
            while(true)
            {
                System.out.println("채널을 선택해주세요 (1,2,3) : ");
                int tmp1 = sc.nextInt();
                if (tmp1 >= 1 && tmp1 <= 3)
                {
                    System.out.println("임의의 시간을 설정해주세요 (0~24를 벗어나면 입력시 현재 시간으로 설정됨) : ");
                    int tmp2 = sc.nextInt();
                    if (tmp2 >= 0 && tmp2 <= 24)
                    {
                        radio.setCustomTime(tmp2, cal);
                    }
                    radio.selectChannel(station[tmp1-1], cal);
                    break;
                }
             }
        }
    }
}

class RadioStation
{
    private String name;
    private Program program;

    public RadioStation(String name, Program program) 
    {
        this.name = name;
        this.program = program;
    }

    public String getName() 
    {
        return name;
    }

    public Program getProgram() 
    {
        return program;
    }
}

class Radio
{
    private boolean on;
    private RadioStation n_station;

    public void turnOn() 
    {
        on = true;
        System.out.println("라디오 켜짐");
    }

    public void turnOff() 
    {
        on = false;
        System.out.println("라디오 꺼짐");
    }
    
    public void selectChannel(RadioStation station, Calendar tmp_cal) 
    {
        n_station = station;
        Program program = station.getProgram();
        System.out.println("현재 방송국 : "+station.getName());
        System.out.println("현재 프로그램 : "+program.getName());
        System.out.println("시작 시각 : "+program.getStime()+"시");
        
        int start_at = program.getStime() - tmp_cal.get(Calendar.HOUR_OF_DAY);
        int until_the_end = program.getEDtime() - tmp_cal.get(Calendar.HOUR_OF_DAY);
        
        System.out.println("프로그램 시작까지 남은 시간 : "+((start_at > 0) ? (start_at+"시간") : "프로그램이 이미 시작되었습니다"));
        System.out.println("프로그램 종료까지 남은 시간 : "+((until_the_end > 0) ? (until_the_end+"시간") : "프로그램이 이미 종료되었습니다"));
    }
    
    public void setCustomTime(int hour, Calendar tmp_cal) 
    {
        tmp_cal.set(Calendar .HOUR_OF_DAY, hour);
        System.out.println("현재 시간을 "+hour+"시로 설정합니다\n");
    }
    
    public boolean isOn()
    {
        return on;
    }
}

class Program 
{
    private String name;
    private int s_time, ed_time;

    public Program(String name, int s_h, int e_h) 
    {
        this.name = name;
        s_time = s_h;
        ed_time = e_h;
    }

    public String getName() 
    {
        return name;
    }

    public int getStime() 
    {
        return s_time;
    }

    public int getEDtime() 
    {
        return ed_time;
    }
}