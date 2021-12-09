package Days;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DAY9 {

    Node[][] arra = new Node[100][100];
    int size = 1;
    ArrayList<Node> low = new ArrayList<>();
    ArrayList<Integer> caves = new ArrayList<>();

    public void solve(String input){
        makeArray(input);
        //System.out.println(getRisk());
        basin();
        Collections.sort(caves,Collections.reverseOrder());
        long sum = 1;
        for (int i = 0; i < 3; i++){
            sum *= caves.get(i);
        }
        System.out.println(sum);
    }
    private void makeArray(String input){
        input.length();
        for (int row = 0; row < 100; row++){
            for (int col = 0; col < 100; col++) {
                arra[row][col] = new Node(Integer.parseInt(input.charAt((row*100) + col) + ""),false,col,row);
            }
        }
    }

    private long getRisk(){
        long risk = 0;
        for (int y = 0; y < 100 ; y++){
            for (int x = 0; x < 100;x++){
                risk += levelNeumann(y,x);
            }
        }
        return risk;
    }

    private int levelNeumann(int y,int x){
        if (y - 1 >= 0)
            if (arra[y - 1][x].value <= arra[y][x].value) {// up neighbour
               return 0;}
        if (y + 1 < 100)
            if (arra[y + 1][x].value <= arra[y][x].value) // down neighbour
               return 0;
        if (x + 1 < 100)
            if (arra[y][x + 1].value <= arra[y][x].value) // right neighbour
                return 0;
        if (x - 1 >= 0)
            if (arra[y][x - 1].value <= arra[y][x].value) // right neighbour
                return 0;
        low.add(arra[y][x]);
        return arra[y][x].value + 1;
    }

    private void basin(){
        // fr each num in array if is not 9 resursive search for nums
        for (int y = 0; y < 100; y++){
            for (int x = 0; x < 100;x++) {
                levelNeumann(y,x);
            }
        }
        for(Node n : low ){
            size = 1;
            n.visited = true;
            search(n.y,n.x);
            restart();
            caves.add(size);
        }
    }
    private void restart(){
        for (int y = 0; y < 100; y++){
            for (int x = 0; x < 100 ;x++) {
                arra[y][x].visited = false;
            }
            }
    }

    private void search(int y , int x){
        if (y - 1 >= 0)
            if (arra[y - 1][x].value > arra[y][x].value && arra[y - 1][x].value != 9) {// up neighbou
                if (!arra[y - 1][x].visited){
                    arra[y - 1][x].visited = true;
                    size ++;
                    search(y - 1, x);
                }
            }
        if (y + 1 < 100)
            if (arra[y + 1][x].value > arra[y][x].value && arra[y + 1][x].value != 9) { // down neighbour
                if (!arra[y + 1][x].visited){
                    arra[y + 1][x].visited = true;
                    size ++;
                    search(y + 1, x);
                }
            }
        if (x + 1 < 100)
            if (arra[y][x + 1].value > arra[y][x].value && arra[y][x + 1].value != 9) { // right neighbour
                if (!arra[y][x + 1].visited){
                    arra[y][x + 1].visited = true;
                    size ++;
                    search(y, x + 1);
                }
            }
        if (x - 1 >= 0)
            if (arra[y][x - 1].value > arra[y][x].value && arra[y][x - 1].value != 9) { // left neighbour
                if (!arra[y][x - 1].visited){
                    arra[y][x - 1].visited = true;
                    size ++;
                    search(y, x - 1);
                }
            }
        return;
    }
}
