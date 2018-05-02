//GitHub: HenriqueIni
//www.blogcyberini.com
#include <stdio.h>
#include <stdlib.h>

//2x2 matrix multiplication, R = A * B
void matrixMult2x2(long A[2][2], long B[2][2], long R[2][2]){
    long temp[2][2];
    temp[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
    temp[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
    temp[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
    temp[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];    
    R[0][0] = temp[0][0];
    R[0][1] = temp[0][1];
    R[1][0] = temp[1][0];
    R[1][1] = temp[1][1];
}

//it computes the o n-th Fibonacci number [O(n)]
long fibonacciLin(int n){
    if(n < 2){
        return n;
    }
    //Base matrix
    long baseMatrix[2][2] = {{0,1},{1,1}};
    
    //Linear power
    long p[2][2] = {{1, 0}, {0, 1}};
    int i;
    for(i = 0; i < n; i++){        
        matrixMult2x2(p, baseMatrix, p);
    }
    return p[0][1];
}

//Tests
int main() {    
    printf("\nFibonacci O(n)\n");    
    for(i = 0; i < 20; i++){
        printf("F%d = %d\n", i, fibonacciLin(i));
    }
    return 0;
}
