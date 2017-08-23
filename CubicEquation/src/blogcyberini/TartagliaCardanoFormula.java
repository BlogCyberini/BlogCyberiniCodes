/*
 * Code by Henrique Felipe (GitHub: HenriqueIni)
 * https://blogcyberini.blogspot.com/
 * 
 * Code under MIT License.
 */

package blogcyberini;

import java.util.Arrays;

public class TartagliaCardanoFormula {
	/**
	 * Solve a cubic equation using the Tartaglia-Cardano formula.
	 * The coefficients are real numbers and the first coefficient can't
	 * be zero.
	 * 
	 * Complex roots are formatted using the following format a+bi.
	 *
	 * Equation form: ax³+bx²+cx+d = 0
	 *
	 * The calculations use <code>double</code> numbers.
	 * 
	 * @param a coefficient
	 * @param b coefficient
	 * @param c coefficient
	 * @param d coefficient
	 * @return a String array with the three roots
	 * @throws IllegalArgumentException if the first coefficient is zero.
	 */
	public static String[] solveEquation(double a, double b, double c, double d){
		if(a == 0){
			throw new IllegalArgumentException("a == 0: the first coefficient can't be equal to zero."); 
		}
		String[] roots = new String[3];
		//it converts the equation to the form x³+Ax²+Bx+C=0 
		double A = b/a;
		double B = c/a;
		double C = d/a;
		
		//constants of the conversion to y³+py+q=0
		double p = B - A * A / 3.0;
		double q = C + 2 * A * A * A / 27.0 - A * B / 3.0;
		
		//discriminant
		double delta = q * q / 4.0 + p * p * p / 27.0;
		
		if(delta >= 0){
			//first root
			double y1 = Math.cbrt(-q/2.0 + Math.sqrt(delta)) + Math.cbrt(-q/2.0 - Math.sqrt(delta));
			roots[0] = String.valueOf(y1 - A/3.0);
			//secondary discriminat of a quadratic equation
			double delta2 = -3.0 * y1 * y1 - 4.0 * p;
			if(delta2 >= 0){
				roots[1] = String.valueOf((-y1 + Math.sqrt(delta2))/2.0 - A/3.0);
				roots[2] = String.valueOf((-y1 - Math.sqrt(delta2))/2.0 - A/3.0);
			}else{
				//complex roots: it computes and formats the roots
				double realPart = -y1/2.0;
				double imPart = Math.sqrt(Math.abs(delta2))/2.0;				
				roots[1] = formatComplexResult(realPart - A/3.0, imPart);
				roots[2] = formatComplexResult(realPart - A/3.0, -imPart);
			}
		}else{
			//it uses the Euler's Formula (complex numbers) to compute de roots
			double rho = Math.sqrt(q * q / 4.0 + Math.abs(delta));
			double theta = Math.acos(-q/(2.0 * rho));
			roots[0] = String.valueOf(2.0 * Math.cbrt(rho) * Math.cos(theta/3.0) - A/3.0);
			roots[1] = String.valueOf(2.0 * Math.cbrt(rho) * Math.cos((theta + 2.0 * Math.PI)/3.0) - A/3.0);
			roots[2] = String.valueOf(2.0 * Math.cbrt(rho) * Math.cos((theta + 4.0 * Math.PI)/3.0) - A/3.0);
		}
		return roots;		
	}
	/**
	 * It formats a complex number (a+bi form). Double version.
	 * 
	 * @param realPart is the real part of the complex number
	 * @param imPart is the imaginary part of the complex number
	 * @return formatted complex number
	 */
	private static String formatComplexResult(double realPart, double imPart){		
		if(realPart == 0 && imPart == 0) return "0";
		String number = "";		
		if(realPart != 0){
			number += realPart;
			if(imPart > 0){
				number += "+" + imPart + "i";
			}else if(imPart < 0){
				number += imPart + "i";
			}
		}else{
			number += imPart + "i";
		}
		return number;
	}
	/**
	 * A method of tests.
	 * @param args
	 */
	public static void main(String[] args){
		//PoliGauss Code: https://blogcyberini.blogspot.com/2013/12/poligauss-gerador-de-equacoes.html
		java.util.Random  rnd = new java.util.Random();
		//it generates a random cubic equation		
		int a, s1, s2, s3, x1, x2, x3;

		x1 = 7 - rnd.nextInt(15);
		x2 = 7 - rnd.nextInt(15);
		x3 = 7 - rnd.nextInt(15);

		do {
			a = 3 - rnd.nextInt(7);
		} while (a == 0);

		s1 = -a * (x1 + x2 + x3);
		s2 = a * (x1 * x2 + x1 * x3 + x2 * x3);
		s3 = -a * x1 * x2 * x3;

		//print the roots
		System.out.println(x1+", "+x2+", "+x3);
		//print the roots computed by solveEquation(a,b,c,d)
		System.out.println(Arrays.toString(solveEquation(a,s1,s2,s3)));		
		//Probably there will be rounding errors...
	}
}
