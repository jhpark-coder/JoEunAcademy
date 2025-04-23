package WEEK02.DAY05;

import java.util.Random;
import java.util.Scanner;

/*
    랜덤 숫자를 1~100까지 받습니다.
    숫자를 입력 : 1~100까지 입력해야합니다.
    Com : 25
    숫자입력 : 25
    맞췄습니다 축하합니다.
    숫자입력 : 50
    다운
    숫자입력 : 10
    업
 */

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        boolean check = true;
        int rand = r.nextInt(100) + 1; //1~100중에 하나값을 랜덤하게 받아옴
                                                // 이 값은 맞출때까지는 고정이여야하므로 while문 밖에 선언
        while (check) { // 맞춘 경우 종료 그 외에는 무한루프로 값을 계속 받음

            System.out.print("숫자를 입력(1~100까지 입력해야합니다) :  ");
            int inputNum = sc.nextInt(); // 입력받기

            if (inputNum >= 1 && inputNum <= 100) { //입력한 숫자가 1이상 100이하 숫자라면 체크해줌

                //맞춘경우 나감
                if (inputNum > rand)//입력한 값이 더 큰 경우
                {
                    System.out.println("다운");

                } else if (inputNum < rand)//입력한 값이 더 작은 경우
                {
                    System.out.println("업");

                } else { //같은 경우
                    System.out.println("맞췄습니다. 축하합니다.");
                    check = false;
                }

            } else { //잘못된 값을 입력한 경우 다시 입력하라고 함
                System.out.println("잘못된 값을 입력했습니다. 다시 입력해주세요.");
            }


        }
    }
}
