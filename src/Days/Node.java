package Days;

public class Node {
    int x;
    int y;
    int value;

    boolean visited;
    Node previous;
    long distance;

    public Node(int val, boolean visited,int x, int y) {
        this.value = val;
        this.visited = visited;
        this.x = x;
        this.y = y;
        this.previous = null;
        this.distance = Integer.MAX_VALUE;
    }
}
