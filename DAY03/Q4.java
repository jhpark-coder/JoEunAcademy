package WEEK01.DAY03;

import java.util.Scanner;

/*
세 과목의 점수를 입력받습니다(국어, 영어, 수학 // 정수값으로)
평균을 소숫점 첫째짜리까지 계산합니다.
그 후에 평균의 학점을 출력해주세요.(평균의 학점만 계산)
단, 과목별 점수가 100점을 초과하는 점수를 입력하면 잘못입력했다고 출력.
국어 : XX
영어 : YY
수학 : ZZ
국어 점수가 잘 못 입력 됐습니다.(출력)
국어, 영어 점수가 잘못 입력 됐습니다. (출력)

평균은 AA학점이고 학점은 BB 입니다.
 */
public class Q4 {
    public static void main(String[] args) {

        //세 과목의 점수를 입력받습니다(국어, 영어, 수학 // 정수값으로)
        Scanner sc = new Scanner(System.in);
        System.out.print("국어 : "); //국어 입력
        int kor = sc.nextInt();
        System.out.print("영어 : "); //영어 입력
        int eng = sc.nextInt();
        System.out.print("수학 : "); //수학 입력
        int math = sc.nextInt();
        //평균을 소숫점 첫째짜리까지 출력시킵니다.(소수점 첫째짜리까지 계산하는 건 안해도 됨)
        //국어 : XX
        //영어 : YY
        //수학 : ZZ

        //1. 점수를 잘못 입력한 경우 = 100점 초과 or 0점 미만 => 평균 계산 x 잘못 입력했다고 출력
        //단, 과목별 점수가 100점을 초과하는 점수를 입력하면 잘못입력했다고 출력.
        int flag = 0; //오류 발생 여부 확인용 플래그
        if(kor > 100 || kor < 0) //국어가 100보다 크거나 0보다 작은 경우
        {
            System.out.print("국어 ");
            flag++;
        }
        if(eng > 100 || eng < 0)    //영어가 100보다 크거나 0보다 작은 경우
        {
            System.out.print("영어 ");
            flag++;
        }
        if(math > 100 || math < 0)  //수학이 100보다 크거나 0보다 작은 경우
        {
            System.out.print("수학 ");
            flag++;
        }
        if(flag > 0) //잘못 입력된 값이 있는 경우
        {
            System.out.print("점수가 잘 못 입력 됐습니다.");
            //국어 점수가 잘 못 입력 됐습니다.(출력)
            //국어, 영어 점수가 잘못 입력 됐습니다. (출력)
        }
        else { //잘못 입력된 값이 없는 경우 => 국어, 영어, 수학 모두 정상적인 값이 입력된 경우
            double avg = ((double) kor + eng + math) / 3;
            //그 후에 평균의 학점을 출력해주세요.(평균의 학점만 계산)
            //평균은 AA학점이고 학점은 BB 입니다.
            String grade; //학점 문자열
            if (avg >= 95) { // 점수에 맞는 학점 부여
                grade = "A+";
            } else if (avg >= 90) {
                grade = "A";
            } else if (avg >= 85) {
                grade = "B+";
            } else if (avg >= 80) {
                grade = "B";
            } else if (avg >= 75) {
                grade = "C+";
            } else if (avg >= 70) {
                grade = "C";
            } else if (avg >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }
            System.out.printf("평균 %.1f점이고 학점은 %s입니다.", avg, grade); //출력
        }

    }
}
