package DAY07;

public class MultiArrayTest3 {
    public static void main(String[] args) {
        int[][][] b= new int[2][2][2];

        int count = 0;

        for(int i = 0 ; i < b.length ; i++) {
            for(int j = 0 ; j < b[i].length ; j++) {
                for(int k = 0 ; k < b[i][j].length ; k++) {
                    b[i][j][k] = ++count;
                    System.out.print(b[i][j][k]+"\t");
                }
            }
        }
    }
}
