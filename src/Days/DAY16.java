package Days;

import java.util.ArrayList;

public class DAY16 {

    String[] packetsVersion = new String[1000];
    ArrayList<String> content = new ArrayList<>();
    int counter = 0;

    public void solve(String input){
        String binary = parseInput(input);
        dividePackets(binary);
        System.out.println(countVersions());
    }

    private long countVersions(){
        long sum = 0;
        for (int i = 0; i < counter;i++){
            sum += decimal(packetsVersion[i]);
        }
        return sum;
    }

    private ArrayList<Long> dividePackets(String binary){
        StringBuilder V = new StringBuilder();
        StringBuilder T = new StringBuilder();
        ArrayList<Long> numbers = new ArrayList<>();
        for (int i = 0; i < binary.length();i++){
            if(binary.substring(i).chars().allMatch(e -> e == '0')) break;
            V.append(binary.charAt(i)); V.append(binary.charAt(i + 1)); V.append(binary.charAt(i + 2));      // version bits
            packetsVersion[counter] = V.toString();
            counter++;
            T.append(binary.charAt(i + 3)); T.append(binary.charAt(i + 4)); T.append(binary.charAt(i + 5));  // type bits
            V.delete(0,V.length());
            if (decimal(T.toString()) == 4){ // literal
                StringBuilder number = new StringBuilder();
                i += 6;
                for (;;i+=5){
                    number.append(binary.substring(i, i + 5));
                    if (binary.charAt(i) == '0'){ // last part is padded with 0
                        i+=4;
                        break;
                    }
                }
                content.add(number.toString());
                content.add("EOP");
                numbers.add(decimal(number.toString()));
            } else {  // operator
                int L_part = 15;
                i += 6;
                boolean dive = binary.charAt(i) == '0';   // dive into subpackets
                if (!dive)
                    L_part = 11;
                i++;
                int sub = (int) (decimal(binary.substring(i, i + L_part)));
                i+=L_part;
                i--;
                if(dive){
                    i++;
                    content.add(T.toString() + "xL" + sub);
                    dividePackets(binary.substring(i ,i + sub));
                    i += sub;
                    i--;
                } else {
                    content.add(T.toString() + "x" + sub);
                }
            }
            T.delete(0,T.length());
        }
        return numbers;
    }
    private long decimal(String input){
        return Long.parseLong(input,2);
    }

    private String parseInput(String input){
        String[] single = input.split("");
        StringBuilder bin = new StringBuilder();
        for (String s : single){
            switch (s){
                case "0" : bin.append("0000"); break;// = 0000
                case "1" : bin.append("0001"); break;// = 0001
                case "2" : bin.append("0010"); break;// = 0010
                case "3" : bin.append("0011"); break;// = 0011
                case "4" : bin.append("0100"); break;// = 0100
                case "5" : bin.append("0101"); break;// = 0101
                case "6" : bin.append("0110"); break;// = 0110
                case "7" : bin.append("0111"); break;// = 0111
                case "8" : bin.append("1000"); break;// = 1000
                case "9" : bin.append("1001"); break;// = 1001
                case "A" : bin.append("1010"); break;// = 1010
                case "B" : bin.append("1011"); break;// = 1011
                case "C" : bin.append("1100"); break;// = 1100
                case "D" : bin.append("1101"); break;// = 1101
                case "E" : bin.append("1110"); break;// = 1110
                case "F" : bin.append("1111"); break;// = 1111
                default: break;
            }
        }
        return bin.toString();
    }

    private long operation(int id,ArrayList num) {
        return switch (id) {
            case 0 -> num.stream().mapToLong(e -> (long) e).sum();
            case 1 -> num.stream().mapToLong(e -> (long) e).reduce((a, b) -> a*b).getAsLong();
            case 2 -> num.stream().mapToLong(e -> (long) e).min().getAsLong();
            case 3 -> num.stream().mapToLong(e -> (long) e).max().getAsLong();
            case 5 -> (long)num.get(0) > (long)num.get(1) ? 1L : 0L;
            case 6 -> (long)num.get(0) < (long)num.get(1) ? 1L : 0L;
            case 7 -> num.get(0).equals(num.get(1)) ? 1L : 0L;
            default -> 0;
        };
    }


}
