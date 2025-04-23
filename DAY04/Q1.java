package WEEK02.DAY04;

import java.util.Scanner;

/*
숫자 입력 : 10
짝수 : 2 4 6 8
홀수 : 1 3 5 7 9
 */

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //숫자 하나를 입력받음
        System.out.print("숫자 입력 : ");
        int num = sc.nextInt();
        System.out.println();

        //짝수를 작성함(단, num보다 작게 작성해야함 == n-1까지)
        System.out.print("짝수 : ");
        for(int i = 2 ; i < num ; i++) //2부터(짝수는 2부터 이므로) n-1까지 돔
        {
            if(i % 2 == 0) {
                System.out.print(i+" ");
            }
        }
        System.out.println();

        //홀수를 작성함(단, num보다 작게 작성해야함 == n-1까지)
        System.out.print("홀수 : ");
        for(int i = 1 ; i < num ; i++) //1부터 n-1까지 돔
        {
            if(i % 2 == 1)
            {
                System.out.print(i+" ");
            }
        }

    }
}
