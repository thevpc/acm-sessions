/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vpc
 */
public class PoliceFinder {

    public static void main(String[] args) {
        PoliceFinder p = new PoliceFinder();
        p.readGraph();
        final Configuration c = p.find();
        System.out.println("-----------------------------");
        System.out.println(c);
        p.writeResult(c);
    }
    public Graph4 graph = new Graph4();
    int nbPoliceman;

    public void readGraph() {
        BufferedReader r = null;
        try {
            r = new BufferedReader(new FileReader("policefinder-input.txt"));
            nbPoliceman = Integer.parseInt(r.readLine());
            String line = null;
            while ((line = r.readLine()) != null) {
                if (line.trim().length() != 0) {
                    final String[] fromTo = line.split(" ");
                    graph.addLink(fromTo[0], fromTo[1]);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PoliceFinder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                r.close();
            } catch (IOException ex) {
                Logger.getLogger(PoliceFinder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void writeResult(Configuration configuration) {
        PrintStream out = null;
        try {
            out = new PrintStream("policefinder-output.txt");
            if (configuration == null) {
                out.println("aucun resultat");
            } else {
                out.println(configuration.time);
                for (String path : configuration.policePaths) {
                    out.println(path);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PoliceFinder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    public Configuration createC0(int nbPoliceman, List<String> nodes) {
        ArrayList<String> paths = new ArrayList<>();
        for (int i = 0; i < nbPoliceman; i++) {
            paths.add(String.valueOf(nodes.get(0)));
        }
        Configuration c0 = new Configuration(paths, nodes.size());
        return c0;
    }

    public Configuration find() {
        Configuration c0 = createC0(nbPoliceman, new ArrayList<>(graph.nodes));
        List<Configuration> toProcess = new ArrayList<>();
        Set<Configuration> visited = new HashSet<>();
        toProcess.add(c0);
        Configuration bestConfig = null;
        while (!toProcess.isEmpty()) {
            int nextConfigIndex = findBestConfigIndex(toProcess);
            Configuration c = toProcess.remove(nextConfigIndex);
            visited.add(c);
            System.out.println("Processing " + c);
            if (c.finalConfig) {
                if (bestConfig == null || bestConfig.time > c.time) {
                    bestConfig = c;
                }
            } else {
                boolean processNext = true;
                if (bestConfig != null) {
                    if (c.time >= bestConfig.time) {
                        processNext = false;
                    }
                }
                if (processNext) {
                    for (Configuration next : nextConfigurations(c)) {
                        if (true) {
                            if (!visited.contains(next)) {
                                toProcess.add(next);
                            }
                        }
                    }
                }
            }
        }
        return bestConfig;
    }

    public int findBestConfigIndex(List<Configuration> toProcess) {
        int index = 0;
        int goodIndex = 0;
        Configuration c = toProcess.get(0);
        for (Configuration configuration : toProcess) {
            boolean better = false;
            if (configuration.visitedCount > c.visitedCount) {
                better = true;
            } else if (configuration.visitedCount == c.visitedCount) {
                if (configuration.time < c.time) {
                    better = true;
                } else if (configuration.time == c.time) {
                    int r = 0;
                    for (String s : configuration.policePaths) {
                        r += s.length();
                    }
                    int r2 = 0;
                    for (String s : c.policePaths) {
                        r2 += s.length();
                    }
                    if (r > r2) {
                        better = true;
                    }
                }
            }
            if (better) {
                c = configuration;
                goodIndex = index;
            }
            index++;
        }
        return goodIndex;
    }

    public List<Configuration> nextConfigurations(Configuration c) {
        List<Configuration> retour = new ArrayList<>();
        List<List<String>> allSuccessors = new ArrayList<>();
        for (int i = 0; i < c.policePaths.size(); i++) {
            String pathi = c.policePaths.get(i);
            String lastNode = String.valueOf(pathi.charAt(pathi.length() - 1));
            final Set<String> successors = graph.getSuccessors(lastNode);
            successors.add("");
            allSuccessors.add(new ArrayList<String>(successors));
        }
        final List<List<String>> prodCart = prodCart(allSuccessors);
        System.out.println("prodCart : " + prodCart);
        for (List<String> list : prodCart) {
            List<String> nextPolicePaths = new ArrayList<>();
            for (int j = 0; j < c.nbPoliceman; j++) {
                nextPolicePaths.add(c.policePaths.get(j) + list.get(j));
            }
            Configuration c2 = new Configuration(nextPolicePaths, graph.nodes.size());
            retour.add(c2);
        }
        return retour;
    }

    public static List<List<String>> prodCart(List<List<String>> allSuccessors) {
        List<Integer> indexes = new ArrayList<>();
        List<Integer> maxIndexes = new ArrayList<>();

        for (int i = 0; i < allSuccessors.size(); i++) {
            List<String> set = allSuccessors.get(i);
            indexes.add(i, 0);
            maxIndexes.add(i, set.size());
        }
        List<List<String>> retour = new ArrayList<>();
        boolean end = false;
        while (!end) {
            //process
            List<String> combin = new ArrayList<>();
            for (int j = 0; j < indexes.size(); j++) {
                List<String> set = allSuccessors.get(j);
                combin.add(set.get(indexes.get(j)));
            }
            retour.add(combin);

            //incrementation des indexes
            int i = indexes.size() - 1;
            while (i >= 0) {
                int v = indexes.get(i);
                v++;
                if (v >= maxIndexes.get(i)) {
                    indexes.set(i, 0);
                    i--;
                } else {
                    indexes.set(i, v);
                    break;
                }
            }
            if (i < 0) {
                end = true;
            }
        }
        return retour;
    }
}
