/*
 * Code by Henrique Felipe
 * https://blogcyberini.blogspot.com/
 *
 * IMPORTANT:
 * The Laplace expansion is not an efficient method
 * for calculating determinants. The complexity in time is O(n!).
 * It means: don't use it in practical situations!
 */
//Portuguese name: Teorema de Laplace
public class LaplaceExpansion {
        //Suppose the matrix is valid
        public static double laplace(double[][] matriz){
            double determinante = 0;//initialization... you can remove it.       
            if(matriz.length == 1){//first base case: 1x1 matrice
                determinante = matriz[0][0];
            }else if(matriz.length == 2){//second base case: 2x2 matrice
                determinante = matriz[0][0]*matriz[1][1] - matriz[0][1]*matriz[1][0];
            }else if(matriz.length == 3){//third base case: 3x3 matrice
                determinante = matriz[0][0]*matriz[1][1]*matriz[2][2]
                            +matriz[0][1]*matriz[1][2]*matriz[2][0]
                            +matriz[0][2]*matriz[1][0]*matriz[2][1]
                            -matriz[0][2]*matriz[1][1]*matriz[2][0]
                            -matriz[0][0]*matriz[1][2]*matriz[2][1]
                            -matriz[0][1]*matriz[1][0]*matriz[2][2];
            }else{
                double[][] aux;
                int i_aux, j_aux, linha, coluna, i;
                
                //Choose the first line for calculating cofactors
                for(i = 0; i < matriz.length; i++){
                    //ignore zero elements (zero times anything is zero)
                    if(matriz[0][i] != 0){
                        aux = new double[matriz.length - 1][matriz.length - 1];
                        i_aux = 0;
                        j_aux = 0;
                        //It generates the matrices to calculate the minors
                        for(linha = 1; linha < matriz.length; linha++){
                            for(coluna = 0; coluna < matriz.length; coluna++){
                                if(coluna != i){
                                    aux[i_aux][j_aux] = matriz[linha][coluna];
                                    j_aux++;
                                }
                            }
                            i_aux++;
                            j_aux = 0;
                        } 
                        determinante += Math.pow(-1, i)*matriz[0][i]*laplace(aux);
                    }
 
                }
            }
            return determinante;
        }
    }
