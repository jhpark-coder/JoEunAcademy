package WEEK03.DAY09;

import java.util.Random;
import java.util.Scanner;

/*
숫자야구게임(함수화)
//주고받는 부분이 배열이 많아야함
//User의 값을 입력받는 부분
//Com Random
// 주는 부분을 배열처리해서 함수화
//User 배열과 Com 배열을 비교해서
//Strike, BALL, OUT 을 판단하는 함수를 만들때
//받는 부분을 배열이 들어가서 비교되도록 구현하세요.

랜덤 숫자 3개를 com이 가지고 있음
com 5 6 7
첫째자리 : 4
둘째자리 : 3
셋째자리 : 2
(1~9)를 넘어가는 수 입력시 다시입력받아야함
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //스캐너 객체 선언
        Random r = new Random(); // 랜덤 객체 선언
        runBaseballGame(sc, r); // 야구게임에는 스캐너와 랜덤이 사용되므로 넘겨줌
        sc.close(); // 스캐너 객체를 다 사용하면 닫아줌
    }

    static void runBaseballGame(Scanner sc,Random r){ // 야구게임 시작
        int[] comNum = new int[3]; // 컴퓨터 숫자 3개를 저장해둘 배열
        createComNum(comNum, r); // 컴퓨터 숫자 3개를 생성함(랜덤하게 만들기 위해 랜덤객체 이용)
        printComNum(comNum); // 컴퓨터 숫자 출력해줌
        int[] sbCount = new int[2];
        while(sbCount[0] < 3) {
            int[] userNum = new int[3]; // 유저 숫자 3개를 저장해둘 배열
            createUserNum(sc, userNum); // 유저에게 입력받기 위한 스캐너객체와 userNum을 넘겨서 배열내 정보를 갱신해줌
            sbCount = sboCheck(comNum, userNum); // 스트라이크 볼 판정을 한 것을 sbCount에 저장해줌
            sboResult(sbCount); // 야구게임 결과를 출력해줌
        }
    }

    static void createComNum(int[] comNum, Random r){ //comNum 초기화(
        while(true){ // 세 가지 숫자가 다를때만 리턴하고 그 외에는 무한루프
            for(int i = 0 ; i < comNum.length ; i++) // comNum의 모든 인덱스에 랜덤값(1~9)을 넣어줌
            {
                comNum[i] = r.nextInt(9)+1;// 1~9중 하나 들어감
            }
            if(comNum[0] != comNum[1] && comNum[1] != comNum[2] && comNum[0] != comNum[2])
                return; // 값이 다 다를때만 리턴해서 메소드 종료
        }
    }

    static void printComNum(int[] comNum){ //컴퓨터 넘버 출력
        System.out.print("COM : ");
        for(int i = 0 ; i < comNum.length ; i++) {
            System.out.print(comNum[i] + " ");
        }
        System.out.println();
    }

    static int inputInnerNumber(Scanner sc, int min, int max) // 숫자가 특정 구간 안에 들어오는지 체크
    {
        int num; //리턴해줄 값
        while(true){ // 숫자가 min, max 사이의 정수값일때만 리턴해줌
            if(sc.hasNextInt()){
                num = sc.nextInt();
                if(num >= min && num <= max) { // 숫자가 min, max 사이 값이면 그 값을 리턴해줌
                    return num;
                }else{
                    System.out.printf("%d와 %d 사이의 값을 입력해주세요\n",min,max); //범위 밖의 숫자면 옳은 값 입력해달라함
                }
            }else{
                System.out.printf("%d와 %d 사이의 정수값을 입력해주세요\n",min,max); //숫자 이외의 값이면 숫자 넣어달라함
                sc.next(); // 버퍼를 비워줌
            }
        }
    }
    static void createUserNum(Scanner sc, int[] userNum){ // 유저 숫자 입력받기
        String str = "번째 자리를 입력해주세요."; //첫번째, 두번째 , 세번째 숫자 입력받기
        int min = 1;
        int max = 9;
        while(true) { // 모든 숫자가 다 다르고 1~9 사이 값일때만 리턴
            for (int i = 0; i < userNum.length; i++) { //유저숫자크기만큼 루프돔
                System.out.printf("%d%s", i + 1, str);
                userNum[i] = inputInnerNumber(sc, min, max); //1~9 사이의 정수인지 확인
            }
            if(userNum[0] != userNum[1] && userNum[1] != userNum[2] && userNum[0] != userNum[2])
                return; // 모두 다를때만 리턴
            else{ // 범위체크는 했으므로 중복인 경우가 포함된 경우
                System.out.println("중복되지 않는 숫자 3개를 입력해주세요.");
            }
        }
    }

    static int[] sboCheck(int[] comNum, int[] userNum){ // 스트라이크, 볼 체크
        int[] sbCount = new int[2];//sbCount[0] -> strike, sbCount[1] = ball

        for(int i = 0 ; i < comNum.length ; i++) {
            for (int j = 0; j < userNum.length; j++) {
                if (comNum[i] == userNum[j]) { // 값이 같을 때
                    if (i == j) { // 인덱스도 같으면 스트라이크
                        sbCount[0]++;
                    } else { // 다르면 볼
                        sbCount[1]++;
                    }
                }
            }
        }
        return sbCount; //sbcount를 리턴해줌

    }

    static void sboResult(int[] sboCount){ //sbo결과 출력하기
        if(sboCount[0] == 0 && sboCount[1] == 0) // strike와 ball이 다 0이라면 아웃
            System.out.println("Out");
        else if(sboCount[0] == 3){
            System.out.println("홈런입니다");
        }
        else{ // 그 외의 경우에는 strike와 ball 출력
            System.out.printf("%dStrike %dBall\n",sboCount[0],sboCount[1]);
        }
    }



}
