package DAY08;

import java.util.Scanner;

/*
//static 변수 사용없이 만들기
 */
public class Q1 {
    public static void main(String[] args) {
        checkWrongInput(inputScore());

    }
    //세 과목의 점수 (국어, 영어, 수학) 정수로 입력받으세요.(주고 안받고)
    static int[] inputScore()
    {
        Scanner sc = new Scanner(System.in);

        int[] score = new int[3];
        String[] subject = {"국어","영어","수학"};

        for (int i = 0; i < 3; i++) {
            System.out.printf("%s 과목의 점수를 입력해주세요 : ",subject[i]);
            score[i] = sc.nextInt();
        }
        return score;
    }

    //평균 학점 연산(주고 받고)
    static double calAverage(int[] num)
    {
        double avg=0;
        for(int i = 0 ; i < num.length ; i++){
            avg+=num[i];
        }
        avg/=3.0;

        return avg;
    }


//        (A+ 95 이상 A0 90 이상 B+ 85이상 B0 80 이상 C+ 75 이상 C 70점 이상 D 60점 이상 F 60점 미만)
//단 각 점수가 100점을 초과하면 평균입력하지 않고 잘못된 점수입니다라고 출력(과목까지 적을필요는 없음)하고 종료

    //잘못된 입력값 확인(안주고 받고)
    static void checkWrongInput(int[] score){
        boolean check = true;
        for(int i = 0 ; i < score.length ; i++){ //3번체크해서
            if(score[i] > 100 || score[i] < 0)
            {   check = false;
                break;
            }
        }
        if(check){
            double avg = calAverage(score);
            printAverage(avg, stringAverage(avg));
        }else{
            wrongPrint();
        }

    }

    //잘못 입력했습니다 출력(안주고 안받고)
    static void wrongPrint(){
        System.out.println("잘못된 점수를 입력했습니다.");
    }

    //그 이후에 평균의 학점을 출력을 해주세요.(주고 받고)
    //평균학점 출력(주고 받고)
    static String stringAverage(double avg){
        String str="";
        if(avg >= 95){
            str+="A+";
        }else if(avg >=90){
            str+="A0";
        }else if(avg >=85){
            str+="B+";
        }else if(avg >=80){
            str+="B0";
        }else if(avg >=75){
            str+="C+";
        }else if(avg >=70){
            str+="C0";
        }else if(avg >=65){
            str+="D+";
        }else if(avg >=60){
            str+="D0";
        }else{
            str+="F";
        }
        return str;
    }

    static void printAverage(double avg, String str)
    {
        System.out.printf("평균은 %.1f, 학점은 %s입니다.",avg,str);
    }

}

