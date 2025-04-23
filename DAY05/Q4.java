package WEEK02.DAY05;
/*
변수 문제 2
숫자야구게임
랜덤 숫자 3개를 com이 가지고 있음
com 5 6 7
첫째자리 : 4
둘째자리 : 3
셋째자리 : 2
(1~9)를 넘어가는 수 입력시 다시입력받아야함
 */

import java.util.Random;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//입력대비 스캐너 선언
        Random r = new Random();

        //com이 가지고 있는 랜덤한 숫자 3개

        //중복이면 안됨
        int comNum1 = r.nextInt(9)+1;
        int comNum2 = r.nextInt(9)+1;
        int comNum3 = r.nextInt(9)+1;

        //중복체크해서 중복 없애줌 중복 아닌경우에 루프탈출
        while(comNum1 == comNum2 || comNum2 == comNum3 || comNum1 == comNum3)
        {
            comNum1 = r.nextInt(9)+1;
            comNum2 = r.nextInt(9)+1;
            comNum3 = r.nextInt(9)+1;
        }

        //중복아닌 comNum1, comNum2, comNum3이 마련되었음
        System.out.printf("Com %d %d %d\n",comNum1,comNum2,comNum3);


        //숫자 3개 저장해둘(입력받을) 변수 3개 선언
        int inputNum1=-1;
        int inputNum2=-2;
        int inputNum3=-3;

        int strike = 0; //스트라이크 횟수 체크
        int ball = 0; //볼 횟수 체크

        while(strike < 3) // strike가 3인 홈런인 경우 루프 멈춤
        {
            boolean dupCheck = true; //중복 체크
            boolean inNum = true; // 범위체크
            while(dupCheck || inNum) {//입력값이 중복이면 안되며, 1~9까지의 수여야함(범위에 맞는 inputNum 입력받기)

                System.out.println("1~9까지의 숫자 3개를 입력해주세요.");
                System.out.print("첫째자리 : ");
                inputNum1 = sc.nextInt();

                System.out.print("둘째자리 : ");
                inputNum2 = sc.nextInt();

                System.out.print("셋째자리 : ");
                inputNum3 = sc.nextInt();

                if(inputNum1 != inputNum2 && inputNum2 != inputNum3 && inputNum1 != inputNum3)
                {
                    dupCheck = false;
                }
                if(inputNum1 >= 1 && inputNum1 <= 9 && inputNum2 >= 1 && inputNum2 <= 9 && inputNum3 >= 1 && inputNum3 <= 9)
                {
                    inNum = false;
                }
                if(dupCheck || inNum)
                    System.out.println("잘못된 입력입니다");

            } //inputNum체크완료


            strike = 0; //strike 값 초기화
            ball = 0; //ball 값 초기화

            //스트라이크 체크
            if(comNum1 == inputNum1)
                strike++;
            if(comNum2 == inputNum2)
                strike++;
            if(comNum3 == inputNum3)
                strike++;

            //볼 체크
            if(comNum1 == inputNum2 || comNum1 == inputNum3)
                ball++;
            if(comNum2 == inputNum1 || comNum2 == inputNum3)
                ball++;
            if(comNum3 == inputNum1 || comNum3 == inputNum2)
                ball++;

            if(strike == 0 && ball == 0) // 아웃인 경우
            {
                System.out.println("Out");
            }
            else // 아웃이 아닌 경우
            {
                if(strike > 0 && strike < 3)
                    System.out.print(strike+"Strike ");
                if(ball > 0)
                    System.out.print(ball+"Ball");
                System.out.println();
            }

        }
        System.out.println("홈런");

    }
}
