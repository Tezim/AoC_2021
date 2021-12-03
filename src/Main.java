import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Integer[] content = new Integer[2000];    // string / integer value depends on input file
        StringBuilder path = new StringBuilder(System.getProperty("user.dir"));
        path.append('\\');
        path.append("input.txt");   // open file
        File f = new File(path.toString());
        Scanner sc = new Scanner(f);
        int i = 0;
        while(sc.hasNext()){
            Integer data  = sc.nextInt();
            content[i] = data;
            i++;
        }
        System.out.println(DAY1.first(content));
        System.out.println(DAY1.second(content));

    }
}
