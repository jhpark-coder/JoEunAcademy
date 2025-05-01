package WEEK04.DAY16;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest1 {
    public static void main(String[] args) {
        HashSet<Integer> odd = new HashSet<>();
        HashSet<Integer> even = new HashSet<>();

        for(int i = 1 ; i <= 5; i+=2){
            odd.add(i);
            even.add(i+1);
        }

        boolean setChanged = odd.add(5);
        System.out.println("odd에 5 추가 성공 ? " + setChanged);

        setChanged = even.add(12);
        System.out.println("even에 12 추가 성공? " + setChanged);

        System.out.println("odd 집합 " + odd );
        System.out.println("even 집합 " + even);

        System.out.println("odd에서 가장 작은 값은? : " + Collections.min(odd));
        System.out.println("even에서 가장 작은 값은? : " + Collections.min(even));

        Iterator<Integer> it = even.iterator(); // iterator 변경 후 탐색 가능
        int sum = 0;
        while(it.hasNext()){ // 기준에서 뒤에 값이 있는지 확인
            sum += it.next(); // 뒤로 이동
        }
        System.out.println("even 집합의 합은 : " + sum);
    }
}
