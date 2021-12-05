import java.util.HashMap;

public class DAY4 {
private  int[] tables = new int[100];

    private  Integer[][][] tabs = new Integer[100][5][5];

    public  Integer first(String[] content){

        Integer[] nums;

        for (int a = 0; a < 100;a++)
            tables[a] = a;
        int id = 0;
        int col = 0;
        int row = 0;
        nums = parseNums(content[0]);
        for (int k = 1; k < content.length - 1;k++) {
            if (content[k] != "\n" && content[k] != " " && content[k] != null) {
                 if (col == 5){
                    col = 0;
                    row++;
                    }
                if (row == 5){
                    id++;
                    if (id == 100)
                        break;
                    col =0;
                    row = 0;
                }
                tabs[id][row][col] = Integer.parseInt(content[k]);
                col++;
            }
        }

        // separate tab in tabs and inputs
        //for each number in input cycle tabs and set + if its a match
        // check for bingo
       for (int l = 0; l < nums.length; l++) {
           mark(nums[l]); // mark found numbers with zero ... has no effect on sum
           int f = check();
           if (f > -1) {
               System.out.println(calc(f,nums[l]));
               tables[f] = -1;
           }
       }
        return 0;
        }

    public  Integer[] parseNums(String s){
        String[] tmp = s.split(",");
        Integer[] tnum = new Integer[200];
        int i = 0;
        for (String m : tmp){
            tnum[i] = Integer.parseInt(m) ;
            i++;
        }
        return tnum;
    }

    public  void mark(Integer s){
        for (int id = 0; id < 100; id++) {
            for (int row = 0; row < 5; row++) {
                for (int column = 0; column < 5; column++) {
                    if (tabs[id][row][column] != 0 ){
                    if (tabs[id][row][column].equals(s)) {
                        tabs[id][row][column] = 0;
                    }
                    }
                }
            }
        }
    }

    public  int check() {
        for (int id = 0; id < 100; id++) {
            if (tables[id] != -1){
            int sum ;

            for (int column = 0; column < 5; column++) {
                sum = 0;
                // sum row, stooopid
                sum += tabs[id][0][column];
                sum += tabs[id][1][column];
                sum += tabs[id][2][column];
                sum += tabs[id][3][column];
                sum += tabs[id][4][column];
                if (sum == 0)
                    return id;
            }
                for (int row = 0; row < 5; row++) {
                    sum = 0;
                    // sum row, stooopid
                    sum += tabs[id][row][0];
                    sum += tabs[id][row][1];
                    sum += tabs[id][row][2];
                    sum += tabs[id][row][3];
                    sum += tabs[id][row][4];
                    if (sum == 0)
                        return id;
                }
            }
        }
        return -1;
    }
    public  int calc(int id, int s){
        int sum = 0;
            for (int row = 0; row < 5;row++){
                for (int column = 0; column<5;column++){
                        sum += tabs[id][row][column];

                }
            }
        return sum * s;
    }

}
