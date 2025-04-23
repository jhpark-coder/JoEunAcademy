package WEEK02.DAY04;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //원하는 구구단 출력
        //전체 구구단 출력
        //종료
        //1번 입력시 : 원하는 구구단 : x => x단 출력
        //2번 입력시 => 전체 구구단 출력
        //3번 입력시 => 프로그램 종료
        boolean check = true;
        while(check) { //check이 true == inputNum에 3이 안들어왔으면 계속 실행
            System.out.println("1. 원하는 구구단 출력");
            System.out.println("2. 전체 구구단 출력");
            System.out.println("3. 종료");
            int inputNum = sc.nextInt();//원하는 메뉴번호 입력받음
            switch(inputNum){
                case 1:
                    System.out.print("원하는 구구단 : ");
                    int dan = sc.nextInt();
                    if(dan >= 2 && dan <= 9) {
                        for(int i = dan ; i < 10 ; i++) // 2~9단 출력
                        {
                            System.out.printf("%d*%d = %d\n",dan,i,dan*i);
                        }
                        System.out.println();
                        System.out.printf("%d단\n",dan);
                    }
                    else{//2~9 이외의 숫자
                        System.out.println("2~9 이외의 숫자는 잘못된 입력입니다");
                    }
                    break;
                case 2://전체 구구단 출력
                    String strDan="";
                    for(int i = 1 ; i < 10 ; i++) // 9줄 출력
                    {
                        String str="";

                        for (int j = 2 ; j < 10 ; j++) { //한줄마다 x한걸 더함

                            str+=(""+j+"*"+i+" = "+(j*i)+"\t");

                            if(i*j < 10){
                                str+="\t";
                            }
                            if (i == 1) {
                                strDan+=""+j+"단\t\t\t";
                            }
                        }
                        System.out.println(str);

                    }
                    System.out.printf(strDan);
                    System.out.println();
                    break;
                case 3:
                    check = false; // 프로그램 종료
                    break;
                default:
                    System.out.println("1~3 이외의 숫자는 잘못된 입력입니다.");
                    break;

            }

        }
    }
}
