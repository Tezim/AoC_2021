package Days;

import java.util.*;

public class DAY14 {
    StringBuilder input;
    String f;
    String l;
    Map<String,String> rules = new HashMap<>();

    public void solve(String[] lines){
        input = new StringBuilder(lines[0]);
        f = String.valueOf(input.charAt(0));
        l = String.valueOf(input.charAt(input.length() - 1));

        for (int i = 2; i < 102;i++){
            String[] tmp = lines[i].split(" -> ");
            rules.put(tmp[0],tmp[1]);
        }
        //partOne();  // 40 memory error
        partTwo();
    }
    private void partTwo(){
        Map<String,Long> pairs = new HashMap<>();
        for (int i = 0; i < input.length() - 1;i++){
            StringBuilder p = new StringBuilder();
            p.append(input.charAt(i));
            p.append(input.charAt(i + 1));
            if (!pairs.containsKey(p.toString())){
                pairs.put(p.toString(), (long) 1);
            } else {
                Long value = pairs.get(p.toString());
                value+=1;
                pairs.put(p.toString(),value);
            }
        }
        for (int i = 0; i < 40 ;i++){
            pairs = step(pairs);
        }
        System.out.print(count(pairs));
    }
    private long count(Map<String, Long> pairs){

        // each appearance letter is doubled except first and last
        // first and last is saved so add + 1 appearance to these letters and divide all by 2
        Map<String,Long> count = new HashMap<>();
        for (Map.Entry<String, Long> entry : pairs.entrySet()) {
            // get key and update count
            String[] key = entry.getKey().split("");
            if (!count.containsKey(key[0])){
                count.put(key[0],entry.getValue());
            } else {
                Long value = count.get(key[0]);
                value+=entry.getValue();
                count.put(key[0],value);
            }
            if (!count.containsKey(key[1])){
                count.put(key[1], entry.getValue());
            } else {
                Long value =count.get(key[1]);
                value+=entry.getValue();
                count.put(key[1], value);
            }
        }
        // add first and last letter appearance
        Long value = count.get(this.f);
        value+=1;
        count.put(this.f, value);
        value = count.get(this.l);
        value+=1;
        count.put(this.l,value);

        ArrayList<Long> values = new ArrayList<>();
        for (Map.Entry<String, Long> entry : count.entrySet()) {
            values.add((entry.getValue()/2));
        }
        Collections.sort(values);
        return ((long)values.toArray()[values.size() - 1] - (long)values.toArray()[0]);
    }
    private Map<String, Long> step(Map<String, Long> pairs) {
        // now there is a map of pairs each pair creates same two new pairs
        // FS creates FH HS, FS is no longer present
        // for each pair create new insert in map
        Map<String,Long> tmp_pairs = new HashMap<>();
        for (Map.Entry<String, Long> entry : pairs.entrySet()) {
            String[] key = entry.getKey().split("");
            String value = rules.get(entry.getKey());
            StringBuilder key1 = new StringBuilder(key[0]);
            key1.append(value);
            StringBuilder key2 = new StringBuilder(value);
            key2.append(key[1]);
            // now we have new pairs . one pair creates one key 1 and oe key 2, 10 pairs create 10 key1....
            // insert new pairs in tmp pair map old pair is not present
            Long count = entry.getValue();
            if (!tmp_pairs.containsKey(key1.toString())){
                tmp_pairs.put(key1.toString(),count);
            } else {
                Long val = tmp_pairs.get(key1.toString());
                val += count;
                tmp_pairs.put(key1.toString(),val);
            }
            if (!tmp_pairs.containsKey(key2.toString())){
                tmp_pairs.put(key2.toString(),count);
            } else {
                Long val = tmp_pairs.get(key2.toString());
                val += count;
                tmp_pairs.put(key2.toString(),val);
            }
        }
        // now there are new pairs after step one so this should is iteratong
        return tmp_pairs;
    }
    private void partOne(){
        for (int i = 0; i < 1;i ++){
            StringBuilder result = new StringBuilder();
            result.append(f);
            step(result);
        }
        count();
    }
    private void count() {
        Map<Character,Integer> count = new HashMap<>();
       for (int i = 0; i < input.length();i++){
           if (!count.containsKey(input.toString().charAt(i))){
               count.put(input.toString().charAt(i),1);
           } else {
               int value = count.get(input.toString().charAt(i));
               value+=1;
               count.put(input.toString().charAt(i),value);
           }
       }
        ArrayList<Integer> values = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            values.add(entry.getValue());
        }
        Collections.sort(values);
        System.out.print((int)values.toArray()[values.size() - 1] - (int)values.toArray()[0]);
    }
    private void step(StringBuilder result){
        StringBuilder key = new StringBuilder();

        for (int idx = 0; idx < input.length() - 1; idx++){
            key.append(input.charAt(idx));
            key.append(input.charAt(idx + 1));
            if (rules.containsKey(key.toString())){
                String insert = rules.get(key.toString());
                result.append(insert);
                result.append(key.toString().toCharArray()[1]);
            }
            key.delete(0,2);
        }
        input = result;
    }
}
