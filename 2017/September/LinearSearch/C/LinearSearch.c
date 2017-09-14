/*
 * Code by Henrique Felipe (GitHub: HenriqueIni)
 * https://blogcyberini.blogspot.com/
 */
#include <stdio.h>
#include <stdlib.h>

/**
 * Search the value 'key' in the vector 'a'.
 * @param a an array
 * @param size the length of the vector
 * @param key search key
 * @return the index of the key or -1, if the key isn't in the vector
 */
int linearSearch(int a[], int size, int key) {
    int i;
    for (i = 0; i < size; i++) {
        if (a[i] == key) {
            return i; //the value was found, return the index
        }
    }
    return -1; //the value wasn't found
}
/*
 * Test codes
 */
int main() {
    int a[] = {2, 3, 8, -1, -4, 20, 0, 5};
    int size = 8;
    printf("Key = 20, Index = %d\n", linearSearch(a, size, 20));
    printf("Key = 9, Index = %d", linearSearch(a, size, 9));
    return 0;
}
