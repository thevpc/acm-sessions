/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.caracgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vpc
 */
public class Graph {
    Map<String,Noeud> noeuds=new HashMap<>();

    public List<Noeud> getNodes(){
        return new ArrayList<Noeud>(noeuds.values());
    }
 
    public void addLien(String from,String to){
        Noeud f = getNoeud(from);
        Noeud t = getNoeud(to);
        f.getLiens().add(new Lien(f, t));
    }
    public Noeud getNoeud(String n){
        Noeud r = noeuds.get(n);
        if(r==null){
            r=new Noeud(n);
            noeuds.put(n, r);
        }
        return r;
    }
}
