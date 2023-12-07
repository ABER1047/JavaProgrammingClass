import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Swing_ex3 implements ActionListener
{
    JFrame converterFrame;		//최상위 컨테이너, the application window
	JPanel converterPanel;		//중간컨테이너

    JTextField tempCelsius; 	//섭씨온도를 입력받을 text field
	JLabel celsiusLabel;	 	//text field를 설명하는 label
	JLabel fahrenheitLabel; 	//변환된 화씨온도를 디스플레이 하기 위한 label
    JButton convertTemp;	 	//변환 작업을 요청하는 button, the event source
    
    public Swing_ex3() 
    {
        // application window를 생성하고, 속성을 설정한다.
        converterFrame = new JFrame("Convert Celsius to Fahrenheit");
        converterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        converterFrame.setSize(new Dimension(120, 40));
        converterFrame.setLocationRelativeTo(null);

            // 중간컨테이너에 컴포넌트들을 부착하고add, 중간컨테이너를 window에 부착한다.
        converterPanel = new JPanel(new GridLayout(2, 2));
        addWidgets();
        converterFrame.getRootPane().setDefaultButton(convertTemp);
        converterFrame.getContentPane().add(converterPanel, BorderLayout.CENTER);

        converterFrame.pack();
        converterFrame.setVisible(true);
    }
    
    private void addWidgets() 
    {
        // 컴포넌트 생성 
        tempCelsius = new JTextField(2); //파라미터 – preferred width (단위: 칼럼의 개수)
        celsiusLabel = new JLabel("Celsius", SwingConstants.LEFT); //align along left
        convertTemp = new JButton("Convert");
        fahrenheitLabel = new JLabel("Fahrenheit", SwingConstants.CENTER);

        // 버튼의 event listener를 설정함
        convertTemp.addActionListener(this);
        //try: tempCelsius.addActionListener(this);

        // 중간 컨테이너에 컴포넌트들을 부착함
        converterPanel.add(tempCelsius);
        converterPanel.add(celsiusLabel);
        converterPanel.add(convertTemp);
        converterPanel.add(fahrenheitLabel);
        
        // 컴포넌트의 경계선 설정
        celsiusLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        fahrenheitLabel.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    
    public void actionPerformed(ActionEvent event) 
    {
        int tempFahr = (int)((Double.parseDouble(tempCelsius.getText()))*1.8 + 32);
        fahrenheitLabel.setText(tempFahr + " Fahrenheit");
    }

    // For thread safety, this method should be invoked from the event-dispatching thread.
    private static void createAndShowGUI() 
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Swing_ex3 converter = new Swing_ex3();
    }
    
    public static void main(String[] args) 
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                createAndShowGUI();
            }
        });
   }
}
