import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DataLine {
    private int x1,x2,y1,y2;
    private double[][] concatenateMatrix;
    
    public DataLine(int x1, int y1, int x2, int y2) {
	this.x1 = x1;
	this.y1 = y1;
	this.x2 = x2;
	this.y2 = y2;
    }//DataLine

    //getters and setters
    public int getx1() {
	return x1;
    }//getx1

    public void setx1(int x) {
	x1 = x;
    }//setx1

    public int gety1() {
	return y1;
    }//gety1

    public void sety1(int y) {
	y1 = y;
    }//sety1

    public int getx2() {
	return x2;
    }//getx2

    public void setx2(int x) {
	x2 = x;
    }//setx2

    public int gety2() {
	return y2;
    }//gety2

    public void sety2(int y) {
	y2 = y;
    }//sety1

    public DataLine[] applyTransformation(double[][] matrix, DataLine[] datalines, int num) {
	DataLine[] transformedLines = new DataLine[num];

	for(int i = 0; i < num; i++) {
	    int x1 = datalines[i].getx1();
	    int y1 = datalines[i].gety1();
	    int x2 = datalines[i].getx2();
	    int y2 = datalines[i].gety2();
	    
	    double[][] point1 = { {(double)x1,(double)y1,1.00} };
	    double[][] point2 = { {(double)x2,(double)y2,1.00} };
	    double[][] result1 = Matrix.multiplicar(point1,matrix);
	    double[][] result2 = Matrix.multiplicar(point2,matrix);
	    DataLine line = new DataLine((int)result1[0][0], (int)result1[0][1], (int)result2[0][0], (int)result2[0][1]);
	    transformedLines[i] = line;
	}

	return transformedLines;
    }//applyTransformation

    public void viewportSpec(int Vx0, int Vy0, int Vx1, int Vy1) {

    }//viewportSpec

    public void displayPixels(DataLine[] datalines, int num) {

    }//displayPixels

    public void inputLines(DataLine[] datalines, int num) {

    }//inputLines

    public static void outputLines(ArrayList<DataLine> datalines, int num) {
	DataLine dataToAppend;
	int x1,x2,y1,y2;
	String input;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter a name for the txt file: ");
	input = scanner.nextLine();
	
	Writer writer = null;

	try {
 	    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(input + ".txt"), "utf-8"));

	    for(int i = 0; i < num; i++) {
		dataToAppend = datalines.get(i);
		x1 = dataToAppend.getx1();
		y1 = dataToAppend.gety1();
		x2 = dataToAppend.getx2();
		y2 = dataToAppend.gety2();
		writer.write("Line " + i + ": (" + x1 + "," + y1 + ") (" + x2 + "," + y2 + ")\n" );
	    }//for

	} catch (IOException ex) {
	    System.out.println("Error");
	} finally {
	    try {writer.close();}
	    catch (Exception ex) {
		System.out.println("Error");
	    }
	}
			
    }//outputLines
    
}//DataLine