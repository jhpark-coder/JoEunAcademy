package WEEK04.DAY17.Q3;

public class PhoneBook {

    private String name; // 이름
    private String telNumber; // 전화번호
    private String address; // 주소

    PhoneBook(String name, String telNumber, String address){ // 생성자로 초기화
        this.name = name;
        this.telNumber = telNumber;
        this.address = address;
    }

    @Override
    public String toString() { // toSTring 오버라이딩해서 바로 출력할수있도록
        return "이름 : " + name + " 전화번호 : " + telNumber + " 주소 : " + address;
    }

    public String getName() { // 게터 통해서 밖에서도 접근할 수 있도록
        return name;
    }

    public String getTelNumber() { // 게터 통해서 밖에서도 접근 가능토록
        return telNumber;
    }

    public String getAddress() { // 게터 통해서 밖에서도 접근 가능토록
        return address;
    }
}
