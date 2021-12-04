import sk.stuba.DAY4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] content = new String[3000];    // string / integer value depends on input file
        StringBuilder path = new StringBuilder(System.getProperty("user.dir"));
        path.append('\\');
        path.append("input4.txt");   // open file
        File f = new File(path.toString());
        Scanner sc = new Scanner(f);
        int i = 0;
        while(sc.hasNext()){
            String data  = sc.next();
            if (data != null){
              content[i] = data;
            i++;}
        }
        DAY4 d = new DAY4();
        d.first(content);


    }
}
