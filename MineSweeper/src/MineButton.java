import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

    public MineButton(int row, int col){
        this.cell = new Cell();
        this.row = row;
        this.col = col;

        this.setActionCommand(row+"_"+col+"_BUTTON_CLICKED");

        setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));

    }


    public Cell getCell() {
        return cell;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}
