package WEEK04.DAY15;

/*
스타크래프트문제                        타겟 = 공격 가능한 유형 / 유형 = 유닛 본인의 속성
유닛 - 가격(미네랄), 에너지(체력), 공격력, 방어력, 타겟, 이동속도, 유형
저글링 - 50, 35, 5, 0, 지상, 2.612, "지상, 소형, 생체"
히드라 - 100, 80, 10, 0, "지상, 공중", 1.741, "지상, 중형, 생체"
마린 - 50, 50, 6, 0, "지상, 공중", 1.875, "지상, 소형, 생체"
저글링, 히드라, 마린은 프린트 함수가 있습니다.

처음 시작시 출력
"히드라의 생산비용은 미네랄 " + super.price + ", 체력 " + super.hp + ", 공격력 " + super.attack + ", 방어력 " + super.defense + ", 공격대상 " + super.target +
", 이동속도 " + super.speed + ", 유닛 특성 " + super.characteristic + "입니다."


마린 3마리 vs 저글링 1마리 히드라 1마리

공격을 맞는건 마린 1번, 저글링 부터
공격을 하면 (마린 1번이 저글링을 공격합니다)
(저글링이 마린 1번을 공격합니다)

 */

abstract class Unit{ // 유닛 클래스
    protected int price; // 유닛 생산 비용
    protected int hp; // 유닛 체력
    protected int attack; // 유닛 공격력
    protected int defense; // 유닛 방어력
    protected String target; // 유닛의 공격가능타입
    protected double speed; // 유닛의 속도
    protected String characteristic;

    abstract void printCreateUnitPrice();

}

class Zergling extends Unit{

    Zergling(){
        setZergling();
    }

    private void setZergling(){
        super.price = 50;
        super.hp = 35;
        super.attack = 5;
        super.defense = 0;
        super.target = "지상";
        super.speed = 2.612;
        super.characteristic = "지상, 소형, 생체";
    }

    @Override
    void printCreateUnitPrice(){
        System.out.println("저글링의 생산비용은 미네랄 " + super.price + ", 체력 " + super.hp + ", 공격력 " + super.attack + ", 방어력 " + super.defense + ", 공격대상 " + super.target +
                        ", 이동속도 " + super.speed + ", 유닛 특성 " + super.characteristic + "입니다.");
    }

}

class Hydralisk extends Unit{

    Hydralisk(){
        setHydralisk();
    }

    private void setHydralisk(){
        super.price = 100;
        super.hp = 80;
        super.attack = 10;
        super.defense = 0;
        super.target = "지상, 공중";
        super.speed = 1.741;
        super.characteristic = "지상, 중형, 생체";
    }


    @Override
    void printCreateUnitPrice(){
        System.out.println("히드라의 생산비용은 미네랄 " + super.price + ", 체력 " + super.hp + ", 공격력 " + super.attack + ", 방어력 " + super.defense + ", 공격대상 " + super.target +
                ", 이동속도 " + super.speed + ", 유닛 특성 " + super.characteristic + "입니다.");
    }

}

class Marine extends Unit{

    Marine(){
        setMarine();
    }

    private void setMarine(){
        super.price = 50;
        super.hp = 50;
        super.attack = 6;
        super.defense = 0;
        super.target = "지상, 공중";
        super.speed = 1.875;
        super.characteristic = "지상, 소형, 생체";
    }

    @Override
    void printCreateUnitPrice(){
        System.out.println("마린의 생산비용은 미네랄 " + super.price + ", 체력 " + super.hp + ", 공격력 " + super.attack + ", 방어력 " + super.defense + ", 공격대상 " + super.target +
                ", 이동속도 " + super.speed + ", 유닛 특성 " + super.characteristic + "입니다.");
    }
}


class Starcraft{

    private Unit[] terrans;
    private Unit[] zergs;
    private int attackTerranUnitIndex; // 0 1 2
    private int attackZergUnitIndex;


    Starcraft(){
        terrans = new Unit[3]; // 테란은 유닛 3개 가짐
        zergs = new Unit[2]; // 저그는 유닛 2개 가짐
        attackTerranUnitIndex = 0; // 처음에 때리는 테란 유닛은 0번째 친구임
        attackZergUnitIndex = 0;  // 처음에 때리는 저그 유닛은 0번째 친구임
    }

    int attack(Unit[] attack, Unit[] attacked, int attackIndex){

        while(true){
            if(attack[attackIndex] == null){
                attackIndex = (attackIndex + 1 ) % attack.length;
            }else break;
        }

        int j; // 맞는애 인덱스 체크해줬음
        for(j = 0 ; j < attacked.length ; j++){ // 맞는애는 널이 아닌 처음 친구
            if(attacked[j] != null) {
                break;
            }
        }
            String attackUnit;
            String attackedUnit;

            if (attack[attackIndex] instanceof Marine) {
                attackUnit = "마린 "+(attackIndex+1);
            } else if (attack[attackIndex] instanceof Zergling) {
                attackUnit = "저글링";
            }
            else {
                attackUnit = "히드라";
            }

            if (attacked[j] instanceof Marine) {
                attackedUnit = "마린 "+(j+1);
            } else if (attacked[j] instanceof Zergling)
                attackedUnit = "저글링";
            else {
                attackedUnit = "히드라";
            }

            String prompt = attackUnit + "이(가) " +attackedUnit + "을(를) 공격합니다.";

            System.out.println(prompt);
            attacked[j].hp = attacked[j].hp - (attack[attackIndex].attack - attacked[j].defense);
            System.out.println("- "+attackedUnit+"의 남은 체력 : "+attacked[j].hp);
            if (attacked[j].hp <= 0) {
                System.out.println("["+attackedUnit+"이(가) 사망했습니다.]");
                attacked[j] = null;
                System.out.println();
            }

            return (attackIndex + 1 ) % attack.length;

    }

    void startGame(){
        terrans[0] = new Marine();
        terrans[1] = new Marine();
        terrans[2] = new Marine();

        zergs[0] = new Zergling();
        zergs[1] = new Hydralisk();

        //terrans[0].printCreateUnitPrice();
        //zergs[0].printCreateUnitPrice();
        //zergs[1].printCreateUnitPrice();

        int flag = 1; //1. 테란 공격 2. 저그 공격
        //어느 한쪽이 null이 될때까지 반복
        while(nullCheck(terrans) && nullCheck(zergs)){
            if(flag == 1) // 테란 공격
            {
                attackTerranUnitIndex = attack(terrans, zergs, attackTerranUnitIndex); // 때리는 애 인덱스를 줘야함 맞는 애는 항상 맨 앞
                flag++;

            }else{ // 저그 공격
                attackZergUnitIndex = attack(zergs, terrans, attackZergUnitIndex); // 때리는 애 인덱스를 줘야함 맞는 애는 항상 맨 앞
                flag--;
            }
        }

        if(!nullCheck(zergs)){
            System.out.println("☆☆☆테란의 승리입니다.☆☆☆");
        }
        if(!nullCheck(terrans)){
            System.out.println("☆☆☆저그의 승리입니다.☆☆☆");
        }
    }

    boolean nullCheck(Unit[] units){ //유닛이 다 떨어진 진영인지 아닌지 체크용
        for(int i = 0 ; i < units.length ; i++){
            if(units[i] != null){
                return true; // 안 비었으면(유닛이 남아있으면) 계속 루프 돌아야해서 트루 줌
            }
        }
        return false; // 비었으면 그만해야되서 false 줌
    }
}

public class Q3 {
    public static void main(String[] args) {
        Starcraft s = new Starcraft();
        s.startGame();
    }
}
