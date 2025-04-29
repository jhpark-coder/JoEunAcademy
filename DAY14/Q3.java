package WEEK04.DAY14;

/*
원숭이 문제
원숭이는 총 5마리가 있습니다.
원숭이는 상자를 가질 수 있습니다.
원숭이는 각각 색깔이 있습니다.
1번 원숭이 : 빨강 / 2번 원숭이 : 노랑 / 3번 원숭이 : 파랑 / 4번 원숭이 : 초록 / 5번 원숭이 : 검정

(기능 - 메소드) <- 매 주기마다 가지고 있습니다 or 가지고 있지않습니다를 하나씩 다 출력시킴
XX(색) 원숭이가 상자를 가지고 있습니다.
XX(색) 원숭이가 상자를 가지고 있지 않습니다.

2가지 랜덤한 수를 받습니다.
1. 좌(0) / 우(1)
2. 횟수 (1~5)까지 입니다.

게임을 시작합니다.
빨간 원숭이가 상자를 가지고 있습니다.

랜덤값이 1이면 빨 -> 노 -> 파 -> 초 -> 검 우측으로 상자 이동
랜덤값이 0이면 빨 <- 노 <- 파 <- 초 <- 검 좌측으로 상자 이동

 */

import java.util.Random;

class Box{ // 박스는 값이 없음
}

class Monkey{ // 원숭이
    private Box box; // 박스를 가질 수 있음(초기값 null)
    private String color; // 원숭이 색

    Monkey(String color){
        this.color = color; // 원숭이 색 입력받음
        box = null;
    }

    //상자 넘겨주기 함수
    //매개변수로 온 친구한테 넘겨줌
    //본인 소유에서 없어짐(null)
    public void giveBox(Monkey m){
        m.box = this.box;
        this.box = null;
    }

    public void haveBoxPrint(){
        if(box != null){
            System.out.println(color + "색 원숭이가 박스를 가지고 있습니다.");
        }else{
            System.out.println(color + "색 원숭이가 박스를 가지고 있지 않습니다.");
        }
    }

    public void createBox(){
        box = new Box();
    }

}

public class Q3 {
    public static void main(String[] args) {
        Monkey[] monkeys = new Monkey[5];
        String[] monkeysColor = {"빨강","노랑","파랑","초록","검정"};
        for(int i = 0 ; i < monkeys.length ; i++){ // 원숭이 다섯마리 만들어 줌
            monkeys[i] = new Monkey(monkeysColor[i]);
        }
        Random r = new Random();

        int lr = r.nextInt(2); // 0 or 1
        //int lr = 0; // 좌측회전일 때 체크
        int times = r.nextInt(5)+1; // 1~5
        //int times = 5; //5인경우 작동안하는 경우 있어서 체크

        System.out.println("LR : " + lr); // 왼쪽 오른쪽 정하기
        System.out.println("times : " + times); // 반복 횟수 정하기

        monkeys[0].createBox(); // 빨간 원숭이를 상자를 가지고 게임 시작

        for(int i = 0 ; i < monkeys.length ; i++){ // 0번째(바꾸기 전) 위치
            monkeys[i].haveBoxPrint();
        }


        System.out.println(); //구분용 줄바꿈

        if(lr == 1){//오른쪽으로 상자 이동
        for(int i = 0 ; i < times ; i++){
            monkeys[i].giveBox(monkeys[((i+1)%5)]); // i+1한테 i꺼를 줌 i가 i+1한테 줌 // 다만 i+1이 5가 되는 경우, 5대신 0한테 줌( 4 -> 0)

            for(int j = 0 ; j < monkeys.length ; j++){ // 매번 줄때마다 한번씩 쫙 출력해줌
                monkeys[j].haveBoxPrint();
            }
            System.out.println(); //구분용 줄바꿈

            }
        }else{
            for(int i = 5 ; i > 5-times ; i--){
                monkeys[i%5].giveBox(monkeys[i-1]); //monkeys의 index는 0, 4, 3, 2, 1 순 -> 5,4,3,2,1인데 5로 나눈 나머지값

                for(int j = 0 ; j < monkeys.length ; j++){ // 매번 줄때마다 한번씩 쫙 출력해줌
                    monkeys[j].haveBoxPrint();
                }

                System.out.println(); //구분용 줄바꿈
            }
        }
    }
}
