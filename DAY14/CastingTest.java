package WEEK04.DAY14;

class A{
    int a;
}

class B extends A{
    int b;
}

class C extends A{
    int c;
}

class D extends A{
    int d;
}

//A클래스 부모, B,C,D 자식 3개


public class CastingTest {
    public static void main(String[] args) {

        A a = new B(); // 업캐스팅
        B b = (B) a; // 다운캐스팅
        //a.b = 20 ; 에러
        a.a = 10;
        b.a = 20;
        b.b = 30;
        a.a = 40;

        //10개 받는다 B,C,D로만
        //(기존버전)
        B[] listB = new B[10];
        C[] listC = new C[10];
        D[] listD = new D[10];

        //형변환 이후
        A[] listA = new A[10];
        listA[0] = new B();
        listA[1] = new C();
        listA[2] = new D();

        B b1 = (B)listA[0];
        // b2 = (B)listA[1]; // (형제사이는 프로그램적으로 의미가 없음에도) 문법에러가 안남(런타임에러)
        if(listA[0] != null){
            if (listA[0] instanceof B){
                System.out.println("객체는 B입니다.");
                B b2 = (B)listA[0];
            }
            else if(listA[0] instanceof C){
                System.out.println("객체는 C입니다.");
            }
            else if(listA[0] instanceof D){
                System.out.println("객체는 D입니다.");
            }
            else{
                System.out.println("객체는 A입니다.");
            }
        }


    }

}
