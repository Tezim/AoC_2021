package Days;

import java.util.Arrays;

public class DAY8 {
    String pattern0;
    String pattern1;
    String pattern2;
    String pattern3;
    String pattern4;
    String pattern5;
    String pattern6;
    String pattern7;
    String pattern8;
    String pattern9;

    public void solve(String[] input){
        long nums = 0;
        for (int i = 0; i< 200;i++)
            nums += parseRow(input[i]);
        System.out.println(nums);
    }
    private long parseRow(String row){
        String[] tmp = row.split("\\|");
        long number = 0;
        String[] paterns = tmp[0].split(" ");
        String [] n = tmp[1].split(" ");
        int[] arr = new int[4];
        int k = 0;
        Arrays.sort(paterns);
        getpatterns(paterns);
        for (int i = 0; i < n.length;i++){
            if (i != 0){
                arr[k-1] = decode(n[i]);
            }
            k++;
        }

        int idx = 1000;
        for ( k = 0; k < 4; k++){
            number += arr[k] * idx;
            idx /= 10;
        }
      return number;
    }
    private void getpatterns(String[] input){
        for (int i = 0; i<input.length;i++){
            if (input[i].length() == 2)
                pattern1 = input[i];
            if (input[i].length() == 3)
                pattern7 = input[i];
            if (input[i].length() == 4)
                pattern4 = input[i];
            if (input[i].length() == 7)
                pattern8 = input[i];
        }
        for (String s : input) {
            if (s.length() == 6)
                if (Contains(s,pattern1) && Contains(s,pattern7) && Contains(s,pattern4))
                    pattern9 = s;
                else if (Contains(s,pattern1) && Contains(s,pattern7))
                    pattern0 = s;
                else
                    pattern6 = s;
        }
        for (String s : input) {
            if (s.length() == 5)
                if (Contains(s,pattern1) && Contains(s,pattern7))
                    pattern3 = s;
                else if (Contains(pattern6,s))
                    pattern5 = s;
                else
                    pattern2 = s;
        }
    }
    private int decode(String input){
        switch (input.length()){
            case 2:{
                return 1;
            }
            case 3:{
                return 7;
            }
            case 4:{
                return 4;
            }
            case 5:{
                if (Contains(input,pattern5))
                    return 5;
                if(Contains(input,pattern2))
                    return 2;
                if (Contains(input,pattern3))
                    return 3;
            }
            case 6:{
                if (Contains(input,pattern0))
                    return 0;
                if(Contains(input,pattern9))
                    return 9;
                if (Contains(input,pattern6))
                    return 6;
            }
            case 7:{
                return 8;
            }
            default: break;
        }

        return -1;
    }
    private boolean Contains(String input, String patt){
        for (int i = 0; i < patt.length();i++){
            if (!input.contains(patt.charAt(i) + "")){
                return false;
            }
        }
        return true;
    }
}
