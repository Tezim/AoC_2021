package Days;

public class DAY7 {

    private long fitness = Long.MAX_VALUE;

    public void first(String content){
        String[] input = content.split(",");
        for (int i = 0; i < 2500; i++){
            changePosition(i,input);
        }
        System.out.println(this.fitness);
    }
    private void changePosition(int i,String[] input){
        long fuel = 0;
       for (int idx = 0; idx<input.length;idx++){
           fuel += getFuel(Math.abs(Integer.parseInt(input[idx]) - i));
           //fuel += Math.abs(Integer.parseInt(input[idx]) - i);

       }
       if (fuel < fitness)
           fitness = fuel;
    }
    private long getFuel(int location){
        long sum=0;
        int fuel = 1;
        for(int i =0;i<location;i++) {
            sum+= fuel;
            fuel++;
        }
        return sum;
    }
}
