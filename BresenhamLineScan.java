/*
  Author: Jackson Wearn
  Description: Implementation of Bresenham Line Scan Algorithm in Java
  Sources: skeleton code taken from stack overflow @ http://stackoverflow.com/questions/3325546/how-to-color-a-pixel.  Bresenham Algortithm Implementation based on code from http://tech-algorithm.com/articles/drawing-line-using-bresenham-algorithm/
 */
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BresenhamLineScan extends JPanel {

    private BufferedImage canvas;
    private ArrayList<DataLine> datalines = new ArrayList<DataLine>();
    private int numOfDatalines;
    private double[][] concatenateMatrix;

    public BresenhamLineScan(int width, int height) {
	int x1,x2,y1,y2;
	double[][] matrix = { {0.0,0.0,0.0}, {0.0,0.0,0.0}, {0.0,0.0,0.0} };
	concatenateMatrix = matrix;
	canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        fillCanvas(Color.BLACK);
	numOfDatalines = 0;
    }

    //returns a DataLine that has been translated by Tx and Ty
    public DataLine basicTranslate(int Tx, int Ty, DataLine dataline) {
	int x1 = dataline.getx1() + Tx;
	int y1 = dataline.gety1() + Ty;
	int x2 = dataline.getx2() + Tx;
	int y2 = dataline.gety2() + Ty;
	DataLine line = new DataLine(x1,y1,x2,y2);
	drawLine(line);
	return line;
    }//basicTranslate

    //returns a DataLine that has been scaled by Tx and Ty
    public DataLine basicScale(double Sx, double Sy, DataLine line) {
	double x1 = Math.round(line.getx1() * Sx);
	double y1 = Math.round(line.gety1() * Sy);
	double x2 = Math.round(line.getx2() * Sx);
	double y2 = Math.round(line.gety2() * Sy);
	DataLine result = new DataLine((int)x1,(int)y1,(int)x2,(int)y2);
	drawLine(result);
	return result;
    }//basicScale

    
    //returns a Dataline that has been rotated by angle
    public DataLine basicRotate(double angle, DataLine dataline) {
	angle = Math.toRadians(angle);
	double cosAngle = Math.cos(angle);
	double sinAngle = Math.sin(angle);
	
	double[][] rotate = { {cosAngle,-sinAngle,1.00}, {sinAngle,cosAngle,0.00}, {0.00,0.00,1.00} };
	double[][] point1 = {{(double)dataline.getx1(),(double)dataline.gety1(),1.00}};
	double[][] point2 = {{(double)dataline.getx2(),(double)dataline.gety2(),1.00}};

	double[][] result1 = Matrix.multiplicar(point1,rotate);
	double[][] result2 = Matrix.multiplicar(point2,rotate);
	DataLine line = new DataLine((int)result1[0][0], (int)result1[0][1], (int)result2[0][0], (int)result2[0][1]);
	drawLine(line);
	return line;	
    }//basicRotate
    
    //returns a 2d array containing the concatenated matrices
    public void concatenate(double[][] matrix1, double[][] matrix2) {
	double[][] result = Matrix.multiplicar(matrix1,matrix2);
	concatenateMatrix = result;
    }//concatenate

    public DataLine[] applyTransformation(double[][] matrix, ArrayList<DataLine> datalines, int num) {
	DataLine[] transformedLines = new DataLine[num];
	
	for(int i = 0; i < num; i++) {
	    int x1 = datalines.get(i).getx1();
	    int y1 = datalines.get(i).gety1();
	    int x2 = datalines.get(i).getx2();
	    int y2 = datalines.get(i).gety2();
	    
	    double[][] point1 = { {(double)x1,(double)y1,1.00} };
	    double[][] point2 = { {(double)x2,(double)y2,1.00} };
	    double[][] result1 = Matrix.multiplicar(point1,matrix);
	    double[][] result2 = Matrix.multiplicar(point2,matrix);
	    DataLine line = new DataLine((int)result1[0][0], (int)result1[0][1], (int)result2[0][0], (int)result2[0][1]);
	    transformedLines[i] = line;
	    drawLine(line);
	}
	
	return transformedLines;
    }//applyTransformation

     public void viewportSpec(int Vx0, int Vy0, int Vx1, int Vy1) {

    }//viewportSpec

    public void displayPixels(DataLine[] datalines, int num) {

    }//displayPixels

    public void inputLines() {
	int x1,y1,x2,y2;
	DataLine line;
	try {
	    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
	    StringTokenizer st;
	    String txtNum;
	    try {
		while((txtNum = br.readLine()) != null) {
		    st = new StringTokenizer(txtNum);
		    x1 = Integer.parseInt(st.nextToken());
		    y1 = Integer.parseInt(st.nextToken());
		    x2 = Integer.parseInt(st.nextToken());
		    y2 = Integer.parseInt(st.nextToken());
		    line = new DataLine(x1,y1,x2,y2);
		    drawLine(line);
		}
	    } catch (IOException ex) {
		System.out.println("Error");
	    }
	} catch (FileNotFoundException ex) {
	    System.out.println("Error");
	}
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

    public double[][] getConcatenateMatrix() {
	return concatenateMatrix;
    }
    
    public ArrayList<DataLine> getDatalines() {
	return datalines;
    }

    public int getNumOfDatalines() {
	return numOfDatalines;
    }//getNumOfDatalines

    public void setDimension(int width, int height) {
	
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }


    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }


    public void drawLine(DataLine dataline) {
	int rgb = 16777215;

	int x = dataline.getx1();
	int y = dataline.gety1();
	int x2 = dataline.getx2();
	int y2 = dataline.gety2();

	
	int w = x2 - x;
	int h = y2 - y;
	int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
	if (w<0) dx1 = -1; else if (w>0) dx1 = 1;
	if (h<0) dy1 = -1; else if (h>0) dy1 = 1;
	if (w<0) dx2 = -1; else if (w>0) dx2 = 1;
	int longest = Math.abs(w);
	int shortest = Math.abs(h);
	if (!(longest>shortest)) {
	    longest = Math.abs(h);
	    shortest = Math.abs(w);
	    if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1;
	    dx2 = 0;            
	}
	int numerator = longest >> 1;
	for (int i=0;i<=longest;i++) {
	    if(x >= 0 && y >=0 && x <= 639 && y <= 479) {
		canvas.setRGB((int)x, (int)y, rgb);
		numerator += shortest;
		if (!(numerator<longest)) {
		    numerator -= longest;
		    x += dx1;
		    y += dy1;
		} else {
		    x += dx2;
		    y += dy2;
		}
	    }
	}
	
        repaint();
	datalines.add(dataline);
	numOfDatalines++;
	
    }
}