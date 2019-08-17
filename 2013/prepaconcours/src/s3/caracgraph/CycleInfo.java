/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.caracgraph;

import java.util.List;

/**
 *
 * @author vpc
 */
public class CycleInfo {

    List<Noeud> noeuds;
    boolean cycle;

    public CycleInfo(List<Noeud> noeuds, boolean cycle) {
        this.noeuds = noeuds;
        this.cycle = cycle;
    }
}
