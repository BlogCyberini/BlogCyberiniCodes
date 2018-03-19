//Code by Henrique Felipe (GitHub: HenriqueIni)
public class LCM {
    //Euclid's Algorithm (iterative)
    private static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    //LCM Algorithm
    private static int lcm(int a, int b){
        return a * (b / gcd(a, b));
    }
    //Tests
    public static void main(String[] args) {
        System.out.println("LCM");
        System.out.printf("lcm(30, 60) = %d\n", lcm(30, 60));
        System.out.printf("lcm(60, 100) = %d\n", lcm(60, 100));
        System.out.printf("lcm(36, 14) = %d\n", lcm(36, 14));
    }    
}
