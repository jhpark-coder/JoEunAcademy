package WEEK02.DAY05;

public class ArrayTest {
    public static void main(String[] args) {
        int[] a = new int[5];

        for(int i = 0 ; i < 5 ; i++)
        {
            System.out.println("a["+i+"] : " + a[i]);
        }

        int b[] = new int[5]; //되긴 되는데 헷갈려서 안씀
        /*
        int[] kor = new int[100];
        for(int i = 0 ; i < 100 ; i++)
        {
            kor[i] = i+1;
        }

        for(int i = 0 ; i < 100 ; i++)
        {
            System.out.printf("kor[%d] : %d\n",i,kor[i]);
        }
        */
        for(int i = 0 ; i < 5 ; i++)
        {
            a[i] = 10*(i+1);
        }
        for(int i = 0 ; i < 5 ; i++)
        {
            System.out.printf("a[%d] : %d\n",i,a[i]);
        }
    }
}
