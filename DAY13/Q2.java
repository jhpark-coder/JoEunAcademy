package WEEK03.DAY13;

/*
포켓몬스터 퀴즈
 */

import java.util.Random;
import java.util.Scanner;

class Pokemon{

    String color; // 색깔
    String name; // 이름
    String size; // 크기
    Random r;

    Pokemon(){
        r = new Random();
        this.color = setColor();
        this.name = setName();
        this.size = setSize();
    }

    String setColor(){
        String[] pokeColor = {"노란색","빨간색","파란색","초록색"};
        return pokeColor[r.nextInt(4)];
    }

    String setName(){
        String[] pokeName = {"피카츄","파이리","꼬부기","이상해씨"};
        return pokeName[r.nextInt(4)];

    }

    String setSize(){
        String[] pokeSize = {"대","중","소","미니"};
        return pokeSize[r.nextInt(4)];

    }

}

class MonsterBall{
    Pokemon p;
}

class Trainer {

    String name; // 지우 or 오박사
    MonsterBall[] monsterBalls;

    Trainer(String name, int num){ // 이름과 몬스터볼 가질 수 있는 크기(지우 = 1, 오박사 = 3)
        this.name = name;
        monsterBalls = new MonsterBall[num];
    }

    void tradePokemon(Trainer t1, Trainer t2, int pokeIndex){//t1은 주는사람 t2는 받는 사람
        for(int i = 0 ; i < t2.monsterBalls.length ; i++){
            if(t2.monsterBalls[i] == null){
                t2.monsterBalls[i] = new MonsterBall();
                t2.monsterBalls[i]=t1.monsterBalls[pokeIndex];
                t1.monsterBalls[pokeIndex] = null;
                return;
            }
        }
    }

    void printMypokemon(){
        for(int i = 0 ; i < monsterBalls.length ; i++){
            System.out.printf("%s의 %d번 포켓몬 : %s %s 이고 크기는 %s 입니다.\n",name,i+1,monsterBalls[i].p.color,monsterBalls[i].p.name,
                    monsterBalls[i].p.size);
        }

    }
}

class PocketMonster{

    Scanner sc;

    PocketMonster(){
        sc = new Scanner(System.in);
    }

    void TradeStart(){
        Trainer jiwoo = new Trainer("지우",1);
        Trainer DrO = new Trainer("오박사",3);
        for(int i = 0 ; i < DrO.monsterBalls.length ; i++){
            DrO.monsterBalls[i] = new MonsterBall();
            DrO.monsterBalls[i].p = new Pokemon();
        }

        DrO.printMypokemon();

        System.out.print("1~3번 중에 원하는 포켓몬 하나를 입력해주세요 : ");
        int pokeIndex = innerVaildInteger(sc, 1, 3)-1;

        DrO.tradePokemon(DrO,jiwoo, pokeIndex);

        jiwoo.printMypokemon();

    }

    int innerVaildInteger(Scanner sc, int min, int max){
        while(true){
            if(sc.hasNextInt()){
                int num = sc.nextInt();
                if(num >= min && num <= max){
                    return num;
                }else{
                    System.out.printf("%d와 %d 사이의 값을 입력해주세요.\n",min,max);
                }
            }else{
                System.out.println("올바른 정수값을 입력해주세요.");
                sc.next();
            }
        }
    }

}


public class Q2 {
    public static void main(String[] args) {
            PocketMonster pm = new PocketMonster();
            pm.TradeStart();


    }
}
