import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.imageio.*;

public class Easy extends JFrame{
	ImageIcon img = new ImageIcon("images/뒤집기전.jpg");
	ImageIcon img1= new ImageIcon("images/테스트1.jpg");
	ImageIcon img2= new ImageIcon("images/테스트2.jpg");
	ImageIcon img3= new ImageIcon("images/테스트3.jpg");
	ImageIcon images[]= {img1,img2,img3,img1,img2,img3};
	JPanel Easy = new JPanel();
	int count[]= new int[6];
	public int n=0,num=0;
	public JButton [] button=new JButton[6];
	
	JButton firstclick;
	JButton secondclick;
	public Easy() {
		setTitle("쉬운 단계");
		Easy.setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton mainscreen=new JButton("메인 화면으로");
        JLabel label=new JLabel("사과, 수박, 바나나 맞추기");
        label.setSize(200,50);
        label.setLocation(20, 20);
        mainscreen.setSize(120,40);
        mainscreen.setBackground(Color.WHITE);
        mainscreen.setLocation(350, 20);
        
        
       
        Easy.setLayout(null); 
        int x=100;
        int x2=100;
        for(int i=0;i<6;i++){
            button[i]=new JButton(img);
            if(i<=2) button[i].setBounds(x,100,150,200);
            else {
               button[i].setBounds(x2,350,150,200);
               x2+=200;
            }
            x+=200;
            button[i].addActionListener(new MyAction(this));
            Easy.add(button[i]);
        }
        add(Easy);
        Easy.add(mainscreen);
        Easy.add(label);
       
        setSize(800,700);
        Random p= new Random();
		for(int i=0;i<6;i++) {
			count[i]=p.nextInt(6);
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
	public MyAction(Easy easy) {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) { 
		//int s=0;


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
	            for(int j=0;j<6;j++){
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
	  
	  if(num==3) {
	    	JOptionPane.showMessageDialog(null, "모든 카드를 뒤집었습니다.");
	  }
    }
   }

	
}

