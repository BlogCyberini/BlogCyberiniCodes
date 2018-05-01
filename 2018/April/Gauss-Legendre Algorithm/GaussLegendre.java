//GitHub: HenriqueIni
//www.blogcyberini.com
public class GaussLegendre {
    //It calculates numerically the value of PI
    public static double pi(int iterations){
        //initializations
        double a = 1;
        double b = Math.sqrt(2)/2;
        double t = 0.25;
        double p = 1;        
        double a_next, b_next, t_next, aux; // auxiliary constants
        
        for(int i = 0; i < iterations; i++){
            //it computes the constants of the i-th iteration
            a_next = (a + b)/2;
            b_next = Math.sqrt(a * b);
            aux = a - a_next; //it avoids pow(a, 2)
            t_next = t - p * aux * aux;
            
            //updating the variables
            p = 2 * p;
            a = a_next;
            b = b_next;
            t = t_next;
        }
        aux = (a + b)/2; //it avoids pow(a, 2)
        return aux * aux / t;
    }
    //Tests
    public static void main(String[] args) {
        for(int i = 0; i <= 5; i++){
            System.out.printf("i = %d: %1.15f\n", i, pi(i));
        }
    }
}
