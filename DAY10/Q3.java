package WEEK03.DAY10;
/*
올림픽 선수 : 한국선수 중국선수 미국선수 러시아선수

한국 선수 : 레인번호, 나라명 전진거리 돌발상황체크
중국 선수 : 레인번호, 나라명 전진거리 돌발상황체크
미국 선수 : 레인번호, 나라명 전진거리 돌발상황체크
러시아 선수 : 레인번호, 나라명 전진거리 돌발상황체크

Main 돌발 상황 주기, 총 전진거리 체크 및 출력(100M 먼저 도착한 선수 우승)

전진거리 최대 10M 랜덤으로 숫자를 받아서 진행

우승 확정시 어느 나라 우승인지 출력

돌발상황 -> 전진 못함(매턴 한 곳만 발생가능. 랜덤하게 발동)

동시에 넘어가면 더 많이 간 나라가 우승

 */
import java.util.Random;

class Player{ // 선수 클래스 선언
    int laneNum; // 레인번호
    String country; // 나라명
    int advanceDistance; // 전진거리
   // boolean randomEvent; //돌발상황체크

    Player(int laneNum, String country, int advanceDistance){ //생성자
        this.laneNum = laneNum; //들어온 값대로 초기화중
        this.country = country;
        this.advanceDistance = advanceDistance;
     //   randomEvent = false; // 처음에는 돌발상황이 없으므로 false로 초기화
    }

    void move(Random r,int num){ // 들어온 거리만큼 이동하기
        if(laneNum!= num){ // 이동은 객체 본인이 하는 것이므로 객체의 메소드로 구현
            this.advanceDistance+=r.nextInt(10)+1;
        }
    }
}
class PlayingGame{

    private Player[] players;
    private int turn;
    private int goalMeter;
    private int randomLine;
    private boolean check;

