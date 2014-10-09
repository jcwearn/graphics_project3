public class LineTransformations {

    public static void basicTranslate(int Tx, int Ty, DataLine line) {
	int x1 = line.getx1() + Tx;
	int y1 = line.gety1() + Ty;
	int x2 = line.getx2() + Tx;
	int y2 = line.gety2() + Ty;
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

}//LineTransformations