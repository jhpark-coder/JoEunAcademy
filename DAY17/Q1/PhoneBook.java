package WEEK04.DAY17.Q1;

class PhoneBook{ // 전화번호부
    private String name; // 이름
    private String phoneNumber; //전화번호
    private String address; // 주소
    private int age; // 나이

    PhoneBook(String name, String phoneNumber, String address, int age){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() { // 객체 출력시 대신 이거 출력
        return "이름 : " + name + " 전화번호 : " + phoneNumber + " 주소 : " + address +" 나이 : " + age;
    }

    public String getName(){ // 이 객체 외부에서 이름 검색하기 위해 이용
        return this.name;
    }
}
