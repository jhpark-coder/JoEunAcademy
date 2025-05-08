package WEEK05.DAY19.Q2;

public class Present {
    boolean isWinning; // 꽝 여부 객체 생성 시에 받음 true인 애만 줌
    Present(){
        this.isWinning = false;
    }
    Present(boolean isWinning){
        this.isWinning = isWinning;
    }
}
