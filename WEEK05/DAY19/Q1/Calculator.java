package WEEK05.DAY19.Q1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField jtf; // 계산기 값 보여주는 필드
    private String[] calButtonString = {"1", "2", "3", "-", "4", "5", "6", "+", "7", "8", "9", "*", "0", " ", "=", "/"}; // 버튼에 넣을 값
    private JButton[] jButtons; // 버튼배열
    private String result=""; // 결과값 처리할 스트링. 여기서 초기화해주고 이후에는 초기화 함부로하면 안됨 실습코드는 버튼눌릴때마다 초기화했음

    Calculator() {
        Container ct = getContentPane(); // 컨테이너 하나 만듬
        JPanel jp1 = new JPanel(); // 숫자 나오게 하는 필드 //
        JPanel jp2 = new JPanel(); // 계산기 나오게 하는 필드 //
        GridLayout gl = new GridLayout(5, 4, 10, 10);
        jtf = new JTextField();
        jtf.setHorizontalAlignment(JTextField.RIGHT);
        Font font1 = new Font("",Font.BOLD,50);
        jtf.setFont(font1);
        JScrollPane scrollPane = new JScrollPane(jtf);
        jp1.setLayout(new BorderLayout());
        jp1.add(scrollPane);
        jp2.setLayout(gl);
        Font font2 = new Font("",Font.BOLD,15);
        ct.setLayout(new GridLayout(2, 1, 10, 10));
        jButtons = new JButton[calButtonString.length];
        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i] = new JButton(calButtonString[i]);
            jButtons[i].addActionListener(this);
            jButtons[i].setFont(font2);
            jp2.add(jButtons[i]);
        }
        ct.add(jp1);
        ct.add(jp2);

        setTitle("Calculator");
        setSize(400, 400);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand(); // 1, 2
        if (input.equals("=")) {
            //분해해서 결과값 바꾸기
            System.out.println(result);
            jtf.setText(calculator(result));
        } else {
            result = jtf.getText() + input;
            jtf.setText(result);
        }
        System.out.println(input);
    }

    public String calculator(String str) {
        String temp = "";
        double preNum = 0;
        double nextNum = 0;
        char op=' ';
        for (int i = 0; i < str.length(); i++) {
            //System.out.printf("%d턴째 temp : %s preNum : %.1f nextNum : %.1f\n",i+1,temp,preNum,nextNum);
            if (str.charAt(i) != '+' && str.charAt(i) != '-' &&
                    str.charAt(i) != '*' && str.charAt(i) != '/') {
                temp = temp + str.charAt(i);
            }
            else { // 사칙연산이 들어온 경우
                if (preNum == 0 && op == ' ') { // 아직 숫자가 안들어온 경우
                    preNum = Double.parseDouble(temp); // 프리넘에 이걸 넣어줌
                    temp = "";
                    op = str.charAt(i); // 이전꺼 저장
                } else { // 사칙연산이 들어오고 기존에 숫자가 있던경우
                    nextNum = Double.parseDouble(temp);
                    temp = "";
                    switch (op) {
                        case '+':
                            preNum = preNum + nextNum;
                            break;
                        case '-':
                            preNum = preNum - nextNum;
                            break;
                        case '*':
                            preNum = preNum * nextNum;
                            break;
                        case '/':
                            preNum = preNum / nextNum;
                            break;
                        default:
                            System.out.println("디폴트");
                            break;
                    }
                    op = str.charAt(i); // 이전꺼 처리하고 다음꺼
                }
            }
        }
        nextNum = Double.parseDouble(temp);

        switch (op) {
            case '+':
                preNum = preNum + nextNum;
                break;
            case '-':
                preNum = preNum - nextNum;
                break;
            case '*':
                preNum = preNum * nextNum;
                break;
            case '/':
                preNum = preNum / nextNum;
                break;
        }

        if(preNum % 1 == 0){
            return ""+(int)preNum;
        }else {
            return "" + (preNum);
        }
    }

}
