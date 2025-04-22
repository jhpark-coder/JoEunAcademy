package WEEK03.DAY10;
/*
자동차(색깔, 최고속력 : 멤버, 운전 : 기능)

자전거(제조사, 자전거기능(~~용) : 멤버, 타다 : 기능)

오토바이(색깔, 최고속력 : 멤버, 운전 : 기능)

자동차 색깔 : 은, 검정, 하양, 형광
자동차 제조사 : Ford, BMW, 삼성, 현대
최고속력 : 220, 240, 200, 180

자전거 제조사 : 삼천리, 자이언트
자전거 기능 : 산악용, 접이식용

오토바이 제조사 : 대림
오토바이 색깔 : 빨강
오토바이 최고속력 : 180

 */

import java.lang.module.ModuleReader;

class Car{ // 차
    String color;
    String brand;
    int maxSpeed;

    void driveCar(){
        System.out.println(brand+"사의"+color+"색 차는 최대 "+maxSpeed+"km/h로 운전할 수 있습니다.");
    }

    Car(String c, String b,int ms){
        color = c;
        brand = b;
        maxSpeed = ms;
    }


}
class Bycycle{
    String brand;
    String purpose;

    Bycycle(String b, String p){
        brand = b;
        purpose = p;
    }

    void driveBycycle(){
        System.out.println(brand+"사 자전거는 "+purpose+"으로 탈 수 있습니다.");
    }

}

class Motorcycle{
    String brand;
    String color;
    int maxSpeed;

    Motorcycle(String b, String c, int ms){
        brand = b;
        color = c;
        maxSpeed = ms;
    }

    void driveMotorcycle(){
        System.out.println(brand+"사의 "+color+"색 오토바이는 최대 "+maxSpeed+"km/h로 운전할 수 있습니다.");
    }
}
/*

class Store{
    Car[] cars;

    Bycycle[] bs;

    Motorcycle[] ms;

    void addCars(Car c){
        if(cars == null){
            cars[0] = c;
        }else {
            cars[cars.length] = c;
        }
    }
    void addBycycles(Bycycle b){
        if(bs == null){
            bs[0] = b;
        }else {
            bs[bs.length] = b;
        }
    }
    void addMortorcycles(Motorcycle m){
        if(ms == null){
            ms[0] = m;
        }else {
            ms[ms.length] = m;
        }
    }
}

 */
class Human{
    Car[] cs;
    Bycycle[] bs;

    void getCar(Car c){

    }

    void getBycycle(Bycycle b){
    }
}

class Human1{
    Car c1;
    Car c2;

    Human1(Car car1, Car car2){
        c1 = car1;
        c2 = car2;
    }
    void hDrive(){
        System.out.println("사람 1이 ");
        c1.driveCar();
        System.out.println("사람 1이 ");
        c2.driveCar();
    }
}

class Human2{
    Bycycle b;
    Motorcycle m;

    Human2(Bycycle b1, Motorcycle m1){
        b = b1;
        m = m1;
    }

    void hDrive(){
        System.out.println("사람 2가 ");
        b.driveBycycle();
        System.out.println("사람 2가 ");
        m.driveMotorcycle();
    }

}

public class Q2 {
    public static void main(String[] args) {


        Car c1 = new Car("은","Ford",220);
        Car c2 = new Car("검정","BMW",240);
        Car c3 = new Car("하양","삼성",200);
        Car c4 = new Car("형광","현대",180);


        Bycycle b1 = new Bycycle("삼천리","산악용");
        Bycycle b2 = new Bycycle("자이언트","접이식용");

        Motorcycle m1 = new Motorcycle("대림","빨강",180);

        Human1 h1 = new Human1(c2, c4);
        c2 = null;
        c4 = null;

        Human2 h2 = new Human2(b1, m1);

        b1 = null;
        m1 = null;

    }
}
