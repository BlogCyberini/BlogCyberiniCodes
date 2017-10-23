//Code by Henrique Felipe (GitHub: HenriqueIni)
//The code works only for nonnegative expoent
public class SqrPowerMatrix {
    //Computes A to the n. The matrix needs to be a square matrix
    //Exponentiation by squaring (logarithmic algorithm)
    public static double[][] powQuad(double A[][], int n) {
        if (n < 0) throw new IllegalArgumentException("n < 0");
        if(n == 0) return I(A.length);
        
        double[][] p = powQuad(A, n/2);
        if(n % 2 == 0){
            return matrixMult(p, p);
        }else{
            double[][] p2 = matrixMult(p, p);
            return matrixMult(A, p2);
        }        
    }
    //Return the identity matrix n x n
    private static double[][] I(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n <= 0");
        }
        double[][] I = new double[n][n];
        for (int i = 0; i < n; i++) {
            I[i][i] = 1;
        }
        return I;
    }
    //Compute A times B
    private static double[][] matrixMult(double[][] A, double[][] B) {
        int n = A[0].length;
        if (n != B.length) {
            throw new IllegalArgumentException("A.columns != B.rows");
        }
        int rows = A.length;
        int cols = B[0].length;
        double[][] C = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}
