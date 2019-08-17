/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.cousins;

/**
 *
 * @author vpc
 */
public class Result {

    private Person first;
    private Person second;
    private boolean parent;
    private boolean cousin;
    private int m;
    private int n;

    public Result(Person first, Person second) {
        this.first = first;
        this.second = second;
    }

    public Person getFirst() {
        return first;
    }

    public Person getSecond() {
        return second;
    }

    public boolean isParent() {
        return parent;
    }

    public void setParent(boolean parent) {
        this.parent = parent;
    }

    public boolean isCousin() {
        return cousin;
    }

    public void setCousin(boolean cousin) {
        this.cousin = cousin;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}