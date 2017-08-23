/*
 * Autor: Henrique Felipe
 * https://blogcyberini.blogspot.com/
 * Julho de 2014
 * 
 * Algoritmos simples do fatorial usando BigInteger.
 * Aqui nao focamos em eficiencia.
 * 
 * Os acentos das palavras nos comentarios foram removidos propositalmente
 * para evitar problemas de codificacao.
 */
import java.math.BigInteger;

public class BasicBigIntFactorial1 {
    //Metodo main com teste dos algoritmos
    public static void main(String[] args) {
        System.out.println("50! = "+basicIterativeFactorial(50));
        System.out.println("50! = "+basicRecursiveFactorial(50));
    }
    //Implementacao iterativa do fatorial.
    private static BigInteger basicIterativeFactorial(int n){
        //caso basico, n = 0, retorna imediatamente o valor 1.
        if(n == 0) return BigInteger.ONE;        
        //Inicializa a variavel fatorial com 1. Ela armazenara o valor n!.
        BigInteger factorial = BigInteger.ONE;
        //Multiplica todos os inteiros de 2 até n. Se n = 1, o loop nao e executado.
        for(int i = 2; i <= n; i++){
            //Cria um objeto BigInteger usando o indice i
            BigInteger indice = BigInteger.valueOf(i);
            //Multiplica o BigInteger factorial pelo indice.
            factorial = factorial.multiply(indice);
        }
        return factorial;
    }
    
    //Implementacao recursiva do fatorial.      
    private static BigInteger basicRecursiveFactorial(int n){
        //caso basico, n = 0, retorna imediatamente o valor 1.
        if(n == 0) return BigInteger.ONE;
        //Cria um objeto BigInteger usando o valor n
        BigInteger m = BigInteger.valueOf(n);
        //Multiplica m (valor de n em BigInteger) pelo fatorial de n - 1
        return m.multiply(basicRecursiveFactorial(n - 1));
    }    
}
