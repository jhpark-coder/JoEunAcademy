package WEEK05.DAY18.Q1;

public class Account {
    private int money; // 누적 모금액

    Account(){
        money = 0; // 초기값 = 0(안해줘도 되긴하는데 명시적으로 작성했음)
    }

    synchronized void donateMoney(){ // 기부 받기
        money += 1000; // 기부액 천원 받음
    }

    synchronized public int getMoney(){ // 현재 모금액 리턴해줌
        return money;
    }
}
