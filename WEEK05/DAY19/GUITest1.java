package WEEK05.DAY19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

// 큰 화면         //화면의 클릭 이벤트를 받는 부모
class GUI1 extends JFrame implements ActionListener {
    private JTextField jtf;
    private JTextArea jta;

    GUI1(){
        JButton jb = new JButton("파일로 저장");
        jtf = new JTextField("파일 이름을 입력하세요.",20);
        jta = new JTextArea("파일의 내용을 입력하세요",10,20);
        Container ct = getContentPane();
        ct.setLayout(new FlowLayout());
        JPanel p1 = new JPanel();
        ct.add(jta);
        p1.add(jtf);
        p1.add(jb);
        ct.add(p1);
        jb.addActionListener(this);
        setTitle("GUI TEST 1");
        setSize(500,500);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String s = jtf.getText();
            FileOutputStream fos = new FileOutputStream(s);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(jta.getText());
            fos.close();
            System.out.println(s + "파일이 생성되었습니다.");
        }catch( Exception exception){
            exception.printStackTrace();
        }
    }
}


public class GUITest1 {
    public static void main(String[] args) {
        //GUI1 gui1 = new GUI1();
        new GUI1();
    }

}
