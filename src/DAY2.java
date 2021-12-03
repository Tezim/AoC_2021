public class DAY2 {
    public static Integer first(String[] content){
            int horizontal = 0;
            int depth = 0;
            for(int i = 0; i< content.length;i++){
                if (content[i].equals("forward")){
                    byte[] tmp = content[i + 1].getBytes();
                    int n = tmp[0] - 48;
                    horizontal += n;
                    i++;
                }
                if (content[i].equals("up")){
                    byte[] tmp = content[i + 1].getBytes();
                    int n = tmp[0] - 48;
                    depth -= n;
                    i++;
                }
                if (content[i].equals("down")){
                    byte[] tmp = content[i + 1].getBytes();
                    int n = tmp[0] - 48;
                    depth += n;
                    i++;
                }
            }
            return depth * horizontal;
        }

    public static Integer seond(String[] content){
        int horizontal = 0;
        int aim = 0;
        int depth = 0;
        for(int i = 0; i< content.length;i++){
            if (content[i].equals("forward")){
                byte[] tmp = content[i + 1].getBytes();
                int n = tmp[0] - 48;
                horizontal += n;
                depth += (aim * n);
                i++;
            }
            if (content[i].equals("up")){
                byte[] tmp = content[i + 1].getBytes();
                int n = tmp[0] - 48;
                aim -= n;
                i++;
            }
            if (content[i].equals("down")){
                byte[] tmp = content[i + 1].getBytes();
                int n = tmp[0] - 48;
                aim += n;
                i++;
            }
        }
        return depth * horizontal;
    }
}
