import java.util.*;

public class map 
{
    public static void main(String args[])
    {
        //Map<키,벨류> / get(key)
        
        
        //HashMap - 순서 X
        Map<String, Integer> hash_map = new HashMap<>();
        hash_map.put("keyB", 2);
        hash_map.put("keyA", 1);
        hash_map.put("keyC", 3);
        System.out.println("hash_map : "+hash_map);
        System.out.println("hash_map - get : "+hash_map.remove("keyA")); //get말고 remove도 가능
        System.out.println("hash_map - check order : "+hash_map+"\n");
        
        //LinkedHashMap - Key 순서 + 접근 순서 영향 받음 (값을 받아올 때 속도)
        Map<String, Integer> linked_hash_map = new LinkedHashMap<>();
        linked_hash_map.put("keyB",2);
        linked_hash_map.put("keyA",1);
        linked_hash_map.put("keyC",3);
        System.out.println("linked_hash_map : "+linked_hash_map);
        System.out.println("linked_hash_map - get : "+linked_hash_map.get("keyA"));
        System.out.println("linked_hash_map - check order: "+linked_hash_map+"\n");
        
        //TreeMap - Key 순서
        Map<String, Integer> tree_map = new TreeMap<>();
        tree_map.put("keyB", 2);
        tree_map.put("keyA", 1);
        tree_map.put("keyC", 3);
        System.out.println("tree_map : "+tree_map);
        System.out.println("tree_map - get : "+tree_map.get("keyA"));
        System.out.println("tree_map - check order : "+tree_map+"\n");
    }
}
