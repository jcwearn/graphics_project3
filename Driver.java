import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver {
     public static void main(String[] args) {
         int width = 640;
         int height = 480;
	 JFrame frame = new JFrame("Direct draw demo");
	

	 BresenhamLineScan panel = new BresenhamLineScan(width, height);

	 DataLine line1 = new DataLine(10,10,10,100);
	 DataLine line2 = new DataLine(10,10,100,10);
	 DataLine line3 = new DataLine(10,10,100,100);
	 DataLine line4 = new DataLine(100,100,150,50);
	 DataLine line5 = line4.basicTranslate(50,50);
	 DataLine line6 = line5.basicScale(2,1.5);
	 DataLine line7 = line6.basicRotate(30);
	 //drawLine(line1);
	 //horizontal
	 //drawLine(line2);
	 //diagonal pos
	 //drawLine(line3);
	 //diagonal neg
	 panel.drawLine(line4);
	 panel.drawLine(line5);
	 panel.drawLine(line6);
	 panel.drawLine(line7);
	 DataLine.outputLines(panel.getDatalines(), panel.getNumOfDatalines());
	
	 frame.add(panel);
	 frame.pack();
	 frame.setVisible(true);
	 frame.setResizable(false);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

