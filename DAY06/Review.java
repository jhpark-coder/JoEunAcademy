package WEEK02.DAY06;

import java.util.Random;
import java.util.Scanner;

public class Review {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //입력준비

        //com용 랜덤한 숫자 3개를 넣어줌
        //랜덤숫자 3개 담을 수 있는 3칸짜리 정수배열 생성
        int[] com = new int[3];

        Random r = new Random(); // 랜덤을 이용하기 위해 랜덤객체 r 생성

        //랜덤한 숫자를 계속 넣어주면서 이게 중복값인지 체크


        for(int i = 0 ; i < 3 ; i++)
        { //i는 현재 넣어주려는 배열

            com[i] = r.nextInt(9)+1;
            for( int j = 0 ; j < i ; j++) //j는 기존에 생성되어있는(값이 들어가있는 배열)
            {   //중복이라는건
                //0번이면 넣어줄 필요가 없고
                //1번이면 0번과 비교해서 넣고
                //2번이면 0번 1번과 비교해서 넣으면 된다는 뜻
                //그래서 j < 3 대신 j < i를 한 것
                //비교하는건 com[i]와 com[j]

                if(com[j] == com[i])
                {   // 기존값 com[j]와 현재값 com[i]가 같다는 건
                    // 중복값이라는 뜻이므로 다시 받아줘야함
                    i--;
                    break;
                }
            }
        }
        for(int i = 0 ; i < 3 ; i++) {
            System.out.println(com[i]); // 중복 아니게 들어간게 맞는지 체크
        }


        //사용자로 부터 값을 3개 입력받음
        //위에 썼던 로직을 활용하여 중복된 값을 받으면 다시 값을 받게 함

        int strike = 0;
        int ball = 0;

        while(strike < 3) // strike가 3 아래라면 홈런이 아니며 홈런이 될때까지 수행
        {
            int[] user = new int[3];//유저가 입력해서 저장할 배열값 생성

            for(int i = 0 ; i < 3 ; i++)
            { //i는 현재 넣어주려는 배열

                System.out.printf("%d번째 입력 : ",(i+1));

                user[i] = sc.nextInt(); // 입력받음
                if(user[i] < 1 || user[i] > 9) {
                    System.out.println("범위를 벗어나는 잘못된 입력입니다.");
                    i--;
                    continue;// 이 아래는 안함
                }
                for( int j = 0 ; j < i ; j++) //j는 기존에 생성되어있는(값이 들어가있는 배열)
                {   //중복이라는건
                    //0번이면 넣어줄 필요가 없고
                    //1번이면 0번과 비교해서 넣고
                    //2번이면 0번 1번과 비교해서 넣으면 된다는 뜻
                    //그래서 j < 3 대신 j < i를 한 것
                    //비교하는건 user[i]와 user[j]

                    if (user[j] == user[i]) {   // 기존값 user[j]와 현재값 user[i]가 같다는 건
                        // 중복값이라는 뜻이므로 다시 받아줘야함
                        i--;
                        break;
                    }
                }
            }

            //중복되지 않으면서 1~9까지의 값 3개를 가진 user가 생성되어있음
            strike = 0;
            ball = 0;

            for(int i = 0 ; i < 3 ; i++) //com[i]
            {
                for(int j = 0 ; j < 3 ; j++) //user[j]
                {
                    if(com[i]==user[j])
                    {
                        if(i == j)
                        {
                            strike++;
                        }
                        else{
                            ball++;
                        }
                    }
                }
            }

            if(strike == 0 && ball == 0)
            {
                System.out.println("Out");
            }
            else if(strike < 3 )
            {
                System.out.printf("%dStrike %dBall\n",strike,ball);    
            }
            else{
                System.out.println("홈런");
            }

        }

    }
}
