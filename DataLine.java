public class DataLine {
    private int x1,x2,y1,y2;
    
    public DataLine(int x1, int y1, int x2, int y2) {
	this.x1 = x1;
	this.y1 = y1;
	this.x2 = x2;
	this.y2 = y2;
    }//DataLine

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

    public DataLine basicTranslate(int Tx, int Ty) {
	int x1 = getx1() + Tx;
	int y1 = gety1() + Ty;
	int x2 = getx2() + Tx;
	int y2 = gety2() + Ty;
	DataLine line = new DataLine(x1,y1,x2,y2);
	return line;
    }//basicTranslate

    public void basicScale(int Sx, int Sy) {

    }//basicScale

    public void basicRotate(int angle) {

    }//basicRotate

    public void concatenate(int[][] matrix1, int[][] matrix2) {
	
    }//concatenate

    public void applyTransformation(int[][] matrix, DataLine[] datalines, int num) {

    }//applyTransformation

    public void viewportSpec(int Vx0, int Vy0, int Vx1, int Vy1) {

    }//viewportSpec

    public void displayPixels(DataLine[] datalines, int num) {

    }//displayPixels

    public void inputLines(DataLine[] datalines, int num) {

    }//inputLines

    public void outputLines(DataLine[] datalines, int num) {

    }//outputLines
    
}//DataLine