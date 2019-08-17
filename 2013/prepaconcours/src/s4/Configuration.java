/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author vpc
 */
public class Configuration {

    int nbPoliceman;
    List<String> policePaths;
    Set<String> visited;
    int time;
    int nodeCount;
    int visitedCount;
    boolean finalConfig;

    public Configuration(List<String> policePaths, int nodeCount) {
        this.nbPoliceman = policePaths.size();
        this.nodeCount = nodeCount;
        this.policePaths = new ArrayList<>(policePaths);
        visited = new HashSet<>();
        time = 0;
        for (String path : policePaths) {
            time = Math.max(time, path.length() - 1);
            for (char c : path.toCharArray()) {
                visited.add(String.valueOf(c));
            }
        }
        visitedCount = visited.size();
        finalConfig = (nodeCount == visitedCount);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.nbPoliceman;
        hash = 37 * hash + Objects.hashCode(this.policePaths);
        hash = 37 * hash + Objects.hashCode(this.visited);
        hash = 37 * hash + this.time;
        hash = 37 * hash + this.nodeCount;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Configuration other = (Configuration) obj;
        if (this.nbPoliceman != other.nbPoliceman) {
            return false;
        }
        List<String> p1 = new ArrayList<String>(this.policePaths);
        List<String> p2 = new ArrayList<String>(other.policePaths);
        Collections.sort(p1);
        Collections.sort(p2);
        if (!Objects.equals(p1, p2)) {
            return false;
        }
        if (!Objects.equals(this.visited, other.visited)) {
            return false;
        }
        if (this.time != other.time) {
            return false;
        }
        if (this.nodeCount != other.nodeCount) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Configuration{" + "nbPoliceman=" + nbPoliceman + ", policePaths=" + policePaths + ", visited=" + visited + ", time=" + time + ", visitedCount=" + visitedCount + ", nodeCount=" + nodeCount + '}';
    }
}
