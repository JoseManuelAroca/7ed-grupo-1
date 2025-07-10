document.addEventListener("DOMContentLoaded",() => {

    let listaOpciones = document.querySelectorAll(".lista-opcion");
    let seccionPerfil = document.getElementById("opcion_perfil");
    let seccionInfo = document.getElementById("opcion_infoJuego");
    let seccionNotificaciones = document.getElementById("opcion_notificaciones");

    // Eventos al hacer click en el menú-usuario

    // debe mostrar la sección del perfil del usuario y ocultar el resto de secciones
    listaOpciones[0].addEventListener('click',() => {
        limpiarSecciones("opcion_perfil");
        seccionPerfil.style.display = "block";
    });

    // debe mostrar la sección de la información del usuario y ocultar el resto de secciones
    listaOpciones[1].addEventListener('click',() => {
        limpiarSecciones("opcion_infoJuego");
        seccionInfo.style.display = "block";
    })

    // debe mostrar la sección de notificaciones del usuario y ocultar el resto de secciones
    listaOpciones[5].addEventListener('click',() => {
        limpiarSecciones("opcion_notificaciones");
        seccionNotificaciones.style.display = "block";
    })


    // esta función se encarga de ocultar todas las secciones excepto a la que se pretende mostrar
    function limpiarSecciones(seccionMantenible){
        document.querySelectorAll(".contenedor-informacionUsuario")
            .forEach(seccion => {
                if (seccion.id !== seccionMantenible) {
                    seccion.style.display = "none";
                }
            })
    }

    limpiarSecciones("opcion_perfil");
});

