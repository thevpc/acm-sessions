/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.cousins;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vpc
 */
public class PersonManager {
    Map<String,Person> all=new HashMap<>();
    public Person get(String name){
        Person p=all.get(name);
        if(p!=null){
            return p;
        }
        p=new Person(name);
        all.put(name, p);
        return p;
    }
}
