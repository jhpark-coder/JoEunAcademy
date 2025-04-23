package WEEK02.DAY06;

public class MultiArrayTest {
    public static void main(String[] args) {
        int[][] a = new int[5][5];
        // a[0] = 10; a[0]는 int배열이기 때문에 int값을 받을 수 없음

        int count = 1;
        for(int i = 0; i < a.length ; i++)
        {
            for(int j = 0 ; j < a[i].length ; j++)
            {
                a[i][j] = count;
                count++;
                System.out.printf("%d\t",a[i][j]);
            }
            System.out.println();
        }
    }
}
