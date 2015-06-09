
$( document ).ready(function() {
        $('#idDivCatalogacao').hide();
        $('#idDivBusca').hide();
        $('#idDivLogin').show();
})

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