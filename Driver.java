import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;

public class Driver {
     public static void main(String[] args) {
	 Boolean isRunning = true;
	 Boolean is3x3 = false;
         int width = 640;
         int height = 480;
	 int input;
	 double matrixInput;
	 double[][] matrix1,matrix2;
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

	 frame.add(panel);
	 frame.pack();
	 frame.setVisible(true);
	 frame.setResizable(false);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	 while(isRunning) {
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
	     
	     input = scan.nextInt();
	     switch(input) {
	     case 1:
		 break;
	     case 2:
		 break;
	     case 3:
		 break;
	     case 4:
		 
		 System.out.println("What size is matrix1?");
		 System.out.println("1: 3x3");
		 System.out.println("2: 1X3");
		 input = scan.nextInt();
		 switch(input) {
		 case 1:
		     is3x3 = true;
		     matrix1 = new double[3][3];
		     break;
		 case 2:
		     matrix1 = new double[1][3];
		     break;
		 default:
		     matrix1 = new double[0][0];
		     System.out.println("Invalid Input");
		 }

		 if(is3x3) {
		     for(int i = 0; i < 3; i++) {
			 for(int j = 0; j < 3; j++) {
			     System.out.println("Enter number " + (i*j+1));
			     matrixInput = scan.nextDouble();
			     matrix1[i][j] = matrixInput;
			 }
		     }
		 }//if

		 else {
		     for(int i = 0; i < 3; i++) {
			 System.out.println("Enter number " + (i+1));
			 matrixInput = scan.nextDouble();
			 matrix1[0][i] = matrixInput;
     		     }
		 }

		 System.out.println("What size is matrix2?");
		 System.out.println("1: 3x3");
		 System.out.println("2: 1X3");
		 input = scan.nextInt();
		 switch(input) {
		 case 1:
		     is3x3 = true;
		     matrix2 = new double[3][3];
		     break;
		 case 2:
		     is3x3 = false;
		     matrix2 = new double[1][3];
		     break;
		 default:
		     matrix2 = new double[0][0];
		     System.out.println("Invalid Input");
		 }

		 if(is3x3) {
		     for(int i = 0; i < 3; i++) {
			 for(int j = 0; j < 3; j++) {
			     System.out.println("Enter number " + (i*j+1));
			     matrixInput = scan.nextDouble();
			     matrix2[i][j] = matrixInput;
			 }
		     }
		 }//if

		 else {
		     for(int i = 0; i < 3; i++) {
			 System.out.println("Enter number " + (i+1));
			 matrixInput = scan.nextDouble();
			 matrix2[0][i] = matrixInput;
     		     }
		 }
		

		 panel.concatenate(matrix1,matrix2);
		 System.out.println("Result stored! It can now be used with other transformations.\n\n");
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
		 isRunning = false;
		 break;
	     default:
		 System.out.println("Invalid input.");
	     }
	 }//while

	 System.exit(0);
    }
}

