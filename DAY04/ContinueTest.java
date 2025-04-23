package WEEK02.DAY04;

public class ContinueTest {
    public static void main(String[] args) {
       // Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < 10 ; i++) //0부터 9까지 반복
        {
            if(i == 5) { //5는 스킵
                continue;
            }
            System.out.println(i);
        }
        System.out.println("==========================================");
        for(int i = 0 ; i < 6 ; i++) //0부터 5까지 반복
        {
            if(i == 5){ //5는 스킵
                continue;
            }
            System.out.println(i);
        }
    }
}
