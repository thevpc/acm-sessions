/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s5;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import s4.Graph4;

/**
 *
 * @author vpc
 */
public class ParcoursGraphe {

    public void parcourirRecProfLeftFirst(Graph4 g, String n) {
        System.out.println(n);
        for (String s : g.getSuccessors(n)) {
            parcourirRecProfLeftFirst(g, n);
        }
    }

    public void parcourirRecProfRightFirst(Graph4 g, String n) {
        System.out.println(n);
        Set<String> successorsSet = g.getSuccessors(n);
        String[] successors = successorsSet.toArray(new String[successorsSet.size()]);
        for (int i = successors.length-1; i >= 0; i--) {
            parcourirRecProfRightFirst(g, n);
        }
    }
    
    public void parcourirPileProfRightFirst(Graph4 g, String n) {
        Stack<String> pile = new Stack<>();
        pile.push(n);
        while (!pile.isEmpty()) {
            String e = pile.pop();
            System.out.println(e);
            for (String s : g.getSuccessors(n)) {
                pile.push(s);
            }
        }
    }
    
    public void parcourirFileProfLeftFirst(Graph4 g, String n) {
        LinkedList<String> pile = new LinkedList<>();
        pile.addLast(n);
        while (!pile.isEmpty()) {
            String e = pile.removeFirst();
            System.out.println(e);
            for (String s : g.getSuccessors(n)) {
                pile.push(s);
            }
        }
    }
}
