package WEEK02.DAY07;

import java.util.Scanner;

public class Q2738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        int[][] sum = new int[n][m];

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                sum[i][j]=sc.nextInt()+arr[i][j];
            }
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                System.out.print(sum[i][j]+" ");
            }
            System.out.println();
        }
    }
}
