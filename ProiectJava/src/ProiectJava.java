import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.lang.Math;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.Border;


public class ProiectJava extends JFrame implements ActionListener{
	
	JPanel panel=new JPanel();
    JPanel panel2=new JPanel();
    JPanel panel3=new JPanel();
    
    JLabel label=new JLabel("Introduceti coeficientii");
    JLabel label2=new JLabel("Proprietatile conicei");
    JLabel label3=new JLabel("Desen");
    
    float a11,a12,a22,a13,a23,a33,delta=1,delta1,x,y; 
    
    JLabel ec = new JLabel("<html>Ecuatia conicei: a<sub>11</sub>x<sup>2</sup>+2a<sub>12</sub>xy+a<sub>22</sub>y<sup>2</sup>+2a<sub>13</sub>x+2a<sub>23</sub>y+a<sub>33</sub>=0</html>");
    JLabel Ldelta = new JLabel("δ=");
    JLabel Ldelta1 = new JLabel("∆=");
    JLabel genulConicei = new JLabel("Genul conicei: ");
    JLabel tipulConicei = new JLabel("Tipul conicei: ");
    JLabel denumireaConicei = new JLabel("Denumirea conicei: ");
    JLabel centrul = new JLabel("Centrul conicei: ");
    
    TextField ta11 = new TextField("6",10),ta12= new TextField("6",10),ta22= new TextField("8",10),ta13= new TextField("21",10),ta23= new TextField("3",10),ta33= new TextField("6",10);
    Button Deseneaza = new Button("Deseneaza");
    
    
    Point c = new Point(); //centrul conicei
    int k =0;
	
	
	ProiectJava(){
		setTitle("Proiect Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        setBounds(0,0,1280,720);
        
        panouri();
        labels();
        casete();
        buton();
        labels2();
        
	}
	
	public void paint(Graphics g) {
		super.paint(getGraphics());
		g.drawLine(860,100 , 860, 640);
		g.drawLine(500,370 , 1220, 370);
		if(k==1) {
		g.setColor(Color.blue);
		g.fillOval((10*(int)(x)+860-5), (10*(-1)*(int)(y)+370-5), 10, 10); //deseneaza centrul conicei
		g.setColor(Color.white);
		float i=-50, j=-50;
		for( i=-50;i<=50;i+=0.01) {
			for( j=-50;j<=50;j+=0.01) {
				if(a11*i*i+2*a12*i*j+a22*j*j+2* a13 *i+2* a23 *j+ a33 > -0.1 && a11*i*i+2*a12*i*j+a22*j*j+2* a13 *i+2* a23 *j+ a33 < 0.1) {
					
					g.drawLine((int)i*10+860, -1*(int)j*10+370, (int)i*10+862, -1*(int)j*10+372);
					g.fillOval((int)i*10+860, -1*(int)j*10+370,2,2);
				}
			}
		}
		}
	}

	
	
	
	public void panouri() {
		
		Border br = BorderFactory.createLineBorder(Color.black);
        Container c=getContentPane();
        
		panel.setBackground(Color.gray);
	    panel.setBounds(10,10,400,325);

	    panel3.setBackground(Color.gray);
	    panel3.setBounds(420,10,830,660);

	    panel2.setBackground(Color.gray);
	    panel2.setBounds(10,345,400,325);
	        
	    panel.setLayout(null);
	    panel2.setLayout(null);
	    panel3.setLayout(null);
	        
	    panel.setBorder(br);
	    panel2.setBorder(br);
	    panel3.setBorder(br);
	    

	    
	    c.add(panel);
	    c.add(panel2);
	    c.add(panel3);
	        
	    setVisible(true); 
	}
	
	public void casete() {
		ta11.setBounds(80, 70, 50, 20);
        ta12.setBounds(80, 100, 50, 20); 
        ta22.setBounds(80, 130, 50, 20);
        ta13.setBounds(250, 70, 50, 20);
        ta23.setBounds(250, 100, 50, 20);       
        ta33.setBounds(250, 130, 50, 20);
        
        panel.add(ta11);
        panel.add(ta12);
        panel.add(ta22);
        panel.add(ta13);
        panel.add(ta23);
        panel.add(ta33);
	}
	
	public void labels() {
		JLabel La11 = new JLabel("a11:");
        JLabel La12 = new JLabel("a12:");
        JLabel La22 = new JLabel("a22:");
        JLabel La13 = new JLabel("a13:");
        JLabel La23 = new JLabel("a23:");
        JLabel La33 = new JLabel("a33:");
        
        La11.setBounds(50, 70, 30, 20);
        La12.setBounds(50, 100, 30, 20);
        La22.setBounds(50, 130, 30, 20);
        La13.setBounds(220, 70, 30, 20);
        La23.setBounds(220, 100, 30, 20);
        La33.setBounds(220, 130, 30, 20);
        
        label.setBounds(130,0,500,30);
        label2.setBounds(135,0,500,30);
        label3.setBounds(410,0,500,30);
        
        panel.add(La11);
        panel.add(La12);
        panel.add(La22);
        panel.add(La13);
        panel.add(La23);
        panel.add(La33);
        
        panel.add(label);
        panel2.add(label2);
        panel3.add(label3);
        
	}
	
	public void labels2() {
		
		Ldelta.setBounds(2,60,400,30);
		Ldelta1.setBounds(2,80,400,30);
		centrul.setBounds(2,100,400,30);
		genulConicei.setBounds(2,120,400,30);
		tipulConicei.setBounds(2,140,400,30);
		denumireaConicei.setBounds(2,160,400,30);
		
		
		ec.setBounds(2,40, 400, 30);
		
		panel2.add(genulConicei);
		panel2.add(tipulConicei);
		panel2.add(denumireaConicei);
		panel2.add(centrul);
		panel2.add(Ldelta1);
		panel2.add(Ldelta);
		panel2.add(ec);
	}
	
	public void buton() {
		Deseneaza.setBounds(150, 220, 80, 40);
		
        Deseneaza.addActionListener(this);
        
        panel.add(Deseneaza);
        
	}
	
	public void actiuneButon() {
		a11 = Integer.parseInt(ta11.getText());
        a12 = Integer.parseInt(ta12.getText());
        a22 = Integer.parseInt(ta22.getText());
        a13 = Integer.parseInt(ta13.getText());
        a23 = Integer.parseInt(ta23.getText());
        a33 = Integer.parseInt(ta33.getText());
        
        delta = a11*a22-a12*a12;
        delta1 = a11*a22*a33+2*a23*a13*a12-a11*a23*a23-a22*a13*a13-a33*a12*a12;
        
        //ec.setText("Ecuatia conicei: " + a11 + "x^2+2*" + a12 + "*x*y+" + a22 + "y^2+2*" + a13 + "*x+2*" + a23 + "*y+" + a33 + "=0");
        ec.setText("<html>Ecuatia conicei: a<sub>11</sub>x<sup>2</sup>+2a<sub>12</sub>xy+a<sub>22</sub>y<sup>2</sup>+2a<sub>13</sub>x+2a<sub>23</sub>y+a<sub>33</sub>=0</html>");
        calculeazaCentru();
       
        Ldelta.setText("δ=" + delta);
        Ldelta1.setText("∆=" + delta1);
        centrul.setText("Centrul conicei: (" +  x + "," + y + ")");
        tipulConicei();
        repaint();
        
	}
	
	public void tipulConicei() {
		if(delta>0 && delta1!=0) {
			genulConicei.setText("Genul conicei: eliptic");
			tipulConicei.setText("Tipul conicei: nedegenerat");
			denumireaConicei.setText("Denumirea conicei: elipsa");
		}
		else if(delta>0 && delta1==0) {
			genulConicei.setText("Genul conicei: eliptic");
			tipulConicei.setText("Tipul conicei: degenerat");
			denumireaConicei.setText("Denumirea conicei: punct dublu");
		}
		else if(delta<0 && delta1!=0) {
			genulConicei.setText("Genul conicei: hiperbolic");
			tipulConicei.setText("Tipul conicei: nedegenerat");
			denumireaConicei.setText("Denumirea conicei: hiperbola");
		}
		else if(delta<0 && delta1==0) {
			genulConicei.setText("Genul conicei: hiperbolic");
			tipulConicei.setText("Tipul conicei: degenerat");
			denumireaConicei.setText("Denumirea conicei: drepte concurente");
		}
		else if(delta==0 && delta1!=0) {
			genulConicei.setText("Genul conicei: parabolic");
			tipulConicei.setText("Tipul conicei: nedegenerat");
			denumireaConicei.setText("Denumirea conicei: parabola");
		}
		else if(delta==0 && delta1==0) {
			genulConicei.setText("Genul conicei: parabolic");
			tipulConicei.setText("Tipul conicei: degenerat");
			denumireaConicei.setText("Denumirea conicei: drepte");
		}
		
	}
	
	public void calculeazaCentru() {
		
		if(delta==0) {
			x=1;
			c.y=0;
		}
		else {
			x= (a12*a23-a22*a13)/delta;
			y = (a12*a13-a11*a23)/delta;
		}
		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new ProiectJava();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
        actiuneButon();
        k=1;
        
	}
	
}

