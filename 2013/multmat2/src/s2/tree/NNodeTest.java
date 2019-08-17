/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.tree;

import java.util.Arrays;

/**
 *
 * @author vpc
 */
public class NNodeTest {
    public static void main(String[] args) {
        NTree t=new NTree();
        t.add("A", null);
        System.out.println(t);
        t.add("B", Arrays.asList("A"));
        System.out.println(t);
        t.add("D", Arrays.asList("A","B"));
        System.out.println(t);
        t.add("E", Arrays.asList("A","B"));
        System.out.println(t);
        t.add("C", Arrays.asList("A"));
        System.out.println(t);
        t.add("F", Arrays.asList("A","C"));
        System.out.println(t);
        t.add("G", Arrays.asList("A","C"));
        System.out.println(t);

        System.out.println(t.findProf("F"));
//        t.remove(Arrays.asList("A","C"));
//        System.out.println(t);
//        
//        t.remove(Arrays.asList("A"));
//        System.out.println(t);
    }
    
}
