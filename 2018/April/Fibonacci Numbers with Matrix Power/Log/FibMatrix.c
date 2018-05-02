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

//it computes the n-th Fibonacci number [O(log n)]
long fibonacciLog(int n){
    if(n < 2){
        return n;
    }
    //Base matrix
    long baseMatrix[2][2] = {{0,1},{1,1}};
    
    //Power by squaring
    long p[2][2] = {{1,0}, {0,1}};    
    while(n > 0){
        if((n % 2) != 0){
            matrixMult2x2(p, baseMatrix, p);
        }        
        matrixMult2x2(baseMatrix, baseMatrix, baseMatrix);
        n = n / 2;
    }
    return p[0][1];
}

//Tests
int main() {
    printf("Fibonacci O(log n)\n");
    int i;
    for(i = 0; i < 20; i++){
        printf("F%d = %d\n", i, fibonacciLog(i));
    }
    return 0;
}
