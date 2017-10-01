//Code by Henrique Felipe (GitHub: HenriqueIni)
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//**************RECURSIVE ALGORITMS**************
//NORMAL VERSION, WITHOUT OPTIMIZATIONS
//This method computes x^n, since x and n are valid parameters
double potQuad(double x, int n) {
    if(n < 0)
        return potQuad(1/x, -n);
    //base case
    if (n == 0)
        return 1;
    if (n % 2 == 0) {//n is even
        double p = potQuad(x, n / 2);
        return p * p;
    } else {//n is odd
        double p = potQuad(x, (n - 1) / 2);
        return x * p * p;
    }
}
//VERSION WITH OPTIMIZATIONS
//This method computes x^n, since x and n are valid parameters
double potQuadAlgOpt(double x, int n) {    
    if(n < 0)
        return potQuad(1/x, -n);
    //base case
    if (n == 0) return 1;
    double p = potQuadAlgOpt(x, n >> 1);
    if ((n & 1) == 0) {//n is even            
        return p * p;
    } else {//n is odd            
        return x * p * p;
    }
}
//**************ITERATIVE ALGORITMS**************
//NORMAL VERSION WITHOUT OPTIMIZATIONS
//x and n need to be valid
double potQuadIter(double x, int n) {
    if (n < 0)
        return potQuadIter(1 / x, -n);

    double p = 1;
    int exp = n; //redundant
    double base = x; //redundant
    while (exp > 0) {
        if (exp % 2 != 0)
            p *= base;
        base *= base;
        exp /= 2;
    }
    return p;
}

//VERSION WITH OPTIMIZATIONS
//x and n need to be valid
double potQuadIterOpt(double x, int n) {
    if (n < 0)
        return potQuadIter(1 / x, -n);

    double p = 1;
    while (n > 0) {
        if ((n & 1) != 0)
            p *= x;
        x *= x;
        n >>= 1;
    }
    return p;
}
//Tests
int main() {
    printf("potQuad(2, 300) = %.8f\n", potQuad(2, 300));
    printf("potQuadAlgOpt(2, 300) = %.8f\n", potQuadAlgOpt(2, 300));
    printf("potQuadIter(2, 300) = %.8f\n", potQuadIter(2, 300));
    printf("potQuadIterOpt(2, 300) = %.8f\n", potQuadIterOpt(2.0, 300));
    printf("pow(2, 300) = %.8f\n", pow(2, 300));
    return 0;
}
