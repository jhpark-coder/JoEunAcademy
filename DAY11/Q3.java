package WEEK03.DAY11;

/*
컴퓨터가 1~31 사이의 랜덤한 수 하나를 받습니다.

유저가 1~31 사이의 입력을 해야합니다.
1~31값이 아니면 잘못된 입력입니다.
출력 이후 다시 입력받습니다.

컴퓨터의 랜덤숫자를 맞추면 게임이 끝납니다.
 */

import java.util.Random;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int min = 1;
        int max = 31;
        int comNum = r.nextInt(31)+1;
        int userNum;
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            if(sc.hasNextInt()) {
                userNum = sc.nextInt();
                if(userNum >= min && userNum <= max) {
                    if (comNum > userNum) { // 컴퓨터가 높음
                        System.out.println("컴퓨터 업");
                    } else if (comNum < userNum) {
                        System.out.println("컴퓨터 다운");
                    } else {
                        System.out.println("정답입니다.");
                        break;
                    }
                }else{
                    System.out.printf("%d~%d 사이의 값을 입력해주세요.\n",min,max);
                }
            }else{
                System.out.printf("%d~%d 사이의 올바른 정수를 입력해주세요.\n",min,max);
                sc.next();
            }
        }
    }
}
