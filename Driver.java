import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver {
     public static void main(String[] args) {
         int width = 640;
         int height = 480;
	 JFrame frame = new JFrame("Direct draw demo");
	

	 BresenhamLineScan panel = new BresenhamLineScan(width, height);

	 frame.add(panel);
	 frame.pack();
	 frame.setVisible(true);
	 frame.setResizable(false);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

