/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.lists;

/**
 *
 * @author vpc
 */
public class EListHT {

    private EListNode head;
    private EListNode tail;
    private int size;

    public EListHT() {
    }

    public void add(String value) {
        EListNode newNode = new EListNode(value, null);
        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void remove(int pos) {
        EListNode previous;
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("3ib 3lik");
        }
        if (pos != 0) {
            EListNode cur = head;
            for (int i = 0; i < pos - 1; i++) {
                cur = cur.getNext();
            }
            previous = cur;
            previous.setNext(previous.getNext().getNext());
        } else {
            if(head==tail){
                head=tail=null;
            }else{
                head=head.getNext();
            }
        }
        size--;
    }

    public void remove(String value) {
//        int p=find(value);
//        remove(p);
        EListNode previous = null;
        EListNode cur = head;
        while (cur != null) {
            if (cur.getValue().equals(value)) {
                if (previous == null) {
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.getNext();
                    }
                } else {
                    EListNode n = cur.getNext();
                    previous.setNext(n);
                    if (n == null) {
                        tail = previous;
                    }
                }
                size--;
                break;
            }
            previous = cur;
            cur = cur.getNext();
        }
    }

    public void update(int pos, String value) {
        EListNode current;
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("3ib 3lik");
        }
        EListNode cur = head;
        for (int i = 0; i < pos; i++) {
            cur = cur.getNext();
        }
        current = cur;
        current.setValue(value);
    }

    public int find(String value) {
        EListNode current;
        EListNode cur = head;
        int pos = 0;
        while (cur != null) {
            if (cur.getValue().equals(value)) {
                return pos;
            }
            cur = cur.getNext();
            pos++;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "EListHT{" + "head=" + head + ", tail=" + tail + ", size=" + size + '}';
    }
}
