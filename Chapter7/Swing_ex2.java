import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Swing_ex2 
{
    private	int numClicks = 0;
	private	JLabel label = new JLabel("0");

	// Event Listener – 내부 클래스inner class
	private class MyButtonListener implements ActionListener 
    {
		public void actionPerformed(ActionEvent e) 
        { //사건 발생 시 자동 호출됨
			if (numClicks < 20) 
            {
				numClicks++;
				label.setText("" + numClicks);
			}
    	}
	}
    
    private void createAndShowGUI() 
    { 
		JFrame frame = new JFrame("Swing7-버튼 클릭 횟수 세기");
		// 프레임 속성 설정
		frame.setLayout(new FlowLayout()); // BorderLayout by default
		frame.setSize(400, 300); // frame.setSize(new Dimension(400,300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close 버튼 행동hide by default 설정 – 프로그램 종료
		frame.setLocationRelativeTo(null); // 디스플레이할 위치 설정 - 화면 중앙

		JButton btn = new JButton("Click Me"); // Event Source
       	btn.addActionListener(new MyButtonListener()); // Event Listener 설정

       	JPanel pane = new JPanel(); // intermediate container
       	pane.add(btn);	 // pane에 버튼 추가
		pane.add(label);	 // pane에 레이블 추가
		frame.add(pane);	 // frame(의 content pane)에 pane 추가

		frame.setVisible(true);
    }
    
    public static void main(String[] args) 
    {
		javax.swing.SwingUtilities.invokeLater(
        // 무명 클래스anonymous class
        new Runnable()
        {
            public void run() 
            { 
                new Swing_ex2().createAndShowGUI();
            }
        });
		/* 무명 메소드람다식 사용: 
			javax.swing.SwingUtilities.invokeLater(
				() -> new Swing_ex2().createAndShowGUI()
			); 
		*/
	}
}
