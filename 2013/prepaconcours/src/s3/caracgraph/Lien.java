/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.caracgraph;

/**
 *
 * @author vpc
 */
public class Lien {

    private Noeud from;
    private Noeud to;

    public Lien(Noeud from, Noeud to) {
        this.from = from;
        this.to = to;
    }

    public Noeud getFrom() {
        return from;
    }

    public void setFrom(Noeud from) {
        this.from = from;
    }

    public Noeud getTo() {
        return to;
    }

    public void setTo(Noeud to) {
        this.to = to;
    }
}
