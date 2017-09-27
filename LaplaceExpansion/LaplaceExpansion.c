#include <stdio.h>
#include <stdlib.h>
/*
 * Code by Henrique Felipe (GitHub: HenriqueIni) 
 *
 * IMPORTANT:
 * The Laplace expansion is not an efficient method
 * for calculating determinants. The complexity in time is O(n!).
 * It means: don't use it in practical situations!
 */
//Portuguese name: Teorema de Laplace
//Suppose the matrix is valid, 'a' is a n x n matrix
double detLaplace(int n, double a[n][n]){
    if(n == 1){
        //base case: 1x1 matrix
        return a[0][0];
    }else{
        double det = 0;
        int i, row, col, j_aux, i_aux;
        
        //Choose the first line for calculating cofactors
        for(i = 0; i < n; i++){
            //ignore zero elements (zero times anything is zero)
            if (a[0][i] != 0) {
                double aux[n - 1][n - 1];
                i_aux = 0;
                j_aux = 0;
                //It generates the matrices to calculate the minors
                for(row = 1; row < n; row++){
                    for(col = 0; col < n; col++){
                        if(col != i){
                            aux[i_aux][j_aux] = a[row][col];
                            j_aux++;
                        }
                    }
                    i_aux++;
                    j_aux = 0;
                }
                double factor = (i % 2 == 0)? a[0][i] : -a[0][i];
                det = det + factor * detLaplace(n - 1, aux);
            }
        }
        return det;
    }
}
//Tests
int main() {
    double a[5][5] = {{1,8,3,5,0},
                      {0,-1,7,9,1},
                      {0,0,3,2,4},
                      {0,0,0,-6,-1},
                      {0,0,0,0,2}};
    printf("%.16f\n", detLaplace(5, a));
    double b[3][3] = {{2,-2,-1},
                      {3,-4,1},
                      {1,1,5}};
    printf("%.16f\n", detLaplace(3, b));
    return 0;
}
