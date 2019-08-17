package s1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vpc
 */
public class UseMatrix {
    public static void main(String[] args) {
        Matrix<Integer> intMatrix=new Matrix<Integer>(5,6,Integer.class);
        Integer i=intMatrix.get(1, 1);
        Matrix<Double> doubleMatrix=new Matrix<Double>(5,6,Double.class);
        Double d=doubleMatrix.get(1, 1);
    }
}
