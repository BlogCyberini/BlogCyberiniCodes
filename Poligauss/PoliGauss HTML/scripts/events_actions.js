/*
Desenvolvido por Henrique Felipe
https://blogcyberini.blogspot.com.br
*/
/*
O algoritmo abaixo é responsável pelas interações com
o usuário
*/
function showResp(){
	document.getElementById("resposta").style.display = "block";
}

function hideResp(){
	document.getElementById("resposta").style.display = "none";
}
function loadActions(){
	document.getElementById("ver_resposta").addEventListener("click", showResp, false);
	document.getElementById("eq2").addEventListener("click", gerarSegundoGrau, false);
	document.getElementById("eq3").addEventListener("click", gerarTerceiroGrau, false);
	document.getElementById("eq4").addEventListener("click", gerarQuartoGrau, false);
	document.getElementById("eq5").addEventListener("click", gerarQuintoGrau, false);
}