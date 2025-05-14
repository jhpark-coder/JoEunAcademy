import javax.swing.*;

public class GameManager {

    // 난이도 초급 중급 고급 커스텀 중에 고르게 함

    // 초급은 9x9/10
    // 중급은 16x16/40
    // 고급은 30x16/99
    // 커스텀은 가로x세로/지뢰갯수 입력받음

    //부가기능으로 저장기능 랭킹기능 힌트기능 종료기능중에 최대한 많이 지원할 수 있도록 할 예정

    private Cell[][] cells;
    private final int[] baseMineNumber = {10, 40, 99};

    public void startGame(int level){

        JFrame jFrame = new JFrame();

        ButtonsPanel bp = new ButtonsPanel(level);
        StatusPanel sp = new StatusPanel(baseMineNumber[level]);
        jFrame.add("South",bp);
        jFrame.add("North",sp);
        JMenuBar menuBar = new JMenuBar();
        setMenuBar(menuBar);
        jFrame.setJMenuBar(menuBar);
        jFrame.pack(); // 각 요소별 크기 존중
        jFrame.setVisible(true);
        jFrame.setTitle("지뢰 찾기");
        //jFrame.setSize(800,800);


    }

    private void setMenuBar(JMenuBar menuBar){ // 상단 메뉴바 작성
        JMenu newGameMenu = new JMenu("새 게임");
        menuBar.add(newGameMenu);

        JMenu hintMenu = new JMenu("힌트");
        menuBar.add(hintMenu);

        JMenu lankingMenu = new JMenu("랭킹");
        menuBar.add(lankingMenu);

        JMenu infoMenu = new JMenu("정보");
        menuBar.add(infoMenu);

        JMenu exitMenu = new JMenu("종료");
        menuBar.add(exitMenu);
    }
}
