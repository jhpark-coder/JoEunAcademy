package WEEK02.DAY04;

import java.util.Scanner;

public class Q4_After {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //별은 i+1개만큼 찍음
        //스페이스는 n-i개만큼 찍음

        for(int i = 0 ; i < n ; i++) {

            for (int j = n-i; j > 1; j--) {
                System.out.print(" ");
            }
            for (int k = 0 ; k < (i*2)+1 ; k++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
