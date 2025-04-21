package WEEK03.DAY09;

/*
/비행기 예약 시스템 만들기 함수화
단, 배열관련함수가 하나 이상 존재해야합니다.

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

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        runFlightReservation(sc); // 예약프로그램은 스캐너를 사용하므로 열어줌
        sc.close(); // 사용이 끝났으므로 닫아줌

    }
    // 비행기 예약 시스템 만들기
    static void runFlightReservation(Scanner sc){
        // 좌석은 총 18자리(9행 2열짜리 행렬)
        int row = 9; // 나중에 확장성을 위해 변수로 선언해둠
        int column = 2; // 나중에 변동사항 있을 때 대비하여 변수로 선언해둠
        boolean[][] seats = new boolean[row][column]; // 예약된 좌석 예약됐냐 아니냐의 경우만 있으므로 boolean으로

        int count = 0; // 차있는 자리의 수
        while(count < row * column){ // 카운트가 총 좌석수보다 작다면 반복
            //예약 번째 입력(계산할 땐 입력값 -1해줘야함)
            int[] inputRC = inputIndex(sc); // 행, 열을 입력받음

            if(!seats[inputRC[0]][inputRC[1]]) {// 예약이 빈 자리인 경우
                seats[inputRC[0]][inputRC[1]] = true;
                System.out.println("예약이 완료되었습니다");
                count++;
            }else{ // 예약이 차 있는 좌석 입력하면
                   // 빈 좌석 위치를 알려줌
                printSeats(seats);
            }
        }
        System.out.println("모든 좌석이 예약되었습니다.");


//
//        좌석이 꽉차면 모든 좌석이 예약되었습니다.
    }

    static void printSeats(boolean[][] seats) { // 빈 좌석 출력해주는 함수
        System.out.println("----------빈 좌석----------");
        for(int i = 0 ; i < seats.length ; i++){
            for(int j = 0; j < seats[i].length ; j++){
                if(!seats[i][j]) {
                    System.out.print((i + 1) + "행 " + (j + 1) + "열" + "\t");
                }
            }
            System.out.println();
        }
    }

    static int inputInnerNumber(Scanner sc, String str, int min, int max) // 범위 내로 들어오게 만들어줌
    {
        int num;
        while(true){
            System.out.print(str);
            if(sc.hasNextInt()){ // 스캐너 안에 다음 정수토큰이 있다면
                num = sc.nextInt();
                if(num >= min && num <= max){ //min <= num <= max 인 경우에만 리턴
                    return num;
                }else{
                    System.out.printf("%d와 %d 사이의 값을 입력해주세요\n",min,max);
                }
            }else{ //정수토큰이 없다면 값이 없거나 정수 이외의 수를 입력한 경우
                System.out.printf("%d와 %d 사이의 자리를 입력해주세요\n",min,max);
                sc.next(); // 버퍼비움
            }
        }
    }

    static int[] inputIndex(Scanner sc){ // 인덱스 입력받아서(x번째로) inputRC로 리턴해줌
        int[] inputRC = new int[2];
        inputRC[0] = inputInnerNumber(sc,"행 : ",1,9) -1; // 첫번째의 인덱스는 0
        inputRC[1] = inputInnerNumber(sc,"열 : ",1,2) -1; // 첫번째의 인덱스는 0
        return inputRC;
    }


}
