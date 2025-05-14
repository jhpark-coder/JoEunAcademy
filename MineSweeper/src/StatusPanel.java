import javax.swing.*;
import java.awt.*;

/*
상단에 위치한 상태창
좌측은 현재 남은 깃발 갯수
가운데는 재시작버튼
우측은 현재 진행 시간
 */

public class StatusPanel extends JPanel {

    private int restFlagCount;
    private JTextField jtf;


    StatusPanel(int restFlagCount){
        super();
        this.restFlagCount = restFlagCount;
        setLayout(new GridLayout(1,3));
        JPanel jPanel1 = new JPanel();
        jtf = new JTextField();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        MineButton mb = new MineButton(0,0);
        jPanel2.add(mb);
        add(jPanel1);
        add(jPanel2);
        add(jPanel3);
    }

    public int getRestFlagCount() {
        return restFlagCount;
    }

    public void setRestFlagCount(int restFlagCount) {
        this.restFlagCount = restFlagCount;
    }

    public JTextField getJtf() {
        return jtf;
    }

    public void setJtf(JTextField jtf) {
        this.jtf = jtf;
    }
}
