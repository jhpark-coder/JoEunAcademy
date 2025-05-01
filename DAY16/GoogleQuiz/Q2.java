package WEEK04.DAY16.GoogleQuiz;

import java.util.HashSet;

public class Q2 {
    public static void main(String[] args) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        int[] numbers = {10,25,10,30,5,25};
        for(int n : numbers){
            uniqueNumbers.add(n);
        }

        System.out.println(uniqueNumbers);

        System.out.println(uniqueNumbers.contains(25));
        System.out.println(uniqueNumbers.contains(100));
        uniqueNumbers.remove(30);
        System.out.println(uniqueNumbers);
        System.out.println(uniqueNumbers.size());

    }
}
