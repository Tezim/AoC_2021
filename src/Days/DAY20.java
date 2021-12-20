package Days;

// 2D cellular automata with null boundary conditions... hehe :D
public class DAY20 {
    String rule;
    char[][] map = new char[200][200];  // map is 100x100 wil expand after each step by one
    private final int steps = 50;
    int height = 100;
    int width = 100;

    public void solve(String[] lines){
        rule = lines[0];
        this.init(lines);
        int starting_x = 49;
        int starting_y = 49;
        print();
        System.out.println(countLigth());
        for (int iter = 0; iter < steps; iter++){
            map = perform(0,0);
            // expansion
            starting_x--;
            starting_y--;
            height++;
            width++;
            print();
            System.out.println(countLigth());
        }
    }
    private long countLigth(){
        long alive = 0;
        for(int y = 0; y < 200;y++){
            for(int x = 0; x < 200;x++){
                if (map[y][x] == '#')
                    alive++;
            }
        }
        return alive;
    }
    private char[][] perform(int x_start, int y_start){
        char[][] map_new = new char[200][200];   // use new tmp map so new states do not affect computation
        for(int y = 0; y < 200;y++){
            for(int x = 0; x < 200;x++){
                map_new[y][x] = '.';
            }
        }

        for(int y = y_start; y <= 199; y++){         // cycle all cells at grid but just the actual map
            for (int x = x_start; x <= 199; x++){
                long index = countNeighboursMoore(x,y);       // evaluate neighborhood
                map_new[y][x] = rule.charAt((int)index);          // get new state
            }
        }
        return map_new;
    }

    // code form my bp 
    private int countNeighboursMoore(int x, int y ){
        StringBuilder number = new StringBuilder();
        for (int row = -1 ; row < 2 ; row++) {
            for (int column = -1; column < 2; column++) {
                if (map[(y + row + 200)%200][(x + column + 200) % 200] == '.') // dark pixel 0
                    number.append('0');
                else
                    number.append('1');
            }
        }
        return Integer.parseInt(number.toString(),2);
    }
    private void print(){
        for(int y = 0; y < 200;y++){
            for(int x = 0; x < 200;x++){
               System.out.print(map[y][x]);
            }
            System.out.println();
        }
        System.out.println("_________________________________________________________________________________________________________________________");
    }
    private void init(String[] lines){
        for(int y = 0; y < 200;y++){
            for(int x = 0; x < 200;x++){
                map[y][x] = '.';
            }
        }
        for(int y = 0; y < 200;y++){
            for(int x = 0; x < 200;x++){
                if (y >= 50 && y < 150){ // 150
                    if (x >= 50 && x < 150){ // 150
                        map[y][x] = lines[y - 48].charAt(x - 50); // + 2 is offset for rule and newline in input
                    }
                }
            }
        }

    }
}
