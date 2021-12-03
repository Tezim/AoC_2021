import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] content = new String[2000];    // string / integer value depends on input file
        StringBuilder path = new StringBuilder(System.getProperty("user.dir"));
        path.append('\\');
        path.append("input2.txt");   // open file
        File f = new File(path.toString());
        Scanner sc = new Scanner(f);
        int i = 0;
        while(sc.hasNext()){
            String data  = sc.next();
            content[i] = data;
            i++;
        }
        System.out.println(DAY2.first(content));
        System.out.println(DAY2.seond(content));

    }
}
