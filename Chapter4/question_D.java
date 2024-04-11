import java.util.*;

public class question_D 
{
    public static void main(String[] args)
    {
        Class ins[] = {
        new Class(0, "전선", 1, "FP0001", "지도교수상담", "0-0-0-0"),
        new Class(0, "전선", 2, "FP0001", "지도교수상담", "0-0-0-0"),
        new Class(1, "전필", 1, "CS0060", "프로그래밍입문", "3-2-0-2"),
        new Class(1, "전필", 2, "CS0010", "자바프로그래밍", "3-2-0-2"),
        new Class(1, "전필", 1, "CS0007", "창의공학설계입문", "2-0-2-0"),
        new Class(1, "전필", 2, "CS0005", "논리회로", "3-2-0-2"),
        new Class(1, "전선", 1, "CS0061", "컴퓨터개론", "3-3-0-0"),
        new Class(1, "전선", 2, "CS0063", "멀티미디어", "2-2-0-0"),
        new Class(1, "전선", 1, "CS0062", "학습과진로", "1-0-0-2"),
        new Class(2, "전필", 1, "CS0064", "자료구조", "4-4-0-0"),
        new Class(2, "전필", 2, "CS0077", "C++프로그래밍", "3-2-0-2"),
        new Class(2, "전필", 1, "CS0011", "컴퓨터구조", "3-2-0-2"),
        new Class(2, "전필", 2, "CS0017", "운영체제", "3-2-0-2"),
        new Class(2, "전필", 1, "CS0012", "데이터베이스", "4-4-0-0"),
        new Class(2, "전필", 2, "CS0016", "컴퓨터네트워크", "4-4-0-0"),
        new Class(2, "전필", 1, "CS0009", "프로그래밍응용", "2-0-2-0"),
        new Class(2, "전필", 2, "CS0069", "융합프로젝트", "2-0-2-0"),
        new Class(2, "전선", 2, "CS0080", "오픈소스소프트웨어", "2-1-0-2")};
        
        
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("정보를 확인할 교과목 과목코드를 입력해주세요 (종료는 -1을 입력해주세요) : ");
            String str = sc.nextLine().replaceAll("\\s","");
            if (str.equals("-1"))
            {
                System.out.println("프로그램을 종료합니다.\n");
                break;
            }
            else
            {
                int found_equals = 0;
                for(int i = 0; i < ins.length; i++)
                {
                    if (ins[i].getClassCode().equals(str))
                    {
                        ins[i].showInfo();
                        found_equals = 1;
                        break;
                    }
                }
                
                if (found_equals == 0)
                {
                    System.out.println("해당 과목코드에 해당되는 교과목이 존재하지 않습니다.\n");
                }
            }
        }
    }
}



class Class
{
    private String classification, class_code, class_name, point;
    private int grade, season;
    
    public String getClassCode()
    {
        return class_code;
    }
    
    public String getClassName()
    {
        return class_name;
    }
    
    public Class(int grade, String classification, int season, String class_code, String class_name, String point)
    {
        this.grade = grade;
        this.classification = classification;
        this.season = season;
        this.class_code = class_code;
        this.class_name = class_name;
        this.point = point;
    }
    
    public void showInfo()
    {
        System.out.println("===========================================");
        System.out.println("학년 : "+((grade == 0) ? "전학년" : grade+"학년"));
        System.out.println("이수 구분 : "+classification);
        System.out.println("학기 : "+season+"학기");
        System.out.println("과목코드 : "+class_code);
        System.out.println("교과목명 : "+class_name);
        System.out.println("학점 : "+point);
        System.out.println("===========================================");
    }
}