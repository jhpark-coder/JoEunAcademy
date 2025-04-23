package WEEK01.DAY03;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int num1, num2; //입력받을 두 수 선언해둠
        Scanner sc = new Scanner(System.in); // 스캐너선언을 통해 입력 준비

        System.out.print("첫번째 수 : "); // 두 수를 입력받아 최대공약수와 최소공배수 구하기
        num1=sc.nextInt(); // 첫 번째 수 입력
        System.out.print("두번째 수 : "); 
        num2=sc.nextInt(); // 두 번째 수 입력

        int gcd = 1; // 최대공약수 선언 및 초기화
        int lcm = 1; // 최소공배수 선언 및 초기화
        int lower = 1; // 둘 중에 더 작은 수 비교 위해 초기화(두 숫자간 차이가 클 경우 이게 더 연산이 빠를 것 같아서 선언해둠)
        if(num1 > num2) // num1이 num2보다 크다면
            lower = num2; // num2가 더 작음
        else lower = num1; // 그렇지 않은 경우 num1이 작거나 같은 경우이기 때문에 num1을 lower에 대입

        for(int i = 1; i <= lower ; i++) // 최대공약수 또는 최소공배수는 1 이상의 양의 정수이기 때문에 1부터 시작하며 최대 lower까지 반복
        {
           if(num1 % i == 0 && num2 % i == 0) // i가 num1, num2의 공약수인 경우
           {
               gcd = i; // gcd를 i로 만듬.
           }
           else continue; // 아닌경우 계속함. else문 작성을 위해 한 줄 적어둔 문장
        }

        lcm = (num1 * num2) / gcd; // 최소공배수는 두 수를 곱한 값을 최대공약수로 나눈 값

        System.out.printf("최대공약수는 %d입니다.",gcd); // 최대공약수 출력
        System.out.printf("최소공배수는 %d입니다.",lcm); // 최소공배수 출력


    }


}
