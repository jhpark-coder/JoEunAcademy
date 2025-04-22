package WEEK03.DAY10;

class KOR{

    int a;

    KOR(int a){
        this.a = a;
    }

    void printThis(){
        System.out.println(this);
    }

}


public class ThisTest1 {
    public static void main(String[] args) {
        KOR k = new KOR(5);
        System.out.println(k.a);
        k.printThis();
    }
}
