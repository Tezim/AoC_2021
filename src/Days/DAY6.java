package Days;

import java.io.*;

public class DAY6 {

    public DAY6(){ }
    public long[] getFrequency(String content){
        char[] input = new char[300];
        int i = 0;
        for (int c = 0;c< content.length();c++){
           if (content.charAt(c) != 44){
               input[i] = content.charAt(c);
               i++;
           }
        }
        long[] frequency = new long[9];
        for (int idx = 0; idx < 300;idx++){
            frequency[input[idx] - 48]++;
        }
        return frequency;
}
    public void first(String content) throws IOException {
        long[] frequency = getFrequency(content);
        for (int i = 0; i < 256 ;i++){
            frequency = evaluate(frequency);
        }
       System.out.println(count(frequency));
    }
    private long[] evaluate(long[] timer) throws IOException {
        long[] tmp = new long[timer.length];
       for (int i = 0; i < timer.length; i++){
          if (i == 0){
              if (timer[i] != 0){
                  // born new fish reset timer
                  tmp[6] += timer[i];
                  tmp[8] += timer[i];
              }
          } else {
              if (timer[i] != 0){
                  // decrease timer
                  tmp[(i - 1)] += timer[i];
              }
          }
       }
       return tmp;
    }

    private long count(long[] fr)  {
        long counter = 0;
        for (int i = 0; i < fr.length; i++){
            counter += fr[i];
        }
        return counter;
    }
}