    public Player[] getPlayers() {
        return players;
    }
    public void setPlayer(Player[] players) {
        this.players = players;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getGoalMeter() {
        return goalMeter;
    }

    public void setGoalMeter(int goalMeter) {
        this.goalMeter = goalMeter;
    }

    public int getRandomLine() {
        return randomLine;
    }

    public void setRandomLine(int randomLine) {
        this.randomLine = randomLine;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    PlayingGame(int playerNum, int goalPoint){
        players = new Player[playerNum];
        setGoalMeter(goalPoint);
        setCheck(true);
    }

    void startGame() {
        setPlayers(players); // 플레이어들 레인넘버, 나라, 시작지점(전진거리=0), 돌발상황체크
        Random r = new Random();
        while(check){ //도착점에 도착한 곳이 없다면 반복 있다면 종료
            setTurn(getTurn()+1); // 처음 시작하면 1주기
            setRandomLine(goRandomMeter(players, r)); // 레인별로 전진거리 더해줌(돌발상황 발생한 곳 제외)
            printNow(players,turn,randomLine); // 현재 상황 출력해줌
            setCheck(goal(players, goalMeter)); // 도착한 곳이 있다면 도착한곳 알려주고 check을 false로 바꾸어 무한루프 종료
            //아니라면 계속
        }
    }

    void setPlayers(Player[] players) { //초기에 플레이어들 값 초기화(생성자 통해서)
        int start_point = 0;
        players[0] = new Player(1,"한국",start_point);
        players[1] = new Player(2,"중국",start_point);
        players[2] = new Player(3,"미국",start_point);
        players[3] = new Player(4,"러시아",start_point);
    }

    int setRandomLine(Player[] players,Random r){ //돌발상황 일어날 랜덤라인을 만듬
        return r.nextInt(4); // 새로 돌발상황 생기는 곳 넣어줌
    }

    int goRandomMeter(Player[] players, Random r){ //나아갈 거리 더해줌
        int randomLine = setRandomLine(players,r);
        for(int i = 0 ; i < players.length ; i++){
            players[i].move(r,randomLine);  //1~10 M 랜덤하게 진행
        }
        return randomLine;
    }

    boolean goal(Player[] players,int goalMeter){ // 도착한 곳

        if(players[0].advanceDistance >= goalMeter || players[1].advanceDistance >= goalMeter ||
                players[2].advanceDistance >= goalMeter || players[3].advanceDistance >= goalMeter)
        {
            int maxCheck = 0;
            String maxCountry="";
            for(int i = 0 ; i < players.length ; i++){
                if(maxCheck < players[i].advanceDistance) {
                    maxCheck = players[i].advanceDistance;
                    maxCountry = players[i].country;
                }
            }
            System.out.println("축하합니다. "+maxCountry+" 선수의 우승입니다.");
            return false;
        }
        return true;
    }

    void printNow(Player[] players, int turn, int randomLine){ // 현재 주기 상황 출력
        System.out.printf("---------%d주기----------\n",turn);
        for(int i = 0 ; i < players.length ; i++){
            System.out.printf("%d번 레인 %s : %d m\n",players[i].laneNum,players[i].country,
                    players[i].advanceDistance);
        }
        System.out.println("돌발상황 발생 : " + players[randomLine].country);
    }
}


public class Q3 {
    public static void main(String[] args) {
        int player = 4;
        int goal_meter = 100;
        PlayingGame p = new PlayingGame(player,goal_meter);
        p.startGame();

    }
    /*
   static void startGame(Random r) {
       Player[] players = new Player[4];
       setPlayers(players); // 플레이어들 레인넘버, 나라, 시작지점(전진거리=0), 돌발상황체크
       int turn = 0; // 몇주기인지 적음
       int goalMeter = 100; // 도착점이 몇인지(하드코딩 안하도록 써둠)
       int randomLine = 0;
       boolean check = true; // 도착여부 체크(도착하면 false, 아니면 true)
       while(check){ //도착점에 도착한 곳이 없다면 반복 있다면 종료

           turn++; // 처음 시작하면 1주기
           randomLine = goRandomMeter(players, r); // 레인별로 전진거리 더해줌(돌발상황 발생한 곳 제외)
           printNow(players,turn,randomLine); // 현재 상황 출력해줌
           check = goal(players, goalMeter); // 도착한 곳이 있다면 도착한곳 알려주고 check을 false로 바꾸어 무한루프 종료
            //아니라면 계속
       }
    }

    static void setPlayers(Player[] players) { //초기에 플레이어들 값 초기화(생성자 통해서)
        int start_point = 0;
        players[0] = new Player(1,"한국",start_point);
        players[1] = new Player(2,"중국",start_point);
        players[2] = new Player(3,"미국",start_point);
        players[3] = new Player(4,"러시아",start_point);
    }

    static int setRandomLine(Player[] players,Random r){ //돌발상황 일어날 랜덤라인을 만듬

        return r.nextInt(4); // 새로 돌발상황 생기는 곳 넣어줌
    }

    static int goRandomMeter(Player[] players, Random r){ //나아갈 거리 더해줌
        int randomLine = setRandomLine(players,r);
        for(int i = 0 ; i < players.length ; i++){
            players[i].move(r,randomLine);  //1~10 M 랜덤하게 진행
        }
        return randomLine;
    }

    static boolean goal(Player[] players,int goalMeter){ // 도착한 곳

        if(players[0].advanceDistance >= goalMeter || players[1].advanceDistance >= goalMeter ||
                players[2].advanceDistance >= goalMeter || players[3].advanceDistance >= goalMeter)
        {
            int maxCheck = 0;
            String maxCountry="";
            for(int i = 0 ; i < players.length ; i++){
                if(maxCheck < players[i].advanceDistance) {
                    maxCheck = players[i].advanceDistance;
                    maxCountry = players[i].country;
                }
            }
            System.out.println("축하합니다. "+maxCountry+" 선수의 우승입니다.");
            return false;
        }
        return true;
    }

    static void printNow(Player[] players, int turn,int randomLine){ // 현재 주기 상황 출력
        System.out.printf("---------%d주기----------\n",turn);
        for(int i = 0 ; i < players.length ; i++){
            System.out.printf("%d번 레인 %s : %d m\n",players[i].laneNum,players[i].country,
                    players[i].advanceDistance);
        }
        System.out.println("돌발상황 발생 : " + players[randomLine].country);

    }

     */
}

