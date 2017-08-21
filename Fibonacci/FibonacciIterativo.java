public class FibonacciIterativo {
    public static long fibonacci(int n){
        int i = 1;
        int j = 0;
        int t;
        for(int k = 1; k <= n; k++){
            t = i + j;
            i = j;
            j = t;
        }
        return j;
    }
    public static void main(String[] args) {
        System.out.printf("%d", fibonacci(10));
    }
}
