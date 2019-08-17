/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s5;

import java.util.Stack;

/**
 *
 * @author vpc
 */
public class Recursivity {
    
    public int factPile(int i){
        Stack<Integer> pile=new Stack<>();
        pile.push(i);
        while(!pile.isEmpty()){
            Integer last = pile.peek();
            if(last.equals(1)){
                break;
            }else{
                pile.push(last-1);
            }
        }
        int v=1;
        while(!pile.isEmpty()){
            Integer last = pile.pop();
            v*=last;
        }
        return v;
    }
    
    public int factRec(int i){
        if(i==0){
            return 1;
        }
        int t=factRec(i-1);
        return t*i;
    }
}
