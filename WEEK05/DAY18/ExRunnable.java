package WEEK05.DAY18;

class RunnableTest implements Runnable{
    @Override
    public void run(){
        for(int i = 1 ; i <= 10 ; i++){
            System.out.println("재미있는 자바 : "+i);
        }
    }
}


public class ExRunnable {
    public static void main(String[] args) {
        RunnableTest r = new RunnableTest(); // 객체 생성
        Thread t = new Thread(r);  // Thread 객체 생성 시 Runnable 상속 받은 객체 매개변수로 대입
        t.start(); // start
        //익명 클래스
        Runnable r1 = new Runnable(){
            @Override
            public void run(){
                System.out.println("hello");
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
    }
}
