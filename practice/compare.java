import java.util.*;

public class compare
{
    public static void main(String args[])
    {
        String cat = "cat", dog = "dog";
        CustomizedComparable c_cat = new CustomizedComparable(1);
        CustomizedComparable c_dog = new CustomizedComparable(2);
        CustomizedComparable c_cow = new CustomizedComparable(3);
        
        System.out.println("compareTo - String : "+cat.compareTo(dog)+"cat < dog여서 return -1");
        System.out.println("customizedCompareTo - String : "+c_cat.compareTo(c_dog));
        
        ArrayList<CustomizedComparable> arrList = new ArrayList<>();
        arrList.add(c_cow);
        arrList.add(c_dog);
        arrList.add(c_cat);
        //정렬 전 출력
        for(int i = 0; i < arrList.size(); i++)
        {
            System.out.println("customizedCompareTo - arrList : "+arrList.get(i).getId());
        }
        
        Collections.sort(arrList,new CustomizedComparator());
        
        //정렬 후 출력
        for(int i = 0; i < arrList.size(); i++)
        {
            System.out.println("customizedCompareTo - arrList : "+arrList.get(i).getId());
        }
    }
}

//커스터마이즈 CompareTo 제작 - 해당 클래스는 반드시 외부 클래스로 빼내던가 static 선언 해줘야함
class CustomizedComparable implements Comparable<CustomizedComparable>
{
    private int id;
    public CustomizedComparable(int arg1)
    {
        this.id = arg1;
    }
    
    public int getId()
    {
        return id;
    }
    
    
    public int compareTo(CustomizedComparable arg1)
    {
        if (arg1.getId() == this.id)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}




class CustomizedComparator implements Comparator<CustomizedComparable>
{
    public int compare(CustomizedComparable ins1, CustomizedComparable ins2)
    {
        if (ins1.getId() < ins2.getId())
        {
            return -1;
        }
        else if (ins1.getId() == ins2.getId())
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}