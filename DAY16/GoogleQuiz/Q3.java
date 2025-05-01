package WEEK04.DAY16.GoogleQuiz;

import java.util.HashMap;
import java.util.Set;

public class Q3 {
    public static void main(String[] args) {
        HashMap<String, Integer> productPrices = new HashMap<>();

        String[] names = {"사과","바나나","오렌지","사과"};
        int[] prices = {1500,2000,1200,1800};

        for(int i = 0 ; i < names.length ; i++){
            productPrices.put(names[i],prices[i]);
        }
        System.out.println(productPrices);

        System.out.println(productPrices.get("바나나"));
        /*
        if(productPrices.get("포도") == null){
            System.out.println(false);
        }else{
            System.out.println(true);
        }*/

        System.out.println(productPrices.containsKey("포도"));

        productPrices.remove("오렌지");

        Set<String> keys = productPrices.keySet();
        System.out.println(keys);
        System.out.println(keys.size()+"종류");
    }
}
