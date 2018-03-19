//Code by Henrique Felipe (GitHub: HenriqueIni)
#include <stdio.h>
#include <stdlib.h>

//Euclid's Algorithm (iterative)
int gcd(int a, int b){
    while(b != 0){
        int r = a % b;
        a = b;
        b = r;
    }
    return a;
}
//LCM Algorithm
int lcm(int a, int b){
    return a * (b / gcd(a, b));
}
//Tests
int main() {
    printf("LCM\n");
    printf("lcm(30, 60) = %d\n", lcm(30, 60));
    printf("lcm(60, 100) = %d\n", lcm(60, 100));
    printf("lcm(36, 14) = %d\n", lcm(36, 14));
    return 0;
}
