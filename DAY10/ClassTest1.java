package WEEK03.DAY10;

class A{
    int a; //멤버변수

    void print(int a/*매개변수 or 인자*/){
        int b;//메소드변수 or 지역변수
    }
    A(){
        a = 10;
    }
}

public class ClassTest1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.a);//10
    }

}
