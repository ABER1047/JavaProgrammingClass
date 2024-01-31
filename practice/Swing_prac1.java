import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Swing_prac1
{
    public static void main(String[] args)
    {
        //invokeLater = GUI띄우는데 시간 좀 걸리면 다른 코드부터 실행 / invokeAndWait = GUI띄우고 나서 이후 코드 실행
        javax.swing.SwingUtilities.invokeLater(new Runnable() // 무명 클래스anonymous class 이름은 무조건Runnable로 고정
        {
            public void run() //run메소드 - 이름은 무조건 run으로 고정
            {
                show_ui();
            }
        });
    }
    
    static class Button_action implements ActionListener //버튼을 눌렀을 때 실행될 이벤트
    {
        public void actionPerformed(ActionEvent e) //헤당 코드는 고정적으로 사용됨
        {
            //실행될 코드
            //e.getSource()로 인스턴스 id값 받아올 수 있음
        }
    }
    
    
    public static void show_ui()
    {
        JFrame frame =  new JFrame("윈도우 이름"); //프레임 추가
        frame.setLayout(new FlowLayout()); //윈도우 보더 레이아웃을 디폴트 레이아웃으로
        frame.setSize(1280,720); //윈도우 사이즈 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기 버튼을 눌렀을 때 윈도우가 닫히도록 설정 (설정 안하면 그냥 최소화만 됨)
        frame.setLocationRelativeTo(null); //윈도우를 화면 중앙에 배치
        
        
        JButton bt = new JButton("버튼 안에 적혀질 이름"); //버튼 생성
        bt.addActionListener(new Button_action()); //버튼이 눌렸을 때 실행될 코드 작성
        
        JLabel label = new JLabel("여기에 라벨 이름을 바로 적어도되고");
        label.setText("여기서 라벨 이름을 적어도 되고");
        
        JPanel panel = new JPanel(); //패널 추가
        panel.add(bt); //패널에 버튼 추가
        
        JPanel panel2 = new JPanel(); //패널2 추가
        panel1.add(label);
        
        frame.add(panel); //프레임에 패널 추가 (프레임 > 패널 > 버튼 등등.. 순서)
        frame.add(panel2); //패널2 추가
        frame.setVisible(true); //GUI띄워주기
    }
}
