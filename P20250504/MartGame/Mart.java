package P20250504.MartGame;

import java.util.ArrayList;

public class Mart {

    private ArrayList<Product> products;

    Mart(){
        products = new ArrayList<>();
    }

    public void openMart(){

        for(ComputerType type : ComputerType.values()){
            for(int i = 0 ; i < 5 ; i++){
                products.add(new Computer(type));
            }
        }

        for(AirConditionerType type : AirConditionerType.values()){
            for(int i = 0 ; i < 5 ; i++){
                products.add(new AirConditioner(type));
            }
        }

        for(RefrigeratorType type : RefrigeratorType.values()){
            for(int i = 0 ; i < 5 ; i++){
                products.add(new Refrigerator(type));
            }
        }

        for(AirCleanerType type : AirCleanerType.values()){
            for(int i = 0 ; i < 5 ; i++){
                products.add(new AirCleaner(type));
            }
        }


    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    public int getMinPrice(){
        int min = 0;
        for(Product p : products){
            if(min == 0){
                min = p.price;
            }
            else{
                if(min > p.price){
                    min = p.price;
                }
            }
        }
        return min;
    }

    public void showMartProuducts(){
        String catalog= "";
        for(Product p : products) {
            String prompt = "상품종류 : " + p.toString() + " 브랜드 : " + p.brand + " 가격 : " + p.price+"\n";
            if(!catalog.contains(prompt)){
                catalog+=prompt;
            }
        }
        System.out.println(catalog);

    }

}
