//http://stackoverflow.com/questions/17623876/matrix-multiplication-using-arrays

public class Matrix {

    public static double[][] multiplicar(double[][] A, double[][] B) {
	int aRows = A.length;
	int aColumns = A[0].length;
	int bRows = B.length;
	int bColumns = B[0].length;
	
	if (aColumns != bRows) {
	    throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
	}

	double[][] C = new double[aRows][bColumns];
	for (int i = 0; i < aRows; i++) {
	    for (int j = 0; j < bColumns; j++) {
		C[i][j] = 0.00000;
	    }
	}

	for (int i = 0; i < aRows; i++) { // aRow
	    for (int j = 0; j < bColumns; j++) { // bColumn
		for (int k = 0; k < aColumns; k++) { // aColumn
		    C[i][j] += A[i][k] * B[k][j];
		}
	    }
	}
	
	return C;
    }
}