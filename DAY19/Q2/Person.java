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
        while(true){
            System.out.print(getName()+"이 가져감 ");
            int index = pg.givePresent();
            Present p = pg.getPresents()[index];
            presents.add(p);
            if(p.isWinning){
                break;
            }
            pg.getPresents()[index] = null;

        }

    }

    public ArrayList<Present> getPresents() {
        return presents;
    }
}
