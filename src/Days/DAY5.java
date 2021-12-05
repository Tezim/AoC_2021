public class DAY5 {

    private int[][] grid = new int[1000][1000];


    public DAY5(){
        for (int i = 0; i < 1000 ; i++){
            for (int j= 0; j < 1000 ; j++){
                grid[i][j] = 0;
            }
        }
    }

    public void first(String[] content){
        for(int i = 0; i < content.length; i+= 3){
            if (content[i] != null)
                parseLine(content[i],content[i + 2]);
        }
        count();
    }

    private void parseLine(String x, String y){
        String[] X = x.split(",");
        String[] Y = y.split(",");
        //ortogonal(Integer.parseInt(X[0]),Integer.parseInt(X[1]),Integer.parseInt(Y[0]),Integer.parseInt(Y[1]));
        all(Integer.parseInt(X[0]),Integer.parseInt(X[1]),Integer.parseInt(Y[0]),Integer.parseInt(Y[1]));;
    }

    private void ortogonal(int x1, int y1, int x2, int y2){
        //System.out.println(x1 + " " + x2 + " " + y1 + " " + y2 + "\n");
        if (x1 == x2) { // same column
            if (y1 > y2){
                int tmp = y1;
                y1 = y2;
                y2  = tmp;
            }
            // mark in grid
            for (int row = y1; row <= y2;row++){
                grid[row][x2] += 1;
            }

        } else if (y1 == y2) { //same row
            if (x1 > x2){
                int tmp = x1;
                x1 = x2;
                x2  = tmp;
            }
            for (int column = x1; column <= x2 ;column++){
                grid[y2][column] += 1;
            }

        }
    }
    private void all(int x1, int y1, int x2, int y2) {
        int start_x, start_y;
        int end_x, end_y;

        if (x1 == x2 || y1 == y2)
            ortogonal(x1, y1, x2, y2);
        else {
            // from top to bottom
        if (y1 < y2){
            start_y = y1;
            end_y = y2;
            if (x1 < x2){ // left -> right
                int x_next = x1;
                int column;
                for (int row = start_y; row<= end_y;row++){
                    for (column = x1; column <= x2; column++){
                        if (column == x_next){
                            grid[row][column] += 1;
                        }
                    }
                    x_next += 1;
                }

            }else if (x1 > x2){ // right -> left
                int x_next = x1;
                int column;
                for (int row = start_y; row <= end_y;row++){
                    for (column = x1; column >= x2; column--){
                        if (column == x_next){
                            grid[row][column] += 1;
                        }
                    }
                    x_next  -= 1;
                }
            }
        }else if (y1 > y2) { // bottom -> top
                start_y = y1;
                end_y = y2;
                if (x1 < x2) {  // left - > right
                    int x_next = x1;
                    int column;
                    for (int row = start_y; row >= end_y; row--) {
                        for (column = x1; column <= x2; column++) {
                            if (column == x_next) {
                                grid[row][column] += 1;
                            }
                        }
                        x_next += 1;
                    }
                } else if (x1 > x2) {
                    int x_next = x1;
                    int column;
                    for (int row = start_y; row >= end_y; row--) {
                        for (column = x1; column >= x2; column--) {
                            if (column == x_next) {
                                grid[row][column] += 1;
                            }
                        }
                        x_next -= 1;
                    }
                }

            }

        }
    }
    private void count(){
        int counter = 0;
        for (int y = 0; y < 1000 ; y++){
            for (int x= 0; x < 1000 ; x++){
                if (grid[x][y] > 1)
                    counter++;
            }
            System.out.println();
        }
        System.out.println(counter);
    }
    private void print(){
        for (int y = 0; y < 10; y++){
            for (int x= 0; x < 10; x++){
                System.out.print(grid[y][x]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
