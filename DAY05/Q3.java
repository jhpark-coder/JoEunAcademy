package WEEK02.DAY05;

import java.util.Random;

/*
변수 문제 1
3개의 변수에 1~9까지 랜덤수를 부여합니다.
단 3개의 숫자에 각각 다른 숫자를 넣어야함.
 */
public class Q3 {
    public static void main(String[] args) {

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        Random r = new Random();

        num1 = r.nextInt(9)+1; // 첫번째 넘버는 중복이 없기때문에 1~9까지의 값중 하나를 넣어줌
        System.out.printf("첫 번째 변수에 값 %d이 들어갔습니다\n",num1);

        boolean check1 = true;
        while(check1) {
            int temp = r.nextInt(9) + 1;
            if(temp == num1)
            {
                System.out.println("두 번째 변수에 넣을 값이 첫 번째 변수값과 중복되기 때문에 다시 받아옵니다.");
            }
            else{
                num2 = temp;
                System.out.printf("두 번째 변수에 값 %d이 들어갔습니다.\n",num2);
                check1 = false;
            }
        }
        boolean check2 = true;
        while(check2) {
            int temp = r.nextInt(9) + 1;
            if(temp == num1 || temp == num2)
            {
                System.out.println("세 번째 변수에 넣을 값이 첫 번째 또는 두 번째 변수값과 중복되기 때문에 다시 받아옵니다.");
            }
            else{
                num3 = temp;
                System.out.printf("세 번째 변수에 값 %d이 들어갔습니다.\n",num3);
                check2 = false;
            }
        }

        System.out.printf("최종적으로 각각 %d %d %d의 값이 들어갔습니다",num1,num2,num3);

    }
}
