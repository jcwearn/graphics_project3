public class DataLine {
    private int x1,x2,y1,y2;
    
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


    //returns a DataLine that has been translated by Tx and Ty
    public DataLine basicTranslate(int Tx, int Ty) {
	int x1 = getx1() + Tx;
	int y1 = gety1() + Ty;
	int x2 = getx2() + Tx;
	int y2 = gety2() + Ty;
	DataLine line = new DataLine(x1,y1,x2,y2);
	return line;
    }//basicTranslate
    
    //returns a DataLine that has been scaled by Tx and Ty
    public DataLine basicScale(double Sx, double Sy) {
	double x1 = Math.round(getx1() * Sx);
	double y1 = Math.round(gety1() * Sy);
	double x2 = Math.round(getx2() * Sx);
	double y2 = Math.round(gety2() * Sy);
	DataLine line = new DataLine((int)x1,(int)y1,(int)x2,(int)y2);
	return line;
    }//basicScale


    //returns a Dataline that has been rotated by angle
    public DataLine basicRotate(double angle) {
	angle = Math.toRadians(angle);
	double cosAngle = Math.cos(angle);
	double sinAngle = Math.sin(angle);
	
	double[][] rotate = { {cosAngle,-sinAngle,1.00}, {sinAngle,cosAngle,0.00}, {0.00,0.00,1.00} };
	double[][] point1 = {{(double)getx1(),(double)gety1(),1.00}};
	double[][] point2 = {{(double)getx2(),(double)gety2(),1.00}};

	double[][] result1 = Matrix.multiplicar(point1,rotate);
	double[][] result2 = Matrix.multiplicar(point2,rotate);

	DataLine line = new DataLine((int)result1[0][0], (int)result1[0][1], (int)result2[0][0], (int)result2[0][1]);
	/*

	double x1 = Math.round(getx1() * Math.cos(angle) + gety1() * Math.sin(angle));
	double y1 = Math.round(getx1() * Math.cos(angle) + gety1() * Math.cos(angle));
	double x2 = Math.round(getx2() * Math.cos(angle) + gety2() * Math.sin(angle));
	double y2 = Math.round(getx2() * Math.cos(angle) + gety2() * Math.cos(angle));
	System.out.println("(" + x1 + "," + y1 + ") (" + x2 + "," + y2 + ")");
	System.out.println("x1:" + getx1() + " y1:" + gety1() + " x2:" + getx2() + " y2:" + gety2());
	DataLine line = new DataLine((int)x1,(int)y1,(int)x2,(int)y2);
	System.out.println(angle);

	*/
	return line;	
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