//Code by Henrique Felipe (GitHub: HenriqueIni)
public class BubbleSort {
    //NORMAL VERSION WITHOUT OPTIMIZATIONS
    //O(n²) in all cases.
    public static void bubbleSort(int[] a){
        if(a == null){
            throw new NullPointerException("The array doesn't exist.");
        }
        for(int i = 0; i < a.length - 1; i++){
            for(int j = 0; j < a.length - i - 1; j++){
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    //VERSION WITH OPTIMIZATIONS
    //Best case: O(n)
    //Average and worst case: O(n²)
    public static void bubbleSortOpt(int[] a){
        if(a == null){
            throw new NullPointerException("The array doesn't exist.");
        }
        boolean flag = true;
        for(int i = 0; i < a.length - 1 && flag; i++){
            flag = false;
            for(int j = 0; j < a.length - i - 1; j++){
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp; 
                    flag = true;
                }
            }
        }
    }
    //Aux. method
    public static void printArray(int a[], int n){
        int i;
        for(i = 0; i < n; i++){
            System.out.printf("%d, ", a[i]);
        }
        System.out.printf("\n");
    }
    //Test method
    public static void main(String[] args) {
        int[] c = {10, 8, -7, 210, -1, 0, 30, 9, 6, -300};
        bubbleSort(c);
        printArray(c, 10);
        int[] d = {10, 8, -7, 210, -1, 0, 30, 9, 6, -300};
        bubbleSortOpt(c);
        printArray(c, 10);
    }    
}
