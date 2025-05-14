package WEEK05.DAY18.Q1;

public class Customer extends Thread{

    private int donateCount;
    private Account a;

    public Customer(Account a, String str) {
        this.a = a;
        setName(str);
        donateCount = 0;
    }

    @Override
    public void run(){
        while(a.getMoney() < 500000) {
            System.out.println(getName() + " : " + ++donateCount + "번째");
            a.donateMoney();
        }
    }
}
