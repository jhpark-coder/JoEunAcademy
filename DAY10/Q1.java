package WEEK03.DAY10;
/*
개 - 색깔, 무게, 짖는다(기능)
고양이 - 색깔, 무게 야옹한다.(기능)
새 - 색깔, 무게, 날아다닌다(기능)


 */

class Dog{
    String color;
    double weight;

    void bark(){
        System.out.println(color + "색인 " + weight + "kg 개가 짖는다");
    }
    Dog(String c, double w){
        color = c;
        weight = w;
    }
}

class Cat{
    String color;
    double weight;

    void meow(){
        System.out.println(color + "색인 " + weight + "kg 고양이가 야옹한다");
    }
    Cat(String c, double w){
        color = c;
        weight = w;
    }
}

class Bird{
    String color;
    double weight;

    void fly(){
        System.out.println(color + "색인 " + weight + "kg 새가 날아다닌다");
    }
    Bird(String c, double w){
        color = c;
        weight = w;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Dog d1 = new Dog("검정",2.5);
        Dog d2 = new Dog("하양",8.3);
        d1.bark();
        d2.bark();
        //Dog d3 = new Dog();

        Cat c1 = new Cat("연갈",1.7);
        Cat c2 = new Cat("주황",6.2);
        c1.meow();
        c2.meow();

        Bird b1 = new Bird("분홍",0.5);
        b1.fly();

    }
}
