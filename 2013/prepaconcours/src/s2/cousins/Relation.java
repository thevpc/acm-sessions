/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.cousins;

/**
 *
 * @author vpc
 */
public class Relation {

    private Person fils;
    private Person ancetre;
    int profondeur;

    public Relation(Person fils, Person ancetre, int profondeur) {
        this.fils = fils;
        this.ancetre = ancetre;
        this.profondeur = profondeur;
    }

    public Person getFils() {
        return fils;
    }

    public Person getAncetre() {
        return ancetre;
    }

    public int getProfondeur() {
        return profondeur;
    }
}
