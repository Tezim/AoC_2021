package helpers;

import Days.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

    public static Node[][] integerContent = new Node[100][100];
    public static String[] stringContent = new String[102];
   // public static String[] stringContent = new String[24];

    public static File openFile(String path){
        return new File(path);
    }
    public static void readInt(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        String input  = "";
        int j = 0;
        while(j < 100) {
            input = sc.next();
            for (int i = 0; i < 100; i++) {
                integerContent[j][i] = new Node(Integer.parseInt(input.charAt(i) + ""),false,i,j);
            }
            j++;
        }
    }
    public static void readStr(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        int i = 0;
        while (sc.hasNext()){
            stringContent[i++] = sc.nextLine();
        }

    }

}
