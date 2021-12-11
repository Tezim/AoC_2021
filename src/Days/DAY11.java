package Days;

public class DAY11 {
    int steps = 500;
    int [][] array = new int[10][10];
    long flashes = 0;
    long end = 0;

    public void solve(int[][] input){
        this.array = input;
        for (int i = 0; i < steps;i++){
            increase();
            System.out.println("\n ");
            if (print()){
                System.out.println("step : " + (i + 1) );
                break;
            }
            if (i == 99)
                end = flashes;
        }
        System.out.println(end);

    }

    private void increase(){
        for(int row = 0; row < 10 ;row++){
            for (int col = 0; col < 10;col++){
                array[row][col] = (array[row][col] + 1) % 10;
            }
        }
        boolean change = true;
        while(change){
           change = flash();
        }
        for(int row = 0; row < 10 ;row++){
            for (int col = 0; col < 10;col++){
               if(array[row][col] == -1)
                   array[row][col] = 0;
            }
        }
    }

    private boolean flash(){
        boolean change = false;
        for(int y = 0; y < 10 ;y++){
            for (int x = 0; x < 10;x++){
                if (array[y][x] == 0){
                    array[y][x] = -1; //deactivate
                    this.flashes++;
                    for (int row = -1 ; row < 2 ; row++) {
                        for (int column = -1; column < 2; column++) {
                            if (!(row == 0 && column == 0)) {
                                if (y + row >= 0 && y + row < 10 && x + column >= 0 && x + column < 10){  // ignore overlap
                                    if (array[y + row][x + column] != -1 && array[y + row ][x + column ] != 0){
                                        array[y + row ][x + column] += 1;
                                        array[y + row ][x + column] %= 10;
                                        if (array[y + row ][x + column ] == 0)
                                            change = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return change;
    }
    private boolean print(){
        boolean stop = true;
        for(int row = 0; row < 10 ;row++){
            for (int col = 0; col < 10;col++){
                if(array[row][col] != 0)
                    stop = false;
                System.out.print(array[row][col]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        return stop;
    }
}
