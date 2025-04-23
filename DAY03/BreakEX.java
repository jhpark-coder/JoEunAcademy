package WEEK01.DAY03;

public class BreakEX {
    public static void main(String[] args) {
        int sum = 0;
        int num = 0;

        /*
        for(num=0; ; num++){
            sum += num;
            if(sum >= 100) {
                break;
            }
        }*/

        while(true){
            sum += num;
            if(sum >= 100) {
                break;
            }
            num++;
        }
        System.out.println(num);
        System.out.println(sum);
        while(true){
            while(true){ //이중 반복문 안의 break는 가까운(인접한) break만 나감 최외곽 while문까지 나가는건 아님
                num++;
                System.out.printf("안에 반복문 %d\n",num);
                if(num >= 15){
                    break;
                }
            }
            System.out.println("제일 바깥 반복문");
            if (num >= 18) {
                break;
            }
        }
    }
}
