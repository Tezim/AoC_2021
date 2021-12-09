package Days;

public class Node {
    int x;
    int y;
    int value;
    boolean visited;

    public Node(int value, boolean visited,int x, int y) {
        this.value = value;
        this.visited = visited;
        this.x = x;
        this.y = y;
    }
}
