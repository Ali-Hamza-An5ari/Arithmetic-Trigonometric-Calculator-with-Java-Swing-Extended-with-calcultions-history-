import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.*;
import static java.lang.Math.*;
class GUI implements ActionListener
{
	JFrame frame ;
	JPanel panel1 ;
	ImageIcon image ;
	JLabel bl,history;
	JTextArea hist;
	Container c ;
	JTextField inp,res;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,plus,min,Bs,clear,mul,div,eq,dec,sq,sqRt,Sinx,Cosx,Tanx;
	Font font;
	String input = "", result = "" ,oper,str;
	StringBuilder sb;
	String [] token = null;
	char f,l;
	double num1,num2,ans;	
	int i,len;
	void Draw ()
	{
		frame = new JFrame ("CALCULATOR");
			frame.setBounds(100,100,600,450);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

			Color color = new Color (200,250,50,80);
		c = frame.getContentPane();
			c.setBackground(color);
			c.setLayout(null);
			
		
		font = new Font("Calibiri",Font.BOLD,15);	
			
		history = new JLabel("HISTORY");
			history.setBounds(340,12,100,40);
			history.setFont(font);
			c.add(history);
		hist = new JTextArea();
			hist.setBounds(340,60,200,280);
			hist.setFont(font);
			c.add(hist);
			
		inp = new JTextField ();
			inp.setPreferredSize(new Dimension (1,24));
			inp.setBounds(10,12,310,32);
			c.add(inp);
		res = new JTextField();
			res.setPreferredSize(new Dimension(1,24));
			res.setBounds(10,50,310,32);
			c.add(res);
		
		// ===================================Row1==========================
		clear = new JButton ("C");
			clear.setFont(font);
			clear.addActionListener(this);
			clear.setBounds(66,88,50,50);
			c.add(clear);
		Bs = new JButton (new ImageIcon("Bs.png"));	
			Bs.addActionListener(this);
			Bs.setBounds(122,88,50,50);
			c.add(Bs);
		div = new JButton (new ImageIcon("div.png"));
			div.addActionListener(this);
			div.setBounds(178,88,50,50);
			c.add(div);
		sqRt = new JButton("\u221A");
			sqRt.setFont(font);
			sqRt.addActionListener(this);
			sqRt.setBounds(244,88,70,50);
			c.add(sqRt);
		// ============================Row2===============================
		
		b7 = new JButton ("7");
			b7.setFont(font);
			b7.addActionListener(this);
			b7.setBounds(10,144,50,50);
			c.add(b7);
		b8 = new JButton ("8");
			b8.setFont(font);
			b8.addActionListener(this);
			b8.setBounds(66,144,50,50);
			c.add(b8);		
		b9 = new JButton ("9");
			b9.setFont(font);
			b9.addActionListener(this);
			b9.setBounds(122,144,50,50);
			c.add(b9);	
		mul = new JButton (new ImageIcon("mul.png"));
		
			mul.addActionListener(this);
			mul.setBounds(178,144,50,50);
			c.add(mul);	
		Sinx = new JButton ("Sinx");
			Sinx.setFont(font);
			Sinx.addActionListener(this);
			Sinx.setBounds(244,144,70,50);
			c.add(Sinx);
		// =============================Row3============================
		
		b4 = new JButton ("4");
			b4.setFont(font);
			b4.addActionListener(this);
			b4.setBounds(10,200,50,50);
			c.add(b4);
		b5 = new JButton ("5");
			b5.setFont(font);
			b5.addActionListener(this);
			b5.setBounds(66,200,50,50);
			c.add(b5);
		b6 = new JButton ("6");
			b6.setFont(font);
			b6.addActionListener(this);
			b6.setBounds(122,200,50,50);
			c.add(b6);
		min = new JButton (new ImageIcon("min.png")); 
			// min.addActionListener(new ListenTomin());
			min.addActionListener(this);
			min.setBounds(178,200,50,50);
			c.add(min);
			c.add(Sinx);		
		Cosx = new JButton("Cosx");
			Cosx.setFont(font);
			Cosx.addActionListener(this);
			Cosx.setBounds(244,200,70,50);
			c.add(Cosx);		
		
		// ===================================Row4===============================
			
		b1 = new JButton ("1");
			b1.setFont(font);
			b1.addActionListener(this);
			b1.setBounds(10,256,50,50);
			c.add(b1);		
		b2 = new JButton ("2");
			b2.setFont(font);
			b2.addActionListener(this);
			b2.setBounds(66,256,50,50);
			c.add(b2);		
		
		b3 = new JButton ("3");
			b3.setFont(font);
			b3.addActionListener(this);
			b3.setBounds(122,256,50,50);
			c.add(b3);		
		plus = new JButton (new ImageIcon("plus.png"));
			plus.addActionListener(this);
			plus.setBounds(178,256,50,50);
			c.add(plus);
		Tanx = new JButton ("Tanx");
			Tanx.setFont(font);
			Tanx.addActionListener(this);
			Tanx.setBounds(244,256,70,50);
			c.add(Tanx);		
	
		// =========================Row5=============================

		dec = new JButton(".");
			dec.setFont(font);
			dec.addActionListener(this);
			dec.setBounds(10,312,50,50);
			c.add(dec);		
			
		b0 = new JButton ("0");
			b0.setFont(font);
			b0.addActionListener(this);
			b0.setBounds(66,312,50,50);
			c.add(b0);		
		
		eq = new JButton (new ImageIcon("eq.png"));
			
			eq.addActionListener(this);
			eq.setBounds(122,312,106,50);
			c.add(eq);	
			
		sq = new JButton ("x^y");	
			sq.setFont(font);
			sq.setBounds(244,312,70,50);
			sq.addActionListener(this);
			c.add(sq);
	
	}
	
