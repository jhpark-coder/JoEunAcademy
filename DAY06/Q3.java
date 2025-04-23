package WEEK02.DAY06;
/*
문제 1 두 수의 최소공배수와 최대공약수를 구해주세요.
단 두 수를 입력받아서 해주세요.
 */


import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            //스캐너 선언

        //숫자 2개를 받음

        System.out.print("숫자 1 : ");
        int num1 = sc.nextInt();
        System.out.print("숫자 2 : ");
        int num2 = sc.nextInt();

        int gcd = 1;//최대공약수
        int min =  num1 < num2 ? num1 : num2; // min함수

        for(int i = 1 ; i < min ; i++)
        {
            if((num1 % i) == 0 && (num2 % i) == 0) // 두 수의 공약수라면
            {
                gcd = i;
            }
        }

        //최소공배수
        int lcm = num1 * num2 / gcd;

        System.out.printf("최대공약수 : %d,\t 최소공배수 : %d\n",gcd,lcm);



    }
}
