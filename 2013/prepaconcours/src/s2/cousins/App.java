/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.cousins;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vpc
 */
public class App {

    PersonManager persons = new PersonManager();
    List<Result> results = new ArrayList<>();

    public static void main(String[] args) {
        App a = new App();
        a.parse();
        a.findResults();
        a.writeResults();
    }

    public void findResults() {
        for (Result result : results) {
            findResult(result);
        }
    }

    public void findResult(Result result) {
        Person p1 = result.getFirst();
        Person p2 = result.getSecond();
        List<Relation> ancetres1 = getAncestorRelations(p1);
        List<Relation> ancetres2 = getAncestorRelations(p2);
        for (int i = 0; i < ancetres1.size(); i++) {
            for (int j = 0; j < ancetres2.size(); j++) {
                Relation r1 = ancetres1.get(i);
                Relation r2 = ancetres2.get(j);
                if (r1.getAncetre().getName().equals(r2.getAncetre().getName())) {
                    if (r1.getAncetre().getName().equals(p1.getName())) {
                        //descendant
                        result.setParent(true);
                        result.setM(r1.getProfondeur());
                    } else if (r1.getAncetre().getName().equals(p2.getName())) {
                        //descendant
                        result.setParent(true);
                        result.setM(r1.getProfondeur());

                    } else if (r2.getAncetre().getName().equals(p1.getName())) {
                        //descendant
                        result.setParent(true);
                        result.setM(r2.getProfondeur());

                    } else if (r2.getAncetre().getName().equals(p2.getName())) {
                        //descendant
                        result.setParent(true);
                        result.setM(r2.getProfondeur());

                    } else {
                        //cousin
                        result.setM(Math.min(r1.getProfondeur(), r2.getProfondeur())-1);
                        result.setN(Math.max(r1.getProfondeur(), r2.getProfondeur())-result.getN()-1);
                    }
                }
            }
        }
    }

    public List<Relation> getAncestorRelations(Person p) {
        List<Relation> list = getAncestorRelations(p, p, 0);
        list.add(0, new Relation(p, p, 0));
        return list;
    }

    public List<Relation> getAncestorRelations(Person p, Person current, int prefix) {
        List<Relation> list = new ArrayList<>();
        for (Relation relation : p.getParents()) {
            list.add(new Relation(current, relation.getAncetre(), relation.getProfondeur() + prefix));
        }
        for (Relation relation : p.getParents()) {
            list.addAll(getAncestorRelations(relation.getFils(), current, prefix + relation.getProfondeur()));
        }
        Collections.sort(list, new Comparator<Relation>() {
            @Override
            public int compare(Relation o1, Relation o2) {
                int x = o1.getProfondeur() - o2.getProfondeur();
                if (x != 0) {
                    return x;
                }
                return 0;
            }
        });
        return list;
    }

    public void writeResults() {
        try {
            PrintStream out = new PrintStream("/home/vpc/cousins.out.txt");
            for (Result result : results) {
                out.print(result.getFirst().getName());
                out.print(" ");
                out.print(result.getSecond().getName());
                out.print(" are ");
                if (result.isCousin()) {
                    out.println(" cousins " + result.getM() + "-" + result.getN());
                } else if (result.isParent()) {
                    out.println(" descendent " + result.getM());
                } else {
                    out.println(" not related");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void parse() {
        BufferedReader r = null;
        try {
            r = new BufferedReader(new FileReader("/home/vpc/cousins.in.txt"));
            String line = null;
            while ((line = r.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#")) {
                    //taffi
                } else if (line.startsWith("R")) {
                    String a = line.substring(1, 6).trim();
                    String b = line.substring(6, 12).trim();
                    int n = Integer.parseInt(line.substring(12).trim());
                    Person p1 = persons.get(a);
                    Person p2 = persons.get(b);
                    Relation rel = new Relation(p1, p2, n);
                    p1.getParents().add(rel);
                    p2.getFils().add(rel);
                } else if (line.startsWith("F")) {
                    String a = line.substring(1, 6).trim();
                    String b = line.substring(6).trim();
                    Person p1 = persons.get(a);
                    Person p2 = persons.get(b);
                    Result res = new Result(p1, p2);
                    results.add(res);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                r.close();
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
