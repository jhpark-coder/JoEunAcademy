package WEEK05.DAY18.Q1;

/*
Account 1000씩 성금을 낼 수 있는 기능
Customer 성금을 내는 사람
성금자 5명이 있음
 */

public class Q1Main {
    public static void main(String[] args) throws InterruptedException {

        Customer[] customers = new Customer[5];
        Account account = new Account();
        for(int i = 0 ; i < customers.length ; i++){
            customers[i] = new Customer(account,(i+1) +"번째 성금자");
        }

        for(Customer c : customers){
            c.start();
        }

        for(Customer c : customers){
            c.join();
        }

        System.out.println("성금 총액은 : "+account.getMoney());

    }
}
