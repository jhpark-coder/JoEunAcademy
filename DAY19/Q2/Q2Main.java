package WEEK05.DAY19.Q2;

/*
보물찾기 문제
3명의 사람이 있음
선물상자는 총 100개가 있고 그 중에 하나에 선물이 있음
3명이 선물 요청하면 선물을 주는데 꽝 or 선물을 주게 됨
이 중에 선물을 받는 사람이 나오면 프로그램을 종료하고 누가 선물을 받았는지 출력

 */

import java.util.Random;

public class Q2Main {
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        PresentGame pg = new PresentGame(3,100, r);

        int ranNum = r.nextInt(pg.getPRESENT_NUMBER());
        for(int i = 0 ; i < pg.getPRESENT_NUMBER(); i++){
            if(i == ranNum){
                pg.getPresents()[i] = new Present(true);
            }else{
                pg.getPresents()[i] = new Present();
            }
        }

        for(int i = 0 ; i < pg.getPEOPLE_NUMBER() ; i++){
           pg.getPeople()[i] = new Person(i, pg, r);
        }
        for(int i = 0 ; i < pg.getPEOPLE_NUMBER() ; i++){
            pg.getPeople()[i].start();
        }
        for(int i = 0 ; i < pg.getPEOPLE_NUMBER() ; i++){
            pg.getPeople()[i].join();
        }

        pg.findWinner();

    }
}
