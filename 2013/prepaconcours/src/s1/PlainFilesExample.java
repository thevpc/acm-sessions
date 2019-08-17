package s1;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vpc
 */
public class PlainFilesExample {
//    public static void main(String[] args){
//        try {
//            OutputStream os=new FileOutputStream("/home/vpc/brut.bin");
//            os.write(new byte[]{(byte)14,(byte)15,(byte)0});
//            os.write(new byte[]{(byte)8,(byte)5});
//            os.close();
//        } catch (Exception ex) {
//            Logger.getLogger(ManipFichierBrut.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public static void main(String[] args){
        try {
            InputStream is=new FileInputStream("/home/vpc/brut.bin");
            byte[] tampon=new byte[2];
            int r;
            while( (r=is.read(tampon))!=0){
                for (int i = 0; i < r; i++) {
                    System.out.println("found "+(int)tampon[i]);
                    
                }
            }
            is.close();
        } catch (Exception ex) {
            Logger.getLogger(PlainFilesExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
