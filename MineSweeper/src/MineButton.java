import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
버튼 하나하나에 대한 GUI처리를 위한 버튼
버튼은 데이터를 다루는 Cell과 실제 GUI 구현을 위한 Button이 있으며
Button - Cell은 has관계로 처리
 */

public class MineButton extends JButton { // 버튼은 jbutton 상속

    private final Cell cell; // 버튼은 기능적측면을 담당하는 cell이 있고
    private final int row; // x좌표 row
    private final int col; // y좌표 col이 있다.
    private static final int BUTTON_SIZE = 25;
    private boolean isInnerRightPressed;

    public MineButton(int row, int col){
        this.cell = new Cell();
        this.row = row;
        this.col = col;
        this.isInnerRightPressed = false;

        setShapeOfButton();
        setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));

        addActionListener(e -> { // 람다식 사용
            setText(row+" "+col);

        });

        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed (MouseEvent e){
                if(SwingUtilities.isRightMouseButton(e) && contains(e.getPoint())){
                    isInnerRightPressed = true;
                }

            }

            @Override
            public void mouseReleased (MouseEvent e){
                if( SwingUtilities.isRightMouseButton(e)
                && isInnerRightPressed && contains(e.getPoint())){
                    setText("🚩");
                }

            }

        });


        }

    private void setShapeOfButton() {
        if(cell.isOpened()){ // 셀이 열렸을 때
            if(cell.isMine()){ // 지뢰가 있다면
                //지뢰 보여주기
            }else{ // 열렸는데 지뢰가 아니다 = 숫자로 보여주기
                //숫자 출력하기
            }
        }else if(cell.isFlagged()) { // 깃발 꼽힌상태면
            // 깃발 출력
        }else{ // 열리지도 않고 않은 상태라면
            //기본상태. 안눌린 버튼 or 마우스 갖다대면 해당 위치의 버튼만 바뀌는정도

        }



}




}
