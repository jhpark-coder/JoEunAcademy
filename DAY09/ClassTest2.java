package WEEK03.DAY09;

class Student {

    int studentID;
    String studentName;
    int grade;
    String address;

    void showStudentInfo(){
        System.out.println(studentName+", "+address);
    }
}

public class ClassTest2 {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.studentName = "홍길동";
        student1.address = "부평구";
        student1.showStudentInfo();

        Student student2 = new Student();
        student1.studentName = "김길동";
        student1.address = "미추홀구";
        student1.showStudentInfo();

    }



}
