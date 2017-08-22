/*
Desenvolvido por Henrique Felipe
https://blogcyberini.blogspot.com.br
*/
 /*
 O algoritmo abaixo cria equações de segundo a quinto grau (cada método)
 aleatoriamente e armazena os coeficientes da equação e raízes
 na ordem) em vetores (array) retornando o vetor.
 Obs.: O algoritmo faz uso das Relações de Girard
 */
 
 /*
    * Gera equações do segundo grau
    */
 function segundoGrau(){
	 var resp = new Array();
	 var a, s1, s2, x1, x2;
	 
	 x1 = 7 - Math.round(Math.random() * 14); 
	 x2 = 7 - Math.round(Math.random() * 14); 
	 
	 do{
		 a = 3 - Math.round(Math.random() * 6);
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
  function terceiroGrau(){
	 var resp = new Array();
	 var a, s1, s2, s3, x1, x2, x3;
	 
	 x1 = 7 - Math.round(Math.random() * 14); 
	 x2 = 7 - Math.round(Math.random() * 14); 
	 x3 = 7 - Math.round(Math.random() * 14); 
	 
	 do{
		 a = 3 - Math.round(Math.random() * 6);
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
  function quartoGrau(){
	var resp = new Array();
	var a, s1, s2, s3, s4, x1, x2, x3, x4;
	
	x1 = 7 - Math.round(Math.random() * 14); 
	x2 = 7 - Math.round(Math.random() * 14); 
	x3 = 7 - Math.round(Math.random() * 14);
	x4 = 7 - Math.round(Math.random() * 14); 
	
	do{
		a = 3 - Math.round(Math.random() * 6);
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
  function quintoGrau(){
	var resp = new Array();
	var a, s1, s2, s3, s4, s5, x1, x2, x3, x4, x5;
	
	x1 = 7 - Math.round(Math.random() * 14); 
	x2 = 7 - Math.round(Math.random() * 14); 
	x3 = 7 - Math.round(Math.random() * 14);
	x4 = 7 - Math.round(Math.random() * 14); 
	x5 = 7 - Math.round(Math.random() * 14); 
	
	do{
		a = 3 - Math.round(Math.random() * 6);
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