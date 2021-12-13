package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

    public static int[][] integerContent = new int[10][10];
    public static String[] stringContent = new String[871];
   // public static String[] stringContent = new String[24];

    public static File openFile(String path){
        return new File(path);
    }
    public static void readInt(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        String input  = "";
        int j = 0;
        while(j < 10) {
            input = sc.next();
            for (int i = 0; i < 10; i++) {
                integerContent[j][i] = Integer.parseInt(input.charAt(i) + "");
            }
            j++;
        }
    }
    public static void readStr(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        int i = 0;
       for(;i<871;i++){
           stringContent[i] = sc.next();
        }

    }

}
