package WEEK05.DAY18;

interface MyNumber{
    int getMax(int num1 , int num2);
}


public class LamdaTest { // 람다식은 하나의 추상메소드를 가진 메소드의 구현
    public static void main(String[] args) {
        MyNumber myNumber = (x,y) -> (x>=y) ? x : y ;
        System.out.println(myNumber.getMax(10,20)); // 만약 추상메소드가 둘 이상이면 이렇게 못쓰고 그냥 추상클래스로 해야됨
    }
}
