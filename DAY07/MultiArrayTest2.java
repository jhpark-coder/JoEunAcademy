package WEEK02.DAY07;

public class MultiArrayTest2 {
    public static void main(String[] args) {
        int[][] a = new int[5][];
        a[3] = new int[5];

        int[][][][][] c = new int[4][4][4][][];

        c[0][0][0][0][0] = 101; //런타임 에러

        c[1][1][1] = a;
    }
}
