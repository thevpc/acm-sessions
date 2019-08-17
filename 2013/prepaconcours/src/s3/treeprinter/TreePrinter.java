/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s3.treeprinter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vpc
 */
public class TreePrinter {

    public static void main(String[] args) {
        TreePrinter app = new TreePrinter();
        try {
            app.run();
        } catch (IOException ex) {
            Logger.getLogger(TreePrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void run() throws IOException {
        Map<String, Person> persons = new HashMap<String, Person>();
        loadPersons(persons);
        List<Person> list = sortPersons(persons);
        writePersons(list);
    }

    public List<Person> sortPersons(Map<String, Person> map) {
        ArrayList<Person> all = new ArrayList<>(map.values());
        Collections.sort(all, new PersonComparator());
        return all;
    }

    public void writePersons(List<Person> persons) throws IOException {
        PrintStream out = new PrintStream("output.txt");
        for (Person o : persons) {
            int d = o.getDepth();
            for (int i = 0; i < d; i++) {
                out.print(" ");
            }
            out.println(o.getName());
        }
    }

    public void loadPersons(Map<String, Person> map) throws IOException {
        BufferedReader r = null;
        try {
            r = new BufferedReader(new FileReader("input.txt"));

            String line;
            while ((line = r.readLine()) != null) {
                if (line.trim().length() > 0) {
                    String[] cols = line.split(" ");
                    Person parent = getPerson(cols[0], map);
                    Person child = getPerson(cols[1], map);
                    child.setParent(parent);
                }
            }
            int pos=1;
            getPerson("Hammadi", map).setX(pos++);
            getPerson("Ahmed", map).setX(pos++);
            getPerson("Ali", map).setX(pos++);
            getPerson("Khalil", map).setX(pos++);
            getPerson("Marouene", map).setX(pos++);
            getPerson("Sofiene", map).setX(pos++);
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
