/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.cousins;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vpc
 */
public class Person {

    private String name;
    private List<Relation> fils = new ArrayList<>();
    private List<Relation> parents = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Relation> getFils() {
        return fils;
    }

    public List<Relation> getParents() {
        return parents;
    }
}
