package WEEK01.DAY03;

import java.util.Scanner;

/*
계산기 만들기
숫자 2개 입력받기
연산자 입력받기
결과값 출력하기
연산자가 잘못되있으면 잘못된 연산자입니다 출력
나눗셈은 소수점 첫자리까지 출력
 */
public class Q2 {
    public static void main(String[] args) {

        int inputNum1, inputNum2; //입력받을 두 숫자 선언
        String op; //입력받을 연산자 오퍼레이터(operator)
        Scanner sc = new Scanner(System.in);//스캐너 선언

        System.out.print("숫자 1 입력 : ");//첫 번째 숫자 입력받기
        inputNum1 = sc.nextInt();
        System.out.print("숫자 2 입력 : ");//첫 번째 숫자 입력받기
        inputNum2 = sc.nextInt();
        System.out.print("연산자 입력 : ");//연산자 입력받기(연산자는 +, - , *, / 총 4가지 존재)
        op = sc.next();
/*
        //1. if문 활용
        if(op.equals("+")){
            System.out.printf("결과값 : %d 입니다.",(inputNum1 + inputNum2));
        }else if(op.equals("-"))
        {
                    System.out.printf("결과값 : %d 입니다.",(inputNum1 - inputNum2));
        }else if(op.equals("*"))
        {
            System.out.printf("결과값 : %d 입니다.",(inputNum1 * inputNum2));
        }else if(op.equals("/"))
        {
            System.out.printf("결과값 : %.1f 입니다.",((float)inputNum1 / (float)inputNum2));
        }else // +, -, *, /가 아닌 경우
        {
            System.out.println("잘못된 연산자입니다."); // 잘못된 연산자라고 알려줌
        }

        */

        //2. switch문 활용
        switch(op) {
            case "+": // 더하기
                System.out.printf("결과값 : %d 입니다.",(inputNum1 + inputNum2));
                break;
            case "-": // 빼기
                System.out.printf("결과값 : %d 입니다.",(inputNum1 - inputNum2));
                break;
            case "*": // 곱하기
                System.out.printf("결과값 : %d 입니다.",(inputNum1 * inputNum2));
                break;
            case "/": //정수의 나누기는 주의해야할 점으로 미리 형변환을 한 상태로 나누기를 해야 제대로 값이 나온다.
                //안 그러면 정수 나누기 정수 한 값을 형변환 하는 형태가 되기 때문에 소수점 이하 자리가 버림이 된다.
                //예를 들면 10/4를 하면 2.5가 되야하나 10/4 = 2로 저장이 되고 그 값을 형변환해봐야 2.000000이 된다.
                System.out.printf("결과값 : %.1f 입니다.",((float)inputNum1 / (float)inputNum2));
                break;
            default: // 오입력값
                System.out.println("잘못된 연산자입니다.");
                break;

        }


    }
}
