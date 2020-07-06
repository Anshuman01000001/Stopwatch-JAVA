import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");
	JLabel timeLable = new JLabel();
	
	int elapesedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener(){
		public void actionPerformed(ActionEvent e){
			
			elapesedTime+=1000;
			hours = (elapesedTime/3600000);
			minutes = (elapesedTime/60000) % 60;
			seconds = (elapesedTime/1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLable.setText(hours_string+":"+minutes_string+":"+seconds_string);
		}
	});
	
	Stopwatch(){
		timeLable.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLable.setBounds(50,50,200,100);
		timeLable.setFont(new Font("Verdana", Font.PLAIN,35));
		timeLable.setBorder(BorderFactory.createBevelBorder(1));
		timeLable.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(50,200,100,50);
		startButton.setFont(new Font("Ink Free", Font.PLAIN,20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		resetButton.setBounds(150,200,100,50);
		resetButton.setFont(new Font("Ink Free", Font.PLAIN,20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(timeLable);
		frame.add(startButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(320,320);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		 if(e.getSource()==startButton){
			 if(started==false){
				 started=true;
				 startButton.setText("STOP");
				 start();
			 }else{
				 started=false;
				 startButton.setText("START");
				 stop();
			 }
		 }
		 if(e.getSource()==resetButton){
			 started=false;
			 startButton.setText("START");
			 reset();
		 }
	}
	
	void start(){
		timer.start();
	}
	
	void stop(){
		timer.stop();
	}
	
	void reset(){
		timer.stop();
		elapesedTime = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLable.setText(hours_string+":"+minutes_string+":"+seconds_string);
	}
}