/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vpc
 */
public class NNode {

    private String value;
    private List<NNode> children = new ArrayList<>(3);

    public NNode(String value) {
        this.value = value;
    }

    public List<NNode> getChildren() {
        return children;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NNode{" + "value=" + value + ", children=" + children + '}';
    }
    
}
