package s1;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
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
public class ManipFichierText {
    public static void main(String[] args) {
        try {
            PrintStream out = new PrintStream("/home/vpc/text.txt");
            out.println("Hello World");
            out.println(2.3);
        } catch (Exception ex) {
            Logger.getLogger(ManipFichierText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void main(String[] args) {
//        try {
//            FileReader fr = new FileReader("/home/vpc/jarnalshell.conf");
//            
//            BufferedReader reader=new BufferedReader(fr);
//            String l=null;
//            int o=1;
//            while((l=reader.readLine())!=null){
//                System.out.println(o+" : "+l);
//                o++;
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ManipFichierText.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
