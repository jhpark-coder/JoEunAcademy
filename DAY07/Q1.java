package DAY07;

/*
    계산기 함수화
    연산자 입력
    숫자 1 입력 : 9
    숫자 2 입력 : 6
    결과 값 : 15입니다.
    단, 연산자가 잘못 입력되면 잘못된 연산자입니다(출력)
    연산자 입력 : a(엔터)
    잘못된 연산자입니다.(출력)
    단, 나눗셈은 소수점 첫자리까지 출력해주세요.
 */

import java.util.Scanner;

public class Q1 {

    static int a;
    static int b;
    static double result;

    public static void main(String[] args) {
        //입력준비
        Scanner sc = new Scanner(System.in);

        String op = "";
        //연산자 입력 :
        while(opIsInvalid(op)){ // 연산자가 잘못된 값이면 true(무한루프), 옳게 입력하면 false(while문 빠져나옴)
            System.out.print("연산자 입력 : "); //연산자는 옳은 값을 받을 때까지 계속 입력받아야함
            op = sc.next();
            if(opIsInvalid(op)) {
                System.out.println("잘못된 연산자입니다.");
            }
        }
        //숫자 1 입력 :
        System.out.print("숫자 1 입력 : ");
        int num1 = sc.nextInt();
        //숫자 2 입력 :
        System.out.print("숫자 2 입력 : ");
        int num2 = sc.nextInt();
        //결과 값 입니다.
        if(op.equals("+")){//더하기 일경우 ( sum(int a, int b) )
            System.out.println("결과 값 : " + sum(num1,num2) + " 입니다."); //num1과 num2값
        }else if(op.equals("-")){//빼기일 경우 ( sub(int a, int b) )
            sub(num1, num2); // 안주고 받기의 경우이므로 num1과 num2를 넘기고 sub 메소드 안에서 result에 받음
            System.out.println("결과 값 : " + (int)result + " 입니다.");

        }else if(op.equals(("*"))){//곱하기일 경우
            a = num1;
            b = num2;
            System.out.println("결과 값 : " + multiply() + " 입니다.");

        }else{//나누기일 경우
            a = num1;
            b = num2;
            divide();
            System.out.printf("결과 값 : %.1f 입니다.",result); //divide한 결과값
        }

    }

    //1. 더하기 연산 (주고 받고)
    static int sum(int a, int b){
        return a+b;
    }

    //2. 곱하기 연산 (주고 안받고)
    static int multiply(){
        return a*b;
    }

    //3. 빼기 연산 (안주고 받고)
    static void sub(int a, int b){
        result = a-b;
    }

    //4. 나누기 연산 (안주고 안받고)
    static void divide(){
        result = (double)a / b;
    }

    static boolean opIsInvalid(String op){ // 연산자가 없으면 true라 while문이 무한루프돌고, 있으면 false라 빠져나옴)
        String[] operator = {"+","-","*","/"};
        boolean check = true;
        for(int i = 0 ; i < operator.length ; i++)
        {
            if(operator[i].equals(op)) //없냐? 아니요 있어요.
                check = false;
        }
        return check;
    }

}
