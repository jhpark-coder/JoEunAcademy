package WEEK03.DAY12;

class Student{

    int studentID;
    private String studentName;
    int grade;
    String address;

    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

}

public class PrivateTest {
    public static void main(String[] args) {
        Student studentLee = new Student();
        //studentLee.studentname = "ABC";
        studentLee.setStudentName("이상원");
        System.out.println(studentLee.getStudentName());
    }
}
