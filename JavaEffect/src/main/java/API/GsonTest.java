package API;

import com.google.gson.Gson;

public class GsonTest {
    public static void main(String[] args) {
        Address address = new Address("인천","대한민국");
        Person person = new Person("홍길동",30,"hong@naver.com",address);

        Gson gson = new Gson();
        String json = gson.toJson(person); // 객체 -> json // !!!!!json과 클래스 변수명 맞춰야함 다르면 오류!!!!!
        System.out.println(json); // json 출력

        Person p1 = gson.fromJson(json,Person.class); // json -> Object(Person.class)
        System.out.println(p1);
    }
}
