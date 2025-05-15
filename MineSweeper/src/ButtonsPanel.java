import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/*
GUI 버튼을 담고 있는 패널
 //초급, 중급, 상급 난이도에 따라 크기가 달라짐
  // 초급은 9x9/10
  // 중급은 16x16/40
  // 고급은 30x16/99
  // 커스텀은 가로x세로/지뢰갯수 입력받음

  좌클릭 -> 열기(연 이후에는 해당 or 주변에 확장되어 열린 버튼은 다시 누를 수 없음)
  우클릭 -> 깃발(깃발이 달린 상태에선 좌클릭이 불가함. 다시 우클릭하면 깃발을 회수함)


 */

public class ButtonsPanel extends JPanel {

    // 일단 jpanel에 버튼 위치시키는거부터.
    // 이걸 위에서 가지고 있다가 줘야될거같은데 왜냐면 위에서 셀도 만들어야해서

    //이 클래스(패널)에서 버튼에 대한 GUI처리를 해줘야함('일시적인' 변화가 아니라 버튼배열 전체의 '지속적인' 변화이기 때문)

    private int row_length; // 간결하게 이용목적
    private int column_length; // 간결하게 이용목적

    private MineButton[][] mineButtons;

    ButtonsPanel(ActionListener actionListener, MouseListener mouseListener, int row, int column){ // 패널 생성자
        super(); // JPANEL 생성
        row_length = row;
        column_length = column;
        setLayout(new GridLayout(row_length,column_length));
        mineButtons = new MineButton[row_length][column_length]; //마인버튼 배열 만들어줌
        createButtons(actionListener, mouseListener); // 마인버튼배열에 실제로 배열객체를 넣어주면서 동시에 패널에도 하나씩 추가해줌
    }


    private void createButtons(ActionListener actionListener, MouseListener mouseListener){
        for(int i = 0 ; i < row_length ; i++){
            for(int j = 0 ; j < column_length ; j++){
                MineButton mb = new MineButton(i,j);
                mb.addActionListener(actionListener);
                mb.addMouseListener(mouseListener);
                setShapeOfButton(mb);
                mineButtons[i][j] = mb;
                add(mineButtons[i][j]);
            }
        }
    }

    public void setShapeOfButton(MineButton mb) {
        // 셀이 열렸을 때
        if(mb.getCell().isOpened()){
            // 지뢰가 있다면
            if(mb.getCell().isMine()){
                //지뢰 보여주기
                mb.setText("💣");
                mb.setBackground(Color.RED);
            // 열렸는데 지뢰가 아니다 = 숫자로 보여주기
            }else{
                //숫자 출력하기
            }
        // 깃발 꼽힌상태면
        }else if(mb.getCell().isFlagged()) {
            // 깃발 출력
            mb.setText("🚩");
        // 열리지도 않고 않은 상태라면
        }else{
            //기본상태. 안눌린 버튼 or 마우스 갖다대면 해당 위치의 버튼만 바뀌는정도
            mb.setText("");
            mb.setEnabled(true);
        }
    }

    public MineButton[][] getMineButtons() {
        return mineButtons;
    }

    public void setMineButtons(MineButton[][] mineButtons) {
        this.mineButtons = mineButtons;
    }
}
