package WEEK05.DAY18.Q3;

import java.util.Random;

public class Bicycle extends Vehicle implements Booster{

    Random r;

    Bicycle(Random r){
        this.r = r;
    }

    public void printMileage(){
        System.out.println(toString()+"의 주행거리 : " + getMileage());
    }

    public void printGauge(){
        System.out.print(toString()+"의 게이지 : " + getGauge()+", ");
    }

    @Override
    public void move() {
        setMileage(getMileage()+r.nextInt(11));
    }

    @Override
    public String toString() {
        return "자전거";
    }
}
