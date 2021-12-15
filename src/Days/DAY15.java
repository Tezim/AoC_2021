package Days;



import java.util.LinkedList;
import java.util.Queue;

public class DAY15 {


    void dijkstra(Node start, Node end,Node[][] map, int size) {
        Queue<Node> to_visit = new LinkedList<>();
        // node value counts as distance
        start.value = 0;               // first node is not counted
        start.distance = start.value;
        to_visit.add(start);
        while(!to_visit.isEmpty()){
            // visit all adjacent nodes that are not visited
            // set distance and previous node
            // add to visit queue
            Node current = to_visit.peek();
            current.visited = true;
            // all adjacent neighbours except node itself only orthogonal
            for (int y = -1; y < 2 ;y++){
                if (current.y + y >= 0 && current.y + y < size && y != 0) {     // left right neighbor
                       if (current.distance + map[current.y + y][current.x].value < map[current.y + y][current.x].distance ){  // path is shorter
                           map[current.y + y][current.x].distance = current.distance + map[current.y + y][current.x].value;
                           map[current.y + y][current.x].previous = current;
                           // if is visited but path is shorter, activate the node and add it to queue
                           map[current.y + y][current.x].visited = false;
                           if (!to_visit.contains(map[current.y + y][current.x]))  // duplicate nodes
                               to_visit.add(map[current.y + y][current.x]);
                       } else {
                           if(!map[current.y + y][current.x].visited){
                               if (!to_visit.contains(map[current.y + y][current.x]))  // duplicate nodes
                                   to_visit.add(map[current.y + y][current.x]);
                           }
                       }
                }
                if (current.x + y >= 0 && current.x + y < size && y != 0) {     // up down neighbor
                        if (current.distance + map[current.y][current.x + y].value < map[current.y][current.x + y].distance ){   // path is shorter
                            map[current.y][current.x + y].distance = current.distance + map[current.y][current.x + y].value;
                            map[current.y][current.x + y].previous = current;
                            // if is visited but path is shorter, activate the node and add it to queue
                            map[current.y][current.x + y].visited = false;
                            if (!to_visit.contains(map[current.y][current.x + y]))  // duplicate nodes
                                to_visit.add(map[current.y][current.x + y]);
                        } else {
                            if(!map[current.y][current.x + y].visited){
                                if (!to_visit.contains(map[current.y][current.x + y]))  // duplicate nodes
                                    to_visit.add(map[current.y][current.x + y]);
                            }
                        }
                }
            }
            to_visit.remove(current);  // remove visited node
        }

        // follow the path
        System.out.println("Path: " + end.distance);
    }
    private Node[][] expand(Node[][] input){
        Node[][] expanded = new Node[500][500];
        int c = 0;
        int k = 0;
        for (int j = 0; j < 500; j++){
            if (j % 100 == 0 && j != 0)
                k++;
            c = 0;
            for (int i = 0; i < 500; i++) {
                if (i % 100 == 0 && i != 0)
                    c++;
                int value = input[j%100][i%100].value;
                value += c;
                value += k;
                if (value > 9)
                    value %= 9;
                expanded[j][i] =new Node(value, false,i, j);

            }
        }
        return expanded;
    }

    public void solve(Node[][] input){
        partOne(input);
        partTwo(input);
    }
    private void partTwo(Node[][] input){
        input[0][0].value = 9; // repair damage after part one
        Node[][] expanded = expand(input);
        this.dijkstra(expanded[0][0],expanded[499][499],expanded,500);
    }
    private void partOne(Node[][] input){
        this.dijkstra(input[0][0],input[99][99],input,100);
    }
}
