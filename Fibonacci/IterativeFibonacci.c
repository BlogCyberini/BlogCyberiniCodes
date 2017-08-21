#include <math.h>
#include <stdio.h>
 
long fibonacci(int n){
    int i = 0;
    int j = 1;
    int k;
    for(k = 1; k < n; k++){
        int t = i + j;
        i = j;
        j = t;
    }
    return j;
}
int main(){
    printf("%d", fibonacci(10));
    getch();
    return 0;
}
