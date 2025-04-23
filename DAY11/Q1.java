package WEEK03.DAY11;
/*
주사위 게임
파란 주사위와
빨간 주사위 중
먼저 50이 되는 주사위를 출력

랜덤으로 나오는 값은 계속 더함

두 주사위 중에 먼저 50이상이 되는 주사위를 출력
 */
import java.util.Random;

class Dice{//주사위 클래스
    String color; // 주사위의 색
    int diceFace; // 주사위 눈금(1~6)

    Dice(String color){ //주사위의 초기눈은 따로 없지만 색깔은 따로 지정했으므로 컬러를 초기화
        this.color = color;
    }

    int rollDice(Random r){ //주사위를 굴림(이건 주사위 자체의 값이므로 여기 넣어줬음)
        diceFace = r.nextInt(6)+1; // 주사위를 굴립니다.
        return diceFace;
    }
}

class DiceGame{// 주사위 게임 관리 클래스
    int[] score; //2칸짜리 점수(각각의 합)
    int turn;
    final int GOALSCORE; // 목표점수
    Random r; // 주사위게임에서 사용될 랜덤객체
    Dice d1; // 주사위게임에서 사용될 첫 번째 주사위 객체
    Dice d2; // 주사위게임에서 사용될 두 번째 주사위 객체
    int num; // 주사위 게임에서 상황에 따라 사용되는 숫자(num에 따라 출력문이 달라짐)

    DiceGame(String c1, String c2, int goalScore){ // 두 자료를 넣어줌
        score = new int[2];
        d1 = new Dice(c1);
        d2 = new Dice(c2);
        GOALSCORE = goalScore;
        r = new Random();
        num = 1;
        turn = 0;
    }

    void startGame(){
        //주사위를 굴림
        printGameSituation(num++); // 여기선 1출력 이후부턴 2출력(후치)
        turn++;
        while(score[0] < GOALSCORE && score[1] < GOALSCORE){ // 점수가 GOALSCORE에 못미쳤다면 반복
            score[0]+=d1.rollDice(r); // 첫 번째 주사위 누적점수에 첫 번째 주사위의 눈금을 더해줌
            score[1]+=d2.rollDice(r); // 두 번째 주사위 누적점수에 두 번째 주사위의 눈금을 더해줌
            printGameSituation(num); // 2상황 출력(주사위게임 중)
            turn++;
        }
        printGameSituation(++num);//전치로 미리 더해줌 메소드 인자로 num이 3인채로 들어감
        //GOALSCORE에 도달하면 종료
    }

    void printGameSituation(int num){ // 숫자 넣어주면 상황에 맞게 출력
        if(num == 1){ // 초기상황
            System.out.println("주사위 게임 시작입니다.\n"+d1.color+"주사위와 "+d2.color+"주사위를 던집니다.\n");
        }else if(num == 2){ // 진행상황
            System.out.println("=========[현재 "+turn+"턴]==========");
            System.out.println(d1.color+"주사위의 눈이 "+ d1.diceFace+"가 나왔습니다");
            System.out.println(d2.color+"주사위의 눈이 "+ d2.diceFace+"가 나왔습니다");
            System.out.println("현재 "+d1.color+"의 누적 눈 : "+score[0]);
            System.out.println("현재 "+d2.color+"의 누적 눈 : "+score[1]);
        }else{//게임 종료
            System.out.println("주사위게임이 종료되었습니다.");
            if(score[0] > score[1]){
                System.out.println(d1.color+"주사위가 먼저 목표점수에 도달했습니다.");
            }else if(score[0] < score[1]){
                System.out.println(d2.color+"주사위가 먼저 목표점수에 도달했습니다.");
            }else{
                System.out.println("비겼습니다");
            }
        }
    }


    }

public class Q1 {
    public static void main(String[] args) {
        //여기서는 다이스게임 객체 만들어서
        //다이스게임 객체 . startGame()메소드 실행
        DiceGame dg = new DiceGame("파랑","빨강",50);
        dg.startGame();
    }
}
