import javax.print.DocFlavor;
import java.util.Arrays;

public class DAY3 {
    static char[] gamma = new char[12];
    static char[] epsilon = new char[12];

    public static void count(String [] content){
        int[] ones = new int[12];
        int[] zero = new int[12];
        for (String c : content){
            if (c != null){
                for (int i = 0; i < 12;i++){
                    if (c.charAt(i) == 48){
                        zero[i] += 1;
                    } else {
                        ones[i] += 1;
                    }
                }
            }
        }
        for (int i = 0; i < ones.length; i++){
            if (ones[i] > zero[i]){
                gamma[i] = '1';
                epsilon[i] = '0';
            } else if (ones[i] < zero[i]){
                gamma[i] = '0';
                epsilon[i] = '1';
            } else {
                gamma[i] = '1';
                epsilon[i] = '0';
            }
        }

    }
    public static Integer first(String[] content){
        count(content);

        int g = Integer.parseInt(convert(gamma),2);
        int e = Integer.parseInt(convert(epsilon),2);
        return e*g;
    }
    public static Integer second(String[] content){
        count(content);    // init count
        String[] CO2 = content.clone();
        int i = 0;
        while (i < 12 ){                // oxygen
            if (content[1] == null)
                break;
            count(content);
            content = eliminate(content,i,gamma);
            i++;
        }
        i = 0;
        while (i < 12 ){                // oxygen
            if (CO2[1] == null)
                break;
            count(CO2);
            CO2 = eliminate(CO2,i,epsilon);
            i++;
        }
        int ox = Integer.parseInt(content[0],2);
        int co = Integer.parseInt(CO2[0],2);
        return ox * co;
    }
    public static String convert(char[] input){
        StringBuilder g = new StringBuilder();
        for (char c : input) {
            g.append(c);
        }
        return g.toString().trim();
    }
    public static String[] eliminate(String[] content, int i,char[] which){
        String[] tmp = new String[2000];
        int j  = 0;
        for (String s : content){
            if (s != null){
                if (s.charAt(i) ==  which[i]){
                    tmp[j] = s;
                    j++;
                }
            }

        }
        return tmp;
    }

}
