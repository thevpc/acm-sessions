package s1;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vpc
 */
public class CollectionsExample {
    public static void main(String[] args) {
        Collection<String> c1=new ArrayList<String>();
        Collection<String> c2=new Vector<String>();
        Collection<String> c3=new LinkedList<String>();
        Collection<String> c4=new HashSet<String>();
        Collection<String> c5=new TreeSet<String>();
        Collection<String> c6=new LinkedHashSet<String>();
        String[] arr=new String[]{"wissem","hassine","manel","haythem","hassine","manel"};
        Collection<String>[] r=new Collection[]{c1,c2,c3,c4,c5,c6};
        for (Collection<String> collection : r) {
            for (String s : arr) {
                collection.add(s);
            }
            
            System.out.println(collection.getClass().getSimpleName()+":"+ collection);
        }
    }
}
