package s1;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vpc
 */
public class MapExample {
    public static void main(String[] args) {
        String[] en={"three","four","five","one","two","one"};
        Integer[] vals={3,4,5,1,2,6};
        Map<String,Integer>[] maps=new Map[]{
            new Hashtable<String,Integer>(),
            new HashMap<String,Integer>(),
            new LinkedHashMap<String,Integer>(),
            new TreeMap<String,Integer>(),
        };
        for (Map<String, Integer> map : maps) {
            for (int i = 0; i < en.length; i++) {
                map.put(en[i], vals[i]);
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String k = entry.getKey();
                Integer v = entry.getValue();
                Integer v2 = map.get(k);
            }
            System.out.println(map.getClass().getSimpleName()+" : "+map);
        }
        
    }
}
