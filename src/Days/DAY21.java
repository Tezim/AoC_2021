package Days;

public class DAY21 {
    // player 1 - 1
    // player 2 - 10

    long scoreA = 0;
    long scoreB = 0;
    int dice = 1;
    int rolls  = 0;

    public void solve(){
        partOne();
        partTwo();
    }

    private void partTwo(){
        // cry
    }

    private void partOne(){
        ////////////////////////
        int playerA_pos = 1;
        int playerB_pos = 10;
        ////////////////////////
        int winner = 0;
        while(scoreA < 1000 && scoreB < 1000) {
            System.out.print("Player A ");
            playerA_pos = movePlayer(playerA_pos, 0);
            if (scoreA >= 1000)
                break;
            System.out.print("Player B ");
            playerB_pos = movePlayer(playerB_pos, 1);
            if (scoreB >= 1000){
                winner = 1;
                break;
            }
        }
        // 0 - 9 circle
        if (winner == 0){
            System.out.println("Score: " + (scoreB * rolls));
        } else {
            System.out.println("Score: " + (scoreA * rolls));
        }
    }
    private int movePlayer(int current_pos,int id){
        long dice = roll();
        int new_pos = (int) ((current_pos + dice) % 10);
        if(new_pos == 0)
            new_pos = 10;
        System.out.print(" moves from: " + current_pos + " to: " + new_pos);
        if(id == 0){
            scoreA += new_pos;
            System.out.print(" Score: " + scoreA);
        } else {
            scoreB += new_pos;
            System.out.print(" Score: " + scoreB);
        }
        System.out.println();
        return new_pos;
    }
    private long roll(){
        long move = 0;
        move += dice;
        System.out.print("rolls: " + dice);
        dice++;
        if (dice > 100)
            dice = 1;
        move += dice;
        System.out.print("," + dice);
        dice++;
        if (dice > 100)
            dice = 1;
        move += dice;
        System.out.print("," + dice);
        dice++;
        if (dice > 100)
            dice = 1;
        rolls += 3;
        return move;
    }
}
