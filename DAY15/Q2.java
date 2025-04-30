package WEEK04.DAY15;

/*
마트게임 2
매장에 컴퓨터, 에어컨, 냉장고, 공기청정기
랜덤으로 40대를 채우세요.
제품에는 제조사랑 제품명만 들어갑니다.

0 : 컴퓨터 -> 0 : 삼성 1 : LG
1 : 에어컨 -> 0 : 삼성 1 : LG
2 : 냉장고 -> 0 : 삼성 1 : LG
3 : 공기청정기 -> 0 : LG 1 : 다이슨

40개의 제품을 출력

제품입력 : 냉장고
제조사 : LG

냉장고 LG 제품이 있다면 그 제품의 첫번째 인덱스를 출력해주기
제품이 없으면 제품이 없습니다 출력
 */

import java.util.Random;
import java.util.Scanner;

abstract class Product{
    protected String brand;
    protected String kind;

    abstract public String setBrand(int num);

}

class Computer extends Product{


    Computer(){
        Random r = new Random();
        kind = "컴퓨터";
        brand = setBrand(r.nextInt(2));
    }
    @Override
    public String setBrand(int num){
        if(num == 0)
            return "삼성";
        else return "LG";
    }
}

class AirConditioner extends Product{

    AirConditioner(){
        Random r = new Random();
        kind = "에어컨";
        brand = setBrand(r.nextInt(2));
    }
    @Override
    public String setBrand(int num){
        if(num == 0)
            return "삼성";
        else return "LG";
    }
}

class Refrigerator extends Product{

    Refrigerator(){
        Random r = new Random();
        kind = "냉장고";
        brand = setBrand(r.nextInt(2));
    }
    @Override
    public String setBrand(int num){
        if(num == 0)
            return "삼성";
        else return "LG";
    }
}

class AirCleaner extends Product{

    AirCleaner(){
        Random r = new Random();
        kind = "공기청정기";
        brand = setBrand(r.nextInt(2));
    }
    @Override
    public String setBrand(int num){
        if(num == 0)
            return "LG";
        else return "다이슨";
    }
}

class Mart{
    private Product[] products;
    Random r;


    Mart(int num){
        products = new Product[num];
        r = new Random();
    }

    public void setProducts() {
        for(int i = 0 ; i < products.length ; i++){
            int ranNum = r.nextInt(4);
            switch (ranNum){
                case 0:
                    products[i] = new Computer();
                    break;
                case 1:
                    products[i] = new AirConditioner();
                    break;
                case 2:
                    products[i] = new Refrigerator();
                    break;
                default:
                    products[i] = new AirCleaner();
                    break;
            }
        }
    }

    public void findProduct(){
        Scanner sc = new Scanner(System.in);
        System.out.print("제품 입력 : ");
        String kind = sc.next();
        System.out.print("제조사 입력 : ");
        String brand = sc.next();
        for(int i = 0 ; i < products.length ; i++){
            if(products[i].brand.equals(brand) && products[i].kind.equals(kind)){
                System.out.println("현재 찾으신 제품의 첫번째 인덱스는 : "+i+" 입니다.");
                return;
            }
        }
            System.out.println("현재 찾으시는 제품이 없습니다.");
    }

    public void showAllProducts(){
        for(int i = 0 ; i < products.length ;i++){
            System.out.println(products[i].kind+"\t"+products[i].brand);
        }
    }
}



public class Q2 {
    public static void main(String[] args) {

        Mart m = new Mart(40); // 40개 물건 들어가는 마트 오픈
        m.setProducts(); // 마트에 물건 가득 채움
        m.showAllProducts(); // 마트에 있는 모든 물건 보여줌
        m.findProduct(); // 특정 물건 찾기
    }
}
