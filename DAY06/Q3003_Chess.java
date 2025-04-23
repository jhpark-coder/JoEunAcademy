package WEEK02.DAY06;

import java.util.Scanner;

public class Q3003_Chess {
    public static void main(String[] args) {
        //흰색 피스가 주어졌을 때 몇개를 더하거나 빼야 올바른지 구하기
        int[] correct = {1,1,2,2,2,8};
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < 6 ; i++)
        {
            int num = sc.nextInt();
            System.out.print(correct[i]-num+" ");
        }
    }
}
