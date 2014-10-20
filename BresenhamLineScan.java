/*
  Author: Jackson Wearn
  Description: Implementation of Bresenham Line Scan Algorithm in Java
  Sources: skeleton code taken from stack overflow @ http://stackoverflow.com/questions/3325546/how-to-color-a-pixel.  Bresenham Algortithm Implementation based on code from http://tech-algorithm.com/articles/drawing-line-using-bresenham-algorithm/
 */
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

    public BresenhamLineScan(int width, int height) {
	int x1,x2,y1,y2;

	canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        fillCanvas(Color.BLACK);
	numOfDatalines = 0;
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