package WEEK05.DAY19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI2 extends JFrame implements ActionListener{

    JLabel jl;

    GUI2(){
        Container ct = getContentPane();
        ct.setLayout(new FlowLayout());
        JButton j1 = new JButton("1");
        JButton j2 = new JButton("2");
        jl = new JLabel("안녕");
        ct.add(j1);
        ct.add(j2);
        ct.add(jl);
        j1.addActionListener(this);
        j2.addActionListener(this);
        setTitle("GUI TEST 2");
        setSize(500, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand(); // 1, 2
        String result = "안녕" + input;
        jl.setText(result);
        System.out.println(input);
    }
}

public class GUITest2 {
    public static void main(String[] args) {
        new GUI2();
    }
}
