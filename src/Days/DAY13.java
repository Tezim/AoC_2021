package Days;

import java.util.*;

public class DAY13 {
    Map<Integer, List<Integer>> ones = new HashMap<>();

    public void solve(String[] lines){
        for (int i = 0; i < 835; i++){  // 835
           String[] tmp = lines[i].split(",");
           ArrayList<Integer> value = new ArrayList<>();
           value.add(Integer.parseInt(tmp[0]));
           // y is key so each row has list of x where is #
           if ( !ones.containsKey(Integer.parseInt(tmp[1])) ){
               ones.put(Integer.parseInt(tmp[1]),value);
           } else {
               ones.get(Integer.parseInt(tmp[1])).add(Integer.parseInt(tmp[0]));
           }
        }
        // now we have list of x for every row, hopefully
        // figure out folds
        for (int j = 837; j < 871;j += 3){   // 837-871
            String[] tmp = lines[j].split("=");
            if (tmp[0].equals("x")){
                foldByX(Integer.parseInt(tmp[1]));
                System.out.println("Sum : "+count());
            } else {
                foldByY(Integer.parseInt(tmp[1]));
                System.out.println("Sum : "+count());
            }
        }
        print();
    }

    private void print(){
        for (int i = 0; i < 6;i++){
            ArrayList<Integer> values = (ArrayList<Integer>) ones.get(i);
            for (int c = 0; c < 40; c++){
                if (values.contains(c))
                    System.out.print("#");
                else
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    private long count(){
        long count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : ones.entrySet()) {
           count += entry.getValue().size();
        }
        return count;
    }

    private void foldByY(int row){
        System.out.print("Folding on row " + row + "\n ");
        // x stays, figure out just y
        // put content of y row to new row, if number is present ignore since its overlaping
        // twice the row is  size of whole paper
        int size = 2 * row;
        for (int i = row+1 ; i < size+1 ;i++){
            // for every row below folding line count new row
            if (ones.containsKey(i)) {
                int nRow = size - i;     // size - current y
                if ( !ones.containsKey(nRow)) { // if new row has no ones until now
                    if (ones.containsKey(i)) {
                        ones.put(nRow, ones.get(i));   // put whole value list in row
                        ones.remove(i);
                    }
                } else {    // row has zeros check for overlap
                    for(Integer num : ones.get(i)){   // take int form old row and look in new
                        if (!ones.get(nRow).contains(num)){   // if its here skip else add
                            ones.get(nRow).add(num);
                        }
                    }
                    // row is moved in new row we can delete old row
                    ones.remove(i);
                }
        }
        }

    }

    private void foldByX(int column){
        System.out.print("Folding on column " + column + "\n ");
        // y stays, figure out just x
        // y is key in map it stays the same, work just with value arraylist
        // look on each row and fold arraylist inside
        for (int i = 0; i < +1310; i++){ // for each row, figure out the height of map !
            if (ones.containsKey(i)){   // row is presents so it has ones, fold arraylist
                ArrayList<Integer> fold = new ArrayList<>();
                for (Integer value : ones.get(i)){
                    if(value > column){  // calc the new col same as in rows
                       int x = ( (column*2) - value);
                        if(!fold.contains(x)){
                            fold.add(x);
                        }
                    }else {
                        if(!fold.contains(value)){
                            fold.add(value);
                        }
                    }
                }
                // rewrite the onld entry with new
                ones.put(i,fold);
            }
        }

    }
}
