package WEEK05.DAY18;

class ThreadTest1 extends Thread{

    public ThreadTest1(String str) { setName(str);} // Thread에 setName -> Thread 이름을 명명

    @Override
    public void run(){
        for(int i = 1 ; i <= 10 ; i++){
            System.out.println(i+getName()); // Thread 이름을 정한 값을 요청시 사용
        }
        System.out.println("끝"+getName());
    }
}

public class EXDoubleThread1 {
    public static void main(String[] args) {
        ThreadTest1 t1 = new ThreadTest1("배우기 쉬운 자바");
        ThreadTest1 t2 = new ThreadTest1("배우기 어려운 자바");
        t1.start();
        t2.start();
        System.out.println("바이");
    }
}
