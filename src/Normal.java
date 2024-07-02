import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.imageio.*;

public class Normal extends JFrame{	
	ImageIcon img = new ImageIcon("images/뒤집기전.jpg");
	ImageIcon img1= new ImageIcon("images/테스트1.jpg");
	ImageIcon img2= new ImageIcon("images/테스트2.jpg");
	ImageIcon img3= new ImageIcon("images/테스트3.jpg");
	ImageIcon img4= new ImageIcon("images/테스트4.jpg");
	ImageIcon img5= new ImageIcon("images/테스트5.jpg");
	ImageIcon img6= new ImageIcon("images/테스트6.jpg");
    ImageIcon images[]= {img1,img2,img3,img4,img5,img6,img1,img2,img3,img4,img5,img6};
    
    JPanel Normal=new JPanel();
	int n=0,num=0;
	int count[]= new int[12];
	JButton firstclick;
	JButton secondclick;
	JButton [] button=new JButton[12];
	public Normal() {
		setTitle("중간 단계");
		Normal.setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton mainscreen=new JButton("메인 화면으로");
        JLabel label=new JLabel("<html>사과, 수박, 바나나<br>포도, 귤, 키위 맞추기</html>");
        label.setSize(200,100);
        label.setLocation(20, 20);
        mainscreen.setSize(120,40);
        mainscreen.setBackground(Color.WHITE);
        mainscreen.setLocation(350, 20);

        
        
        Normal.setLayout(null);
        int x=10;
        int x2=10;
        int x3=250;
        for(int i=0;i<12;i++){
            button[i]=new JButton(img);
            if(i<=4) button[i].setBounds(x,130,150,200);
            else if(i>4&&i<=9) {
               button[i].setBounds(x2,340,150,200);
               x2+=160;
            }
            else {
            	button[i].setBounds(x3,550, 150, 200);
            	x3+=160;
            }
            x+=160;
            button[i].addActionListener(new MyAction(this));
            Normal.add(button[i]);
        }       
        add(Normal);
        Normal.add(mainscreen);
        Normal.add(label);
        setSize(850,900);
		
        Random p= new Random();
		for(int i=0;i<12;i++) {
			count[i]=p.nextInt(12);
			for(int j=0;j<i;j++) {
				if(count[i]==count[j]){
				     i--;
				}
			}
					
		}
		setVisible(true);
		mainscreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JavaProj();
				setVisible(false);
			}
		});
	}
	private class MyAction implements ActionListener{
		public MyAction(Normal normal) {
			// TODO Auto-generated constructor stub
		}

		public void actionPerformed(ActionEvent e) { 


		  for(int i = 0; i < button.length; i++) { 
		    if(e.getSource() == button[i]) { 
		       n++;
		       button[i].setIcon(images[count[i]]);
		       if(n==1) {
				firstclick=button[i];
		       }
		       else if(n==2) {
			     secondclick=button[i];
			     if(secondclick.getIcon()!=firstclick.getIcon()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            button[i].setIcon(img);
		            for(int j=0;j<12;j++){
		               if(firstclick==button[j]) button[j].setIcon(img);
		           }
		         }
			     else{
				    	num++;
				    	}
			    n=0;
		      }
		    }
		  }
		  if(num==6) {
		    	JOptionPane.showMessageDialog(null, "모든 카드를 뒤집었습니다.");
		  }
	    }
	   }
}
