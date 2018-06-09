/*
 * Code by Henrique Felipe (GitHub: HenriqueIni)
 * https://blogcyberini.blogspot.com/
 *
 * Code under MIT License.
 */

/* 
 * Solve a cubic equation using the Tartaglia-Cardano formula.
 * The coefficients are real numbers and the first coefficient can't
 * be zero.
 * 
 * Complex roots are formatted using the following format a+bi.
 * 
 * Equation form: ax³+bx²+cx+d = 0
 */
function solve(a, b, c, d){
    if(a == 0){
        throw "the coefficient a can't be zero!";
    }
    //the container of the roots (they will be Strings)
    var roots = [];
    //it converts the equation to the form x³+Ax³+Bx+C=0
    var A = b/a;
    var B = c/a;
    var C = d/a;
    
    //constants of the conversion to y³+py+q=0
    var p = B - A * A / 3;
    var q = C + 2 * A * A * A / 27 - A * B / 3;
    
    //discriminant
    var delta = q * q / 4 + p * p * p / 27;
    
    if(delta >= 0){
        //first root
        var y1 = Math.cbrt(-q/2 + Math.sqrt(delta)) + Math.cbrt(-q/2 - Math.sqrt(delta));
        roots[0] = (y1 - A/3).toString();
        //secondary discriminat of a quadratic equation
        var delta2 = -3 * y1 * y1 - 4 * p;
        if(delta2 >= 0){
            roots[1] = ((-y1 + Math.sqrt(delta2))/2 - A/3).toString();
            roots[2] = ((-y1 - Math.sqrt(delta2))/2 - A/3).toString();
        }else{
            //complex roots: it computes and formats the roots
            var realPart = -y1/2;
            var imPart = Math.sqrt(Math.abs(delta2))/2;
            roots[1] = formatComplexResult(realPart - A/3, imPart);
            roots[2] = formatComplexResult(realPart - A/3, -imPart);
        }
    }else{
        //it uses the Euler's Formula (complex numbers) to compute de roots
        var rho = Math.sqrt(q * q / 4 + Math.abs(delta));
        var theta = Math.acos(-q/(2 * rho));
        roots[0] = (2 * Math.cbrt(rho) * Math.cos(theta/3) - A/3).toString();
        roots[1] = (2 * Math.cbrt(rho) * Math.cos((theta + 2 * Math.PI)/3) - A/3).toString();
        roots[2] = (2 * Math.cbrt(rho) * Math.cos((theta + 4 * Math.PI)/3) - A/3).toString();
    }
    return roots;
}

//It formats a complex number (a+bi form)
function formatComplexResult(realPart, imPart){
    //a simple case
    if(realPart == 0 && imPart == 0) return "0";
    
    var number = "";
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
