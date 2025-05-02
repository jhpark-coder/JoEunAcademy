package WEEK04.DAY17.Q3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookManager {

    private ArrayList<PhoneBook> pbs;
    private Scanner sc;
    private String phoneBookFileName = "phonebooks.txt";
    private File file;

    PhoneBookManager(){
        pbs = new ArrayList<>();
        sc = new Scanner(System.in);
        file = new File(phoneBookFileName);
    }

    public void startWork() throws IOException { // 일단 키면 파일명의 파일이 있는지 확인하고
        boolean check = file.createNewFile(); // 기존에 있는지 체크 있으면 false 없으면 true
        if(!check) { // 있는경우 false이기 때문에 not을 붙여서 true를 해줌
            readTextFile(); //기존에 파일이 있으면 그거부터 가져와서 배열리스트에 저장함. 그리고 순차적으로 배열리스트에 하나 추가하고, 파일에 입력하는 방식
        }
        int num = 0;
        while(num != 5){ //1~5중 하나
            System.out.println("전화번호부 관리자입니다 무엇을 도와드릴까요?");
            System.out.print("1. 입력 2. 검색 3. 삭제 4. 출력 5. 종료 : ");
            num = sc.nextInt();
            sc.nextLine();
            if(num == 1){
                addPhoneBook();
            }else if(num == 2){
                searchPhoneBook();
            }else if(num == 3){
                deletePhoneBook();
            }else if(num == 4){
                printAllPhoneBook();
            }else if(num == 5){
                System.out.println("수고하셨습니다. 영업종료입니다.");
                endSaveFile();
                sc.close();
            }else{
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public void addPhoneBook() throws IOException {
        System.out.println("[전화번호부 추가 기능]"); // 추가기능
        System.out.print("이름 : ");
        String name = sc.nextLine();

        System.out.print("전화번호 : ");
        String telNumber = sc.nextLine();

        System.out.print("주소 : ");
        String address = sc.nextLine();

        pbs.add(new PhoneBook(name, telNumber, address)); // 배열리스트에 추가해줌
    }

    public void searchPhoneBook(){ // 검색기능
        System.out.println("[이름 검색 기능]"); 
        System.out.print("이름 : "); // 이름에 맞는걸 추가해줌
        String name = sc.nextLine();
        for(PhoneBook p : pbs){
            if(p.getName().equals(name)){
                System.out.println(p);
                return;
            }
        }
        System.out.println("해당하는 이름이 전화번호부에 없습니다");
    }

    public void deletePhoneBook() throws IOException { // 삭제기능
        System.out.println("[삭제 기능]");
        System.out.print("이름 : ");
        String name = sc.nextLine(); // 이름에 맞는걸 배열리스트에서 삭제해줌
        boolean check = false;
        for(int i = 0 ; i < pbs.size() ; i++){
            if(pbs.get(i).getName().equals(name)){
                System.out.println(name+"의 정보를 제거했습니다.");
                pbs.remove(i);
                check = true;
                break;
            }
        }
        if (check) { // 만약에 삭제한 경우에는 임시파일을 만들어서 그걸 덮어쓰기해줌

            String tempFileName = "temp_";
            File file = new File(tempFileName + phoneBookFileName);
            //bufferedwriter의 생성자 매개변수로 filewriter를 줌 filewriter는 매개변수로 파일과 boolean값을 가짐
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));

            for (PhoneBook p : pbs) {
                bufferedWriter.write(p.getName() + "#" + p.getTelNumber() + "#" + p.getAddress());
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
            bufferedWriter.close();

            Path originalPath = Paths.get(phoneBookFileName);
            Path tempPath = Paths.get(file.getPath());
            Files.move(tempPath, originalPath, StandardCopyOption.REPLACE_EXISTING);
        }else{
            System.out.println("찾으시는 이름이 없습니다");
        }
    }
    public void printAllPhoneBook(){ // 모든 정보 출력
        System.out.println("[전체 출력 기능]");
        for(PhoneBook p : pbs){
            System.out.println(p);
        }
    }

    public void readTextFile() throws IOException { // 처음에 파일이 있는지 체크, 있으면 넣어줌
        BufferedReader br = new BufferedReader(new FileReader(phoneBookFileName));
        String str;
        while ((str = br.readLine()) != null){
            String[] strTemp = str.split("#");
            pbs.add(new PhoneBook(strTemp[0],strTemp[1],strTemp[2]));
        }
        br.close();
    }

    private void endSaveFile() throws IOException { // 마지막에 한번에 쫙 써줌

        File file = new File(phoneBookFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,false));

        for(PhoneBook p : pbs){
            bufferedWriter.write(p.getName()+"#"+p.getTelNumber()+"#"+p.getAddress());
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}