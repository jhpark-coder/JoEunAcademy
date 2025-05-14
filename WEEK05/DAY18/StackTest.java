package WEEK05.DAY18;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        System.out.println("스택에 push : " + stack.push("경기도")); //push() 데이터 추가
        System.out.println("스택에 push : " + stack.push("충청도"));
        System.out.println("스택에 push : " + stack.push("강원도"));
        System.out.println("스택에 push : " + stack.push("전라도"));
        System.out.println("스택에 push : " + stack.push("경상도"));
        System.out.println("스택에 push : " + stack.push("제주도"));
        System.out.println("============================================");

        int n = stack.search("제주도"); // 제주도 인덱스 찾기
        if(n != -1){
            System.out.println("스택에서 숫자 제주도에 위치는 : " + n + "번째 입니다.");
        }else{ //-1이면 데이터가 없다는 것
            System.out.println("제주도는 없습니다.");
        }
        System.out.println("================================================");
        while(!stack.empty()){ // 비어 있지 않으면 계속 반복
            String obj = stack.pop(); // 데이터 추출 pop
            System.out.println("스택에서 pop : "+ obj); // 데이터 추출 순서대로 출력
        }
    }
}
