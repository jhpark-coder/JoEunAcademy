package DAY08;


import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        inputNumber(); // 입력받음

    }

    //3. 종료(1~2일때는 넓이구하기 3일때 종료 나머지는 잘못된입력입니다로 반복

    //사각형 넓이 : 25


//0. 값 입력받는 함수(주고 안받고)
 static int[] inputNumber(){
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int[] num = new int[2];

        while(check) {
            System.out.println("1. 사각형 넓이 2. 삼각형 넓이 3. 종료 : ");
            int flag = sc.nextInt();
            if (flag == 1) { // 사각형 넓이 계산

                System.out.println("사각형 넓이 : "+square(num));
            }else if(flag == 2){ // 삼각형 넓이 계산
                num[0]=sc.nextInt();
                num[1]=sc.nextInt();
                triangle(num);
            }else if(flag == 3){
                check = false;
            }
            else{
                System.out.println("잘못된 입력입니다.");
            }
        }
        return num;
}

static void mainChecker(int[] num){


}


//0-1. 값이 올바르지 않은 경우(1~3 이외의 값입력하면 잘못된 입력입니다)
//0-2. 값이 올바른 경우 (1 또는 2 입력시 1. 가로 : 2. 세로 : 결과값 출력)

    //0-2-1. 사각형 넓이 (주고 받고)
    static int square(int[] num) {
        return num[0] * num[1];
    }

//0-2-2. 삼각형 넓이 (안주고 받고)
    static void triangle(int[] num){
        Scanner sc = new Scanner(System.in);
        num[0] = sc.nextInt();
        num[1] = sc.nextInt();
        System.out.println("삼각형 넓이 : "+ num[0]*num[1] /2.0);
    }

}


