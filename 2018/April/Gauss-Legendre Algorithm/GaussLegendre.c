//GitHub: HenriqueIni
//www.blogcyberini.com
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//It calculates numerically the value of PI
double pi(int iterations){
    //initializations
    double a = 1;
    double b = sqrt(2)/2;
    double t = 0.25;
    double p = 1;
    double a_next, b_next, t_next, aux; // auxiliary constants
    
    int i;    
    for(i = 0; i < iterations; i++){
        //it computes the constants of the i-th iteration
        a_next = (a + b)/2;
        b_next = sqrt(a * b);
        aux = a - a_next; //it avoids pow(a, 2)
        t_next = t - p * aux * aux;
        
        //updating the variables
        p = 2 * p;
        a = a_next;
        b = b_next;
        t = t_next;
    }
    aux = (a + b)/2; //it avoids pow(a, 2)
    return aux * aux / t;
}
//Tests
int main() {
    int i;
    for(i = 0; i <= 5; i++){
        printf("i = %d: %1.15f\n", i, pi(i));
    }
    return 0;
}
