package WEEK03.DAY09;

public class recursiveTest {
    public static void main(String[] args) {
        int result = abc(5);
        System.out.println(result);
    }

    static int abc(int a){
        if( a == 0 )
            return 0;
        else return abc(a-1) + a;
    }

}
