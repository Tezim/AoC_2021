public class DAY1 {
    public static Integer first(Integer[] content){
        int counter = 0;
        Integer actual = 0;
        for(int i = 0; i < content.length - 1; i++){
            actual = content[i];
            if (actual < content[i + 1])    // increase
                counter++;
        }
        return counter;    //answer
    }
    public static Integer second(Integer[] content) {
        int counter = 0;
        for (int i = 0; i < content.length - 3; i++) {
            // akoze chcelo to byt floating window
            int sum1 = content[i] + content[i + 1] + content[i + 2];
            int sum2 = content[i + 1] + content[i + 2] + content[i + 3];
            if (sum1 < sum2)
                counter++;
        }
        return counter;
    }
}
