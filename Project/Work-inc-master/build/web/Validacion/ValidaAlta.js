
function solonumeros(e) {
    key = e.keyCode || e.which;
    teclado = String.fromCharCode(key);
    letras = "1234567890";
    especiales = "8-37-38-46-164";
    tecladoespecial = false;
    for (var i in especiales) {
        if (key === especiales[i]) {
            tecladoespecial = true;
            break;
        }
    }
    if (letras.indexOf(teclado) === -1 && !tecladoespecial) {
        return false;
    }
}

function sololetras(e) {
    key = e.keyCode || e.which;
    teclado = String.fromCharCode(key).toLowerCase();
    letras = "abcdefghijklmnñopqrstuvwxyz ";
    especiales = "8-37-38-46-164";
    tecladoespecial = false;
    for (var i in especiales) {
        if (key == especiales[i]) {
            tecladoespecial = true;
            break;
        }
    }
    if (letras.indexOf(teclado) == -1 && !tecladoespecial) {
        return false;
    }
}

function sololetrasynumeros(e) {
    key = e.keyCode || e.which;
    teclado = String.fromCharCode(key).toLowerCase();
    letras = "abcdefghijklmnñopqrstuvwxyz ";
    numeros = "0123456789";
    especiales = "8-37-38-46-164";
    tecladoespecial = false;
    for (var i in especiales) {
        if (key == especiales[i]) {
            tecladoespecial = true;
            break;
        }
    }
    if (letras.indexOf(teclado) === -1 && !tecladoespecial && numeros.indexOf(teclado) === -1) {
        return false;
    }
    
    
    
}

function confirma() {
    uno = document.getElementById("contra").value;
    dos = document.getElementById("confircontra").value;
    if (dos !== uno) {
        alert("La contraseña no esta coincidiendo");
    }

}


function enviar(){

    nombre = document.getElementById("nombre").value;
    apat = document.getElementById("apat").value;
    amat = document.getElementById("amat").value;
    edad = document.getElementById("edad").value;
    genero= document.getElementsByName("genero").value;
    fecha_nac= document.getElementById("fecha_nac").value;
    nom_usu = document.getElementById("nom_usu").value;
    contra = document.getElementById("contra").value;
    confircontra = document.getElementById("confircontra").value;
    correo = document.getElementById("correo").value;

    if (contra===confircontra) {
        if (nombre !== "" && apat !== "" && amat !== "" && edad !== "" && genero !== "" && fecha_nac !== "" && nom_usu !== ""
                && contra !== "" && confircontra !== "" && correo !== "") {
            return true;
        }else {
            alert("Los datos no cuncuerdan con el formato requerido");
            return false;
        }
    }else{
        alert("Los datos no cuncuerdan con el formato requerido");
        return false;
    }


}












 