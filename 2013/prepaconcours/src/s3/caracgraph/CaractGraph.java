/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.caracgraph;

import s3.treeprinter.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vpc
 */
public class CaractGraph {

    public static void main(String[] args) {
        CaractGraph app = new CaractGraph();
        try {
            app.run();
        } catch (IOException ex) {
            Logger.getLogger(TreePrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void run() throws IOException {
        Graph g = new Graph();
        loadGraph(g);
        writeGraph(g);
    }

    public void writeGraph(Graph graph) throws IOException {
        PrintStream out = new PrintStream("output.txt");
        System.out.println(isCyclic(graph) ? "graphe cyclique" : "graphe non cyclique");
        System.out.println(isDense(graph) ? "graphe dense" : "graphe non dense");
        System.out.println(isSimple(graph) ? "graphe simple" : "graphe non simpledense");
    }

    public boolean isCyclic(Graph graph) {
        if(!isSimple(graph)){
            return true;
        }
        for (Noeud noeud : graph.getNodes()) {
            List<Noeud> liste=new ArrayList<Noeud>();
            liste.add(noeud);
            if(isCycle(graph, noeud, liste)){
                return true;
            }                    
        }
        return false;
    }
    
    public boolean isCycle(Graph graph,Noeud noeud,List<Noeud> path){
        for (Lien lien : noeud.getLiens()) {
            if(path.contains(lien.getTo())){
                return true;
            }
            List<Noeud> path2=new ArrayList<Noeud>(path);
            path.add(lien.getTo());
            if(isCycle(graph, lien.getTo(), path2)){
                return true;
            }
        }
        return false;
    }

    public boolean isSimple(Graph graph) {
        for (Noeud noeud : graph.getNodes()) {
            for (Lien lien : noeud.getLiens()) {
                if(lien.getTo().equals(noeud)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isDense(Graph graph) {
        int i=graph.getNodes().size();
        for (Noeud noeud : graph.getNodes()) {
            if(noeud.getLiens().size()<i-1){
                return false;
            }
        }
        return true;
    }

    public void loadGraph(Graph graph) throws IOException {
        BufferedReader r = null;
        try {
            r = new BufferedReader(new FileReader("input.txt"));

            String line;
            while ((line = r.readLine()) != null) {
                if (line.trim().length() > 0) {
                    String[] cols = line.split(" ");
                    graph.addLien(cols[0], cols[1]);
                }
            }
        } finally {
            if (r != null) {
                r.close();
            }
        }
    }

    public Person getPerson(String n, Map<String, Person> map) {
        Person p = map.get(n);
        if (p == null) {
            p = new Person(n, null);
            map.put(n, p);
        }
        return p;

    }
}
