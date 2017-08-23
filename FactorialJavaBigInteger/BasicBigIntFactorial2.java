/*
 * Autor: Henrique Felipe
 * https://blogcyberini.blogspot.com/
 * Julho de 2014
 * 
 * Algoritmos simples do fatorial usando BigInteger. Alguns recebem como parâmetro
 * outro BigInteger. Lancamento de excecoes implementado.
 * 
 * Os acentos das palavras nos comentarios foram removidos propositalmente
 * para evitar problemas de codificacao.
 */
import java.math.BigInteger;

public class BasicBigIntFactorial2 {
    //Metodo main com teste dos algoritmos
    public static void main(String[] args) {
        System.out.println("50! = "+iterativeFactorial(50));
        System.out.println("50! = "+recFactorial(50));
        System.out.println("50! = "+iterativeFactorial(BigInteger.valueOf(50)));
        System.out.println("50! = "+recFactorial(BigInteger.valueOf(50)));
    }
    //Implementacao iterativa do fatorial.
    private static BigInteger iterativeFactorial(int n){
        if(n < 0)
            throw new IllegalArgumentException("n >= 0 required");
        BigInteger factorial = BigInteger.ONE;        
        for(; n >= 2; n--){
            factorial = factorial.multiply(BigInteger.valueOf(n));
        }
        return factorial;
    }
    //Faz a validacao de n e chama o metodo 'recursiveFactorial(n)' retornando n!
    private static BigInteger recFactorial(int n){
        if(n < 0)
            throw new IllegalArgumentException("n >= 0 required");
        return recursiveFactorial(n);
    }
    //Implementacao recursiva do fatorial.
    private static BigInteger recursiveFactorial(int n){
        if(n == 0) return BigInteger.ONE;
        return BigInteger.valueOf(n)
                .multiply(recursiveFactorial(n - 1));
    }    
    //Implementacao iterativa do fatorial.
    private static BigInteger iterativeFactorial(BigInteger n){
        if(n.compareTo(BigInteger.ZERO) == -1)
            throw new IllegalArgumentException("n >= 0 required");
        BigInteger factorial = BigInteger.ONE;
        for(; n.compareTo(BigInteger.ONE) == 1; n = n.subtract(BigInteger.ONE)){            
            factorial = factorial.multiply(n);
        }
        return factorial;
    }
    //Faz a validacao de n e chama o metodo 'recursiveFactorial(n)' retornando n!
    private static BigInteger recFactorial(BigInteger n){
        if(n.compareTo(BigInteger.ZERO) == -1)
            throw new IllegalArgumentException("n >= 0 required");
        return recursiveFactorial(n);
    }
    //Implementacao recursiva do fatorial.
    private static BigInteger recursiveFactorial(BigInteger n){
        if(n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;
        return n.multiply(recursiveFactorial(n.subtract(BigInteger.ONE)));
    }
}
