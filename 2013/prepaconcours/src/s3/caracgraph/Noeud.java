/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.caracgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author vpc
 */
public class Noeud {

    private String name;
    private List<Lien> lien = new ArrayList<Lien>();

    public Noeud(String name) {
        this.name = name;
    }

    public List<Lien> getLiens() {
        return lien;
    }

    public String getName() {
        return name;
    }

    public List<Lien> getLien() {
        return lien;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Noeud other = (Noeud) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
