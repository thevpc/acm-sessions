package s1;


import java.lang.reflect.Array;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vpc
 */
public class Matrix<T> {
    private T[][] content;
    private int columns;
    private int rows;

    public Matrix(int rows,int columns,Class<T> type) {
        this.columns = columns;
        this.rows = rows;
        content=(T[][])Array.newInstance(type, rows,columns);
    }
    
    public void set(int i,int j,T value){
        content[i][j]=value;
    }
    
    public T get(int i,int j){
        return content[i][j];
    }
    
}
 