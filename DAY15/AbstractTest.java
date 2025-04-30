package WEEK04.DAY15;

abstract class Z{

    int a;
    void abc(){
        System.out.println("abc");
    }
    Z(int a, int b){

    }

    abstract void def();
    abstract void kor();
}

class X extends Z{
    X(){
        super(5,8);
    }

    @Override
    void def(){
        System.out.println("def");
    }

    @Override
    void kor(){
        System.out.println("kor");
    }
}

public class AbstractTest {
    public static void main(String[] args) {
        X x = new X();
        x.abc();
        x.def();
        x.kor();

        Z z = new X();
        z.abc();
        z.def();
        z.kor();
    }
}
