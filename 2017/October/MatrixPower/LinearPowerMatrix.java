//Code by Henrique Felipe (GitHub: HenriqueIni)
//The code works only for nonnegative expoent
public class LinearPowerMatrix {    
    //Computes A to the n. The matrix needs to be a square matrix
    //Linear algorithm
    public static double[][] powLinear(double A[][], int n){
        if(n < 0){
            throw new IllegalArgumentException("n < 0");
        }
        int order = A.length;
        double[][] p = I(order);
        for(int i = 0; i < n; i++){
            p = matrixMult(p, A);
        }
        return p;
    }
    //Return the identity matrix n x n
    private static double[][] I(int n){
        if(n <= 0){
            throw new IllegalArgumentException("n <= 0");
        }
        double[][] I = new double[n][n];
        for(int i = 0; i < n; i++){
            I[i][i] = 1;
        }
        return I;
    }
    //Compute A times B
    private static double[][] matrixMult(double[][] A, double[][] B){        
        int n = A[0].length;        
        if(n != B.length){
            throw new IllegalArgumentException("A.columns != B.rows");
        }
        int rows = A.length;
        int cols = B[0].length;
        double[][] C = new double[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                for(int k = 0; k < n; k++){
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }        
        return C;
    }
}
