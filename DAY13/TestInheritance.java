package WEEK03.DAY13;

class C{

    int a;

    C(){
        System.out.println("C 생성");
    }
}

class D extends C{

    int b;

    D(){
        System.out.println("D 생성");
    }
}
public class TestInheritance {
    public static void main(String[] args) {
        C c = new C();
        c.a = 10;

        D d = new D();
        d.b = 20;
        d.a = 30;
        System.out.println(c.a);
        System.out.println(d.b);
        System.out.println(d.a);
    }
}
