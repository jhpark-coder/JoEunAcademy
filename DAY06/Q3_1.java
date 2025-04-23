package WEEK02.DAY06;

import java.util.Scanner;

public class Q3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //값이 원하는 값이 아니면 다시 받기

        int[] num = new int[2];

        for(int i = 0 ; i < 2; i++) // 숫자 맞게 입력할때까지 체크하고 입력 받는 곳
        {
            System.out.printf("숫자 %d : ",i+1);
            num[i] = sc.nextInt();
            if(num[i] < 1)
            {
                System.out.println("다시 입력해주세요");
                i--;

            }
        }

        int gcd = 1;//최대공약수
       // int min =  num[0] < num[1] ? num[0] : num[1]; // min함수
        /*
        for(int i = 1 ; i < min ; i++)
        {
            if((num[0] % i) == 0 && (num[1] % i) == 0) // 두 수의 공약수라면
            {
                gcd = i;
            }
        }

         */

        //유클리드 호제법을 사용하기 위해 num1에 더 큰 수를 num2에 더 작은수를 넣는다.
        int num1 = num[0] > num[1] ? num[0] : num[1]; //num1에 더 큰수
        int num2 = num[0] < num[1] ? num[0] : num[1]; //num2에 더 작은수

        /*
        for(int i = 0 ; i < num.length-1 ; i++) //갯수가 3개 이상일 때 정렬
        {
           for(int j = 1 ; j < num.length ; j++)
           {
               if(num[i] > num[j])
               {
                   int temp = num[j];
                   num[j] = num[i];
                   num[i] = temp;
               }
           }
        }
        int num1 = num[0];
        int num2 = num[1];

         */

        //유클리드 호제법으로 구현 1
        /*//1. break 사용
        while(true)
        {
            gcd= num1 % num2;
            if(gcd == 0)
            {
                gcd = num2;
                break; //num2에 gcd를 넣고 나가기 위함
            }
            num1 = num2;
            num2 = gcd;
        }
         */
        //2. continue 사용
        /*
        while(gcd > 0)
        {
            gcd= num1 % num2;
            if(gcd == 0)
            {
                continue;
            }
            num1 = num2;
            num2 = gcd;
        }

        gcd = num2; //중간에 나가면 num2가 gcd
        */
        //3. continue, break없이 하기
        while(gcd > 0)
        {
            gcd= num1 % num2;
            num1 = num2;
            num2 = gcd;
        }

        gcd = num1; //중간에 나가면 num2가 gcd인데 끝나고 나가면 num1이 gcd가 되어있음



        //최소공배수
        int lcm = num[0] * num[1] / gcd;

        System.out.printf("최대공약수 : %d,\t 최소공배수 : %d\n",gcd,lcm);
    }
}
