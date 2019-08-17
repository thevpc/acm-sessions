/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s2.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author vpc
 */
public class NTree {

    private NNode root;

    public void add(String value, List<String> path) {
        if (path == null || path.size() == 0) {
            if (root == null) {
                root = new NNode(value);
            } else {
                throw new IllegalArgumentException("Tree Could not have multiple roots");
            }
        } else {
            NNode n = find(path);
            if (n == null) {
                throw new IllegalArgumentException("Invalid path");
            }
            n.getChildren().add(new NNode(value));
        }
    }

    public void update(String value, List<String> path) {
        NNode n = find(path);
        if (n == null) {
            throw new IllegalArgumentException("Invalid path");
        }
        n.setValue(value);
    }

    public void remove(List<String> path) {
        if (path.size() == 0) {
            throw new IllegalArgumentException("Invalid path");
        } else {
            String nodeValue = path.get(path.size() - 1);
            List<String> parentPath = new ArrayList<>(path);
            parentPath.remove(parentPath.size() - 1);
            if (parentPath.size() == 0) {
                if (nodeValue.equals(root.getValue())) {
                    root = null;
                } else {
                    throw new IllegalArgumentException("Invalid path");
                }
            } else {
                NNode n = find(parentPath);
                if (n == null) {
                    throw new IllegalArgumentException("Invalid path");
                }
                NNode f = null;
                for (NNode nNode : n.getChildren()) {
                    if (nNode.getValue().equals(nodeValue)) {
                        f = nNode;
                        break;
                    }
                }
                if (f != null) {
                    n.getChildren().remove(f);
                } else {
                    throw new IllegalArgumentException("Invalid path");
                }
            }
        }
    }

    public NNode find(List<String> path) {
        NNode c = root;
        if (!path.get(0).equals(root.getValue())) {
            return null;
        }
        for (int i = 1; i < path.size(); i++) {
            String v = path.get(i);
            boolean found = false;
            for (NNode n : c.getChildren()) {
                if (n.getValue().equals(v)) {
                    c = n;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return null;
            }
        }
        return c;
    }

    public NNode findProf(String value) {
        Stack<NNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            NNode e = stack.pop();
            System.out.println("[DEBUG] "+e);
            //traitement
            if (e.getValue().equals(value)) {
                return e;
            }

            for (NNode n : e.getChildren()) {
                stack.push(n);
            }
        }
        return null;
    }

    public NNode findLarg(String value) {
        LinkedList<NNode> file = new LinkedList<>();
        file.addLast(root);
        while (!file.isEmpty()) {
            NNode e = file.removeFirst();
            System.out.println("[DEBUG] "+e);
            //traitement
            if (e.getValue().equals(value)) {
                return e;
            }

            for (NNode n : e.getChildren()) {
                file.addLast(n);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "NTree{" + "root=" + root + '}';
    }
    
}
