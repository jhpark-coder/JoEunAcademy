package WEEK05.DAY19.Q2;

import java.util.ArrayList;
import java.util.Random;

public class Person extends Thread{

    private PresentGame pg;
    private Random r;
    private ArrayList<Present> presents;

    Person(int index, PresentGame pg, Random r){
        setName((index+1)+"번 사람");
        this.pg = pg;
        this.r = r;
        presents = new ArrayList<>();
    }

    @Override
    public void run() {
        while(pg.getGivePresentCount() < pg.getPRESENT_NUMBER()){
            Present p = pg.sendPresent(this);
            if(p!= null && p.isWinning){
                System.out.print(getName()+"이 진짜 선물 가져감");
                break;
            }
        }

    }

    public ArrayList<Present> getPresents() {
        return presents;
    }
}