	public void actionPerformed (ActionEvent ae)
	{
		input = inp.getText();
		if (ae.getSource() == b0){input = input+ "0";}
		if (ae.getSource() == b1){input = input+ "1";}
		if (ae.getSource() == b2){input = input+ "2";}
		if (ae.getSource() == b3){input = input+ "3";}
		if (ae.getSource() == b4){input = input+ "4";}
		if (ae.getSource() == b5){input = input+ "5";}
		if (ae.getSource() == b6){input = input+ "6";}
		if (ae.getSource() == b7){input = input+ "7";}
		if (ae.getSource() == b8){input = input+ "8";}
		if (ae.getSource() == b9){input = input+ "9";}
		if (ae.getSource() == plus){input = input+ "+";}
		if (ae.getSource() == min){input = input+ "-";}
		if (ae.getSource() == mul){input = input+ "x";}
		if (ae.getSource() == div){input = input+ "/";}
		if (ae.getSource() == clear){input = ""; res.setText("");}
		if (ae.getSource() == dec){input = input+ ".";}
		if (ae.getSource() == sq) {input = input + "^";}
		if (ae.getSource() == sqRt) {input = "\u221A"+input;}
		if (ae.getSource() == Sinx) {input = "Sin("+input+")";}
		if (ae.getSource() == Cosx) {input = "Cos("+input+")";}
		if (ae.getSource() == Tanx) {input = "Tan("+input+")";}
		if (ae.getSource() == Bs)
		{
			sb = new StringBuilder(inp.getText());
			if (sb.length() > 0)
			{
				sb = sb.deleteCharAt(sb.length()-1);
				input = sb.toString();
			}
			
		}
		
		inp.setText(input);
		
		str = input;
		
		
		if (ae.getSource() == eq)
		{
			l = input.charAt(input.length()-1);
			f = input.charAt(0);
			
		//Here we are dealing with input syntax error of signs. This if will not allow to enter a sign at last of first.
			// if ((input.charAt(input.length()-1) != '+') || (input.charAt(input.length()-1) != '-') || (input.charAt(input.length()-1) != 'x') || (input.charAt(input.length()-1) != '/')||(input.charAt(0) != '+') ||(input.charAt (0) != '-') || (input.charAt(0) != 'x') || (input.charAt(0) != '/'))
		if ((f != '+') && (f != '-') && (f != 'x') && (f != '/')&& (f != '^') &&(l != '+') &&(l != '-') && (l != 'x') && (l != '/')&& (l != '^')&& (l != '\u221A'))
		{
			if (input.contains("+") )
			{
				token = input.split("[+]");
				num1= Double.parseDouble(token[0]);
				num2= Double.parseDouble(token[1]);
				
				ans = (num1+num2);
				result = ans+"" ;
			}
			if (input.contains("-"))
			{
				token = input.split("[-]");
				num1= Double.parseDouble(token[0]);
				num2= Double.parseDouble(token[1]);
				result = (num1-num2)+"";
			}
			if (input.contains("x"))
			{
				token = input.split("[x]");
				num1= Double.parseDouble(token[0]);
				num2= Double.parseDouble(token[1]);
				result = (num1*num2)+"";
			}
			if (input.contains("/"))
			{
				token = input.split("[/]");
				num1= Double.parseDouble(token[0]);
				num2= Double.parseDouble(token[1]);
				result = (num1/num2)+"";
			}
			if (input.contains("^")) 
			{
				token[0] = input.substring(0,input.indexOf('^'));
				token[1] = input.substring(input.indexOf('^')+1);
				
				num1 = Double.parseDouble(token[0]);
				num2 = Double.parseDouble(token[1]);
				result = token[0]+" "+token[1];
				
			} 
			if (input.contains("\u221A"))
			{
				token = input.split("[\u221A]");
				num2 = Double.parseDouble(token[1]);
				result = (sqrt(num2))+"";
				
			}
		}
		else 
		{
			result = "Syntax Error!";
		}
		
		//Trigonometric functions.
		
			if (input.contains("Sin"))
			{
				input = input.substring(4,input.length()-1);
				num1 = Double.parseDouble(input);
				num1 = toRadians(num1);
				ans = sin(num1);
				result = ans+"";
			}			
			if (input.contains("Cos"))
			{
				input = input.substring(4,input.length()-1);
				num1 = Double.parseDouble(input);
				num1 = toRadians(num1);
				ans = cos(num1);
				result = ans+"";
			}			
			if (input.contains("Tan"))
			{
				input = input.substring(4,input.length()-1);
				num1 = Double.parseDouble(input);
				num1 = toRadians(num1);
				ans = tan(num1);
				result = ans+"";
			}
			res.setText(result);
			
			str = str +" = " + result;
			hist.setText(hist.getText()+"\n"+str);	
		}
			
			
	}
}


public class Calculator
{
	public static void main (String args[])
	{
		GUI gui = new GUI ();
		gui.Draw();
	}
	
}
