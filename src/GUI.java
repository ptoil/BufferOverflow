import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.*;
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

public class GUI {
	
	Memory RAM;
	HashMap<String, Boolean> flags;
	
	public GUI (Memory m, HashMap<String,Boolean> f) {
		RAM = m;
		flags = f;
	}
	
	public void display () {
		String html = "";
		try {
			File f = new File("src/Grid.html");
//			System.out.println(f.getAbsolutePath());
			Scanner scan = new Scanner(f);
			scan.useDelimiter("\\Z"); 
			html = scan.next();
			scan.close();
		} catch (Exception e) {System.out.println("Issue opening html file");}

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Memory");
		shell.setLayout(new FillLayout());
		Browser browser;
		try {
			browser = new Browser(shell, SWT.NONE);
		} catch (SWTError e) {
			System.out.println("Could not instantiate Browser: " + e.getMessage());
			display.dispose();
			return;
		}
		
		browser.addProgressListener(ProgressListener.completedAdapter(event -> {
			for (int i = 0; i < 50; i++) {
				String script = "document.getElementById('c"+i+"').innerHTML = '" + RAM.readMemory(i, 1)[0] + "';";
				Boolean x = browser.execute(script);
				if (!x) {
					System.out.print(script + " failed");
				}
			}
			for (String i : flags.keySet()) {
				String script = "document.getElementById('flags').innerHTML += '" + i + ": " + flags.get(i) + "<br><br>'";
				Boolean x = browser.execute(script);
				if (!x) {
					System.out.print(script + " failed");
				}
			}
		}));
		
		
		browser.setText(html);		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	
}