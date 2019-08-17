/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author vpc
 */
public class Graph4 {
  public Map<String,List<Link>> fromTo=new HashMap<>();
  public Set<String> nodes=new LinkedHashSet<>();
  
  public void addLink(String from,String to){
      nodes.add(from);
      nodes.add(to);
      List<Link> list = fromTo.get(from);
      if(list==null){
          list=new ArrayList<>();
          fromTo.put(from, list);
      }
      list.add(new Link(from, to));
  }
  
  public Set<String> getSuccessors(String from){
      Set<String> s=new HashSet<>();
      List<Link> list = fromTo.get(from);
      if(list!=null){
          for (Link link : list) {
              s.add(link.to);
          }
      }
      return s;
  }
  
  public class Link{
      public String from;
      public String to;

        public Link(String from, String to) {
            this.from = from;
            this.to = to;
        }
  }
}
