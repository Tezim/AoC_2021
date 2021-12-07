
import Days.DAY7;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] content = new String[3000];    // string / integer value depends on input file
        StringBuilder path = new StringBuilder(System.getProperty("user.dir"));
        path.append('\\');
        path.append("files\\input7.txt");   // open file
        File f = new File(path.toString());
        Scanner sc = new Scanner(f);
        int i = 0;
        String input = sc.next();
        DAY7 d = new DAY7();
        d.first(input);


    }
}
