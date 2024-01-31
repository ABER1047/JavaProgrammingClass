import java.util.*;

public class Priority_Queue 
{
    public static void main(String args[])
    {
        //기본
        Queue<Integer> pq1 = new PriorityQueue<>();
        pq1.add(5);
        pq1.add(6);
        pq1.add(4);
        pq1.add(3);
        
        Iterator<Integer> iter1 = pq1.iterator();
        while(iter1.hasNext())
        {
            System.out.println(iter1.next());
        }
        
        //toArray
        Object toArr[] = pq1.toArray();
        for(int i = 0; i < pq1.size(); i++)
        {
            //타입을 Object -> String으로 변경 후 parseInt로 정수 타입으로 변경
            System.out.println("toArray : "+Integer.parseInt(toArr[i].toString()));
        }
        
        
        
        //역순
        System.out.println("==================================================");
        Queue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.add(5);
        pq2.add(3);
        pq2.add(4);
        pq2.add(6);
        
        Iterator<Integer> iter2 = pq2.iterator();
        while(iter2.hasNext())
        {
            System.out.println(iter2.next());
        }
    }
}
