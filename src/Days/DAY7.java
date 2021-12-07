package Days;

public class DAY7 {

    private long fitness = Long.MAX_VALUE;

    public void first(int[] input){
        for (int i = 0; i < 2000; i++){
            changePosition(i,input);
        }
        System.out.println(this.fitness);
    }
    private void changePosition(int i,int[] input){
        long fuel = 0;
        for (int s : input) {
            //fuel += getFuel(Math.abs(s - i));
            fuel += Math.abs(s - i);
        }
       if (fuel < fitness)
           fitness = fuel;
    }
    private long getFuel(int location){
        long sum=0; int fuel = 1;
        for(int i =0;i<location;i++) {
            sum+= fuel;
            fuel++;
        }
        return sum;
    }
}
