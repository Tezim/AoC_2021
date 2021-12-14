import Days.DAY14;
import helpers.Reader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder path = new StringBuilder(System.getProperty("user.dir"));
        path.append('\\');
        path.append("files\\input14.txt");   // open file

        //Reader.readInt(Reader.openFile(path.toString()));
        Reader.readStr(Reader.openFile(path.toString()));

        DAY14 d = new DAY14();
        d.solve(Reader.stringContent);
    }
}
