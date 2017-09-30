//Code by Henrique Felipe (GitHub: HenriqueIni)
public class PowerBySquaringIterative {
    //NORMAL VERSION WITHOUT OPTIMIZATIONS
    public static double potQuadIter(double x, int n){
        if(x == 0 && n == 0)
            throw new ArithmeticException("It's not possible to compute 0^0");        
        if(x == 0 && n < 0)
            throw new ArithmeticException("It's not possible to compute 0^(-n)");
        
        if(x == 0)
            return 0;
        if(n < 0)
            return potQuadIter(1/x, -n);
        
        double p = 1;
        int exp = n; //redundant
        double base = x; //redundant
        while(exp > 0){
            if(exp % 2 != 0)
                p *=  base;
            base *= base;
            exp /= 2;
        }
        return p;
    }
    //VERSION WITH OPTIMIZATIONS
    public static double potQuadIterOpt(double x, int n){
        if(x == 0 && n == 0)
            throw new ArithmeticException("It's not possible to compute 0^0");
        if(x == 0 && n < 0)
            throw new ArithmeticException("It's not possible to compute 0^(-n)");
        if(x == 0)
            return 0;
        if(n < 0)
            return potQuadIter(1/x, -n);
        
        double p = 1;
        while(n > 0){
            if((n & 1) != 0)
                p *=  x;
            x *= x;
            n >>= 1;
        }
        return p;
    }
}
