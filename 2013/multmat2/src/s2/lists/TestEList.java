/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.lists;

/**
 *
 * @author vpc
 */
public class TestEList {
    public static void main(String[] args) {
        EListH li=new EListH();
        li.add("Hello");
        System.out.println("1: "+li);
        li.add("world");
        System.out.println("2: "+li);
        li.update(1, "World");
        System.out.println("3: "+li);
        System.out.println(li.find("World"));
        li.remove("World");
        System.out.println("4: "+li);
        
        li.remove(0);
        System.out.println("5: "+li);
        
    }
}
