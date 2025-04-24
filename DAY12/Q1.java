package WEEK03.DAY12;

/*
마피아 게임
시민 5명이 있습니다.
그 중에 1명이 마피아가 됩니다.
경찰은 번호를 받는 객체입니다.

시민이면 print
억울합니다. 저는 마피아가 아닙니다.

마피아면 print
네 제가 마피아입니다.

 */

import java.util.Random;
import java.util.Scanner;

class Citizen{

    boolean isMafia; //마피아여부 변수를 가짐

    Citizen(){
        isMafia = false;
    }
    Citizen(boolean im){
        isMafia = im;
    }

    //마피아면 억울합니다. 네 제가 마피아입니다.
    //마피아가 아니면 저는 마피아가 아닙니다.
    boolean printMafiaOrNot(int num){
        if(isMafia){
            System.out.println(num+1+"번 시민) 네 제가 마피아입니다.");
            return false;
        }
        else{
            System.out.println(num+1+"번 시민) 억울합니다. 저는 마피아가 아닙니다.");
            return true;
        }
    }
}

class Police{
    //마피아인지 묻는 메소드
    int areYouMafia(Scanner sc){
        System.out.print("경찰) 마피아는 몇 번일까요? : ");
        return isVaildNumber(sc, 1, 5);
    }

    int isVaildNumber(Scanner sc, int min, int max){
        while(true){
            if(sc.hasNext()) {
                int num = sc.nextInt();
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.print("경찰) 숫자를 다시 입력해주세요. : ");
                }
            }
        }
    }
}

class MafiaGame{

    final int MAFIAGAMERS = 5; // 5명이 게임함
    final int MAFIA = 1; // 1명이 마피아임
    Scanner sc = new Scanner(System.in);
    Citizen[] citizens;
    Police p;


    MafiaGame(){
        citizens = new Citizen[MAFIAGAMERS];
        setCitizens();
        p = new Police();
    }

    void setCitizens(){
        Random r = new Random();
        int designateMafia = r.nextInt(5);
        for(int i = 0 ; i < citizens.length ; i++){
            if(i == designateMafia){
                citizens[i] = new Citizen(true);
            }else {
                citizens[i] = new Citizen();
            }
        }
    }

    void playMafiaGame(){
        boolean endflag = true;
        System.out.println("마피아게임 시작입니다.");
        int num;
        while(endflag){
            num = p.areYouMafia(sc)-1;
            endflag = citizens[num].printMafiaOrNot(num);
        }
    }
}
public class Q1 {
    public static void main(String[] args) {
        MafiaGame mg = new MafiaGame();
        mg.playMafiaGame();
    }
}
