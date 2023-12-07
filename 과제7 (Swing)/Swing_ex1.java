import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Swing_ex1
{
    private static void createAndShowGUI() 
    {
		// GUI 생성
		JFrame frame = new JFrame("Swing1 Program"); 	//최상위 컨테이너 – 필수

		JLabel label = new JLabel("I am a label");	//atomic component 생성

		Container contentPane = frame.getContentPane();
		contentPane.add(label); //content pane에 부착

		// GUI 실현
		frame.pack(); // Jframe 크기 결정, 컴포넌트 배치
		frame.setVisible(true); // GUI 실현 – 실제로 GUI를 화면에 그림
  	} 

	public static void main(String[] args) 
    {
		// Event-Dispatching Thread에서 GUI 관련 코드 실행: GUI drawing, Event handling.
		SwingUtilities.invokeLater(new Runnable() 
        {//무명 클래스
            public void run() 
            {
                createAndShowGUI();
            } 
		});
	}    
}
