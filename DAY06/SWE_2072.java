package WEEK02.DAY06;

import java.util.Scanner;

public class SWE_2072 {
    public static void main(String[] args) {
        //10개의 수 입력받아서
        //그 중 홀수만 더함
        //모든 수는 0이상 1만 이하의 정수이다.

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // t만큼 반복

        for(int i = 0 ; i < t ; i++)
        {
            int sum = 0;
            for(int j = 0 ; j < 10 ; j++)
            {
                int num = sc.nextInt();
                if(num % 2 == 1)
                    sum+=num;
            }
            System.out.printf("#%d %d\n",i+1,sum);
        }

    }

}
