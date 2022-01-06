package Days;

public class DAY25 {

    String[][] init_arr;
    boolean change = true;
    long counter = 0;

    public void solve(String[][] input){
        init_arr = input;
       while(change){
            print(init_arr);
            step();
        }
    }

    private void step(){
        counter++;
        change = false;
        String[][] new_arr = new String[137][139];
        exchange(init_arr, new_arr);

        // move east facing first >
        for (int y = 0; y < 137; y++){ // 137
            for (int x = 0; x < 139; x++){ // 139
                if (init_arr[y][x].equals(">")){  // try to move to right
                    // overlap sides
                    if (x + 1 == 139){  // 139
                        // look at zero x
                        if (init_arr[y][0].equals(".")){  // empty field -> can move there
                            new_arr[y][0] = ">";
                            new_arr[y][x] = ".";
                            change = true;
                        }
                    } else { // not an edge
                        if (init_arr[y][x + 1].equals(".")){  // empty field -> can move there
                            new_arr[y][x + 1] = ">";
                            new_arr[y][x] = ".";
                            change = true;
                        }
                    }
                }
            }
        }

        exchange(new_arr, init_arr);   // from , to

        // move south facing v
        for (int y = 0; y < 137; y++){  // 137
            for (int x = 0; x < 139; x++){ // 139
                if (init_arr[y][x].equals("v")){  // try to move to right
                    // overlap sides
                    if (y + 1 == 137){ // 137
                        // look at zero x
                        if (init_arr[0][x].equals(".")){  // empty field -> can move there
                            new_arr[0][x] = "v";
                            new_arr[y][x] = ".";
                            change = true;
                        }
                    } else { // not an edge
                        if (init_arr[y + 1][x].equals(".")){  // empty field -> can move there
                            new_arr[y + 1][x] = "v";
                            new_arr[y][x] = ".";
                            change = true;
                        }
                    }
                }
            }
        }

        // exchange arrays
        exchange(new_arr, init_arr);   // from , to

        System.out.print(change);
        System.out.print(" " + counter);
        System.out.println();
    }

    private void exchange(String[][] new_arr, String[][] init_arr) {
        for (int i = 0; i < 137; i++){  // 137
            for (int j = 0; j < 139; j++){ // 139
                if (new_arr[i][j].equals(">"))
                    init_arr[i][j] = ">";
                else if (new_arr[i][j].equals("v"))
                    init_arr[i][j] = "v";
                else
                    init_arr[i][j] = ".";
            }
        }
    }

    private void print(String[][] arr){
        for (int i = 0; i < 137; i++){  // 137
            for (int j = 0; j < 139; j++){ // 139
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
