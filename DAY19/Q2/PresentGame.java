package WEEK05.DAY19.Q2;

import java.util.ArrayList;
import java.util.Random;

public class PresentGame {

    private Person[] people;
    private Random r;
    private Present[] presents;
    private final int PEOPLE_NUMBER;
    private final int PRESENT_NUMBER;


    PresentGame(int peopleNum, int presentNum,Random r){
        PEOPLE_NUMBER = peopleNum;
        people = new Person[PEOPLE_NUMBER];
        PRESENT_NUMBER = presentNum;
        presents = new Present[PRESENT_NUMBER];
        this.r = r;
    }


    synchronized public int givePresent(){
        while(true) {
            int rNum = r.nextInt(PRESENT_NUMBER);
            if (presents[rNum] != null) {
                System.out.println("이번에 가져간 선물은 " + rNum + "번째 상자");
                return rNum;
            }
        }
    }

    public void findWinner(){
        for(Person p : people){
            for(Present present : p.getPresents()){
                if(present.isWinning){
                    System.out.println("축하합니다." + p.getName() + "의 승리입니다.");
                    return;
                }
            }
        }
    }

    public int getPEOPLE_NUMBER() {
        return PEOPLE_NUMBER;
    }

    public int getPRESENT_NUMBER() {
        return PRESENT_NUMBER;
    }

    public Present[] getPresents() {
        return presents;
    }

    public Person[] getPeople() {
        return people;
    }
}
