package WEEK04.DAY16.Q2;

import java.util.Random;

public class Battle extends Buff{
    private Random r;
    private int attackpoint = 0;
    private Knight knight;
    private Villain villain;

    Battle(){
        r = new Random();
        knight = new Knight();
        villain = new Villain();
    }

    void getBuff(Unit u){
        int randomBuff = r.nextInt(3); // 0 ~ 2
        if(randomBuff == 1){
            attackpoint = attackUP(r,u);
        }else if(randomBuff == 2){
            heal(r,u);
        }else{
            injure(r,u);
        }
    }

    void attack(Unit attackUnit, Unit attackedUnit){
        getBuff(attackUnit);
        if(attackUnit.getHp() > 0){
            System.out.println(attackUnit.name + "의 공격!! ");
            attackedUnit.setHp(attackedUnit.getHp() - attackUnit.getAttack());
            System.out.println(attackedUnit.name + "에게 " + attackUnit.getAttack() + " 데미지!!");
            System.out.println(attackedUnit.name + "의 체력이 " + attackedUnit.getHp() + " 남았다.");
            System.out.printf("현재 %s의 공격력/체력 : %d/%s\n", attackUnit.getName(), attackUnit.getAttack(), attackUnit.getHp());
            System.out.printf("현재 %s의 공격력/체력 : %d/%s\n", attackedUnit.getName(), attackedUnit.getAttack(), attackedUnit.getHp());
            System.out.println("==============================================");
            attackUnit.setAttack(attackUnit.getAttack() - attackpoint);
            attackpoint = 0;
        }else{ // 체력 디버프 얻고 사망한 경우
            System.out.println("디버프로 인해 " + attackUnit.getName() + " 사망!!");
        }
    }

    boolean endCheck(Unit u1, Unit u2){ //안끝났으면 무한루프 끝났으면 종료
        if(u1.getHp() <= 0){
            System.out.println(u2.getName()+"의 승");
            return false;
        }else if(u2.getHp() <= 0){
            System.out.println(u1.getName()+"의 승");
            return false;
        }else{
            return true;
        }
    }

    void battleStart(){
        int turn = 1;
        while(endCheck(knight, villain)){
            System.out.println(turn+"번째 경기가 시작됩니다.");
            System.out.println("==============================================");
            if(turn % 2 == 1){
                attack(knight, villain);
            }else{
                attack(villain, knight);
            }
            turn++;
        }
    }
}
