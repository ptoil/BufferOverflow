import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class GUI {
	
	static Memory RAM;
	
	public GUI (Memory r) {
		RAM = r;
	}
	
	public void display() {
		JFrame frame = new JFrame("Memory");
		frame.setLayout(new GridLayout(10, 20));
		
		for (int i = 0; i < 200; i++) {
			try {
				char xx = RAM.readMemory(i, 1)[0];
				String x = Character.toString(xx);
				System.out.println(xx);
				JTextField j = new JTextField(x);
				j.setEditable(false);
				j.setFont(j.getFont().deriveFont(32.0f));
				frame.add(j);
			} catch (NullPointerException e) {}
		}   
		
		frame.setSize(1200, 700);
		frame.setVisible(true);
	}
	
}
