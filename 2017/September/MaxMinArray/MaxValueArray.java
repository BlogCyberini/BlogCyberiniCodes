//Code by Henrique Felipe (GitHub: HenriqueIni)
public class MaxValueArray {
    //Return the maximum value of an array
    public static int maxValue(int[] a){
        int max = a[0]; //the first element is the supposed max
        for(int i = 1; i < a.length; i++){
            //a value greater than max was found
            if(max < a[i]){
                max = a[i]; //replace the max value
            }
        }
        return max; //return the max value
    }
    //Return the index of the maximum value of an array
    public static int maxValueIndex(int[] a){
        int maxIndex = 0; //the first element is the supposed max
        int maxValue = a[0];
        for(int i = 1; i < a.length; i++){
            //a value greater than max was found
            if(maxValue < a[i]){
                maxValue = a[i]; //replace the max value
                maxIndex = i; //replace the max index
            }
        }
        return maxIndex; //return the max index
    }
    //tests
    public static void main(String[] args){
        int[] a = {-1, 2, -3, -4, 5, 8, 10, 20, 80, -1000, 9};
        System.out.println("Maximum value = " + maxValue(a));
        System.out.println("Maximum value index = " + maxValueIndex(a));
    }
}
