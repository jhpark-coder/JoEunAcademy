package WEEK03.DAY12;

/*
낚시게임을 클래스화시켜주세요
물고기클래스, 호수클래스, 낚시꾼클래스화 해주세요.
호수클래스는 물고기객체배열을 가지고 있음(기본은 null, 물고기는 물고기객체)
 */

import java.util.Random;
import java.util.Scanner;

class Fish{
// 1. 물고기 클래스(낚시게임에 의해 호수 어딘가에 배치되며, 낚시꾼에 의해 낚임)
//추가적인 정보는 필요없음(물고기의 색깔이라던가, 길이라던가 등등이 없으므로)
}

class Lake{
    // 2. 호수 클래스(물고기객체배열을 가지고 있음)
    private Fish[][] fishes; // 물고기객체가 배치되는 2차원 배열의 호수

    public Fish[][] getFishes() { // 나중에 여기 물고기가 있는지 체크하기 위해 사용
        return fishes;
    }

    public void setFishes(int i1, int i2) {
        fishes[i1][i2] = new Fish(); // 특정위치에 물고기객체를 넣어줌
    }

    public int fishingFishes(Fish[] fishes, int index, int i1, int i2){
        fishes[index+1] = this.fishes[i1][i2];
        this.fishes[i1][i2] = null;
        return index++;
    }

    Lake(int num){
        fishes = new Fish[num][num]; // 처음에 num * num 크기로 초기화해줌(다만 이때는 null값임)
    }

}

class Fisher{

    private int[] rodXY = new int[2]; // 낚싯대 좌표 XY
    // 3. 낚시꾼 클래스(낚싯대를 던지고, 낚싯대를 옮기는 함수를 가짐)
    private Fish[] fishes;
    int lastFishIndex;

    Fisher(int num){
        fishes = new Fish[num];
        lastFishIndex = -1;
    }
    public void setRodXY(int x, int y){
        rodXY[0] = x;
        rodXY[1] = y;
    }

    public int[] getRodXY(){
        return rodXY;
    }


    public int castingRod(Lake lake, int[] rodXY,int countFish){// 낚싯대 던지기
        if(lake.getFishes()[rodXY[0]][rodXY[1]] != null) {
            lake.fishingFishes(fishes, lastFishIndex, rodXY[0], rodXY[1]); // 낚음
            return --countFish; // 한마리 낚았다고 게임한테 알려줌
        }else return countFish;

    }

    public int moveRod(Lake lake,int num, int fishcount){//낚싯대 옮기기
        if(num == 1){
            if(rodXY[0] > 0){
                //낚싯대 왼쪽으로 옮기기
                rodXY[0]--;
                if(checkLake(lake,rodXY)){
                    lake.fishingFishes(fishes, lastFishIndex, rodXY[0], rodXY[1]);
                    System.out.println("잡았다!!");
                    fishcount--;
                }
            }else{
                System.out.println("거긴 호수 밖이라 못움직여");
            }
        }else if(num == 2){
            if(rodXY[0] < lake.getFishes().length-1){
                rodXY[0]++;
                if(checkLake(lake,rodXY)){
                    lake.fishingFishes(fishes, lastFishIndex, rodXY[0], rodXY[1]);
                    System.out.println("잡았다!!");
                    fishcount--;
                }
            }else{
                System.out.println("거긴 호수 밖이라 못움직여.");
            }
        }else if(num == 3){
            if(rodXY[1] > 0){
                rodXY[1]--;
                if(checkLake(lake,rodXY)){
                    lake.fishingFishes(fishes, lastFishIndex, rodXY[0], rodXY[1]);
                    System.out.println("잡았다!!");
                    fishcount--;
                }
            }else{
                System.out.println("거긴 호수 밖이라 못움직여.");
            }

        }else{
            if(rodXY[1] < lake.getFishes().length-1){
                rodXY[1]++;
                if(checkLake(lake,rodXY)){
                    lake.fishingFishes(fishes, lastFishIndex, rodXY[0], rodXY[1]);
                    System.out.println("잡았다!!");
                    fishcount--;
                }
            }else{
                System.out.println("거긴 호수 밖이라 못움직여.");
            }

        }
        return fishcount;
    }

    public boolean checkLake(Lake lake, int[] xy){
        if(lake.getFishes()[xy[0]][xy[1]] != null){
            return true; // 물고기 있는거임
        }else return false; // 물고기 없는거임

    }

}

