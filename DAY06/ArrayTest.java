package WEEK02.DAY06;

public class ArrayTest {
    public static void main(String[] args) {
        int[] array = new int[10];
        //총 갯수 : 10개 인덱스 : 9 array.length-1;

        System.out.println(array.length);

        for(int i = 0 ; i < array.length ; i++){
            array[i] = i + 1;
        }
        for (int i = 0 ; i < array.length ; i++){
            System.out.println(array[i]);
        }

    }
}
