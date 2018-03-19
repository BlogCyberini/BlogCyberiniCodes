//Code by Henrique Felipe (GitHub: HenriqueIni)
#include <stdio.h>
#include <stdlib.h>

//Euclid's algorithm (recursive)
int gcdRecursive(int a, int b){
    if(b == 0) return a;
    return gcdRecursive(b, a % b);
}
//Euclid's algorithm (recursive)
int gcdIterative(int a, int b){
    while(b != 0){
        int r = a % b;
        a = b;
        b = r;
    }
    return a;
}
int main() {
    //Tests recursive
    printf("GCD recusive\n");
    printf("gcd(30, 60) = %d\n", gcdRecursive(30, 60));
    printf("gcd(50, 12) = %d\n", gcdRecursive(50, 12));
    printf("gcd(100, 11) = %d\n", gcdRecursive(100, 11));
    //Tests iterative
    printf("\nGCD iterative\n");
    printf("gcd(30, 60) = %d\n", gcdIterative(30, 60));
    printf("gcd(50, 12) = %d\n", gcdIterative(50, 12));
    printf("gcd(100, 11) = %d", gcdIterative(100, 11));
    return 0;
}
