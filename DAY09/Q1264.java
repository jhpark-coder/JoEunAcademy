package WEEK03.DAY09;

import java.util.Scanner;

public class Q1264 {
    public static void main(String[] args) {
        String vowels = "aeiouAEIOU";
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String temp = sc.nextLine();
            if(!temp.equals("#")) {
                int count = 0;
                for (int i = 0; i < temp.length(); i++) {
                    for (int j = 0; j < vowels.length(); j++) {
                        if (temp.charAt(i) == vowels.charAt(j))
                            count++;
                    }
                }
                System.out.println(count);
            }else{
                break;
            }
        }
    }
}
