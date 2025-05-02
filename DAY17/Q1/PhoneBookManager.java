package WEEK04.DAY17.Q1;

import java.util.ArrayList;
import java.util.Scanner;

class PhoneBookManager{
    private ArrayList<PhoneBook> pbs; // 전화번호부
    private Scanner sc; // 스캐너 객체(한 번만 생성하려고 여기 선언)

    PhoneBookManager(){ //
        pbs = new ArrayList<>(); // 전화번호부 매니저는 전화번호 여러개를 가짐
        sc = new Scanner(System.in); // 스캐너는 처음 가짐
    }

    public void startPBM(){ // 전화번호부 메인 분기
        int num = 0; // 초기값 0
        while(num != 5){ // 5 받을때까지 반복해서 받음
            System.out.print("1. 추가 2. 삭제 3. 전체 출력 4. 이름 검색 5. 종료 : "); // 1~5 중에 하나를 받음
            num = sc.nextInt();
            if(num == 1){ // 1이면
                addPhoneBook(); // 추가기능
            }else if(num == 2){ //2면
                deletePhoneBookByName(); // 삭제기능
            }else if(num == 3){ // 3이면
                printAllPhoneBook(); //모두 출력
            }else if(num == 4){ // 4면
                searchPhoneBookByName(); // 이름으로 삭제
            }else if(num == 5){ //5면 프로그램 종료
                System.out.println("프로그램 종료");
                sc.close();
            }else{ // 그 외에 잘못된 입력 출력
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public void addPhoneBook(){ // 추가 기능
        String name;
        String phoneNumber;
        String address;
        int age;
        System.out.println("[전화번호부 추가] 기능입니다");
        System.out.print("이름 : ");
        name = sc.next(); //이름은 문자열하나
        System.out.print("전화번호 : ");
        phoneNumber = sc.next(); // 전화번호는 문자열 하나 \n
        sc.nextLine(); // next()나 nextInt()는 사용 후 개행문제가 버퍼에 남아서 nextLine을 쓰기 위해선 그 전에 버퍼를 한 번 비워야됨
        System.out.print("주소 : ");
        address = sc.nextLine(); // 주소는 한 라인 통째로
        System.out.print("나이 : ");
        age = sc.nextInt();
        PhoneBook pb = new PhoneBook(name,phoneNumber,address,age); // 전화번호부에 추가해줌
        pbs.add(pb);
        System.out.println("추가하신 정보 입니다.");
        System.out.println(pb);
    }

    public void deletePhoneBookByName(){
        System.out.print("[삭제 기능]입니다. 삭제하시려는 이름을 입력해주세요 : ");
        String name = sc.next(); // 삭제하려는 이름 name을 입력받음
        for(int i = 0 ; i < pbs.size() ; i++){ //전화번호부 크기만큼 돌면서 찾음
            if(pbs.get(i).getName().equals(name)){ // 전화번호부에 찾으려는 이름과 같은 이름이 있다면
                pbs.remove(i); // 전화번호부에서 해당 인덱스의 정보를 삭제해줌
                System.out.println("해당 이름 "+name+"님의 정보를 삭제했습니다.");
                return; // 그리고 메소드를 종료해줌
            }
        }
        System.out.println("해당하는 이름이 없어 삭제에 실패했습니다."); // 반복문 돌동안 찾지 못했다는 뜻은 해당하는 이름이 없었다는 뜻
    }

    public void printAllPhoneBook(){ // 모두 출력하기
        System.out.println("전화번호부에 저장된 모든 연락처입니다");
        for(PhoneBook pb : pbs){ // 출력하는건 향상된 for문으로 객체 받아와서 override된 tostring쓰면 됨
            System.out.println(pb);
        }
    }
    public void searchPhoneBookByName(){ // 이름으로 검색하기
        System.out.print("[이름으로 검색 기능]입니다 이름을 입력해주세요 : "); // 이름으로 검색하기
        String name = sc.next(); // 찾으려는 이름을 검색받음
        for(PhoneBook p : pbs){ // 향상된 for문 돌면서 찾음
            if(p.getName().equals(name)){ // 이름이 같은 객체가 있다면
                System.out.println("찾으신 "+name+"님의 정보입니다 : ");
                System.out.println(p); // 해당 객체의 toString 출력
                return;
            }
        }
        System.out.println("해당하는 이름이 없어 검색에 실패했습니다.");
    }
}