class FishGame{
    // 4. 낚시게임 클래스(물고기를 호수 어딘가에 풀어두는 역할)
    // 낚시꾼이 물고기가 있는 위치에 낚싯대를 던지거나
    // 낚시꾼이 물고기가 있는 위치에 낚싯대를 옮기면 처리해줌
    final int LAKE_LENGTH; //호수 길이
    final int MAX_FISH; // 물고기 최대 수
    int nowFishCount; // 현재 물고기 수
    Scanner sc;

    FishGame(int l, int m){
        LAKE_LENGTH = l; // 입력받은 길이로 호수 초기화
        MAX_FISH = m; // 입력받은
        nowFishCount = 0;
        sc = new Scanner(System.in);
    }

    public void fishingGameStart(){ //낚시게임 시작
        //호수 객체를 만듬
        Lake lake = new Lake(LAKE_LENGTH); // 호수 하나 만들면 호수 안의 물고기 2차원 배열이 초기화(null로)
        //물고기 풀어두는 함수를 씀
        releaseFishes(lake);
        //물고기 없어질때까지 낚싯대 던지고, 옮겨서 물고기 건지는 거 체크함
        //다 건지면 종료함

        Fisher fi = new Fisher(MAX_FISH);

        while(nowFishCount > 0){
            printLake(lake);
            int i1 = isValidNumber(sc, "낚싯대를 던지길 원하시는 X좌표를 입력해주세요 : ", 0, LAKE_LENGTH);
            int i2 = isValidNumber(sc, "낚싯대를 던지길 원하시는 Y좌표를 입력해주세요 : ",0,LAKE_LENGTH);
            fi.setRodXY(i1, i2);
            int temp = nowFishCount;
            System.out.printf("temp : %d\n",temp);
            nowFishCount = fi.castingRod(lake, fi.getRodXY(), nowFishCount);
            if(temp > nowFishCount) {
                continue;
            }
            temp = nowFishCount;
            while(temp == nowFishCount) {
                printLake(lake, fi.getRodXY());
                int num = isValidNumber(sc, "낚싯대를 옮기실 방법을 알려주세요 1. 위, 2. 아래, 3. 왼쪽, 4. 오른쪽 : ", 1, 4);
                nowFishCount = fi.moveRod(lake, num, nowFishCount);
            }
        }
        printLake(lake);
        System.out.println("낚시게임 종료");

    }

    //물고기 풀어두는 함수
    public void releaseFishes(Lake lake){
        Random r = new Random();
        int i1;
        int i2;
        while(nowFishCount < MAX_FISH){
            i1 = r.nextInt(LAKE_LENGTH);
            i2 = r.nextInt(LAKE_LENGTH);
            if(lake.getFishes()[i1][i2] == null){
                lake.setFishes(i1, i2);
                nowFishCount++;
            }
        }
    }
    //낚시꾼이 던지고 있는 낚싯대 위치 체크하는 함수
    //물고기 위치랑 낚싯대 위치가 같으면 물고기 호수에서 건져주는 함수
    //상황별로 출력하는 함수(처음에 시작합니다, 중간에 옮겨주세요, 다했으면 끝났습니다.)
    //호수 상태 보여주는 함수

    public void printLake(Lake lake){
        for(int i = 0 ; i < lake.getFishes().length ; i++){
            for(int j = 0 ; j < lake.getFishes()[i].length ; j++){
                if(lake.getFishes()[i][j] == null){
                    System.out.print("🟦");
                }else{
                    System.out.print("🐟");
                }
            }
            System.out.println();
        }
    }

    public void printLake(Lake lake, int[] rodXY){
        for(int i = 0 ; i < lake.getFishes().length ; i++){
            for(int j = 0 ; j < lake.getFishes()[i].length ; j++){
                if(i == rodXY[0] && j == rodXY[1]){
                    System.out.print("🎣");
                }else{
                    if(lake.getFishes()[i][j] == null){
                        System.out.print("🟦");
                    }else{
                        System.out.print("🐟");
                    }
                }
            }
            System.out.println();
        }
    }

    public int isValidNumber(Scanner sc, String prompt, int min, int max){

        System.out.print(prompt);
        int num;
        while(true){
            if(sc.hasNext()) {
                num = sc.nextInt();
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.printf("%d와 %d 사이의 올바른 정수값을 입력해주세요 : ", min, max);
                }
            }
        }
    }

}

public class Q2 { //낚시게임 클래스화 문제
    public static void main(String[] args) {
        FishGame fg = new FishGame(5,3);
        fg.fishingGameStart();
    }
}
