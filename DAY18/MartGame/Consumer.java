package P20250504.MartGame;

import java.util.ArrayList;

public class Consumer {

    private String name;
    private int money;
    private ArrayList<Product> purchasedProducts;

    Consumer(String name, int money){
        this.name = name;
        this.money = money;
        purchasedProducts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void showMyProducts(){
        System.out.printf("[%s의 구매목록]\n",name);
        for(Product p : purchasedProducts){
            System.out.printf("물건 종류 : %s 제조사 : %s 가격 : %d\n",p.toString(),p.brand,p.price);
        }
    }
}
