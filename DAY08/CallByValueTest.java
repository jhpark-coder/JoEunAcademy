package DAY08;

public class CallByValueTest {
    static void abc(int a){
        a = 20;
    }

    public static void main(String[] args) {
        int a = 10;
        abc(a);
        System.out.println(a);
    }
}
