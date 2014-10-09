public class DataLine {
    int x1,x2,y1,y2;
    
    public DataLine(int x1, int y1, int x2, int y2) {
	this.x1 = x1;
	this.y1 = y1;
	this.x2 = x2;
	this.y2 = y2;
    }

    private int getx1() {
	return x1;
    }

    private void setx1(int x) {
	x1 = x;
    }

    private int gety1() {
	return y1;
    }

    private void sety1(int y) {
	y1 = y;
    }

    private int getx2() {
	return x2;
    }

    private void setx2(int x) {
	x2 = x;
    }

    private int gety2() {
	return y2;
    }

    private void sety2(int y) {
	y2 = y;
    }
    
}//DataLine