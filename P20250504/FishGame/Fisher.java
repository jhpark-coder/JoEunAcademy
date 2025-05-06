package P20250504.FishGame;

import java.util.ArrayList;
import java.util.Scanner;

import static P20250504.FishGame.Toolbox.inputRightNumber;

public class Fisher {

    private int[] floatLocationXY;
    private ArrayList<Fish> fishingPort;
    private Scanner sc;
    private final static int MOVE_UP = 1;
    private final static int MOVE_DOWN = 2;
    private final static int MOVE_LEFT = 3;
    private final static int MOVE_RIGHT = 4;

    Fisher(Scanner sc){
        floatLocationXY = new int[2];
        fishingPort = new ArrayList<>();
        this.sc = sc;
    }

    public void casting(int maxIndex){
        //낚싯대 던지기
        floatLocationXY[0] = inputRightNumber("내가 어디에 낚싯대를 던지길 원해?(X좌표 입력) : ",0,maxIndex,sc);
        floatLocationXY[1] = inputRightNumber("내가 어디에 낚싯대를 던지길 원해?(Y좌표 입력) : ",0,maxIndex,sc);
    }

    public void relocating(int maxIndex){
        int command = inputRightNumber("내가 어디로 옮길까? 1. 위 2. 아래 3. 왼쪽 4. 오른쪽",MOVE_UP,MOVE_RIGHT,sc);
        if(command == MOVE_UP && floatLocationXY[0] > 0){
                floatLocationXY[0]--;
        }
        else if(command == MOVE_DOWN && floatLocationXY[0] < maxIndex){
                floatLocationXY[0]++;
        }else if(command == MOVE_LEFT && floatLocationXY[1] > 0){
                floatLocationXY[1]--;
        }else if(command == MOVE_RIGHT && floatLocationXY[1] < maxIndex){
                floatLocationXY[1]++;
        }else{
            printOutOfLake();
        }
    }

    public ArrayList<Fish> getFishingPort(){
        return fishingPort;
    }

    public int[] getFloatLocationXY(){
        return floatLocationXY;
    }

    public void printOutOfLake(){
        System.out.println("거긴 호수 밖이야");
    }


}
