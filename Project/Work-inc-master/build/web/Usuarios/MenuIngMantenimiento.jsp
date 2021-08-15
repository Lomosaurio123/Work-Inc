<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Work-Inc</title>
        <link href="../Disegno/CSS/menu.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

    </head>
    <body>
        <nav class="sidebar-navigation">
            <ul>
                <a href="" target="prueba">
                    <li class="active">
                        <i class="fas fa-atom"></i>
                        <span class="tooltip">Work-Inc</span>
                    </li>
                </a>
                <a href="../ReadUsuario" target="prueba">
                    <li> 
                        <i class="fas fa-user-circle"></i>
                        <span class="tooltip">Mi Perfil</span>
                    </li>
                </a>
                <a href="../Proyectos/proyectos1.jsp" target="prueba">
                    <li>
                        <i class="fas fa-briefcase"></i>
                        <span class="tooltip">Proyectos</span>
                    </li>
                </a>
                <a href="../ConsultaUsuarioCurriculum" target="prueba">
                    <li>
                        <i class="fas fa-address-card"></i>
                        <span class="tooltip">Currículo</span>
                    </li>
                </a>
                <a href="../Historial" target="prueba">
                    <li>
                        <i class="far fa-eye"></i>
                        <span class="tooltip">Noticias</span>
                    </li>
                </a>
                <a href="../JUEGO/Juego.html" target="prueba">
                    <li>
                        <i class="fas fa-dice"></i>
                        <span class="tooltip">Juego</span>
                    </li>
                </a>
                <a href="../TraeReportesMantenimiento" target="prueba">
                    <li>
                        <i class="fas fa-cogs"></i>
                        <span class="tooltip">Reportes de Mantenimiento</span>
                    </li>
                </a>
                 <a href="../cerrarcesion" >
                    <li>
                        <i class="fas fa-power-off"></i>
                        <span class="tooltip">Cerrar Sesion</span>
                    </li>
                </a>
            </ul>
        </nav>

        <div class="page">
            <!--<iframe src="http://localhost:4000" name="prueba" style="left: 90px; position: absolute; height: 90%;width: 90%;top:5%;">-->
            <iframe src="../Usuarios/Menu.jsp" name="prueba" style="left: 90px; position: absolute; height: 90%;width: 90%;top:5%;">

                
                
                
            </iframe>
        </div>

        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

        <script>
            $('ul li').on('click', function () {
                $('li').removeClass('active');
                $(this).addClass('active');
            });
        </script>
    </body>
</html>
