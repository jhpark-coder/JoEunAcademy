package WEEK04.DAY14;

class A1{
    void abc(){
        System.out.println("A");
    }
}

class B1 extends A1{
    void abc(){
        System.out.println("B");
    }

    void kor(){
        System.out.println("KOR");
    }
}

class C1 extends A1{
    void abc(){
        System.out.println("C");
    }
}

class D1 extends A1 {
    void abc(){
        System.out.println("D");
    }
}

class E1 extends A1{
    void abc(){
        System.out.println("E");
    }
}

class F1 extends A1{
    void abc(){
        System.out.println("F");
    }
}

class X{
    void run(B1 b1){
        b1.abc();
    }
    void run(C1 c1){
        c1.abc();
    }
    void run(D1 d1){
        d1.abc();
    }
    void run(E1 e1){
        e1.abc();
    }
    void run(F1 f1){
        f1.abc();
    }
    void run(A1 a1){
        a1.abc();
    }
}

class X1{
    void run(A1 a1){
        a1.abc();
        if(a1 instanceof B1){
            B1 b1 = (B1)a1;
            b1.kor();
        }
    }
}



public class MethodOverridingTest1 {
    public static void main(String[] args) {
       X x = new X();
       x.run(new B1());
       x.run(new F1());
       A1 a1 = new B1();
       x.run(a1);

       X1 x1 = new X1();
       A1 a2 = new C1();
       x1.run(a2);

    }
}
