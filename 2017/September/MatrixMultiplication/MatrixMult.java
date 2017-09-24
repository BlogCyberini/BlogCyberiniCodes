//Code by Henrique Felipe (GitHub: HenriqueIni)
public class MatrixMult {
    //Compute A * B. A and B need to be valid matrices.
    //A.columns = B.rows
    public static double[][] mult(double[][] A, double[][] B){        
        int n = A[0].length; //A.columns = B.rows
        //Check if A.columns = B.rows
        if(n != B.length){
            throw new IllegalArgumentException("A.columns != B.rows");
        }
        int rows = A.length; //A.rows
        int cols = B[0].length; //B.columns
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
    //Aux. method to convert a matrix to String
    private static String toString(double[][] matrix){
        String aux = "";
        for(int i = 0; i < matrix.length; i++){
            aux += "[" + matrix[i][0];
            for(int j = 1; j < matrix[i].length; j++){
                aux += "," + matrix[i][j];
            }
            aux += "]";
            if(i != matrix.length - 1){
                aux += "\n";
            }
        }
        return aux;
    }
    public static void main(String[] args){
        //Example 1        
        double[][] A = {{3, 1},
                        {2, -1},
                        {0, 4}};
        double[][] B = {{1, -1, 2},
                        {3, 0, 5}};
        System.out.println("A = \n" + toString(A));
        System.out.println("B = \n" + toString(B));
        System.out.println("A * B = \n" + toString(mult(A, B)));
        
        System.out.println();//break the line
        
        //Example 2
        A = new double[][]{{1, 2},
                           {0, 5}};
        B = new double[][]{{-1},
                           {1}};
        System.out.println("A = \n" + toString(A));
        System.out.println("B = \n" + toString(B));
        System.out.println("A * B = \n" + toString(mult(A, B)));
    }
}
