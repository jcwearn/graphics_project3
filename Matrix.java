public class Matrix {

    int matrix[][];
    
    public Matrix(int val1, int val2,  int val3) {
	matrix = new int[1][3];
	matrix[0][0] = val1;
	matrix[0][1] = val2;
	matrix[0][2] = val3;
    }

    public Matrix(int val1, int val2, int val3, int val4, int val5, int val6, int val7, int val8, int val9) {
	matrix = new int[3][3];
	matrix[0][0] = val1;
	matrix[0][1] = val2;
	matrix[0][2] = val3;
	matrix[1][0] = val4;
	matrix[1][1] = val5;
	matrix[1][2] = val6;
	matrix[2][0] = val7;
	matrix[2][1] = val8;
	matrix[2][2] = val9;       
    }
    
}