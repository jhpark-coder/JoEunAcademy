package WEEK02.DAY05;

import java.util.Scanner;

public class Q2675_repetition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0 ; i < t ; i++) //i번 반복해서 실행
        {
            int r = sc.nextInt();
            String str = sc.next();
            for(int j = 0 ; j < str.length() ; j++)
            {
                for(int k = 0 ; k < r ; k++)
                {
                    System.out.print(str.charAt(j));
                }

            }
            System.out.println();
        }

    }
}
