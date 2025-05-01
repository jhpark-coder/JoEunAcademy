package WEEK04.DAY16;

interface Repairable{} // 추상메소드가 없더라도 일종의 태그처럼 활용하는 방법

interface Heal{}

class Unit1{

    int attack;

    int hitPoint;

    final int MAX_HP;

    Unit1(int hp, int attack){
        MAX_HP = hp;
        hitPoint = MAX_HP;
        this.attack = attack;
    }
}

class GroundUnit extends Unit1{
    GroundUnit(int hp, int attack){ super(hp, attack);}
}

class AirUnit extends Unit1{
    AirUnit(int hp, int attack){ super(hp, attack);}
}

class Tank extends GroundUnit implements Repairable{
    Tank(){
        super(150, 10);
    }
   @Override
   public String toString() {return "Tank";} //Object class 오버라이딩
}

class SCV extends GroundUnit implements Repairable,Heal{

    SCV() { super(60,5);}

    void repair(Repairable r){
        if(r instanceof Unit1){
            Unit1 u = (Unit1) r;
            if(u != null && u.MAX_HP != u.hitPoint){
                System.out.println(u+"에너지 1증가");
                u.hitPoint++;
            }
        }
    }
}

class Marine1 extends GroundUnit implements Heal{

    Marine1() { super(40, 6);}
}

class Medic extends GroundUnit implements Heal{

    Medic() { super(80,0);}

    void Heal(Heal h){
        if(h instanceof Unit1){
            Unit1 u = (Unit1) h;
            if(u != null && u.MAX_HP != u.hitPoint){
                u.hitPoint += 2;
            }
        }
    }
}


public class TestAbstract {
    public static void main(String[] args) {

        Tank t = new Tank();
        Marine1 marine1 = new Marine1();
        SCV scv = new SCV();
        // scv.repair(marine1); // 마린은 repairable이 없어서 안됨
        t.hitPoint = 20;
        while(t.hitPoint != t.MAX_HP){
            scv.repair(t);
        }

    }
}
