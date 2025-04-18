package DAY07;

import java.util.Random;
import java.util.Scanner;

/*
낚시게임
5x5호수가 있다
호수에는 물고기 3마리가 있다.
물고기는 랜덤한 좌표에 위치해있다.(중복위치 x)
위치가 지정되면 낚시게임 시작

낚시꾼은 미끼가 달린 바늘을 던짐
(좌표의 범위를 벗어나지 않게 던져야함)

좌표범위를 넘으면 다시 캐스팅해달라는 출력을 해야함
1. 위
2. 아래
3. 왼쪽
4. 오른쪽
명령을 받아서 낚시바늘 위치를 이동

낚시바늘의 위치와 물고기의 위치가 같아지면 물고기를 잡게 됨

//빈공간은 O
//현재 위치는 X
//물고기 위치는 검은색으로 표시

//다 잡으면 게임 종료

 */
public class Q3 {
    public static void main(String[] args) {
        //5x5호수가 있다.
        boolean[][] lake = new boolean[5][5]; // 호수 5x5짜리 만들기

        Scanner sc = new Scanner(System.in);//나중에 낚시바늘 입력받기 위해 스캐너 객체 선언

        Random r = new Random();//랜덤으로 넣기 위해 랜덤객체 생성
        //물고기가 3마리 있다.
        //호수에 물고기 3마리를 넣는다.(중복 불가)

        /*
        int[] fish = new int[3]; //물고기 3마리의 위치(단일인덱스 활용해서 작성하면 됨) 0~24
        for(int i = 0 ; i < fish.length ; i++)//3번 입력받음
        {
            fish[i] = r.nextInt(25); // 랜덤값 받음
            //만약 중복이 있다면 i 인덱스를 -1해줘서 다시 받게 함
            for(int j = 0 ; j < i ; j++)
            {
                if(fish[i] == fish[j]) {
                    i--;
                }
            }
        }



        // 물고기 3마리를 넣어줌
        for(int i = 0 ; i < fish.length ; i++){
           lake[fish[i]/5][fish[i]%5] = true;
        }
        */
        int count = 0; //남은 물고기 수

        for(int i = 0 ; i < 3 ; i++)
        {
            int i1 = r.nextInt(5);
            int i2 = r.nextInt(5);
            if(!lake[i1][i2]) { // 비었으면 기본이 false상태, !했으니 기본이 true 차있으면 false)
                lake[i1][i2] = true; // 물고기 위치로 지정하고(lake[i1][i2]를 true로 바꿔주고) 횟수 1감소
                i--;
                count++;
            }
        }

        //물고기 3마리 잘 들어간거 체크
        for(int i = 0 ; i < lake.length ; i++){
            for(int j = 0 ; j < lake[i].length ; j++){
                if(lake[i][j])
                    System.out.print("●");
                else
                    System.out.print("○");
            }
            System.out.println();
        }


        while(count > 0){
            // 안잡힌 물고기가 있다면 반복문 계속 돔
            int p1;
            int p2;
            // 낚싯대 던짐 = 좌표를 입력 받음(단, 범위를 벗어나면 안됨)
            while(true) {//올바르게 던질때까지 받음
                System.out.print("낚시바늘을 던질 x 좌표 : ");
                p1 = sc.nextInt();
                System.out.print("낚시바늘을 던질 y 좌표 : ");
                p2 = sc.nextInt();
                if (p1 < 0 || p1 > lake.length - 1 || p2 < 0 || p2 > lake[0].length - 1) {
                    System.out.println("좌표의 범위(0,0~4,4)를 벗어나지 않게 다시 입력해주세요");
                } else {
                    break;
                }
            }

            //물고기를 잡을때까지 무한동작
            while(true) {
                // 출력할 때 현재 위치는 X 아니라면 빈공간은 O 물고기 위치는 검은색 -> if, else
                for(int i = 0 ; i < lake.length ; i++) {
                    for(int j = 0 ; j < lake[i].length ; j++)
                    {
                        if(i == p1 && j == p2) {
                            System.out.print("X");
                        }else if(lake[i][j]) {
                                System.out.print("●");
                        }
                        else {
                            System.out.print("○");
                        }
                    }
                    System.out.println();
                }

                if (lake[p1][p2]) {//던졌을 때 좌표가 같다면
                    //잡힘
                    System.out.println("물고기를 잡았습니다!!");
                    lake[p1][p2] = false;
                    count--;
                    break;
                } else { //다르다면 = 안잡힘 = 낚싯대 위치 옮김(잡힐때까지)

                    //위 아래 왼쪽 오른쪽 명령 받음(범위 넘으면 다시 입력해달라고 함)
                    System.out.println("낚시바늘을 옮길 위치를 알려주세요");
                    System.out.println("1. 위 2. 아래 3. 왼쪽 4. 오른쪽");
                    System.out.print("입력 : ");
                    int command = sc.nextInt(); //1~4까지의 명령을 입력받음
                    //명령을 입력받음
                    switch (command) {
                        case 1: //1. 위 = i-1, j
                            if (p1 - 1 < 0) {// 위로 가면 index(p1)가 배열을 벗어나는 경우
                                System.out.println("좌표 범위를 넘은 명령입니다. 다시 입력해주세요.");
                            } else {
                                p1--;
                            }
                            break;
                        case 2: //2. 아래 = i+1, j
                            if (p1 + 1 >= lake.length) {// 아래로가면 index(p1)가 배열을 벗어나는 경우
                                System.out.println("좌표 범위를 넘은 명령입니다. 다시 입력해주세요.");
                            } else {
                                p1++;
                            }
                            break;
                        case 3: //3. 왼쪽 = i, j-1
                            if (p2 - 1 < 0) {// 왼쪽으로 가면 index(p2)가 배열을 벗어나는 경우
                                System.out.println("좌표 범위를 넘은 명령입니다. 다시 입력해주세요.");
                            } else {
                                p2--;
                            }
                            break;
                        case 4: //4. 오른쪽 = i, j+1
                            if (p2 + 1 >= lake.length) {//오른쪽으로 가면 index(p2)가 배열을 벗어나는 경우
                                System.out.println("좌표 범위를 넘은 명령입니다. 다시 입력해주세요.");
                            } else {
                                p2++;
                            }
                            break;
                        default: // 오입력
                            System.out.println("잘못된 입력입니다. 1~4중에 하나를 입력해주세요");
                            break;
                    }
                }
            }
        }
        //다 잡으면 게임 종료
        System.out.println("낚시게임이 종료되었습니다.");
    }
}
