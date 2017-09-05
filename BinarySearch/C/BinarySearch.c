/*
 * Henrique Felipe (GitHub: HenriqueIni)
 * https://blogcyberini.blogspot.com/
 */
#include <stdio.h>
#include <stdlib.h>

/**
 * Try to find a element in the specified array (iteratively). 
 * Time complexity: O(log n) 
 *  
 * @param a array
 * @param size array length
 * @param key element to be searched
 * @return key's position or -1 (if the element isn't in the array)
 */
int binarySearchIterative(int a[], int size, int key) {
    int begin = 0;
    int end = size - 1;
    while (begin <= end) {
        int middle = (begin + end) / 2;//it computes the middle
        if (key == a[middle]) {
            return middle;//the element was found
        } else {
            if (key > a[middle]) {
                begin = middle + 1;//the search will continue on the right subarray
            } else {
                end = middle - 1;//the search will continue on the left subarray
            }
        }
    }
    return -1;//the element isn't in the array
}
/**
 * Try to find a element in the specified array (recursively). 
 * Time complexity: O(log n) 
 * 
 * @param a array
 * @param begin first index of the array
 * @param end last index of the array
 * @param key element to be searched
 * @return key's position or -1 (if the element isn't in the array)
 */
int binarySearchRecursive(int a[], int begin, int end, int key) {
    if (begin <= end) {
        int middle = (begin + end) / 2;//it computes the middle
        if (key == a[middle]) {
            return middle;//the element was found
        } else {
            if (key > a[middle]) {
                //the search will continue on the right subarray
                return binarySearchRecursive(a, middle + 1, end, key);
            } else {
                //the search will continue on the left subarray
                return binarySearchRecursive(a, begin, middle - 1, key);
            }
        }
    } else {
        return -1;//the element isn't in the array
    }
}
/*
 * Teste function
 */
int main() {
    int test[] = {1, 3, 4, 55, 104, 222, 229, 300};
    int n = sizeof(test)/sizeof(int);
    int key = 55;
    printf("%d\n%d\n", binarySearchRecursive(test, 0, n - 1, key), binarySearchIterative(test, n, key));
    return 0;
}
