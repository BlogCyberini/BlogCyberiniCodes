//Code by Henrique Felipe (GitHub: HenriqueIni)
public class EuclidGCD {
    //Euclid's algorithm (recursive)
    public static int gcdRecursive(int a, int b){
        if(b == 0) return a;
        return gcdRecursive(b, a % b);
    }
    //Euclid's algorithm (iterative)
    public static int gcdIterative(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static void main(String[] args) {
        //Tests recursive
        System.out.println("GCD recusive");
        System.out.printf("gcd(30, 60) = %d\n", gcdRecursive(30, 60));
        System.out.printf("gcd(50, 12) = %d\n", gcdRecursive(50, 12));
        System.out.printf("gcd(100, 11) = %d\n", gcdRecursive(100, 11));
        //Tests iterative
        System.out.println("\nGCD iterative");
        System.out.printf("gcd(30, 60) = %d\n", gcdIterative(30, 60));
        System.out.printf("gcd(50, 12) = %d\n", gcdIterative(50, 12));
        System.out.printf("gcd(100, 11) = %d", gcdIterative(100, 11));
    }
}
