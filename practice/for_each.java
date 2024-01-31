import java.util.*;

public class for_each
{
    public static void main(String[] args)
    {
        //array - for each
        int arr[] = { 0,1,2,3,4,5,6,7 };
        for(int i : arr)
        {
            System.out.println(arr[i]);
        }
        
        
        //List - for each
        System.out.println("===================================");
        List<Integer> arr_list = new ArrayList<>();
        List<Integer> linked_list = new LinkedList<>();
        for(int i = 0; i < 5; i++)
        {
            arr_list.add(i);
            linked_list.add(i);
        }
        
        for(int i : arr_list)
        {
            System.out.println("arr_list : "+arr_list.get(i));
            System.out.println("linked_list : "+linked_list.get(i));
        }
        
        //ArrayList - for each
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < 5; i++)
        {
            arrList.add(i);
        }
        
        System.out.println("- 정렬 전 :");
        //for(int i : arrList)
        //{
            System.out.println("arrList : "+arrList);
        //}
        
        Collections.sort(arrList,new ReverseOrder());
        
        System.out.println("- 정렬 후 :");
        //for(int i : arrList)
        //{
            System.out.println("arrList : "+arrList);
        //}
        //Deque는 index를 지정해서 값을 리턴하는 메소드가 없음
        //PriorityQueue는 index를 지정해서 값을 리턴하는 메소드가 없음
    }
}


//역순 정렬하는 CustomOrder
class ReverseOrder implements Comparator<Integer>
{
    public int compare(Integer obj1, Integer obj2)
    {
        if (obj1.intValue() < obj2.intValue())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}