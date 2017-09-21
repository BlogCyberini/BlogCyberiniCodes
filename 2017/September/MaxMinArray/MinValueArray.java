//Code by Henrique Felipe (GitHub: HenriqueIni)
public class MinValueArray {
    //Return the minimum value of an array
    public static int minValue(int[] a){
        int min = a[0]; //the first element is the supposed min
        for(int i = 1; i < a.length; i++){
            //a value less than min was found
            if(min > a[i]){
                min = a[i]; //replace the min value
            }
        }
        return min; //return the min value
    }
    //Return the index of the minimum value of an array
    public static int minValueIndex(int[] a){
        int minIndex = 0; //the first element is the supposed min
        int minValue = a[0];
        for(int i = 1; i < a.length; i++){
            //a value less than min was found
            if(minValue > a[i]){
                minValue = a[i]; //replace the min value
                minIndex = i; //replace the min index
            }
        }
        return minIndex; //return the min index
    }
    //tests
    public static void main(String[] args){
        int[] a = {-1, 2, -3, -4, 5, 8, 10, 20, 80, -1000, 9};
        System.out.println("Minimum value = " + minValue(a));
        System.out.println("Minimum value index = " + minValueIndex(a));
    }
}
