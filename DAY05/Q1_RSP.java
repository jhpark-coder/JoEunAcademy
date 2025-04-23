package WEEK02.DAY05;

import java.util.Random;
import java.util.Scanner;

public class Q1_RSP {
    public static void main(String[] args) {
        /*
        1.게임시작 2. 종료
        1. -> 1. 가위, 2. 바위, 3. 보
        컴퓨터가 가위(1)이면 유저 바위 승리
        컴퓨터가 바위(2)이면 유저바위 무승부
        컴퓨터가 보(3)이면 유저바위 패

        게임이 끝나면 첫화면으로 이동
        게임결과 : User 승
         */


        //스캐너 선언
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        boolean check = true;
        while(check){
            System.out.print("1.게임시작 2.종료 : ");// 게임 메인메뉴
            int num = sc.nextInt(); //정수변수 num을 입력받음
            switch(num) { //num이 1인지 2인지 확인해서 1이면 게임시작 2이면 종료 그 외 값이면 잘못된 입력값이라고 알려줌
                case 1: //게임시작
                    System.out.print("1. 가위, 2. 바위, 3. 보를 선택해주세요 : ");
                    int userRSP = sc.nextInt(); // 유저한테 가위바위보 입력받음
                    int comRSP = r.nextInt(3)+1; //1~3까지
                    if(userRSP == 1)//유저가 가위인 경우
                    {
                        switch(comRSP){ //comRSP는 무조건 1,2,3만 가능하므로 1,2, default로 처리하는게 빠름
                            case 1: //유저 가위, 컴퓨터 가위인 경우 = 비김
                                System.out.println("게임 결과 : 비겼습니다.");
                                break;
                            case 2: //유저 가위, 컴퓨터 바위인 경우 = com 승
                                System.out.println("게임 결과 : Com 승");
                                break;
                            default: //유저 가위, 컴퓨터 보인 경우 = user 승 (case 3)
                                System.out.println("게임 결과 : User 승");
                                break;
                        }
                    }
                    else if(userRSP == 2)// 유저가 바위인 경우
                    {
                        switch(comRSP){
                            case 1: //유저 바위, 컴퓨터 가위인 경우 = user 이김
                                System.out.println("게임 결과 : User 승");
                                break;
                            case 2: //유저 바위, 컴퓨터 바위인 경우 = 비김
                                System.out.println("게임 결과 : 비겼습니다.");
                                break;
                            default: //유저 바위, 컴퓨터 보인 경우 = com 이김(= case 3)
                                System.out.println("게임 결과 : Com 승");
                                break;
                        }

                    }
                    else if(userRSP == 3) // 유저가 보인 경우
                    {
                        switch(comRSP){
                            case 1: // 유저 보, 컴퓨터 가위인 경우 = com 승
                                System.out.println("게임 결과 : Com 승");
                                break;
                            case 2: // 유저 보, 컴퓨터 바위인 경우 = 유저 승
                                System.out.println("게임 결과 : User 승");
                                break;
                            default: // 유저 보, 컴퓨터 보인 경우 = 비김(=case 3)
                                System.out.println("게임 결과 : 비겼습니다.");
                                break;
                        }
                    }
                    else{// 잘못된 입력인 경우. comRSP와 달리 userRSP는 오입력이 있을 수 있으므로 체크
                        System.out.println("가위바위보는 1~3까지 입력하셔야 합니다.");
                    }
                    break;
                case 2: //2인 경우 가위바위보 게임 종료
                    check = false;
                    break;
            }
        }



    }

}
