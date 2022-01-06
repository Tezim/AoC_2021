package Days;

public class DAY22 {

    char[][][] reactor = new char[200][200][200];

    public void solve(String[] lines){
        for (int x = 0; x < 100; x++){
            for (int y = 0; y < 100; y++){
                for (int z = 0; z < 100; z++){
                    reactor[z][y][x] = '0';
                }
            }
        }

        for (String s : lines) {
            String[] line = s.split(" ");
            reboot(line[0], line[1]);
            System.out.println(count());
        }
    }

    private long count(){
        long sum = 0L;

        for (int x = 0; x < 150; x++){
            for (int y = 0; y < 150; y++){
                for (int z = 0; z < 150; z++){
                    if(reactor[z][y][x] == '1')
                        sum++;
                }
            }
        }
        return sum;
    }
    private void reboot(String instruction, String coordinates){
        String[] tmp = coordinates.split(",");
        String[] X = tmp[0].split("=")[1].replace(".."," ").split(" ");
        String[] Y = tmp[1].split("=")[1].replace(".."," ").split(" ");
        String[] Z = tmp[2].split("=")[1].replace(".."," ").split(" ");

        int x = Integer.parseInt(X[0]) + 50;
        int x_max = Integer.parseInt(X[1]) + 50;
        int y = Integer.parseInt(Y[0]) + 50;
        int y_max = Integer.parseInt(Y[1]) + 50;
        int z = Integer.parseInt(Z[0]) + 50;
        int z_max = Integer.parseInt(Z[1]) + 50;

        if (instruction.equals("on")){
            for (int i = x; i <= x_max; i++){
                for (int j = y; j <= y_max; j++){
                    for (int k = z; k <= z_max ; k++){
                        reactor[k][j][i] = '1';
                    }
                }
            }
        } else {
            for (int i = x; i <= x_max; i++){
                for (int j = y; j <= y_max; j++){
                    for (int k = z; k <= z_max ; k++){
                        reactor[k][j][i] = '0';
                    }
                }
            }
        }
    }
}
