/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.treeprinter;

import java.util.Comparator;

/**
 *
 * @author vpc
 */
public class PersonComparator implements Comparator<Person> {

    public int compare(Person o1, Person o2) {
        int x=compare0(o1, o2);
        int y=o1.getX()-o2.getX();
        if(x*y<0){
            System.out.println("Why");
            compare0(o1, o2);
        }
        System.out.println(o1+" : "+o2+" : "+x);
        return x;
    }

    public int compare0(Person o1, Person o2) {
        Person p1 = o1.getParent();
        Person p2 = o2.getParent();
        if (p1 == p2) {
            return o1.getName().compareTo(o2.getName());
        } else if (o1.getDepth() == o2.getDepth()) {
            return compare(p1, p2);
        } else if (o1.getDepth() < o2.getDepth()) {
            int t = compare(o1, p2);
            if(t==0){
                return -1;
            }
            return t;
        } else {
            int t = compare(p1, o2);
            if(t==0){
                return 1;
            }
            return t;
        }
    }
}
