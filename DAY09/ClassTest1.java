package WEEK03.DAY09;

class A{
    int a; // 변수(속성)

    //기능(메소드)
    void print(){
        System.out.println("a는 "+a+"입니다.");
    }
}

public class ClassTest1 {
    public static void main(String[] args) {
        A a = new A(); // 객체 생성
        a.a = 20;
        a.print();

        A b = new A(); // new = 초기화
        b.print(); // b.a = 0
    }
}
