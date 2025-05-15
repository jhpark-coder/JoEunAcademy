import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

/*
상단에 위치한 상태창패널
좌측은 현재 남은 깃발 갯수(깃발을 사용하면 갯수가 줄어들고, 반대로 치우면 갯수가 늘어남)
가운데는 재시작버튼(좌클릭에만 반응)
우측은 현재 진행 시간(자바 시간메소드 이용)
 */

public class StatusPanel extends JPanel {

    private int restFlagCount;
    private JTextField jtf;
    private JLabel timeLabel;
    private ImageIcon smileIcon;
    private ImageIcon pressedSmileIcon;


    StatusPanel(ActionListener actionListener, MouseListener mouseListener, int restFlagCount){
        super();
        this.restFlagCount = restFlagCount;
        setLayout(new GridLayout(1,3));
        JPanel jPanel1 = new JPanel();
        jtf = new JTextField();
        jPanel1.add(jtf);
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        MineButton mb = new MineButton(0,0);
        mb.addActionListener(actionListener);
        mb.setActionCommand("RESET_BUTTON_CLICKED");
        setResetButtonGUI(mb);
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel2.add(mb, BorderLayout.CENTER);
        add(jPanel1);
        add(jPanel2);

        timeLabel = new JLabel("시간 : 0");
        jPanel3.add(timeLabel);
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

    public void updateFlagDisplay(){
        if(jtf != null){
            jtf.setText("깃발 : "+ restFlagCount);
        }
    }

    public void updateTimeDisplay(int seconds){
        if( timeLabel != null){
            timeLabel.setText("시간 : " + seconds);
        }
    }

    private void setResetButtonGUI(JButton b){
        URL smileUrl = StatusPanel.class.getResource("/images/smile(50x50).png");
     if (smileUrl != null) {
         smileIcon = new ImageIcon(smileUrl);
     } else {
         System.err.println("smile.png를 찾을 수 없습니다.");
     }
        URL pressedSmileUrl = StatusPanel.class.getResource("/images/smile.png");
     if (pressedSmileUrl != null) {
            pressedSmileIcon = new ImageIcon(pressedSmileUrl);
     } else {
            System.err.println("pressed_smile.png를 찾을 수 없습니다.");
     }

     if(smileIcon != null && pressedSmileIcon != null){
         b.setIcon(smileIcon);
         //b.setPressedIcon(pressedSmileIcon);
         b.addMouseListener(new MouseAdapter() {
             private boolean mousePressedOnButton = false;
             @Override
             public void mousePressed(MouseEvent e) {
                 if (b.isEnabled() && pressedSmileIcon != null) {
                     b.setIcon(pressedSmileIcon); // 작은 아이콘으로 직접 교체
                     mousePressedOnButton = true;
                 }
             }
             @Override
             public void mouseReleased(MouseEvent e) {
                 // 버튼 위에서 마우스를 떼었거나, 버튼 밖에서 떼었더라도
                 // 이전에 버튼 위에서 눌렀었다면 원래 아이콘으로 복원
                 if (mousePressedOnButton) {
                     if (smileIcon != null) b.setIcon(smileIcon);
                     mousePressedOnButton = false;
                 }
             }
         });

         b.setHorizontalAlignment(SwingConstants.CENTER);
         b.setVerticalAlignment(SwingConstants.CENTER);

         b.setMargin(new Insets(0,0,0,0));
         b.setBorderPainted(false);
         b.setContentAreaFilled(false);
         b.setFocusPainted(false);
     }
        if (smileIcon != null) {
            b.setPreferredSize(new Dimension(smileIcon.getIconWidth(), smileIcon.getIconHeight()));
        }

    }


}
