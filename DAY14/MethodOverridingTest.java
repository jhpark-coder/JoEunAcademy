package WEEK04.DAY14;

class E{
    void abc(){
        System.out.println("abc");
    }
}

class F extends E{

    @Override
    void abc(){
        System.out.println("def");
    }
}

public class MethodOverridingTest {
    public static void main(String[] args) {

        E e = new E();
        e.abc();
        F f = new F();
        f.abc();
        E e1 = new F();
        e1.abc();

    }
}
