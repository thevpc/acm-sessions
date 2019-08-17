package s1;


import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vpc
 */
public class MultMatrixAL {

    public ArrayList<ArrayList<Double>> mult(ArrayList<ArrayList<Double>> a, ArrayList<ArrayList<Double>> b) {
        double[][] tt={{1.2,3},{3.9,5}};
        if (a.size() == 0) {
            throw new RuntimeException("Pbm");
        }
        if (a.get(0).size() == 0) {
            throw new RuntimeException("Pbm");
        }
        if (b.size() == 0) {
            throw new RuntimeException("Pbm");
        }
        if (b.get(0).size() == 0) {
            throw new RuntimeException("Pbm");
        }
        if (a.get(0).size() != b.size()) {
            throw new RuntimeException("Pbm");
        }
        ArrayList<ArrayList<Double>> r = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < a.size(); i++) {
            ArrayList<Double> ligne=new ArrayList<>();
            r.add(ligne);
            for (int j = 0; j < b.get(0).size(); j++) {
                double v=0;
                for (int k = 0; k < a.get(0).size(); k++) {
                    v+=a.get(i).get(k).doubleValue()*b.get(k).get(j).doubleValue();
                }
                r.get(i).add(v);
            }
        }
        return r;
    }
}