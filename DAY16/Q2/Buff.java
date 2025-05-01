package WEEK04.DAY16.Q2;

import java.util.Random;

public abstract class Buff {

    public int attackUP(Random r, Unit u){
        int upPoint = r.nextInt(101)+50;
        u.setAttack(u.getAttack()+upPoint);
        System.out.println("버프 : "+u.name+"의 공격력이 "+upPoint+" 만큼 증가하였다.");
        return upPoint;
    }

    public void heal(Random r, Unit u){
        int upPoint = r.nextInt(301);
        u.setHp(u.getHp()+upPoint);
        System.out.println("버프 : "+u.name+"의 체력이 "+upPoint+" 만큼 증가하였다.");

    }

    public void injure(Random r, Unit u){
        int downPoint = r.nextInt(201)+100;
        u.setHp(u.getHp()-downPoint);
        System.out.println("디버프 : "+u.name+"의 체력이 "+downPoint+" 만큼 감소하였다.");

    }
}
