package WEEK05.DAY18;


class OutClass{
    private int num = 10; // 외부 class 인스턴스 변수
    private static int sNum = 20; // 외부 static 변수

    private InClass inClass;

    OutClass(){
        inClass = new InClass();
    }

    static class InStaticClass{
        int inNum = 100; // 내부 class 인스턴스 변수
        static int sInNum = 200; // 내부 class static 변수

        void inTest(){
            System.out.println(inNum);
            System.out.println(sInNum);
            System.out.println(sNum);
            //System.out.println(num); // 인스턴스 변수는 사용하려면 객체가 필요
        }

        static void sTest(){ // static 메소드는 인스턴스 변수 사용 불가
            System.out.println(sInNum);
            System.out.println(sNum);
            // System.out.println(inNum); // 인스턴스 변수는 사용하려면 객체가 필요
        }
    }

    class InClass{
        int inNUm = 100;
        static int sInNum = 200;

        void inTest(){
            System.out.println("OutClass num = " + num);
            System.out.println("OutClass sNum = " + sNum);
        }

        static void sTest(){

        }
    }

    public void usingClass(){
        inClass.inTest();
    }
}


public class InnerTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.usingClass();
        OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
        sInClass.inTest(); // 정적 class -> 인스턴스 메소드
        OutClass.InStaticClass.sTest(); // 정적 class -> 정적 메소드
    }
}
