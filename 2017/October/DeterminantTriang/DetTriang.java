//Code by Henrique Felipe (GitHub: HenriqueIni)
public class DetTriang {
    //Computes the determinant of the matrix A, of order n, via triangularization[O(n³)].
    public static double detTriang(double[][] A, int n){
        //The code don't do validations, 'A' needs to be a valid matrix
        int p = 1; //adjustment factor of the sign
        for(int k = 0; k < n - 1; k++){
            double max = Math.abs(A[k][k]);
            int maxIndex = k;
            //find the max absolute value in the column k, after the line k
            for(int i = k + 1; i < n; i++){
                if(max < Math.abs(A[i][k])){
                    max = Math.abs(A[i][k]);
                    maxIndex = i;
                }
            }
            //exchange the line k by maxIndex line
            if(maxIndex != k){
                double temp;
                p = p * (-1);
                for(int j = 0; j < n; j++){
                    temp = A[k][j];
                    A[k][j] = A[maxIndex][j];
                    A[maxIndex][j] = temp;
                }
            }
            //if afterall A[k][k] is zero, so the matrix is singular
            if(A[k][k] == 0){
                return 0;
            }else{
                //'create zeros' in the column k, after the line k
                for(int m = k + 1; m < n; m++){
                    double F = (-1) * A[m][k]/A[k][k];
                    A[m][k] = 0; //avoid the the first iteration
                    for(int l = k + 1; l < n; l ++){
                        A[m][l] = A[m][l] + F * A[k][l];
                    }
                }
            }
        }
        //After the triangularization, computes the determinant
        double det = 1;        
        for(int q = 0; q < n; q++){
            //Multiply the elements in the main diagonal (the matrix is triangular)
            det = det * A[q][q];
        }
        return p * det;
    }
    //Tests
    public static void main(String[] args){
        double[][] A = {{2, -2, -1},
                        {3, -4, 1},
                        {1, 1, 5}}; //det A = -21
        double[][] B = {{1, 5},
                        {-2, 3}}; //det B = 13
        double[][] C = {{1, 2, 3, 4},
                        {4, 3, 2, 1},
                        {5, 6, 7, 8},
                        {8, 7, 6, 5}}; //det C = 0
        double[][] D = {{-2, 3, 1, 7},
                        {0, -1, 2, 1},
                        {3, -4, 5, 1},
                        {1, 0, -2, -1}}; //det D = 24
        double[][] E = {{1, 0, 5, 0},
                        {2, -1, 0, 3},
                        {3, 0, 2, 0},
                        {7, 0, 6, 5}}; //det E = 65
        double[][] F = {{1, 2, 3, 4, 5},
                        {-1, 0, 8, 5, 9},
                        {2, 2, 3, 5, 7},
                        {-3, -1, 12, 0, 7},
                        {1, -1, 1, 3, 13}}; //det F = -710
        System.out.println("det A = " + detTriang(A, 3));
        System.out.println("det B = " + detTriang(B, 2));
        System.out.println("det C = " + detTriang(C, 4));
        System.out.println("det D = " + detTriang(D, 4));
        System.out.println("det E = " + detTriang(E, 4));
        System.out.println("det F = " + detTriang(F, 5));
    }
}
