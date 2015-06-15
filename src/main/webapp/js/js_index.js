var control;
var respostaJSON;
var editable;
var respostaJSONcatalogo;
var position;
function iniciar() {
    $('#idDivCatalogacao').hide();
    $('#idDivBusca').hide();
    $('#idDivLogin').show();
    var controlOfChecks = function () {
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

    control.patrimonio.addEventListener("click", function () {
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
    control.tituloOU.addEventListener("click", function () {
        control.tituloE.checked = false;
        control.patrimonio.checked = false;
    });
    control.tituloE.addEventListener("click", function () {
        control.tituloOU.checked = false;
        control.patrimonio.checked = false;
    });
    control.autoriaOU.addEventListener("click", function () {
        control.autoriaE.checked = false;
        control.patrimonio.checked = false;
    });
    control.autoriaE.addEventListener("click", function () {
        control.autoriaOU.checked = false;
        control.patrimonio.checked = false;
    });
    control.veiculoOU.addEventListener("click", function () {
        control.veiculoE.checked = false;
        control.patrimonio.checked = false;
    });
    control.veiculoE.addEventListener("click", function () {
        control.veiculoOU.checked = false;
        control.patrimonio.checked = false;
    });
    control.datapublicacaoOU.addEventListener("click", function () {
        control.datapublicacaoE.checked = false;
        control.patrimonio.checked = false;
    });
    control.datapublicacaoE.addEventListener("click", function () {
        control.datapublicacaoOU.checked = false;
        control.patrimonio.checked = false;
    });
    control.palchaveOU.addEventListener("click", function () {
        control.palchaveE.checked = false;
        control.patrimonio.checked = false;
    });
    control.palchaveE.addEventListener("click", function () {
        control.palchaveOU.checked = false;
        control.patrimonio.checked = false;
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

function limparbusca() {
    document.getElementById('idpatrimonio2').value = " ";
    document.getElementById('idcheckpatrimonio').checked = false;
    document.getElementById('idtitulo2').value = " ";
    document.getElementById('idchecktituloOU').checked = false;
    document.getElementById('idchecktituloE').checked = false;
    document.getElementById('idautoria2').value = " ";
    document.getElementById('idcheckautoriaOU').checked = false;
    document.getElementById('idcheckautoriaE').checked = false;
    document.getElementById('idveiculo2').value = " ";
    document.getElementById('idcheckveiculoOU').checked = false;
    document.getElementById('idcheckveiculoE').checked = false;
    document.getElementById('iddatapublicacao2').value = " ";
    document.getElementById('idcheckdatapublicacaoOU').checked = false;
    document.getElementById('idcheckdatapublicacaoE').checked = false;
    document.getElementById('idpalchave2').value = " ";
    document.getElementById('idcheckpalchaveOU').checked = false;
    document.getElementById('idcheckpalchaveE').checked = false;
    document.getElementById("idTabelaResultados").textContent = "";
}

function modeloBusca() {
    var busca = {};
    busca.patrimonio = {};
    busca.titulo = {};
    busca.autoria = {};
    busca.veiculo = {};
    busca.datapublicacao = {};
    busca.palchave = {};
    if (document.getElementById('idcheckpatrimonio').checked === true) {
        busca.patrimonio = document.getElementById('idpatrimonio2').value;
    }
    else {
        if (document.getElementById('idchecktituloOU').checked === true) {
            busca.titulo.texto = document.getElementById('idtitulo2').value;
            busca.titulo.mode = "OU";
        }
        else if (document.getElementById('idchecktituloE').checked === true) {
            busca.titulo.texto = document.getElementById('idtitulo2').value;
            busca.titulo.mode = "E";
        }
        if (document.getElementById('idcheckautoriaOU').checked === true) {
            busca.autoria.texto = document.getElementById('idautoria2').value;
            busca.autoria.mode = "OU";
        }
        else if (document.getElementById('idcheckautoriaE').checked === true) {
            busca.autoria.texto = document.getElementById('idautoria2').value;
            busca.autoria.mode = "E";
        }
        if (document.getElementById('idcheckveiculoOU').checked === true) {
            busca.veiculo.texto = document.getElementById('idveiculo2').value;
            busca.veiculo.mode = "OU";
        }
        else if (document.getElementById('idcheckveiculoE').checked === true) {
            busca.veiculo.texto = document.getElementById('idveiculo2').value;
            busca.veiculo.mode = "E";
        }
        if (document.getElementById('idcheckdatapublicacaoOU').checked === true) {

            busca.datapublicacao.texto = document.getElementById('iddatapublicacao2').value;
            busca.datapublicacao.mode = "OU";
        }
        else if (document.getElementById('idcheckdatapublicacaoE').checked === true) {
            busca.datapublicacao.texto = document.getElementById('iddatapublicacao2').value;
            busca.datapublicacao.mode = "E";
        }
        if (document.getElementById('idcheckpalchaveOU').checked === true) {
            busca.palchave.texto = document.getElementById('idpalchave2').value;
            busca.palchave.mode = "OU";
        }
        else if (document.getElementById('idcheckpalchaveE').checked === true) {
            busca.palchave.texto = document.getElementById('idpalchave2').value;
            busca.palchave.mode = "E";
        }
    }
    return busca;
}
function enviarBusca() {
    document.getElementById("idTabelaResultados").textContent = "";
    fazerPedidoAJAX();

}
//------------------------------------------------------------------------------------------------------------------------------------------
function edit() {
    if (document.getElementById('idEditar').value === "EDITAR") {
        document.getElementById('idtitulo3').readOnly = false;
        document.getElementById('idautoria3').readOnly = false;
        document.getElementById('idveiculo3').readOnly = false;
        document.getElementById('iddatapublicacao3').readOnly = false;
        document.getElementById('idpalchave3').readOnly = false;
        document.getElementById('idSalvarNovo').disabled = true;
        document.getElementById('idCancelar').disabled = false;
        document.getElementById('idMsgDialogo3').textContent = "EDITANDO !!";
        editable = true;
        document.getElementById('idEditar').value = "LER";
    }
    else if (document.getElementById('idEditar').value === "LER") {
        document.getElementById('idtitulo3').readOnly = true;
        document.getElementById('idautoria3').readOnly = true;
        document.getElementById('idveiculo3').readOnly = true;
        document.getElementById('iddatapublicacao3').readOnly = true;
        document.getElementById('idpalchave3').readOnly = true;
        document.getElementById('idMsgDialogo3').textContent = "";
        document.getElementById('idSalvarNovo').disabled = false;
        document.getElementById('idCancelar').disabled = true;
        editable = false;
        document.getElementById('idEditar').value = "EDITAR";
    }
}

function limparCatalogo() {
    if (editable === true) {
        document.getElementById('idtitulo3').value = " ";
        document.getElementById('idautoria3').value = " ";
        document.getElementById('idveiculo3').value = " ";
        document.getElementById('iddatapublicacao3').value = " ";
        document.getElementById('idpalchave3').value = " ";
        document.getElementById('idNovoComentario').textContent = " ";
        document.getElementById('idComentarios').innerHTML = " ";
    }
}

function modeloCatalogo(mode) {
    var catalogo = {};
    catalogo.patrimonio = document.getElementById('idpatrimonio3').value;
    catalogo.mode = mode;
    if (document.getElementById('idtitulo3').value === "" ||
            document.getElementById('idtitulo3').value === " ") {
        document.getElementById('idMsgDialogo3').textContent = "O campo Titulo esta vazio";
        return null;
    } else {
        catalogo.titulo = document.getElementById('idtitulo3').value;
    }
    if (document.getElementById('idautoria3').value === "" ||
            document.getElementById('idautoria3').value === " ") {
        document.getElementById('idMsgDialogo3').textContent = "O campo Autoria esta vazio";
        return null;
    } else {
        catalogo.autoria = document.getElementById('idautoria3').value;
    }
    if (document.getElementById('idveiculo3').value === "" ||
            document.getElementById('idveiculo3').value === " ") {
        document.getElementById('idMsgDialogo3').textContent = "O campo veiculo esta vazio";
        return null;
    } else {
        catalogo.veiculo = document.getElementById('idveiculo3').value;
    }
    if (document.getElementById('iddatapublicacao3').value === "" ||
            document.getElementById('iddatapublicacao3').value === " ") {
        document.getElementById('idMsgDialogo3').textContent = "O campo Data da publicação esta vazio";
        return null;
    } else {
        catalogo.datapublicacao = document.getElementById('iddatapublicacao3').value;
    }
    if (document.getElementById('idpalchave3').value === "" ||
            document.getElementById('idpalchave3').value === " ") {
        document.getElementById('idMsgDialogo3').textContent = "O campo Palavras-chave esta vazio";
        return null;
    } else {
        catalogo.palchave = document.getElementById('idpalchave3').value;
    }
    if (document.getElementById('idNovoComentario').value !== "" ||
            document.getElementById('idNovoComentario').value !== " ") {
        catalogo.novocomentario = document.getElementById('idNovoComentario').value;
    }
    return catalogo;
}


function fazerPedidoAJAX() {
    //-------------------------
    // Preparacao do pedido
    console.log("=== sendData: " + modeloBusca());
    var data = JSON.stringify(modeloBusca());
    console.log("=== data: " + data);
    var ajaxRequest = new XMLHttpRequest();
    ajaxRequest.open("POST", "controller");
    ajaxRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    //-------------------------
    // Prepara recebimento da resposta
    ajaxRequest.onreadystatechange =
            function () {
                if (ajaxRequest.readyState === 4 && ajaxRequest.status === 200) {
                    console.log("resposta ajax : " + ajaxRequest.responseText);
                    respostaJSON = JSON.parse(ajaxRequest.responseText);
                    console.log(respostaJSON);
                    if (respostaJSON[0] == null) {
                        document.getElementById("idMsgDialogo2").textContent = "Catalogo não encontrado !";
                        document.getElementById("idTabelaResultados").textContent = "";
                    } else {
                        for (var i = 0; i < respostaJSON.length; i++) {
                            document.getElementById("idMsgDialogo2").textContent = "Catalogo(s) encontrado(s) !";
                            document.getElementById("idTabelaResultados").insertAdjacentHTML('beforeend', "<a href='#' onclick='carregarCatalogo(" + i + ");'> " + respostaJSON[i][1].titulo + "</a><br>");
                        }
                    }

                }
            };
    //-------------------------
    // Envio do pedido
    ajaxRequest.send(data);
    //-------------------------
    //document.getElementById('idTabelaResultados').textContent = "terminei pedido1";
}

function carregarCatalogo(i) {
    position = i;
    console.log("que deveria aparecer " + position);
    console.log("catalogo atual é " + position);
    document.getElementById("idMsgDialogo3").textContent = "";
    document.getElementById("idNovoComentario").value = "";
    document.getElementById("idpatrimonio3").value = respostaJSON[i][0].patrimonio;
    document.getElementById('idtitulo3').value = respostaJSON[i][1].titulo;
    document.getElementById('idautoria3').value = respostaJSON[i][2].autoria;
    document.getElementById('idveiculo3').value = respostaJSON[i][3].veiculo;
    document.getElementById('iddatapublicacao3').value = respostaJSON[i][4].date;
    document.getElementById('idpalchave3').value = respostaJSON[i][6].palchave;
    document.getElementById('idComentarios').innerHTML=respostaJSON[i][7].comentarios;
    document.getElementById('idAbrirArquivo').onclick = function () {
        openFile(i);
    };
    mostrarDiv(3);
}

function openFile(i) {
    if (respostaJSON[i][5].arquivo != null) {
        self.location = "files/" + respostaJSON[i][5].arquivo;
    } else {
        document.getElementById("idMsgDialogo3").textContent = "Arquivo não encontrado";
    }

}

function sendCatalogo(mode) {
    console.log("=== sendData: " + modeloCatalogo(mode));
    var data = JSON.stringify(modeloCatalogo(mode));
    console.log("=== data: " + data);
    var ajaxRequest = new XMLHttpRequest();
    ajaxRequest.open("POST", "ControllerCatalogo");
    ajaxRequest.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    //-------------------------
    // Prepara recebimento da resposta
    ajaxRequest.onreadystatechange =
            function () {
                if (ajaxRequest.readyState === 4 && ajaxRequest.status === 200) {
                    respostaJSONcatalogo = JSON.parse(ajaxRequest.responseText);
                    console.log("resposta catalogo: " + JSON.stringify(respostaJSONcatalogo));
                    if (respostaJSONcatalogo == null) {
                        document.getElementById("idMsgDialogo3").textContent = "Catalogo não enviado!";
                        document.getElementById("idTabelaResultados").textContent = "";
                    } else {
                        document.getElementById("idMsgDialogo3").textContent = "Catalogo enviado !";
                    }

                }
            };
    //-------------------------
    // Envio do pedido
    ajaxRequest.send(data);
}
// NAO ESTA FUNCIONANDO DEVIDAMENTE !! -----------------------------------------
function proximo() {
    console.log("buscando catalogo " + (position + 1));
    if (position + 1 < respostaJSON.length) {
        carregarCatalogo(position + 1);
        position += 1;
    }
}
function anterior() {
    console.log("buscando catalogo " + position - 1);
    if (position - 1 >= 0) {
        carregarCatalogo(position - 1);
        position -= 1;
    }
}
//------------------------------------------------------------------------------
function salvarAtual() {
    sendCatalogo("atualizar");
}

function salvarNovo() {
    if (document.getElementById("idSalvarNovo").value == "SALVAR NOVO") {
        editable = true;
        document.getElementById('idpatrimonio3').value = "";
        document.getElementById('idtitulo3').readOnly = false;
        document.getElementById('idautoria3').readOnly = false;
        document.getElementById('idveiculo3').readOnly = false;
        document.getElementById('iddatapublicacao3').readOnly = false;
        document.getElementById('idpalchave3').readOnly = false;
        document.getElementById('idMsgDialogo3').textContent = "Novo Catalogo";
        limparCatalogo();
        document.getElementById('idExcluir').disabled = true;
        document.getElementById('idAbrirArquivo').disabled = true;
        document.getElementById('idSalvarAtual').disabled = true;
        document.getElementById('idSalvarNovo').value = "ENVIAR";
        document.getElementById('idCancelar').disabled = false;
        
    } else {
        sendCatalogo("novo");
    }
}

function cancelar(){
        carregarCatalogo(position);
        document.getElementById('idExcluir').disabled = false;
        document.getElementById('idAbrirArquivo').disabled = false;
        document.getElementById('idSalvarAtual').disabled = false;
        document.getElementById('idSalvarNovo').disabled =false;
        document.getElementById('idCancelar').disabled= true;
        editable = false;
        document.getElementById('idtitulo3').readOnly = true;
        document.getElementById('idautoria3').readOnly = true;
        document.getElementById('idveiculo3').readOnly = true;
        document.getElementById('iddatapublicacao3').readOnly = true;
        document.getElementById('idpalchave3').readOnly = true;
        document.getElementById('idMsgDialogo3').textContent = "";
     if(document.getElementById('idSalvarNovo').value =="ENVIAR" ){
        document.getElementById('idSalvarNovo').value = "SALVAR NOVO";
     }
     else if(document.getElementById('idEditar').value =="LER" ){
        document.getElementById('idEditar').value = "EDITAR";
     }
}

function excluir(){
    if(confirm("O catalogo será excluir. Tem certeza que deja continuar essa operação ?")){
        sendCatalogo("excluir");
    }
}