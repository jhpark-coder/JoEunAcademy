package WEEK04.DAY16.GoogleQuiz;

import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>();

        todoList.add("자바 공부");
        todoList.add("점심 식사");
        todoList.add("과제 하기");
        todoList.add("운동 하기");
        todoList.add("자바 공부");

        System.out.println(todoList);

        System.out.println(todoList.get(2));
        todoList.set(2, "스터디 참여");

        System.out.println(todoList);

        todoList.removeFirst();
        System.out.println(todoList);
        System.out.println("남은 갯수 : "+todoList.size()+"개");
    }
}
