package WEEK04.DAY14;

class A2{
    int a;
    A2(int a){

    }

    void def(){

    }
}

class B2 extends A2{

    int a;

    B2(){
        super(5); // 부모 = 5 자식 = 0
    }
    B2(int a){
        super(a);
    }
    void abc(){
        this.a = 20; // 부모  = 30
        super.a = 30; // 자식 = 20
        super.def();
    }

}


public class SuperTest {
    public static void main(String[] args) {

        B2 b2 = new B2();
        System.out.println(b2.a);
        b2.abc();
        System.out.println(b2.a);

        B2 b3 = new B2(5);
        System.out.println(b3.a);
        //b3.super.a는 문법상 안됨
        b3.abc();
        System.out.println(b3.a);

    }
}
