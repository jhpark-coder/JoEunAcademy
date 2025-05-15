import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class GameManager {

    // 난이도 초급 중급 고급 커스텀 중에 고르게 함

    // 초급은 9x9/10
    // 중급은 16x16/40
    // 고급은 30x16/99
    // 커스텀은 가로x세로/지뢰갯수 입력받음

    //부가기능으로 저장기능 랭킹기능 힌트기능 종료기능중에 최대한 많이 지원할 수 있도록 할 예정

    private Cell[][] cells;
    private final int EASY_LEVEL = 0; // 초급 난이도
    private final int NORMAL_LEVEL = 1; // 중급 난이도
    private final int HARD_LEVEL = 2; // 상급 난이도
    private final int CUSTOM_LEVEL = 3; // 커스텀 난이도
    private final int[][] ROW_COLUMN = {{9,9},{16,16},{16,30}}; // 초급, 중급, 상급의 행열 갯수
    private final int ROW_INDEX = 0; // row_column변수에서 row는 앞에꺼(추후 코드에서 숫자대신 상수변수 사용목적)
    private final int COLUMN_INDEX = 1; // row_column 변수에서 comumn은 뒤에꺼(위와 동일목적)
    private final int[] baseMineNumber = {10, 40, 99};
    private int gameLevel;
    private JFrame jFrame;
    private ButtonsPanel buttonsPanel;
    private StatusPanel statusPanel;
    private GameTimer gameTimer;
    private int nowMineNumber;

    private ActionListener actionListener;
    private MouseListener mouseListener;

    GameManager(){
        actionListener = createActionListener();
        mouseListener = createMouseListener();
    }

    public void startGame(int level){

        jFrame = new JFrame();
        gameLevel = level;
        setCells();
        buttonsPanel = new ButtonsPanel(actionListener, mouseListener, ROW_COLUMN[gameLevel][ROW_INDEX],ROW_COLUMN[gameLevel][COLUMN_INDEX]);
        statusPanel = new StatusPanel(actionListener, mouseListener, baseMineNumber[gameLevel]);
        jFrame.add("South",buttonsPanel);
        jFrame.add("North",statusPanel);

        gameTimer = new GameTimer(statusPanel);
        JMenuBar menuBar = new JMenuBar(); // 메뉴바 생성 및 세팅
        setMenuBar(menuBar);
        jFrame.setJMenuBar(menuBar); // JFRAME에 달아줌
        jFrame.pack(); // 각 요소별 크기 존중
        jFrame.setVisible(true);
        jFrame.setTitle("지뢰 찾기");

        if(gameLevel != CUSTOM_LEVEL) {
            initMines(baseMineNumber[gameLevel]);
        }
        gameTimer.resetAndStart();
    }

    // 좌클릭 처리용
    private ActionListener createActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("RESET_BUTTON_CLICKED")){
                    gameTimer.resetAndStart();
                }

            }
        };
    }

    // 우클릭 처리용
    private MouseListener createMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }
        };
    }

    private void setCells(){
        if(gameLevel != CUSTOM_LEVEL) {
            cells = new Cell[ROW_COLUMN[gameLevel][ROW_INDEX]][ROW_COLUMN[gameLevel][COLUMN_INDEX]];
            for (int i = 0; i < ROW_COLUMN[gameLevel][ROW_INDEX]; i++) {
                for (int j = 0; j < ROW_COLUMN[gameLevel][COLUMN_INDEX]; j++) {
                    cells[i][j] = new Cell();
                }
            }
        }else{

        }
    }

    // 상단 메뉴바 작성
    private void setMenuBar(JMenuBar menuBar){
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

    private void initMines(int mines){
        nowMineNumber = 0;
        Random r = new Random();
            while(nowMineNumber < mines){
                int r1 = r.nextInt(ROW_COLUMN[gameLevel][ROW_INDEX]);
                int r2 = r.nextInt(ROW_COLUMN[gameLevel][COLUMN_INDEX]);
                if(!cells[r1][r2].isMine()){
                    cells[r1][r2].setMine(true);
                    nowMineNumber++;
                }
            }

        for(Cell[] c1 : cells){
            for(Cell c : c1){
                if(c.isMine()){
                    System.out.print("💣");
                }else{
                    System.out.print("⬜");
                }
            }
            System.out.println();
        }
    }

}
