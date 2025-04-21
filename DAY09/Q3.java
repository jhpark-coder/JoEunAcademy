package WEEK03.DAY09;

import java.util.Random;
import java.util.Scanner;

/*
낚시게임을 함수화로 구현하세요
함수화 진행시 함수 하나에 하나의 기능만 존재하도록 구현
메인 함수는 명령어가 하나여야함.

 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        runFishingGame(sc);
    }

    static void runFishingGame(Scanner sc) {
        //5x5호수 생성(boolean lake[5][5]
        int n = 5;// 호수 크기
        boolean[][] lake = createLake(n);
        int count = 0;
        //호수에 물고기 3마리 존재(int count)
        //물고기는 랜덤한 자리에 위치(중복 x)
        int[] xy = new int[2];
        count = placeFish(count,lake);
        noCastingPrintLake(lake);
        //낚시게임 시작
        mainGame(sc, lake,xy,count);
        // 낚시바늘의 위치와 물고기 위치가 같아지면 물고기를 잡음
        // 빈공간은 ○ 현재 위치는 X 물고기 위치는 ●으로 표시
        //물고기를 3마리 다 잡으면 게임 종료
        sc.close();
    }

    private static void mainGame(Scanner sc, boolean[][] lake, int[] xy, int count) {
        while (count > 0) {
            // 1. 미끼 던지기
            System.out.printf("\n남은 물고기: %d 마리\n", count);
            castingRod(sc, xy); // xy 배열에 캐스팅 위치 저장

            // 2. 던진 직후 확인
            int previousCount = count;
            count = checkRod(xy, lake, count); // 잡았으면 count 감소 및 메시지 출력
            printLake(xy, lake); // 현재 상태 출력

            // 3. 던지자마자 잡았으면 다음 턴 (새로운 캐스팅)
            if (count < previousCount) {
                continue; // while(count > 0) 루프의 다음 반복으로 넘어감
            }

            // 4. 못 잡았으면 이동 시작 (내부 루프)
            while (true) { // 이동 루프
                // 5. 이동 방향 입력 받기 (0 입력 시 다시 캐스팅)
                System.out.println("이동할 방향을 입력하세요: 1(위), 2(아래), 3(왼쪽), 4(오른쪽), 0(다시 던지기)");
                int moveInput = inputCorrectNumber(sc, "입력: ", 0, 4);

                if (moveInput == 0) {
                    System.out.println("미끼를 다시 던집니다.");
                    break; // 이동 루프 탈출 -> 외부 while문으로 가서 새 캐스팅 시작
                }

                // 6. 낚싯바늘 이동
                xy = correctMove(xy, moveInput, lake); // xy 좌표 업데이트

                // 7. 이동 후 확인
                previousCount = count;
                count = checkRod(xy, lake, count); // 이동한 위치 확인
                printLake(xy, lake); // 이동 후 상태 출력

                // 8. 이동 후 잡았으면 이동 루프 탈출 -> 외부 while문으로 가서 새 캐스팅 시작
                if (count < previousCount) {
                    break; // 이동 루프 탈출
                }

                // 9. 모든 물고기를 다 잡았으면 게임 종료 (이동 중에도 체크)
                if (count == 0) {
                    return; // mainGame 함수 종료
                }
                // 못 잡았으면 이동 루프 계속 (while(true) 처음으로)
            }
        }
            // 내부 이동 루프(while(true))가 break로 끝나면 여기로 옴
            // -> 외부 while(count > 0) 루프의 다음 반복으로 가서 새 캐스팅 시작
    }

    static int checkRod(int[] xy, boolean[][] lake,int count) { //낚싯바늘하고 물고기 위치 같은지 확인
        if(lake[xy[0]][xy[1]])
        {
            System.out.println("물고기를 잡았습니다!!");
            lake[xy[0]][xy[1]] = false; //같을 때 false로 바꾸고 카운트--
            count--;
            System.out.printf("count : %d\n",count);
            //printLake(xy,lake);
        }
        return count;
    }

    static boolean[][] createLake(int n) {
        boolean[][] lake = new boolean[n][n];
        return lake;
    }

    static int placeFish(int count,boolean[][] lake){ //물고기 위치시키기
        Random r= new Random();//랜덤함수 이용하여 랜덤한 위치 넣기
        while(count < 3){ // 3마리가 안채워졌다면 반복
            int i = r.nextInt(5);
            int j = r.nextInt(5);
            if(!lake[i][j]){
                lake[i][j] = true;
                count++;
            }
        }

        return count;
    }

    static void castingRod(Scanner sc, int[] xy){ //낚싯대 던지기
        xy[0] = inputCorrectNumber(sc, "행 입력 : ",0,4);
        xy[1] = inputCorrectNumber(sc, "열 입력 : ",0,4);
    }

    static int inputCorrectNumber(Scanner sc, String prompt, int min, int max){
        int num;
        while(true){
            System.out.print(prompt);
            if(sc.hasNextInt()){
                num = sc.nextInt();
                if(num >= min && num <= max) {
                    return num;
                }else{
                    System.out.printf("%d와 %d 사이의 값을 입력해주세요\n",min,max);
                }
            }else{
                System.out.println("%d와 %d 사이의 정수를 입력해주세요\n");
                sc.next();
            }

        }

    }

    static int[] correctMove(int[] xy, int inputNum,boolean[][] lake){
        switch(inputNum){
        case 1: // 위로 가기
            if(xy[0] > 0)
                xy[0]--;
            else System.out.println("잘못된 입력입니다.");
            break;
        case 2: // 아래로 가기
            if(xy[0] < lake[0].length-1)
                xy[0]++;
            else System.out.println("잘못된 입력입니다.");
            break;
        case 3://왼쪽으로 가기
            if(xy[1] > 0)
                xy[1]--;
            else System.out.println("잘못된 입력입니다.");
            break;
        case 4://오른쪽으로 가기
            if(xy[1] < lake.length-1)
                xy[1]++;
            else System.out.println("잘못된 입력입니다.");
            break;
        default:
            System.out.println("1~4 사이의 값을 입력해주세요.");
    }
    return xy;

    }
    static void noCastingPrintLake(boolean[][]lake){
        for(int i = 0 ; i < lake.length ; i++){
            for(int j = 0 ; j < lake[i].length ; j++){
                if(lake[i][j]){ //낚싯대 위치
                    System.out.print("●");
                }else{ //빈 호수
                    System.out.print("○");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    static void printLake(int[]xy, boolean[][]lake){
        for(int i = 0 ; i < lake.length ; i++){
            for(int j = 0 ; j < lake[i].length ; j++){
                if(i == xy[0] && j == xy[1]) //낚싯대 위치
                    System.out.print("X");
                else if(lake[i][j]){ //물고기 있다
                    System.out.print("●");
                }else{ //빈 호수
                    System.out.print("○");
                }
            }
            System.out.println();
        }
        System.out.println();
    }



}
