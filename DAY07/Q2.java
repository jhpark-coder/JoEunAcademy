package DAY07;
/*
//입력에 대응해서 만들어질 수 있게 만들기
1   2   3   4   5
16  17  18  19  6
15  24  25  20  7
14  23  22  21  8
13  12  11  10  9
input 5 = 5 x 5 짜리 배열
1. 열 인덱스 0->4
2. 행 인덱스 1->4
3. 열 인덱스 3->0
4. 행 인덱스 3->1
5. 열 인덱스 1->3
6. 행 인덱스 2->3
7. 열 인덱스 2->1
8. 행 인덱스 감소
9. 열 인덱스 증가

1   2   3   4   5   6


 */

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원하시는 달팽이배열의 크기 : ");
        int n = sc.nextInt(); //크기 n을 입력받음

        int[][] arr = new int[n][n]; // n * n 배열 생성


        //과정이 크게 4가지임
//        1. 열 인덱스가 증가하면서 값을 넣어주기(행 인덱스는 고정)[i][j++]
//        2. 행 인덱스가 증가하면서 값을 넣어주기(열 인덱스는 고정)[i--][j]
//        3. 열 인덱스가 감소하면서 값을 넣어주기(행 인덱스는 고정)[i][j--]
//        4. 행 인덱스가 감소하면서 값을 넣어주기(열 인덱스는 고정)[i--][j]
        //순서대로 돌게 만듬.
        int i = 0;
        int j = 0;
        int inputType = 1; //1~4까지 반복하게 할거임
        int max = n * n; // 몇번 돌게 할건지 체크
        int count = 0; // 전치로 더하고 값 넣게 할거임
        while(count < max) { // 최대값만큼 안넣었다면 계속 진행
            switch (inputType) {
                case 1: // 1. 열 인덱스가 증가하면서 값을 넣어주기(행 인덱스는 고정)[i][j++]
                    while(j < arr.length) {//j가 길이보다 작을때만 체크. 밖으로 넘어가는거 막기 위해
                        if (arr[i][j] == 0) {
                            arr[i][j] = ++count;
                            System.out.printf("arr[%d][%d] : %d\n",i,j,arr[i][j]);
                            j++;
                        } else {
                            break;
                        }
                    }
                    i++; // 다음 체크할 곳은 i++위치부터
                    j--; // j가 arr.length와 같을 때 탈출했기 때문에 1을 빼줌
                    inputType = 2;
                    break;
                case 2: // 2. 행 인덱스가 증가하면서 값을 넣어주기(열 인덱스는 고정)[i++][j]
                    while(i < arr[0].length) {//i가 길이보다 작을때만 체크. 밖으로 넘어가는거 막기 위해
                        if (arr[i][j] == 0) {
                            arr[i][j] = ++count;
                            System.out.printf("arr[%d][%d] : %d\n",i,j,arr[i][j]);
                            i++;
                        } else {
                            break;
                        }
                    }
                    j--; // 다음 체크할 곳은 j--위치부터
                    i--; // i가 arr[0].length일때 나왔기 때문에 1을 빼줌
                    inputType = 3;
                    break;
                case 3: // 3. 열 인덱스가 감소하면서 값을 넣어주기(행 인덱스는 고정)[i][j--]
                    while(j >= 0) {//j가 0이상일 때만 넣음. 밖으로 넘어가는거 막기 위해
                        if (arr[i][j] == 0) {
                            arr[i][j] = ++count;
                            System.out.printf("arr[%d][%d] : %d\n",i,j,arr[i][j]);
                            j--;
                        } else {
                            break;
                        }
                    }
                    i--; // 다음 체크할 곳은 i--위치부터
                    j++; // j가 -1일때 나왔기 때문에 1을 더해줌
                    inputType = 4;
                    break;
                case 4: // 4. 행 인덱스가 감소하면서 값을 넣어주기(열 인덱스는 고정)[i--][j]
                    while(i >= 0) {//i가 0 이상일 때만 넣음 밖으로 넘어가는거 막기 위해
                        if (arr[i][j] == 0) {
                            arr[i][j] = ++count;
                            System.out.printf("arr[%d][%d] : %d\n",i,j,arr[i][j]);
                            i--;
                        } else {
                            break;
                        }
                    }
                    i++; // i가 0일때 나왔기 때문에 1을 더해줌
                    j++; // 다음 체크할 곳은 j++위치부터
                    inputType = 1;
                    break;
                default:
                    System.out.println("Switch문 inpytType 오류, inputType의 값 : "+inputType);
                    break;
            }
        }

        for(int p = 0 ; p < arr.length ; p++){ //배열안의 모든 값 출력
            for(int q = 0 ; q < arr[p].length ; q++){
                System.out.print(arr[p][q]+"\t");
            }
            System.out.println();
        }

    }
}
