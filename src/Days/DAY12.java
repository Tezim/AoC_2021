package Days;

import javax.print.DocFlavor;
import java.util.*;

public class DAY12 {
    private long count = 0;
   // boolean twice = true;  // stackoverflow
    Map<String , List<String>> ends = new HashMap<>();

    public void solve(String[] input){
          for (String s : input){
             if (s != null) {
                 String[] tmp = s.split("-");
                 ArrayList<String> value = new ArrayList<>();
                 ArrayList<String> value2 = new ArrayList<>();
                 // maybe use guava MultiMap
                 value.add(tmp[1]);
                 if(!ends.containsKey(tmp[0]))
                    this.ends.put(tmp[0],value);
                 else
                     this.ends.get(tmp[0]).add(tmp[1]);
                 // add the other way :( too long
                 value2.add(tmp[0]);
                 if(!ends.containsKey(tmp[1]))
                     this.ends.put(tmp[1],value2);
                 else
                     this.ends.get(tmp[1]).add(tmp[0]);
             }
          }
          // in map start of path is key, end is value
        Stack<String> path = new Stack<>();
        path.add("start");
        countPaths(path,true);
        System.out.print(count);
    }
    // visit all connected points
    private void countPaths(Stack<String> last,boolean twice){
        // base case
        if (last.peek().equals("end")){
            System.out.print(last + "\n");
            count++;
            return;
        }
       // find node in map and save its list
        List<String> connected = ends.get(last.peek());
        for (String node : connected){
            if (!last.contains(node) || node.equals(node.toUpperCase())){  // if its uppercase safe to visit twice , lowercase only once
                last.add(node);
                countPaths(last,twice);  // recursive search
                last.pop();        // remove last node and go for another from list
            } else if (!node.contains("start") && !node.contains("end") && twice) { // connot visit start end twice
                last.add(node);
                // twice is false already used small cave two times
                countPaths(last,false);   // recursive search
                last.pop();        // remove last node and go for another from list
            }
        }
    }
}
