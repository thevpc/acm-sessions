/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.lists;

/**
 *
 * @author vpc
 */
public class EListNode {

    private String value;
    private EListNode next;

    public EListNode(String value, EListNode next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public EListNode getNext() {
        return next;
    }

    public void setNext(EListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "{" + "value=" + value + ", next=" + next + '}';
    }
    
}
