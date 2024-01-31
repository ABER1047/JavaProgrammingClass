import java.util.*;

public class set 
{
    public static void main(String args[])
    {
        Set<Integer> linkedHashSet = new LinkedHashSet<>(); //삽입 순서
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        Iterator iter1 = linkedHashSet.iterator();
        while(iter1.hasNext())
        {
            System.out.println("LinkedHashSet : "+iter1.next());
        }
        Object toArr[] = linkedHashSet.toArray();
        for(int i = 0; i < linkedHashSet.size(); i++)
        {
            System.out.println("toArray : "+toArr[i]);
        }
        
        
        Set<Integer> hashSet = new HashSet<>(); //순서 X
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(2);
        Iterator iter2 = hashSet.iterator();
        while(iter2.hasNext())
        {
            System.out.println("HashSet : "+iter2.next());
        }
        
        
        Set<Integer> treeSet = new TreeSet<>(); //네츄럴 오더
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        Iterator iter3 = treeSet.iterator();
        while(iter3.hasNext())
        {
            System.out.println("TreeSet : "+iter3.next());
        }
    }
}
