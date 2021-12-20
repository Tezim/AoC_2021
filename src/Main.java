import Days.DAY20;
import helpers.Reader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder path = new StringBuilder(System.getProperty("user.dir"));
        path.append('\\');
        path.append("files\\input20.txt");   // open file

        //Reader.readInt(Reader.openFile(path.toString()));
        Reader.readStr(Reader.openFile(path.toString()));

        DAY20 d = new DAY20();
        d.solve(Reader.stringContent);
    }
}
