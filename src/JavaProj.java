import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;


public class JavaProj extends JFrame {
	ImageIcon img = new ImageIcon("images/주의사항.png");
	private MyPanel panel = new MyPanel();
	public JavaProj() {
		setTitle("자바 프로젝트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//시작메뉴창
		panel.setLayout(null);
		JLabel warning=new JLabel("게임 방법을 읽고 시작해주세요.");
		warning.setSize(600,100);
		warning.setLocation(100,400);
		warning.setIcon(img);
		JButton start= new JButton("게임 시작");
		start.setSize(90,50);
		start.setLocation(350,500);
		start.setBackground(Color.WHITE);
		JButton method= new JButton("게임 방법");
		method.setSize(90,50);
		method.setLocation(350,580);
		method.setBackground(Color.WHITE);
		add(panel);
		panel.add(start);	
		panel.add(method);
		panel.add(warning);
		setSize(800, 700);
		setVisible(true);
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NextScreen();
				setVisible(false);
			}
		});
		method.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Method();
				setVisible(false);
			}
		});
	}
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/시작화면.jpg");
		private Image img = icon.getImage(); // 이미지 객체
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);
		}
	}
	public static void main(String[] args) {
		new JavaProj();
	}

}
