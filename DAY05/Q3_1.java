package WEEK02.DAY05;

import java.util.Random;

/*
변수 문제 1
3개의 변수에 1~9까지 랜덤수를 부여합니다.
단 3개의 숫자에 각각 다른 숫자를 넣어야함.
 */
public class Q3_1 {
    public static void main(String[] args) {

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        Random r = new Random();

        num1 = r.nextInt(9)+1; // 첫 번째 넘버는 중복이 없기때문에 1~9까지의 값중 하나를 넣어줌
        System.out.printf("첫 번째 변수에 값 %d이 들어갔습니다\n",num1);


        while(num3 == 0) { //num3에 값이 안 들어가 있다면 반복
            int temp = r.nextInt(9)+1; //임시 정수. 넣을지 말지 보는 값으로 중복되면 다시받아옴
            if(num2 == 0) //num2에 값이 안넣었을 때 넣어주는 작업
            {
                if(num1 != temp) //num2에 넣을 temp1이 num1과 중복이 아니라면
                {
                    num2 = temp; //temp에 저장된 랜덤한 값을 num2에 대입
                    System.out.printf("두 번째 변수에 값 %d이 들어갔습니다\n",num2);
                }
                else { //중복이라면 다시 받아옴
                    System.out.println("2번 값으로 기존 값과 중복된 값 "+temp+"를 가져왔기 때문에 두 번째 변수의 값을 새로 받아왔습니다");
                }
            }
            else//if(num2 != 0 && num3 == 0) //num3에 값이 안넣었을 때 넣어주는 작업
            {//num2에는 값이 있으면서 num3이 0인 경우(while문으로 체크) = num1, num2 넣었고 num3 넣어야하는 경우
                if(num1 != temp && num2 != temp) //temp가 num1과 num2와 중복이 아니라면
                {
                    num3 = temp; //temp에 저장된 랜덤한 값을 num3에 대입
                    System.out.printf("세 번째 변수에 값 %d이 들어갔습니다\n",num3);
                }
                else{ //temp이 num1 또는 num2와 같다는 뜻이기 때문에 중복임
                    System.out.println("3번 값으로 기존 값과 중복된 값 "+temp+"를 가져왔기 때문에 세 번째 변수의 값을 새로 받아왔습니다");
                }
            }
            //num3에 넣은 이후에도 1회 수행되긴 하지만 이게 제일 코드가 짧고 변수사용도 적음
            //temp = r.nextInt(9)+1; // 다시 받아옴 거의 매번수행되기 때문에 맨 아랫줄에 한번 더 넣었음

        }
        //최종 결과 출력 및 종료
        System.out.printf("최종적으로 각각 %d %d %d의 값이 들어갔습니다",num1,num2,num3);


    }
}
