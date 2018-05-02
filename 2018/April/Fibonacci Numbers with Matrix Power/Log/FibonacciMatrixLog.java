//GitHub: HenriqueIni
//www.blogcyberini.com
public class FibonacciMatrixLog {
    //it computes the n-th Fibonacci Number [O(log n)]
    public static long fibonacci(int n){
        if(n < 2) return n;        
        long[][] baseMatrix = {{0,1},{1,1}};        
        long[][] result = powMatrix2x2(baseMatrix, n);
        return result[0][1];
    }
    
    //it computes A^n, A is a 2x2 matrix [O(log n)]
    private static long[][] powMatrix2x2(long[][] A, int n){
        //power by squaring
        long[][] p = {{1,0},{0,1}};
        while(n > 0){
            if((n % 2) != 0)
                p = multMatrix2x2(p, A);
            A = multMatrix2x2(A, A);
            n = n / 2;
        }
        return p;
    }
    
    //it computes A*B, A and B are 2x2 matrices [O(1)]
    private static long[][] multMatrix2x2(long[][] A, long[][] B){
        return new long[][]{{A[0][0] * B[0][0] + A[0][1] * B[1][0],
                             A[0][0] * B[0][1] + A[0][1] * B[1][1]},
                            {A[1][0] * B[0][0] + A[1][1] * B[1][0],
                             A[1][0] * B[0][1] + A[1][1] * B[1][1]}};
    }
    
    //Tests
    public static void main(String[]args){
        System.out.println("Fibonacci O(log n)");
        for(int i = 0; i < 20; i++){
            System.out.printf("F%d = %d\n", i, fibonacci(i));
        }        
    }
}
