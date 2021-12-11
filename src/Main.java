import Days.DAY11;
import helpers.Reader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder path = new StringBuilder(System.getProperty("user.dir"));
        path.append('\\');
        path.append("files\\input11.txt");   // open file

        Reader.readInt(Reader.openFile(path.toString()));
        //Reader.readStr(Reader.openFile(path.toString()));

        DAY11 d = new DAY11();
        d.solve(Reader.integerContent);
    }
}
