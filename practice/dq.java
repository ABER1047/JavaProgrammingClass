import java.util.*;

public class dq 
{
    public static void main(String args[])
    {
        //Deque
        Deque<Integer> dq_linkedList = new LinkedList<>();
        Deque<Integer> dq_arrDeque = new ArrayDeque<>();
        for(int i = 0; i < 5; i++)
        {
            dq_linkedList.add(i);
            dq_arrDeque.addLast(i);
        }
        
        
        
        //Itorator
        Iterator<Integer> iter_linkedList = dq_linkedList.iterator();
        Iterator<Integer> iter_arrayDeque = dq_arrDeque.iterator();
        
        while(iter_linkedList.hasNext())
        {
            System.out.println(iter_linkedList.next());
        }
        
        while(iter_arrayDeque.hasNext())
        {
            System.out.println(iter_arrayDeque.next());
        }
        
        
        
        //'1' 이라는 Integer 오브젝트를 포함하고 있는가?
        if (dq_arrDeque.contains(1))
        {
            System.out.println("dq_arrDeque는 1이라는 Integer 오브젝트를 포함하고 있음");
        }
        
        
        
        //Iterator는 '순회자' 역할로 기존 dq와는 분리된 상태
        System.out.println("Iterator는 remove로 값을 빼는게 아니라서 기존 dq값은 그대로 보존되어 있음\ndq_linkedList.remove() : "+dq_linkedList.remove());
    }
}
