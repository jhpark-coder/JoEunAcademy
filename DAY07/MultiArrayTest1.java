package DAY07;

public class MultiArrayTest1 {
    public static void main(String[] args) {

        int[][] d = new int[3][];
        d[0] = new int[5];
        d[1] = new int[2];
        d[2] = new int[3];
        int count = 0;
        for(int i = 0 ; i < d.length ; i++) {
            for (int j = 0 ; j < d[i].length ; j++) {
                d[i][j] = ++count;
            }
        }

        for(int i = 0 ; i < d.length ; i++) {
            for(int j = 0 ; j < d[i].length ; j++) {
                System.out.print(d[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
