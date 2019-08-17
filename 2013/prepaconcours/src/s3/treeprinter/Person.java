/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.treeprinter;

import java.util.Objects;

/**
 *
 * @author vpc
 */
public class Person {

    private int x;
    private String name;
    private Person parent;

    public Person(String name, Person parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(Person parent) {
        this.parent = parent;
    }
    
    public int getDepth(){
        if(getParent()==null){
            return 0;
        }
        return 1+getParent().getDepth();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", parent=" + parent + '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    
}
