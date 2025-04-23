package WEEK02.DAY06;

public class ArrayTest2 {
    public static void main(String[] args) {
        int[][] a = new int[5][5];

        for(int i = 0 ; i < a.length ; i++)
        {
            for (int j = 0 ; j < a[i].length ; j++)
            {
                a[i][j]=j+ (a.length*+i) +1;
                System.out.printf("%d ",a[i][j]);
            }
            System.out.println();
        }


    }
}
