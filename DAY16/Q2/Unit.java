package WEEK04.DAY16.Q2;

public abstract class Unit {

    String name;
    int attack;
    int hp;

    Unit(String name, int attack, int hp){
        this.name = name;
        this.attack = attack;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
