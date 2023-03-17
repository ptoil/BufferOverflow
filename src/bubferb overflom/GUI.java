package seniorProject;

import javax.swing.*;
import java.awt.*;

public class GUI {
	
	static Memory RAM;
	
	public GUI (Memory r) {
		RAM = r;
	}

		public void display() {
			JFrame frame = new JFrame("Memory");
			frame.setLayout(new GridLayout(10, 20));
			
			for (int i = 0; i < RAM.MEMORY_SIZE; i++) {
				try {
					char xx = RAM.readMemory(i, 1)[0];
					String x = Character.toString(xx);
					JTextField j = new JTextField(x);
					JTextField o = new JTextField(Integer.toString(i));
					j.setEditable(false);
					o.setEditable(false);
					j.setFont(j.getFont().deriveFont(32.0f));
					o.setFont(o.getFont().deriveFont(12.0f));
					frame.add(o);
					frame.add(j);
					j.setHorizontalAlignment(JTextField.CENTER);
					o.setHorizontalAlignment(JTextField.CENTER);
				} catch (NullPointerException e) {}
			}   
			
			frame.setSize(1200, 700);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			
		}
		
	}