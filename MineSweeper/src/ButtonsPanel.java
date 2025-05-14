import javax.swing.*;
import java.awt.*;

/*
GUI 버튼을 담고 있는 패널
 //초급, 중급, 상급 난이도에 따라 크기가 달라짐
  // 초급은 9x9/10
  // 중급은 16x16/40
  // 고급은 30x16/99
  // 커스텀은 가로x세로/지뢰갯수 입력받음


 */

public class ButtonsPanel extends JPanel {

    //일단 jpanel에 버튼 위치시키는거부터.

    private final int EASY_LEVEL = 0; // 초급 난이도
    private final int NORMAL_LEVEL = 1; // 중급 난이도
    private final int HARD_LEVEL = 2; // 상급 난이도
    private final int CUSTOM_LEVEL = 3; // 커스텀 난이도
    private final int[][] ROW_COLUMN = {{9,9},{16,16},{16,30}}; // 초급, 중급, 상급의 행열 갯수
    private final int ROW_INDEX = 0; // row_column변수에서 row는 앞에꺼(추후 코드에서 숫자대신 상수변수 사용목적)
    private final int COLUMN_INDEX = 1; // row_column 변수에서 comumn은 뒤에꺼(위와 동일목적)
    private int row; // 간결하게 이용목적
    private int column; // 간결하게 이용목적

    private MineButton[][] mineButtons;

    ButtonsPanel(int level){ // 패널 생성자
        super(); // JPANEL 생성
        setPanel(level); // 패널 만들때 인자로 level줌
        mineButtons = new MineButton[row][column]; //마인버튼 배열 만들어줌
        createButtons(level); // 마인버튼배열에 실제로 배열객체를 넣어주면서 동시에 패널에도 하나씩 추가해줌
    }

    private void setPanel(int level) { // 지뢰 패널 세팅

        if(level == EASY_LEVEL){// 초급
            row = ROW_COLUMN[EASY_LEVEL][ROW_INDEX];
            column = ROW_COLUMN[EASY_LEVEL][COLUMN_INDEX];
            setLayout(new GridLayout(row,column));
        }else if(level == NORMAL_LEVEL){ // 중급
            row = ROW_COLUMN[NORMAL_LEVEL][ROW_INDEX];
            column = ROW_COLUMN[NORMAL_LEVEL][COLUMN_INDEX];
            setLayout(new GridLayout(row,column));
        }else if(level == HARD_LEVEL){ // 상급
            row = ROW_COLUMN[HARD_LEVEL][ROW_INDEX];
            column = ROW_COLUMN[HARD_LEVEL][COLUMN_INDEX];
            setLayout(new GridLayout(row,column));

        }else{ // 커스텀 -> 가로길이, 세로길이, 지뢰갯수 입력받아야함

        }
    }

    private void createButtons(int level){
        for(int i = 0 ; i < ROW_COLUMN[level][ROW_INDEX] ; i++){
            for(int j = 0 ; j < ROW_COLUMN[level][COLUMN_INDEX] ; j++){
                mineButtons[i][j] = new MineButton(i,j);
                add(mineButtons[i][j]);
            }

        }
    }

}
