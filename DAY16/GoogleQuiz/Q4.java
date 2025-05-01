/*
문제: 도서 관리 프로그램 (간단 버전)
목표: Book이라는 사용자 정의 클래스를 만들고, 이 Book 객체들을 ArrayList에 저장하고 관리하는 간단한 프로그램을 작성합니다.
요구사항:
Book 클래스 정의:
title (String, 책 제목)과 author (String, 저자)를 멤버 변수(필드)로 가지는 Book 클래스를 만드세요.
생성자(Constructor)를 만들어 책 제목과 저자를 초기화할 수 있도록 하세요.
각 필드(title, author)의 값을 외부에서 읽을 수 있도록 getter 메소드 (getTitle(), getAuthor())를 만드세요.
(중요!) Book 객체들이 컬렉션에서 제대로 비교되고 관리될 수 있도록 equals()와 hashCode() 메소드를 오버라이드(Override) 하세요. (두 객체의 title과 author가 모두 같으면 같은 책으로 간주하도록 구현하세요.)
책 정보를 보기 좋게 출력하기 위해 toString() 메소드도 오버라이드하세요. (예: "제목: 자바 기초, 저자: 홍길동")
LibraryManager 클래스 (또는 main 메소드):
Book 객체를 저장할 ArrayList를 생성하세요. 변수 이름은 bookList로 하세요.
다음 정보를 가진 Book 객체 3개를 생성하여 bookList에 추가하세요:
제목: "자바 기초", 저자: "홍길동"
제목: "데이터베이스 설계", 저자: "이순신"
제목: "자바 기초", 저자: "홍길동" (중복된 책 정보)
bookList에 있는 모든 책 정보를 향상된 for문을 사용하여 출력하세요. (toString()이 잘 구현되었다면 객체만 출력해도 정보가 보일 것입니다.)
bookList에 "자바 기초" 책이 몇 권 있는지 확인하여 출력하세요. (힌트: 반복문을 돌면서 equals() 메소드를 사용하거나, title getter를 사용해 비교할 수 있습니다.)
bookList의 총 도서 수를 출력하세요.
핵심 학습 포인트:
사용자 정의 클래스 만들기 (필드, 생성자, getter)
equals()와 hashCode() 오버라이드의 중요성 (특히 컬렉션에서 객체를 다룰 때)
toString() 오버라이드로 객체 정보 출력하기
ArrayList에 사용자 정의 객체 저장 및 관리
컬렉션 내 객체 검색 또는 개수 세기
 */

package WEEK04.DAY16.GoogleQuiz;

import java.util.ArrayList;
import java.util.Objects;

class Book{
    private String title; // 책 제목
    private String author; // 책 저자

    Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "제목: "+ title + ", 저자 : " + author;
    }
}

public class Q4 {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();

        bookList.add(new Book("자바 기초", "홍길동"));
        bookList.add(new Book("데이터베이스 설계", "이순신"));
        bookList.add(new Book("자바 기초", "홍길동"));

        for(Book b : bookList){ // toString 객체 출력하면 대신 이게 나옴
            System.out.println(b);
        }

        int bookCount = 0;
        String bookName = "자바 기초";
        for(Book b : bookList){
            if(b.getTitle().equals(bookName)){
                bookCount++;
            }
        }
        System.out.println(bookName + " 책은 " + bookCount + "권 있습니다.");

        System.out.println("책은 총 "+bookList.size() + "권 있습니다.");
    }
}
