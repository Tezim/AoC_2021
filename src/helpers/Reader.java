package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

    public static int[] integerContent = new int[1000];
    public static String stringContent = "";

    public static File openFile(String path){
        return new File(path);
    }
    public static void readInt(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        String[] input = sc.next().split(",");
        int i = 0;
        for (String s : input)
           integerContent[i++] = Integer.parseInt(s);
    }
    public static void readStr(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        while (sc.hasNext()){
            stringContent += sc.next();
        }
    }

}
