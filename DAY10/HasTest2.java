package WEEK03.DAY10;

class Subject{
    String subjectName;
    int scorePoint;
}

class Student{
    int studentID;
    String studentName;
    Subject korean; // 다른 class 타입 변수선언 -> has관계
    Subject math;
}

public class HasTest2 {
}
