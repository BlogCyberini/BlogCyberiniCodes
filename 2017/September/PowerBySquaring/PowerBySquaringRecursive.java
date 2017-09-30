//Code by Henrique Felipe (GitHub: HenriqueIni)
public class PowerBySquaringRecursive {    
    //NORMAL VERSION WITHOUT OPTIMIZATIONS
    //x is the base, n is the expoent. This method just do validations.
    public static double potQuad(double x, int n){
        if(x == 0 && n == 0){
            throw new ArithmeticException("It's not possible to compute 0^0");
        }
        if(x == 0 && n < 0){
            throw new ArithmeticException("It's not possible to compute 0^(-n)");
        }
        if(x == 0) return 0;
        if(n < 0) return potQuadAlg(1/x, -n);
        return potQuadAlg(x, n);
    }
    //This method computes x^n, since x and n are valid parameters
    private static double potQuadAlg(double x, int n){
        //base case
        if(n == 0) return 1;
        if(n % 2 == 0){//n is even
            double p = potQuadAlg(x, n/2);
            return p * p;
        }else{//n is odd
            double p = potQuadAlg(x, (n - 1)/2);
            return x * p * p;
        }
    }
    
    //VERSION WITH OPTIMIZATIONS
    //x is the base, n is the expoent. This method just do validations.
    public static double potQuadOpt(double x, int n){
        if(x == 0 && n == 0){
            throw new ArithmeticException("It's not possible to compute 0^0");
        }
        if(x == 0 && n < 0){
            throw new ArithmeticException("It's not possible to compute 0^(-n)");
        }
        if(x == 0) return 0;
        if(n < 0) return potQuadAlgOpt(1/x, -n);
        return potQuadAlgOpt(x, n);
    }
    //This method computes x^n, since x and n are valid parameters
    private static double potQuadAlgOpt(double x, int n){
        //base case
        if(n == 0) return 1;
        double p = potQuadAlgOpt(x, n >> 1);
        if((n & 1) == 0){//n is even            
            return p * p;
        }else{//n is odd            
            return x * p * p;
        }
    }
    //Tests
    public static void main(String[] a){        
        System.out.println("potQuad(2, 300) = " + potQuad(2, 300));
        System.out.println("potQuadOpt(2, 300) = " + potQuadOpt(2, 300));
        System.out.println("Math.pow(2, 300) = " + Math.pow(2, 300));
    }   
}
