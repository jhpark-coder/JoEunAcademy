package WEEK05.DAY18;

class ThreadTest extends Thread{
    @Override
    public void run(){
        for (int i = 1 ; i <= 10 ; i++){
            System.out.println("재미있는 자바 : " + i);
        }
    }
}

public class ExThread1 {
    public static void main(String[] args) {
        ThreadTest t = new ThreadTest(); // 쓰레드 생성
        t.start();
        for(int i = 1 ; i <= 10 ; i++){
            System.out.println("메인 쓰레드 : " + i);
        }
    }

}
