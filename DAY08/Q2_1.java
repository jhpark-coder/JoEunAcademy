
package DAY08;

import java.util.Scanner;

public class Q2_1 {
    public static void main(String[] args) {

        calculator();
    }


    static void calculator(){
        int flag = 0;
        Scanner sc = new Scanner(System.in);
        while(flag != 3){
            System.out.println("1.사각형 넓이 2. 삼각형 넓이 3. 종료 :");
            System.out.print("[숫자 입력] : ");
            flag = sc.nextInt();

            if(flag == 1 || flag == 2){
                int[] wh = inputWH();
                if(flag == 1){
                    square(wh[0],wh[1]);
                }
                else{
                    triangle(wh[0],wh[1]);
                }
            }
            else if(flag == 3){
                break;
            }
            else{
                System.out.println("잘못된 입력입니다.");
            }

        }
        System.out.println("계산기 종료");

    }

    static int[] inputWH(){
        Scanner sc = new Scanner(System.in);
        int[] num = new int[2];
        System.out.print("가로 입력 : ");
        num[0] = sc.nextInt();
        System.out.print("세로 입력 : ");
        num[1] = sc.nextInt();

        return num;
    }

    static void square(int num1, int num2){
        System.out.println("사각형 넓이 : "+num1*num2);
    }
    static void triangle(int num1, int num2){
        System.out.println("사각형 넓이 : "+num1*num2 / 2.0);
    }


}