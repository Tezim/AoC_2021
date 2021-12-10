package Days;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class DAY10 {
    ArrayList<Long> scores = new ArrayList<>();

    public void solve(String[] input){
        long score = 0;
        for (String line : input){
            score += checkLine(line);
        }
        System.out.println(score);
        Collections.sort(scores);
        System.out.println(scores.get(scores.size()/2));
    }
    private long checkLine(String input){
        // corrupted left on stack if found right and is correct pop else end
        Stack<Character> left = new Stack<Character>();
        for (int i = 0; i < input.length();i++){
            if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{' || input.charAt(i) == '<'){
                left.push(input.charAt(i));
            } else {
                Character tmp = left.peek();
                if (check(left.peek(),input.charAt(i))){
                    left.pop();
                } else {
                    //System.out.println("corrupted");
                    return getScore(input.charAt(i));
                }
            }
        }
        this.scores.add(correct(left));
        //System.out.println("incomplete");
        return 0;
    }
    private long correct(Stack<Character> left){
        long score = 0;
        while(left.size() > 0){
            score *= 5;
            score += findScore(left.peek());
            left.pop();
        }
        return score;
    }

    private int findScore(char c){
        return switch (c) {
            case '(' -> 1;
            case '[' -> 2;
            case '{' -> 3;
            case '<' -> 4;
            default -> 0;
        };
    }
    private boolean check(char stack, char input){
         switch (stack) {
             case '(' : if (input == ')' )
                            return true;
                        else
                            break;
             case '[' : if (input == ']' )
                            return true;
                        else break;
             case '{'  : if (input == '}' )
                            return true;
                        else
                            break;
             case '<'  : if (input == '>' )
                            return true;
                        else
                          break;
             default  : return false;
         }
         return false;
    }
    private long getScore(char c){
        /*
          ): 3 points.
          ]: 57 points.
          }: 1197 points.
          >: 25137 points.
        */
        return switch (c) {
            case ')' -> 3;
            case ']' -> 57;
            case '}' -> 1197;
            case '>' -> 25137;
            default -> 0;
        };

    }
}
