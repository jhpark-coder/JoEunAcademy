package WEEK05.DAY18.Q3;

import java.util.Random;

public class Car extends Vehicle implements Booster{

    Random r;

    Car(Random r){
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
        setMileage(getMileage()+r.nextInt(21));
    }

    @Override
    public String toString() {
        return "차";
    }
}
