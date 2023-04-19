package multithread;

import java.util.Map;

class Multithreading extends Thread {
    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println(
                "Thread " + Thread.currentThread().getId() + " is running");
            	System.out.println(Thread.currentThread().getState());
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}
 
// Main Class
public class uhoh {
    public static void main(String[] args) {
        int n = 2; // Number of threads
        for (int i = 0; i < n; i++) {
            Multithreading object = new Multithreading();
            object.start();
        }
        
        
        /*
        Map<Thread, StackTraceElement[]> m = Thread.getAllStackTraces();
        
        for (var entry : m.entrySet()) {
        	Thread.State state = ((Thread) entry).getState();
        	System.out.println("State: " + state);
        	
        }
        
        
         * for (Map.Entry<Thread, StackTraceElement[]> entry : m.entrySet()) {
        	System.out.println(entry.getKey() + "/" + entry.getValue());
        }
         */
        /*
        for (var entry : m.entrySet()) {
        	System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        */
    }

   
}

