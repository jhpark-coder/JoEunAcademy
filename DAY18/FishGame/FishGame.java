package P20250504.FishGame;

import java.util.Random;
import java.util.Scanner;

import static P20250504.FishGame.Toolbox.inputRightNumber;

public class FishGame {
    private Lake lake;
    private Scanner sc;

    FishGame(){
        sc = new Scanner(System.in);
    }

    public void gameStart(){

        System.out.println("어서오세요 낚시게임에 오신 걸 환영합니다.");
        //호수 생성
        createLake();
        //호수에 물고기 배치
        //게임 시작
        Fisher fs = new Fisher(sc);

        while(fs.getFishingPort().size() < lake.getMAX_FISHES()){
            //1 호수에 낚싯대 던지기
                fs.casting(lake.getFishes().length - 1);
                if (isCaughtFish(fs.getFloatLocationXY(), fs)) {
                    printLake("물고기를 잡았습니다!");
                    continue;
                } else {
                    boolean gotcha = false;
                    while(!gotcha) {
                        printLake(fs.getFloatLocationXY());
                        fs.relocating(lake.getFishes().length - 1);
                        if (isCaughtFish(fs.getFloatLocationXY(), fs)){
                            printLake("물고기를 잡았습니다!");
                            gotcha = true;
                        }
                }
            }
        }

        System.out.println("모든 물고기를 잡았습니다. 게임이 종료됩니다");

        //1-1. 낚싯대에 물고기가 낚인 경우(위치가 같은경우) -> 물고기 낚고 다시 던지게 함
        //1-2. 낚싯대에 물고기가 낚이지 않은 경우(위치가 다른 경우) -> 낚시 찌를 옮기게함
        //1-2-1. 옮기고 물고기가 낚인 경우 -> 물고기 낚고 다시 던지게 함
        //1-2-2. 물고기가 낚이지 않은 경우 -> 낚일때까지 낚시 찌 옮기게 함
        //물고기 배치 후, 낚싯대 던진 후, 낚인 후 모두 호수 상태를 출력해주기

    }

    private void createLake(){

        int size = inputRightNumber("원하시는 호수의 크기를 적어주세요(3 입력시 3 x 3 크기 호수 생성) : ", sc);
        int maxfish = inputRightNumber("원하시는 물고기 수를 입력해주세요",1,size*size, sc);
        lake = new Lake(size, maxfish);
        Random r = new Random();
        while(lake.getFishCount() < lake.getMAX_FISHES()){
            int i1 = r.nextInt(size);
            int i2 = r.nextInt(size);
            if(lake.getFishes()[i1][i2] == null){
                lake.setFishes(i1,i2,new Fish());
                lake.updateFishCount(1); // +1
            }
        }

        System.out.println("호수 생성 후 물고기 배치 완료");
        printLake();



    }

    private void printLake(){
        for(int i = 0 ; i < lake.getFishes().length; i++){
            for(int j = 0 ; j < lake.getFishes()[i].length ; j++){
                if(lake.getFishes()[i][j] != null){
                    System.out.print("🐟");
                }else{
                    System.out.print("🟦");
                }
            }
            System.out.println();
        }
    }

    private void printLake(int[] xy){
        for(int i = 0 ; i < lake.getFishes().length; i++){
            for(int j = 0 ; j < lake.getFishes()[i].length ; j++){
                if(i == xy[0] && j == xy[1]){
                    System.out.print("🎣");
                }
                else if(lake.getFishes()[i][j] != null){
                    System.out.print("🐟");
                }else{
                    System.out.print("🟦");
                }
            }
            System.out.println();
        }
    }

    private void printLake(String temp){
        System.out.println(temp);
        for(int i = 0 ; i < lake.getFishes().length; i++){
            for(int j = 0 ; j < lake.getFishes()[i].length ; j++){
                if(lake.getFishes()[i][j] != null){
                    System.out.print("🐟");
                }else{
                    System.out.print("🟦");
                }
            }
            System.out.println();
        }
    }

    public boolean isCaughtFish(int[] xy, Fisher fs){
        if(lake.getFishes()[xy[0]][xy[1]] != null){
            fs.getFishingPort().add(lake.getFishes()[xy[0]][xy[1]]);
            System.out.println("어부의 어창 속 물고기 수 : "+fs.getFishingPort().size());
            lake.setFishes(xy[0],xy[1],null);
            lake.updateFishCount(-1);
            return true;
        }else{
            return false;
        }
    }
}
