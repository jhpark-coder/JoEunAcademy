package WEEK03.DAY13;

/*

컨트롤 클래스에는 더하기 곱하기 빼기 나누기 연산을 하는 함수를 만들어주세요.
실수와 정수의 연산이 될 수 있도록 오버로딩을 사용해서 만들어주세요.
입력과 출력도 컨트롤 클래스에서 만들어줍니다.
메인함수에서 연산이 되도록 구현해주세요.

1. 정수연산 2. 실수연산 3. 종료 : (입력)

1. 더하기 2. 빼기 3. 곱하기 4. 나누기 : (입력)

숫자 1 입력 : 5
숫자 2 입력 : 5

결과 값 : 10

출력 이후에 다시 첫화면으로 이동해주세요.

(모든 곳에 잘못된 입력 처리를 해주세요.)

 */

import java.util.Scanner;

class Control{ // 컨트롤 클래스를 만듭니다.

    Scanner sc;

    //더하기 함수
    int add(int a, int b){
        return a+b;
    }
    double add(double a, double b){
        return a+b;
    }
    //빼기 함수
    int sub(int a, int b){
        return a-b;
    }
    double sub(double a, double b){
        return a-b;
    }
    //곱하기 함수
    int mul(int a, int b){
        return a*b;
    }
    double mul(double a, double b){
        return a*b;
    }
    //나누기 함수
    int div(int a, int b){
        return a/b;
    }
    double div(double a, double b){
        return a/b;
    }
    //입력
    void inputNumber(){
        int num = 0;
        while(true) {
            int flag = 1;
            printMain(flag++);
            num = checkInnerInteger(1,3);
            if(num == 3)
                break;
            int num1 = 0;
            double d1;
            printMain(flag++); //2번 출력하고 3이 됨
            if (num == 1) { //정수연산
                num1 = checkInnerInteger(1, 4);
                if (num1 == 1) { // 더하기
                    int n1 = checkIsInteger(flag++);
                    int n2 = checkIsInteger(flag);
                    printResult(add(n1, n2));
                }else if(num1 == 2){ // 빼기
                    int n1 = checkIsInteger(flag++);
                    int n2 = checkIsInteger(flag);
                    printResult(sub(n1, n2));
                }else if(num1 == 3){ // 곱하기
                    int n1 = checkIsInteger(flag++);
                    int n2 = checkIsInteger(flag);
                    printResult(mul(n1, n2));
                }else{ // 나누기
                    int n1 = checkIsInteger(flag++);
                    int n2 = checkIsInteger(flag);
                    printResult(div(n1, n2));
                }
            } else if (num == 2) { //실수연산
                num1 = checkInnerInteger(1, 4);
                if (num1 == 1) { // 더하기
                    double dn1 = checkIsDouble(flag++);
                    double dn2 = checkIsDouble(flag);
                    printResult(add(dn1, dn2));
                }else if(num1 == 2){ // 빼기
                    double dn1 = checkIsDouble(flag++);
                    double dn2 = checkIsDouble(flag);
                    printResult(sub(dn1, dn2));
                }else if(num1 == 3){ // 곱하기
                    double dn1 = checkIsDouble(flag++);
                    double dn2 = checkIsDouble(flag);
                    printResult(mul(dn1, dn2));
                }else{ // 나누기
                    double dn1 = checkIsDouble(flag++);
                    double dn2 = checkIsDouble(flag);
                    printResult(div(dn1, dn2));
                }
            } else { // 종료
                return;
            }
        }//출력 이후에 첫화면으로 이동
    }

    void printMain(int flag){
        if(flag == 1){
            System.out.print("1. 정수연산 2. 실수연산 3. 종료 : ");
        }else if(flag == 2){
            System.out.println("1. 더하기 2. 빼기 3. 곱하기 4. 나누기 : ");
        } else if (flag == 3) {
            System.out.print("숫자 입력 1 : ");
        } else{
            System.out.print("숫자 입력 2 : ");
        }
    }
    //출력
    void printResult(int a){
        System.out.println("결과 값 : "+ a );
    }
    //출력
    void printResult(double a){
        System.out.println("결과 값 : "+ a );
    }


    int checkInnerInteger(int min, int max){
        while(true) {
            if(sc.hasNextInt()) {
                int num = sc.nextInt();
                if (num >= min && num <= max)
                    return num;
                else {
                    System.out.printf("%d %d 사이의 올바른 정수값을 입력해주세요", min, max);
                }
            }else{
                System.out.printf("%d %d 사이의 올바른 정수값을 입력해주세요", min, max);
                sc.next();
            }
        }
    }

    int checkIsInteger(int num){
        printMain(num);
        while(sc.hasNext()) {
            if (sc.hasNextInt())
                return sc.nextInt();
            else {
                System.out.println("정수값을 입력해주세요.");
                sc.next();
            }
        }
        return 0;
    }

    double checkIsDouble(int num){
        printMain(num);
        while(sc.hasNext()) {
            if (sc.hasNextDouble())
                return sc.nextDouble();
            else {
                System.out.println("실수값을 입력해주세요.");
                sc.next();
            }
        }
        return 0.0;
    }
    Control(){
        sc = new Scanner(System.in);
    }
}

public class Q1 {
    public static void main(String[] args) {

        Control c = new Control();
        c.inputNumber();

    }
}
