package Days;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class DAY17 {

    // input target area: x=124..174, y=-123..-86
    ArrayList<Point> coord = new ArrayList<>(); // list of correct input velocities

    public void solve(String input){

        long sum = 0;
        for (int i = 1; i <= 122;i++){ // symmetrical after fall
            sum += i;
        }
        System.out.println(sum);
        // shooting up
        // if shooting up, sum of x does not extend target x   x <= 18  y highest point is 122
        // shooting down
        // x cannot be lower than 0 and higher than 174    x >= 0 && x <= 174
        // y cannot be lower than lowest point pf target so its - 123  y >= 0 && y <= 123
        for (int x = 0; x <= 174;x++){
            for (int y = -123 ; y <= 122; y++){
                shoot(x,y);
            }
        }
        System.out.println(coord.size());
    }

    private boolean check(int x , int y){
         return (x >= 124 && x <= 174 && y >= -123 && y <= -86 );
    }

    private void shoot(int x, int y) {
        coord.add(new Point(x,y));
        int j = 0;
        int i = 0;
        while (i <= 174 && j >= -123) { // not overshoot
            i += x;
            j += y;
            if (x > 0)  // lower velocity if there is else probe is free falling
                x--;
            y--;
            if (check(i,j)){ // hits the target
                return ;
            }
        }
        coord.remove(coord.size()-1);
    }
}
