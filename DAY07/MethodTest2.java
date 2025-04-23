package WEEK02.DAY07;

public class MethodTest2 {

    public static void main(String[] args) {
        String str = printHello("더조은");
        System.out.println(str);

        int hap = sum();
        System.out.println(hap);

        outputName("더조은");

        printBye();

    }
    //1. 주고 받고
    static String printHello(String name)
    {
        return "안녕하세요 "+name+"님";
    }
    //2.주고 안받고
    static int sum(){
        int a = 10;
        int b = 20;
        return a + b;
    }
    //3. 안주고 받고
    static void outputName(String name){
        System.out.println("안녕하세요 "+name+"님");
    }
    //4. 안주고 안받고
    static void printBye(){
        System.out.println("Bye Bye");
    }
}
