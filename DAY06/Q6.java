package WEEK02.DAY06;
/*
    비행기 예약 시스템 만들기
    좌석은 총 18자리(9행 2열짜리 행렬)
    예약할 좌석의 행 위치, 열 위치를 받음
    행 : (입력)(인덱스 기준이 아니라 번째로 해야함)
    열 : (입력)(인덱스 기준이 아니라 번째로 해야함)
    비어있다면 예약이 완료되었습니다.

    값이 벗어나면 잘못된 입력입니다.

    차있는 좌석 입력하면
    빈 좌석 위치를 알려줌

    좌석이 꽉차면 모든 좌석이 예약되었습니다.

 */

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        //입력준비
        Scanner sc = new Scanner(System.in);

        //좌석 18개
        int seat = 18;// 좌석 남은 카운트하기 위한 정수
        int[][] seatArr = new int[9][2]; // 9*2개짜리 좌석 만듬

        //좌석이 0개보다 많다면(남은 좌석이 있다면) 무한루프
        while( seat > 0 )
        {
        //예약할 좌석의 행 위치, 열 위치를 받음
        int inputRow;
        int inputColumn; // 입력받을 행, 열

            //빈자리를 옳게 입력할 때까지 반복. 옳게 입력되었다면 false통해 루프 빠져나옴
            System.out.print("행 : "); // 1~9까지 받을 예정
            inputRow = sc.nextInt(); // 사용자로부터 행을 입력받음
            if (inputRow > 9 || inputRow < 1) { //입력받은 행의 값이 범위를 벗어나는 경우
                System.out.println("잘못된 입력입니다. 행은 1~9까지의 수를 입력하셔야 합니다.");
                continue; // 루프 처음부터 다시 수행할 것(=입력값 다시 받을 것)
            }
            System.out.print("열 : "); //1~2
            inputColumn = sc.nextInt();// 사용자로부터 열을 입력받음
            if (inputColumn > 2 || inputColumn < 1) { //입력받은 열의 값이 범위를 벗어나는 경우
                System.out.println("잘못된 입력입니다. 열은 1~2까지의 수를 입력하셔야 합니다.");
                continue; // 루프 처음부터 다시 수행할 것(=입력값 다시 받을 것)
            }

            //여기까지 하면 입력값이 범위내의 숫자로 들어오게 됨

            //입력값은 범위 내의 값이 맞지만 이미 예약이 차있는 경우
            if( seatArr[inputRow-1][inputColumn-1] == 1)
            {
                System.out.println("예약이 완료된 자리입니다. 다시 예약해주세요."); //예약된 자리라고 알려줌
                System.out.println("비어있는 좌석은 ");
                for(int i = 0 ; i < seatArr.length ; i++) //추가로 비어있는 좌석을 알려줌
                {
                    for(int j = 0 ; j < seatArr[i].length ; j++)
                    {
                        if(seatArr[i][j] == 0)//비어있는 좌석이 있다면
                        {   //i+1행, j+1열이라고 출력해줌
                            System.out.printf("%d행 %d열\n",i+1,j+1);
                        }
                    }
                }
                System.out.println("입니다.");
            }
            else{
                //빈 자리를 옳게 입력한 경우. 빈 자리를 채우고 예약이 정상처리되었다고 알려줌.
                seatArr[inputRow-1][inputColumn-1] = 1; // 배열에서 좌석을 채워줌
                seat--;// 빈좌석수 -1
                System.out.println("예약이 정상처리 되었습니다.");
            }
        }
        //좌석이 0개라면 예약이 모두 완료된 것
        System.out.println("예약이 모두 완료되었습니다.");
    }
}
