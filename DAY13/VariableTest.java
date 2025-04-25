package WEEK03.DAY13;

class A{
    int a; // 멤버변수(인스턴스 변수)
    static int b; // 클래스변수 (static 변수)
    private static int c;
    void abc(){ // 인스턴스 메소드
        int k; // 지역변수
        System.out.println("abc");
    }
    static void def(){ // 클래스 메소드
        System.out.println("def");
    }
}


public class VariableTest {
    public static void main(String[] args) {
        A.def();
        System.out.println(A.b); // 클래스명으로 호출
        //A.c;
        //A.abc();
        A a = new A();
        a.a = 10; //a.a(int a)는 객체에 종속되어있고 객체가 생길때마다 생김
        //a.b; //객체로는 호출불가
        //a.def(); // 객체로는 호출불가
    }
}
