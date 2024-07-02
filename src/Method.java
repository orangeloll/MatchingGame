import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;

public class Method extends JFrame {
	MyPanel Method=new MyPanel();

	public Method() {
		setTitle("방법");
		Method.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton back= new JButton("돌아가기");
		back.setSize(120,50);
		back.setLocation(350,550);
		back.setBackground(Color.WHITE);
		Method.add(back);
		add(Method);
		setSize(800, 700);
		setVisible(true);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JavaProj();
				setVisible(false);
			}
		});
	}
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/게임설명.jpg");
		private Image img = icon.getImage(); // 이미지 객체
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);
		}
	}
}
