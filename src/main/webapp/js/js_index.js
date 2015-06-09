var control;
function iniciar() {
    $('#idDivCatalogacao').hide();
    $('#idDivBusca').hide();
    $('#idDivLogin').show();
    var controlOfChecks = function (){
        this.patrimonio = document.getElementById('idcheckpatrimonio');
        this.tituloOU = document.getElementById('idchecktituloOU');
        this.tituloE = document.getElementById('idchecktituloE');
        this.autoriaOU = document.getElementById('idcheckautoriaOU');
        this.autoriaE = document.getElementById('idcheckautoriaE');
        this.veiculoOU = document.getElementById('idcheckveiculoOU');
        this.veiculoE = document.getElementById('idcheckveiculoE');
        this.datapublicacaoOU = document.getElementById('idcheckdatapublicacaoOU');
        this.datapublicacaoE = document.getElementById('idcheckdatapublicacaoE');
        this.palchaveOU = document.getElementById('idcheckpalchaveOU');
        this.palchaveE = document.getElementById('idcheckpalchaveE');
    }
     control = new controlOfChecks();
     
     control.patrimonio.addEventListener("click",function(){
         control.tituloOU.checked = false;
         control.tituloE.checked = false;
         control.autoriaOU.checked = false;
         control.autoriaE.checked = false;
         control.veiculoOU.checked = false;
         control.veiculoE.checked = false;
         control.datapublicacaoOU.checked = false;
         control.datapublicacaoE.checked = false;
         control.palchaveOU.checked = false;
         control.palchaveE.checked = false;
     });
     control.tituloOU.addEventListener("click",function(){
         control.tituloE.checked = false;
     });
     control.tituloE.addEventListener("click",function(){
         control.tituloOU.checked = false;
     });
     control.autoriaOU.addEventListener("click",function(){
         control.autoriaE.checked = false;
     });
     control.autoriaE.addEventListener("click",function(){
         control.autoriaOU.checked = false;
     });
     control.veiculoOU.addEventListener("click",function(){
         control.veiculoE.checked = false;
     });
     control.veiculoE.addEventListener("click",function(){
         control.veiculoOU.checked = false;
     });
     control.datapublicacaoOU.addEventListener("click",function(){
         control.datapublicacaoE.checked = false;
     });
     control.datapublicacaoE.addEventListener("click",function(){
         control.datapublicacaoOU.checked = false;
     });
     control.palchaveOU.addEventListener("click",function(){
         control.palchaveE.checked = false;
     });
     control.palchaveE.addEventListener("click",function(){
         control.palchaveOU.checked = false;
     });
}

function mostrarDiv(i) {
    if (i === 1) {
        $('#idDivCatalogacao').hide();
        $('#idDivBusca').hide();
        $('#idDivLogin').show();
    }
    else if (i === 2) {
        $('#idDivLogin').hide();
        $('#idDivCatalogacao').hide();
        $('#idDivBusca').show();
    }
    else if (i === 3) {
        $('#idDivLogin').hide();
        $('#idDivBusca').hide();
        $('#idDivCatalogacao').show();
    }
}

function limparbusca(){
    document.getElementById('idpatrimonio2').value = " " ;
    document.getElementById('idcheckpatrimonio').checked = false;
    document.getElementById('idtitulo2').value = " " ;
    document.getElementById('idchecktituloOU').checked = false;
    document.getElementById('idchecktituloE').checked = false;
    document.getElementById('idautoria2').value = " " ;
    document.getElementById('idcheckautoriaOU').checked = false;
    document.getElementById('idcheckautoriaE').checked = false;
    document.getElementById('idveiculo2').value = " " ;
    document.getElementById('idcheckveiculoOU').checked = false;
    document.getElementById('idcheckveiculoE').checked = false;
    document.getElementById('iddatapublicacao2').value = " " ;
    document.getElementById('idcheckdatapublicacaoOU').checked = false;
    document.getElementById('idcheckdatapublicacaoE').checked = false;
    document.getElementById('idpalchave2').value = " " ;
    document.getElementById('idcheckpalchaveOU').checked = false;
    document.getElementById('idcheckpalchaveE').checked = false; 
}