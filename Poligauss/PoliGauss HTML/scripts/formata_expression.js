/*
Desenvolvido por Henrique Felipe
https://blogcyberini.blogspot.com.br
*/

/*
O algoritmo abaixo formata a equação antes dela ser exibida.
*/

/*
Formata o primeiro coeficiente
*/
  function firstCoe(c, grau){
	var retorno;
	
	if(c > 0){
	  if(c == 1){
		retorno = "x<sup>"+grau+"</sup>";
	  }else{
		retorno = c+"x<sup>"+grau+"</sup>";
	  }
	}else{//<0, nunca é zero
	  if(c == -1){
		retorno = "-x<sup>"+grau+"</sup>";
	  }else{
		retorno = c+"x<sup>"+grau+"</sup>";
	  }
	}
	return retorno;
  }
  /*
  Formata qualquer coeficiente, com exceção do primeiro
  */
  function coeGeneral(c, grau){
	var retorno;
	if(c > 0){
	  if(grau == 0){//termo independente
		retorno = "+" + c;
	  }else if(grau == 1){
		if(c == 1){
		  retorno = "+x";
		}else{
		  retorno = "+"+c+"x";
		}
	  }else{
		if(c == 1){
		  retorno = "+x<sup>"+grau+"</sup>";
		}else{
		  retorno = "+"+c+"x<sup>"+grau+"</sup>";
		}
	  }
	}else if(c < 0){
	  if(grau == 0){//termo independente
		retorno = ""+c;
	  }else if(grau == 1){
		if(c == -1){
		  retorno = "-x";
		}else{
		  retorno = c+"x";
		}
	  }else{
		if(c == -1){
		  retorno = "-x<sup>"+grau+"</sup>";
		}else{
		  retorno = c+"x<sup>"+grau+"</sup>";
		}
	  }
	}else{
	  retorno = "";
	}
	return retorno;
  }
  
  /*
  Fazendo uso da função 'quintoGrau()', que gera a equação,
  formata e insere a mesma na página
  */
  function gerarQuintoGrau(){
    hideResp();
	var eq_atual = quintoGrau();
	var result = "";
	var raizes = "As soluções da equação são:";
	
	result += firstCoe(eq_atual[0], 5)
                + coeGeneral(eq_atual[1], 4)
                + coeGeneral(eq_atual[2], 3)
                + coeGeneral(eq_atual[3], 2)
                + coeGeneral(eq_atual[4], 1)
                + coeGeneral(eq_atual[5], 0);
	
	result += " = 0";
	raizes += "<br/>X<sub>1</sub> = "+eq_atual[6];
	raizes += "<br/>X<sub>2</sub> = "+eq_atual[7];
	raizes += "<br/>X<sub>3</sub> = "+eq_atual[8];
	raizes += "<br/>X<sub>4</sub> = "+eq_atual[9];
	raizes += "<br/>X<sub>5</sub> = "+eq_atual[10];
	
	document.getElementById("resposta").innerHTML = raizes;
	document.getElementById("equacao").innerHTML = result;

  }
  /*
  Fazendo uso da função 'quartoGrau()', que gera a equação,
  formata e insere a mesma na página
  */
  function gerarQuartoGrau(){
    hideResp();
	var eq_atual = quartoGrau();
	var result = "";
	var raizes = "As soluções da equação são:";
	
	result += result += firstCoe(eq_atual[0], 4)
                + coeGeneral(eq_atual[1], 3)
                + coeGeneral(eq_atual[2], 2)
                + coeGeneral(eq_atual[3], 1)
                + coeGeneral(eq_atual[4], 0);
	
	result += " = 0";
	raizes += "<br/>X<sub>1</sub> = "+eq_atual[5];
	raizes += "<br/>X<sub>2</sub> = "+eq_atual[6];
	raizes += "<br/>X<sub>3</sub> = "+eq_atual[7];
	raizes += "<br/>X<sub>4</sub> = "+eq_atual[8];
	
	document.getElementById("resposta").innerHTML = raizes;
	document.getElementById("equacao").innerHTML = result;

  }
  /*
  Fazendo uso da função 'terceiroGrau()', que gera a equação,
  formata e insere a mesma na página
  */
  function gerarTerceiroGrau(){
    hideResp();
	var eq_atual = terceiroGrau();
	var result = "";
	var raizes = "As soluções da equação são:";
	
	result += firstCoe(eq_atual[0], 3)
                + coeGeneral(eq_atual[1], 2)
                + coeGeneral(eq_atual[2], 1)
                + coeGeneral(eq_atual[3], 0);
	
	result += " = 0";
	raizes += "<br/>X<sub>1</sub> = "+eq_atual[4];
	raizes += "<br/>X<sub>2</sub> = "+eq_atual[5];
	raizes += "<br/>X<sub>3</sub> = "+eq_atual[6];
	
	document.getElementById("resposta").innerHTML = raizes;
	document.getElementById("equacao").innerHTML = result;

  }
  /*
  Fazendo uso da função 'segundoGrau()', que gera a equação,
  formata e insere a mesma na página
  */
  function gerarSegundoGrau(){
    hideResp();
	var eq_atual = segundoGrau();
	var result = "";
	var raizes = "As soluções da equação são:";
	
	result += firstCoe(eq_atual[0], 2) +
			coeGeneral(eq_atual[1], 1) +
			coeGeneral(eq_atual[2], 0);
	
	result += " = 0";
	raizes += "<br/>X<sub>1</sub> = "+eq_atual[3];
	raizes += "<br/>X<sub>2</sub> = "+eq_atual[4];
	
	document.getElementById("resposta").innerHTML = raizes;
	document.getElementById("equacao").innerHTML = result;

  }