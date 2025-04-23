package WEEK02.DAY07;

import java.util.Scanner;

public class Q2444_Star7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //윗 피라미드
        //총 5,6,7,8,9개 찍음
        //공백 4,3,2,1,0개 찍음
        //별 1,3,5,7,9개 찍음

        int n = sc.nextInt();

        for(int i = 1 ; i <= n; i++) // 크기 n짜리의 피라미드 찍기 //i -> 0~4(5개짜리)
        {
            for(int j = n-1-i ; j >= 0 ; j--) // j -> 4 ~ 0
            {
                System.out.print(" ");

            }
            for(int k = 1 ; k < 2*i ; k++)
            {
                System.out.print("*");

            }
            System.out.println();
        }

        for(int i = 0 ; i < n ;i++)
        {
            for(int j = 0; j <= i ; j++)
            {
                System.out.print(' ');
            }
            for(int k = (n-1-i)*2 -1 ; k > 0 ; k--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
