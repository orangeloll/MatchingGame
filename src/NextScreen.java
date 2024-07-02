import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NextScreen extends JFrame{
	MyPanel Screen2 = new MyPanel();
	public NextScreen() {
		setTitle("단계 선택");
		Screen2.setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Screen2.setLayout(null);
		JButton easy= new JButton("쉬운 단계");
		easy.setSize(90,50);
		easy.setLocation(350,300);
		easy.setBackground(Color.WHITE);
		JButton normal= new JButton("중간 단계");
		normal.setSize(90,50);
		normal.setLocation(350,380);
		normal.setBackground(Color.WHITE);
		JButton hard= new JButton("어려운 단계");
		hard.setSize(120,50);
		hard.setLocation(335,460);
		hard.setBackground(Color.WHITE);
		add(Screen2);
		Screen2.add(easy);
		Screen2.add(normal);
		Screen2.add(hard);
		setSize(800,700);
		setVisible(true);
		easy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Easy();
				setVisible(false);
			}
		});
		normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Normal();
				setVisible(false);
			}
		});
		hard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Hard();
				setVisible(false);
			}
		});
	}
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/단계선택.jpg");
		private Image img = icon.getImage(); // 이미지 객체
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);
		}
	}
}
