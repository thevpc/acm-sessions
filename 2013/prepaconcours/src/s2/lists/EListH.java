/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.lists;

/**
 *
 * @author vpc
 */
public class EListH {

    private EListNode head;
    private int size;

    public EListH() {
    }

    public void add(String value) {
        EListNode newNode = new EListNode(value, null);
        EListNode tail = head;
        if (head != null) {
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
            tail.setNext(newNode);
        } else {
            head = newNode;
        }
        size++;
    }

    public void remove(int pos) {
        EListNode previous;
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("3ib 3lik");
        }
        if (pos == 0) {
            head = head.getNext();
        } else {
            EListNode cur = head;
            for (int i = 0; i < pos - 1; i++) {
                cur = cur.getNext();
            }
            previous = cur;
            previous.setNext(previous.getNext().getNext());
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
                EListNode n = cur.getNext();
                previous.setNext(n);
                size--;
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
        return "EListH{" + "head=" + head + ", size=" + size + '}';
    }
}
