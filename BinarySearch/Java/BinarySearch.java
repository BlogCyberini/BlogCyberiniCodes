/*
 * Henrique Felipe (GitHub: HenriqueIni)
 * https://blogcyberini.blogspot.com/
 */
public class BinarySearch {
    /**
     * Try to find a element in the specified array (iteratively).
     * Time complexity: O(log n)
     * 
     * @param a array
     * @param key element to be searched
     * @return key's position or -1 (if the element isn't in the array)
     */
    public static int binarySearchIterative(int[] a, int key){
        int begin = 0;
        int end = a.length - 1;
        while(begin <= end){
            //it computes the middle
            int middle = (begin + end)/2;
            if(key == a[middle]){
                //the element was found
                return middle;
            }else{
                if(key > a[middle]){
                    //the search will continue on the right subarray
                    begin = middle + 1;
                }else{
                    //the search will continue on the left subarray
                    end = middle - 1;
                }
            }
        }
        //the element isn't in the array
        return -1;
    }
    /**
     * Try to find a element in the specified array (iteratively). 
     * Time complexity: O(log n)
     * 
     * @param a array
     * @param begin first index of the array
     * @param end last index of the array
     * @param key element to be searched
     * @return key's position or -1 (if the element isn't in the array)
     */
    public static int binarySearchRecursive(int[] a, int begin, int end, int key){
        if(begin <= end){
            //it computes the middle
            int middle = (begin + end)/2;
            if(key == a[middle]){
                //the element was found
                return middle;
            }else{
                if(key > a[middle]){
                    //the search will continue on the right subarray
                    return binarySearchRecursive(a, middle + 1, end, key);
                }else{
                    //the search will continue on the left subarray
                    return binarySearchRecursive(a, begin, middle - 1, key);
                }
            }
        }else{
            //the element isn't in the array
            return -1;
        }
    }
    /*
     * Test method
     */
    public static void main(String[] args) {
        int[] test = {1, 3, 4, 55, 104, 222, 229, 300};
        System.out.println(binarySearchRecursive(test, 0, test.length - 1, 55));
        System.out.println(binarySearchIterative(test, 55));
    }    
}
