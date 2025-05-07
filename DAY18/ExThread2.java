package WEEK05.DAY18;

class A{
    synchronized void plus(int i){
        for(int j = 0 ; j < 5 ;j++){
            System.out.println(j*i);
        }
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class B extends Thread{
    A a;
    int i;

    B(A a, int i){
        this.a = a;
        this.i = i;
    }

    @Override
    public void run(){
        a.plus(i);
    }
}

public class ExThread2 {
    public static void main(String[] args) {
        A a = new A();
        B b1 = new B(a,3);
        B b2 = new B(a,7);
        b1.start();
        b2.start();
    }
}
