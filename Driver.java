import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;

public class Driver {
     public static void main(String[] args) {
         int width = 640;
         int height = 480;
	 JFrame frame = new JFrame("Project 3");
	 Scanner scan = new Scanner(System.in);
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

	 System.out.println("What would you like to do?");
	 System.out.println("1: Basic Translation");
	 System.out.println("2: Basic Scale");
	 System.out.println("3: Basic Rotate");
	 System.out.println("4: Concatenate");
	 System.out.println("5: Apply Transformation");
	 System.out.println("6: Viewport-spec");
	 System.out.println("7: Display Pixels");
	 System.out.println("8: Input Lines");
	 System.out.println("9: Output Lines");
	 System.out.println("10: Exit");

	 int input = scan.nextInt();
	 switch(input) {
	 case 1:
	     break;
	 case 2:
	     break;
	 case 3:
	     break;
	 case 4:
	     break;
	 case 5:
	     break;
	 case 6:
	     break;
	 case 7:
	     break;
	 case 8:
	     break;
	 case 9:
	     DataLine.outputLines(panel.getDatalines(), panel.getNumOfDatalines());
	     break;
	 case 10:
	     break;
	 default:
	     System.out.println("Invalid input.");
	 }
	
	 frame.add(panel);
	 frame.pack();
	 frame.setVisible(true);
	 frame.setResizable(false);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

