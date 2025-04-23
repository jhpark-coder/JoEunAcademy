package WEEK02.DAY08;


import java.util.Scanner;

/*
(main문은 1~2줄, 메소드는 각 4개 이상이여야 함)
1. 구구단 출력
2. 별찍기 출력
3. 종료
(잘못된 번호 입력시 잘못된 입력 출력 함수화)


1. 원하는 구구단을 입력하세요 :
2. 전체 구구단 출력

2. 별찍기 출력

1. 네모
2. 직삼각형 정방향
3. 직삼각형 역방향
4. 피라미드
5. 다이아몬드

 */
public class Q4 {
    public static void main(String[] args) {
        mainMethod();
    }

    //메인 메소드
    static void mainMethod(){
        Scanner sc = new Scanner(System.in);
        int flag = 0;
        while(true){
            printMenu();
            flag = outCheck(sc.nextInt(),1,3);
            if(flag == 1){ // 1이면 구구단
                multiTable();
            }else if(flag == 2){ //2면 별찍기
                starPrint();
            } else {
                System.out.println("프로그램 종료");
                break;
            }
        }

    }

    //1. 구구단 출력
    static void multiTable() {

        //출력
        System.out.println("원하는 구구단을 입력하시면 1");
        System.out.println("전체 구구단 출력을 원하시면 2 입력 : ");
        //원하는 구구단 입력받기
        Scanner sc = new Scanner(System.in);
        int flag = outCheck(sc.nextInt(), 1, 2);
        if (flag == 1) {
            System.out.print("원하는 단을 입력해주세요 : ");
            wantMT(outCheck(sc.nextInt(), 2, 9));
        }
        else {
            allMT();
        }
    }
    static int outCheck(int num, int min, int max){
        Scanner sc = new Scanner(System.in);
        while(num > max || num < min){
            System.out.printf("%d~%d 사이의 올바른 값을 입력해주세요\n",min,max);
            num = sc.nextInt();
        }
        return num;
    }
    static void wantMT(int dan){
        for(int i = 0 ; i < 9 ; i++){
            System.out.printf("%d * %d = %d\n",dan,i+1,dan*(i+1));
        }

    }
    static void allMT(){
        for(int i = 1 ; i <= 9 ; i++){
            String str = "";
            for(int j = 2 ; j <= 9 ; j++) {
                str+=(j+ " * " + i + " = " + i*j + "\t");
            }
            System.out.println(str);
        }

    }
    //2. 별찍기 출력
    static void starPrint(){
        Scanner sc = new Scanner(System.in);
        System.out.println("원하는 별찍기 방법을 입력해주세요 : ");
        System.out.println("1. 네모 2. 직삼각형 정방향 3. 직삼각형 역방향 4. 피라미드 5. 다이아몬드");
        int num = outCheck(sc.nextInt(),1,5);
        switch(num){
            case 1:
                //네모찍기
                starSquare(starNumber());
                break;
            case 2:
                //직삼각형 정방향 찍기
                starRightTriangle(starNumber());
                break;
            case 3:
                //직삼각형 역방향 찍기
                starRevRightTriangle(starNumber());
                break;
            case 4:
                //피라미드 찍기
                starPyramid(starNumber());
                break;
            default:
                //다이아몬드 찍기
                starDiamond(starNumber());
                break;
        }
    }
    static void printMenu(){
        System.out.println("1. 구구단 출력");
        System.out.println("2. 별찍기 출력");
        System.out.println("3. 종료");
    }
    static int starNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇개나 찍을 지 알려줘");
        return sc.nextInt();
    }
    static void starSquare(int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
    static void starRightTriangle(int n){

        for(int i = 1 ; i <= n ; i++)
        {
            for(int j = 0; j < n ; j++){
                if(i > j){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
    static void starRevRightTriangle(int n){
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = n-1; j >= 0 ; j--){
                if(j > i){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    static void starPyramid(int n){
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = n-i-1 ; j > 0 ; j--){
                System.out.print(" ");
            }
            for(int j = 0 ; j < 2*i+1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void starDiamond(int n){
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = n-i-1 ; j > 0 ; j--){
                System.out.print(" ");
            }
            for(int j = 0 ; j < 2*i+1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = n-1 ; i > 0 ; i--)
        {
            for(int j = n-i ; j > 0 ; j--){
                System.out.print(" ");
            }
            for(int j = 0 ; j < 2*i-1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
