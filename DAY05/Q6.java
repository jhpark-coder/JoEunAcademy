package WEEK02.DAY05;

import java.util.Random;
import java.util.Scanner;

/*
배열 문제 2
숫자야구게임
랜덤 3자리 숫자를 com이 가지고 있습니다.
5 6 7
1~9까지만 들어갈 수 있습니다. 또한 각 자리별로 같은 수가 있으면 안됩니다.
com 5 6 7
첫째자리 :
둘째자리 :
셋째자리 :
랜덤값을 받아올 때 첫째자리에서 다르다면 바로 올라가게
 */
public class Q6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int[] comArr = new int[3];
        int[] tempArr = new int[3];
        while(comArr[2] == 0) { //arr[2]에 값이 안들어간경우 계속 수행
            for (int i = 0; i < 3; i++) {
                tempArr[i] = r.nextInt(9) + 1;
            }
            if(tempArr[0] != tempArr[1] && tempArr[1] != tempArr[2] && tempArr[0] != tempArr[2])
            {
                System.out.printf("Com ");
                for( int i = 0 ; i < 3 ; i++)
                {
                    comArr[i] = tempArr[i];
                    System.out.print(comArr[i]+" ");

                }
                System.out.println();
            }
        }

        int[] inputNum = new int[3];
        int strike = 0;
        int ball = 0;


        while(strike < 3)
        {
            System.out.println("1~9까지의 숫자 3개를 입력해주세요. ");

                    for (int i = 0 ; i < 3 ; i++) { //각 자리에 대한 값 입력받기. 범위 벗어나는거 체크, 중복체크
                        System.out.print((i + 1) + " 번째 자리 : ");
                        inputNum[i] = sc.nextInt();
                        if(inputNum[i] > 9 || inputNum[i] < 1) //1. 범위 벗어나는거 확인
                        {
                            i--; //inputNum[i] 값을 다시 입력받기위한 방법
                            System.out.println("범위 벗어났음");
                            continue;
                        }
                        for (int j = 0; j < i; j++) { // 2. 중복체크

                            if (inputNum[i] == inputNum[j]) {
                                System.out.println("중복임");
                                i--; //중복체크가 됐으면 다시 입력받고 추가적으로 중복체크를 더 할 필요가 없음
                                break;
                            }
                        }
                    }

                     strike = 0;
                     ball = 0;

                    //comArr와 inputNum을 비교하면서 Strike, Ball을 더해주면 됨

            for(int i = 0 ; i < 3 ; i++) // comArr
            {
                for(int j = 0 ; j < 3 ; j++)
                {
                    if(inputNum[i] == comArr[j])
                    {
                        if(i==j)
                            strike++;
                        else
                            ball++;
                    }
                }
            }

            if(strike > 0 && strike < 3)
                System.out.print(strike+"Strike ");
            if(ball > 0)
                System.out.print(ball+"Ball");
            System.out.println();


        }

        System.out.println("홈런");


    }



}

