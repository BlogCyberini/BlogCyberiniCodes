/*
 * Code by Henrique Felipe
 * https://blogcyberini.blogspot.com
 */

/*
 * A classe abaixo contém métodos que geram equações de segundo a quinto grau.
 * As equações são geradas aleatoriamente fazendo uso das 'Relações de Girard'.
 * Todos os métodos retornam vetores de números inteiros que armazenam, ordenadamente,
 * os coeficientes da equação seguidos das raízes
 */
/*
 * REFERÊNCIAS BIBLIOGRÁFICAS
 * 
 * DANTE, Luiz Roberto. Matemática, volume único. 1ª edição. São Paulo: Ática, 2005
 * 
 * IEZZI, Gelson. Fundamentos de Matemática Elementar Volume 6 - Complexos,
 * Polinômios, Equações. São Paulo: Atual, 1977
 */
import java.util.Random;

public class PoliGauss {
    
   private static Random rnd = new Random();//gerador de números aleatórios
   
   /*
    * Gera equações do segundo grau
    */
    public static int[] segundoGrau() {
        int[] resp = new int[5];
        int a, s1, s2, x1, x2;     

        x1 = 7 - rnd.nextInt(15);
        x2 = 7 - rnd.nextInt(15);
        
        do{
            a = 3 - rnd.nextInt(7);
        }while(a == 0);
         
        s1 = - a * (x1 + x2);
        s2 = a * x1 * x2;
        
        resp[0] = a;
        resp[1] = s1;
        resp[2] = s2;
        resp[3] = x1;
        resp[4] = x2;
        
        return resp;
    }
    /*
    * Gera equações do terceiro grau
    */
    public static int[] terceiroGrau() {
        int[] resp = new int[7];
        int a, s1, s2, s3, x1, x2, x3;
        
        x1 = 7 - rnd.nextInt(15);
        x2 = 7 - rnd.nextInt(15);
        x3 = 7 - rnd.nextInt(15);
        
        do{
            a = 3 - rnd.nextInt(7);
        }while(a == 0);
        
        s1 = -a * (x1 + x2 + x3);
        s2 = a * (x1*x2 + x1*x3 + x2*x3);
        s3 = -a * x1 * x2 * x3;
        
        resp[0] = a;
        resp[1] = s1;
        resp[2] = s2;
        resp[3] = s3;
        resp[4] = x1;
        resp[5] = x2;
        resp[6] = x3;
        
        return resp;
    }
    /*
    * Gera equações do quarto grau
    */
    public static int[] quartoGrau() {
        int[] resp = new int[9];
        int a, s1, s2, s3, s4, x1, x2, x3, x4;
        
        x1 = 7 - rnd.nextInt(15);
        x2 = 7 - rnd.nextInt(15);
        x3 = 7 - rnd.nextInt(15);
        x4 = 7 - rnd.nextInt(15);
        
        do{
            a = 3 - rnd.nextInt(7);
        }while(a == 0);
        
        s1 = -a * (x1 + x2 + x3 + x4);
        s2 = a * (x1*x2 + x1*x3 + x1*x4 + x2*x3 + x2*x4 + x3*x4);
        s3 = -a * (x1*x2*x3 + x1*x3*x4 + x1*x2*x4 + x2*x3*x4);
        s4 = a * x1 * x2 * x3 * x4;
        
        resp[0] = a;
        resp[1] = s1;
        resp[2] = s2;
        resp[3] = s3;
        resp[4] = s4;
        resp[5] = x1;
        resp[6] = x2;
        resp[7] = x3;
        resp[8] = x4;
        
        return resp;
    }
    /*
    * Gera equações do quinto grau
    */
    public static int[] quintoGrau() {
        int[] resp = new int[11];
        int a, s1, s2, s3, s4, s5, x1, x2, x3, x4, x5;
        
        x1 = 7 - rnd.nextInt(15);
        x2 = 7 - rnd.nextInt(15);
        x3 = 7 - rnd.nextInt(15);
        x4 = 7 - rnd.nextInt(15);
        x5 = 7 - rnd.nextInt(15);
        
        do{
            a = 3 - rnd.nextInt(7);
        }while(a == 0);
        
        s1 = - a * (x1 + x2 + x3 + x4 +x5);
        s2 = a * (x1*x2 + x1*x3 + x1*x4 + x1*x5 + x2*x3 + x2*x4 + x2*x5 + x3*x4 + x3*x5 + x4*x5);
        s3 = -a * (x1*x2*x3 + x1*x3*x4 + x1*x2*x4 + x1*x4*x5 + x1*x2*x5 + x1*x3*x5
                  + x2*x3*x4+ x2*x3*x5 + x2*x4*x5 + x3*x4*x5);
        s4 = a * (x1*x2*x3*x4 + x1*x3*x4*x5 + x1*x2*x4*x5 + x1*x2*x3*x5 + x2*x3*x4*x5);
        s5 = - a * x1 * x2 * x3 * x4 * x5;
        
        resp[0] = a;
        resp[1] = s1;
        resp[2] = s2;
        resp[3] = s3;
        resp[4] = s4;
        resp[5] = s5;
        resp[6] = x1;
        resp[7] = x2;
        resp[8] = x3;
        resp[9] = x4;
        resp[10] = x5;
        
        return resp;
    }
}
