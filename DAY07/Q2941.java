package WEEK02.DAY07;

import java.util.Scanner;

public class Q2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] arr= new char[8][];
        arr[0] = new char[]{'c', '='}; //c=
        arr[1] = new char[]{'c', '-'}; // c-
        arr[2] = new char[]{'d', 'z','='}; // dz=
        arr[3] = new char[]{'d', '-'}; // d-
        arr[4] = new char[]{'l', 'j'}; // lj
        arr[5] = new char[]{'n', 'j'}; // nj
        arr[6] = new char[]{'s', '='}; // s=
        arr[7] = new char[]{'z', '='}; // z=

        String str = sc.next(); // 문자열을 입력받음

        //체크하기
        int count = 0; // 크로아티아 알파벳 갯수 세기
        boolean rightCheck = false ; // 글자마다 옳은지 체크
        for(int i = 0 ; i < str.length() ; i++)
        { // i = String 현재검색 시작위치 찍어두는 인덱스

            for(int j = 0 ; j < arr.length ; j++) {
                //j = arr[j][k]
                for(int k = 0 ; k < arr[j].length ; k++)
                {
                    if(arr[j][k] != str.charAt(i)) // 해당 배열과 다른 글자를 보면 그 배열말고 다음 배열에서 검색해야함
                    {
                        rightCheck = false; // 이 라인에선 맞는게 없다는 뜻
                        break;
                    }else{
                        rightCheck = true;
                    }
                }
                if(!rightCheck){
                    count++;
                    System.out.println(i);
                    i = i + arr[j].length-1;
                    break;
                }else{
                    count++;
                    break;
                }

            }
            rightCheck = true;

        }

        System.out.println(count);

    }

}
