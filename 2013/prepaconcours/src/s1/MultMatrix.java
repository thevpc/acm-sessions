package s1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vpc
 */
public class MultMatrix {

    public double[][] mult(double[][] a, double[][] b) {
        double[][] tt={{1.2,3},{3.9,5}};
        if (a.length == 0) {
            throw new RuntimeException("Pbm");
        }
        if (a[0].length == 0) {
            throw new RuntimeException("Pbm");
        }
        if (b.length == 0) {
            throw new RuntimeException("Pbm");
        }
        if (b[0].length == 0) {
            throw new RuntimeException("Pbm");
        }
        if (a[0].length != b.length) {
            throw new RuntimeException("Pbm");
        }
        double[][] r = new double[a.length][b[0].length];
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                double v=0;
                for (int k = 0; k < r[i].length; k++) {
                    v+=a[i][k]*b[k][j];
                }
                r[i][j]=v;
            }
        }
        return r;
    }
}