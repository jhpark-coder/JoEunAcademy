package WEEK04.DAY16;

class Box<T>{

    T vol;

    public T getVol() {
        return vol;
    }

    public void setVol(T vol) {
        this.vol = vol;
    }
}


public class GenericTest {
    public static void main(String[] args) {
        Box<Integer> ibox = new Box<>();
        ibox.setVol(200);
        System.out.println(ibox.getVol());

        Box<Double> dbox = new Box<>();
        dbox.setVol(30.5);
        System.out.println(dbox.getVol());

        Box<String> sbox = new Box<>();
        sbox.setVol("안녕하세요");
        System.out.println(sbox.getVol());
    }
}
