
<%@page import="java.util.Base64"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.working.modelos.Noticia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>WorkInc</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href="Disegno/CSS/index.css" rel="stylesheet" type="text/css"/>
        <link href="Disegno/CSS/animate.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="Disegno/icon/style.css">
         <script type="text/javascript" src="Validacion/ValidaAlta.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    </head>
    <%
            List<Noticia> todaslasnoticias;
            todaslasnoticias = (List<Noticia>)request.getAttribute("Todos");
            int numerodenoticias=0;
            ArrayList<Noticia> NoticiasTodas= new ArrayList<Noticia>();
            Noticia no;
            
           /* for(Noticia n : todaslasnoticias){
               String titulo=n.getTitulo();
               String noticia=n.getNoticia();
               Blob imagen= n.getImagen();
               String Categoria = n.getCategoria();
               
               no= new Noticia(titulo, noticia, imagen, Categoria);
               NoticiasTodas.add(n);
               numerodenoticias=numerodenoticias+1;
            }*/
        %>
    <body>
        <header class="menuP">
            <input type="checkbox" id="ocu">
            <label for="ocu"><img src="RecursosGraficos/Imagenes/menu.png" alt="Menu"/></label>
            <nav class="menu">
                <ul>
                    <li><a href="#" id="menu" class="wow zoomIn" data-wow-duration="2s" data-wow-delay="1s">Ayuda</a></li>
                    <li><a href="#noticias" id="menu" class="wow zoomIn" data-wow-duration="2s" data-wow-delay="1s">Noticias</a></li>
                    <li><a href="#conocenos" id="menu" class="wow zoomIn" data-wow-duration="2s" data-wow-delay="1s">Conócenos</a></li>
                    <li><a href="#" id="menu" class="wow zoomIn" data-wow-duration="2s" data-wow-delay="1s">¡Juega!</a></li>
                    <li><a href="Login" id="menu2" class="wow zoomIn" data-wow-duration="2s" data-wow-delay="1s">Iniciar Sesión</a></li>
                </ul>
            </nav>
        </header>
        <header class="header content">
            <div class="header-video">
                <video src="RecursosGraficos/Videos/friends.mp4" autoplay muted loop id="video"></video>

            </div>
            <div class="header-overlay"></div>
            <div class="header-content">
                <h1 class="wow jackInTheBox" data-wow-duration="2s" data-wow-delay="1s">Work-Inc</h1>
                <p class="wow fadeInLeft" data-wow-duration="2s" data-wow-delay="1s">Si la vida te da limones... Haz un proyecto.</p>
                <a href="#" id="reg" class="btn wow fadeInRightBig" data-wow-duration="2s" data-wow-delay="1s">Registrate.</a>
            </div>
        </header>


        <div id="conocenos" class="main wow rubberBand" data-wow-duration="2s" data-wow-delay="1s">
            <div class="slides">
                <img src="RecursosGraficos/Imagenes/ques.png" alt="Que es Work-Inc?"/>
                <img src="RecursosGraficos/Imagenes/porque.png" alt="Por que Work-Inc?"/>
                <img src="RecursosGraficos/Imagenes/axissomos.png" alt="Informacion Axis"/>
            </div>
        </div>

        <br><br>
        
        <div class="container2" id="noticias">
            <%
                for(int i=0; i<=numerodenoticias-1; i++){
            %>
            <%
                Noticia ni= NoticiasTodas.get(i);
                
                ByteArrayOutputStream baos= new ByteArrayOutputStream();
                    byte[] buf= new byte[1024];
                    Blob blob = ni.getImagen();
                    InputStream in= blob.getBinaryStream();
                    int n =0;
                    while((n=in.read(buf))>=0){
                        baos.write(buf,0,n);
                    }
                    in.close();
                    byte[] bytes = baos.toByteArray();
                    byte[] encodedBytes= Base64.getEncoder().encode(bytes);
                    String base64Encoded = new String(encodedBytes, "UTF-8");
            %>
            <div class="column wow fadeInLeftBig" data-wow-duration="2s">
                <div class="post-module">
                    <div class="thumbnail">
                        <div class="date">
                            <div class="day">18</div>
                            <div class="month">Mayo</div>
                        </div><%out.println("<div><img src='data:image/jpg;base64,"+base64Encoded+"' alt='Imagen ID:' ></div>");%>
                    </div>
                    <div class="post-content">
                        <div class="category">Foto</div>
                        <h1 class="title"><%out.print(ni.getTitulo());%></h1>
                        <p class="description"><%out.print(ni.getNoticia());%></p>
                        <div class="post-meta">
                            <span class="comments"><i class="fas fa-book"></i><a href="#"> Leer más...</a></span>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>
        </div>

        <br><br>

        <footer>
            <div class="footer-copy-redes">
                <div class="main-copy-redes">
                    <div class="footer-copy wow heartBeat" data-wow-duration="2s" data-wow-delay="1s">
                        &copy; 2019, Todos los derechos reservados - | AXIS |.
                    </div>
                    <div class="footer-redes">
                        <a href="#" class="fas fa-envelope wow rotateInUpLeft" data-wow-duration="2s" data-wow-delay="1s"></a>
                        <a href="#" class="fas fa-phone wow rotateInUpLeft" data-wow-duration="2s" data-wow-delay="1s"></a>
                        <a href="#" class="far fa-registered wow rotateInUpLeft" data-wow-duration="2s" data-wow-delay="1s"></a>
                    </div>
                </div>
            </div>
        </footer>


        <div id="openModal" class="modalDialog">
            <div>

                <div id="menuF">
                    <ul>
                        <li><a  class="active">Iniciar Sesión</a></li>
                        <li><a >Registro</a></li>
                    </ul>
                </div>
                <div id="formularios">
                    <form action="Login" method="post">
                        <p>Usuario:</p>
                        <div class="fiel-container">
                            <i class="fas fa-id-card-alt" aria-hidden="true"></i>
                            <input type="text" class="field" id="usuario" name="usuario"/>
                        </div>
                        <p>Contraseña:</p>
                        <div class="fiel-container">
                            <i class="fas fa-lock" aria-hidden="true"></i>
                            <input type="password" class="field" id="contra" name="contra"/>
                        </div>
                        <p class="center-content">
                            <input type="submit" class="btn2"  name="ingresar" id="ingresar" value="Ingresar"/>
                        </p>
                    </form>

                    <form  action="AltaUsuario" method="post" onsubmit=" return enviar();" id="form_register">

                        <div class="columns">
                            <div class="field-container">
                                <p> Nombre:</p>
                                <i class="fa fa-user-circle fa-lg" aria-hidden="true"></i>	
                                <input type="text" class="field" name="nombre"  id="nombre" pattern="[A-Za-z]{1,20}" title="Este campo debe de llenarse unicamente con letras" placeholder="Silvia"  onkeypress="return sololetras(event)" required  > <br/>
                            </div>
                            <div class="field-container">
                                <p> Apellido Paterno:</p>
                                <i class="fa fa-user-circle fa-lg" aria-hidden="true" ></i>	
                                <input type="text" class="field" placeholder="Rivas" name="apat" id="apat" pattern="[A-Za-z]{1,20}" title="Este campo debe de llenarse unicamente con letras" onkeypress="return sololetras(event)" required > <br/>
                            </div>
                            <div class="field-container">
                                <p> Apellido Materno:</p>
                                <i class="fa fa-user-circle fa-lg" aria-hidden="true"></i>	
                                <input type="text" class="field" placeholder="González" name="amat" id="amat" pattern="[A-Za-z]{1,20}" title="Este campo debe de llenarse unicamente con letras" onkeypress="return sololetras(event)" required > <br/>
                            </div>
                        </div>

                        <p>Correo electrónico:</p>
                        <div class="field-container">
                            <i class="fas fa-envelope" aria-hidden="true"></i>	
                            <input type="text" class="field" placeholder="user@example.com" name="correo" id="correo" required> <br/>
                        </div>

                        <p>Contraseña:</p>
                        <div class="field-container">
                            <i class="fa fa-key fa-lg" aria-hidden="true"></i>	
                            <input type="password" class="field" placeholder="*******" name="contra" id="contra" required/> <br/>
                        </div>
                        <p>Confirma contraseña:</p>
                        <div class="field-container">
                            <i class="fa fa-key fa-lg" aria-hidden="true"></i>	
                            <input type="password" class="field" placeholder="*******" name="confircontra" id="confircontra" required/> <br/>
                        </div>
                        <p>Genero:</p>
                        <div class="fiel-container" id="radio">	
                            <input type="radio" class="field" value="Femenino" id="Femenino" name="genero"     required>
                            <label for="Femenino">Femenino </label>
                        </div>
                        <div class="fiel-container" id="radio">	
                            <input type="radio" class="field" value="Masculino" id="Masculino" name="genero"      required>
                            <label for="Masculino">Masculino </label>
                        </div>
                        <div class="columns">

                            <div class="field-container">
                                <p> Cédula Profesional:</p>
                                <i class="fas fa-graduation-cap" aria-hidden="true"></i>	
                                <input type="text" class="field" placeholder="12345678" name="cedula" id="cedula"  pattern="[0-9]{1,8}" title="Este campo debe de llenarse unicamente con numeros" onkeypress="return solonumeros(event)"     required> <br/>
                            </div>
                            <div class="field-container">
                                <p> Edad:</p>
                                <i class="fas fa-hourglass" aria-hidden="true"></i>	
                                <input type="text" class="field" name="edad" id="edad"  placeholder="25" pattern="[0-9]{1,2}" title="Este campo debe de llenarse unicamente con numeros" onkeypress="return solonumeros(event)" required > <br/>
                            </div>
                            <div class="field-container">
                                <p> Teléfono:</p>
                                <i class="fa fa-phone fa-lg" aria-hidden="true"></i>	
                                <input type="text" class="field" placeholder="55..."  name="telefono" id="telefono" pattern="[0-9]{1,10}" title="Este campo debe de llenarse unicamente con numeros" onkeypress="return solonumeros(event)"   required> <br/>
                            </div>

                        </div>
                        <p class="center-content">
                            <input type="submit" class="btn2" name="guarda" id="guarda" value="GUARDAR INFORMACION">
                        </p>
                    </form>
                </div>
                <a href="#close" class="close">Cerrar</a>
                <br><br>
            </div>
        </div>



        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="Disegno/js/jquery.slides.js" type="text/javascript"></script>
        <script src="Disegno/js/wow.min.js" type="text/javascript"></script>
        <script>

            $(function () {
                $(".slides").slidesjs({
                    play: {
                        active: true,
                        effect: "slide",
                        interval: 3000,
                        auto: true,
                        swap: true,
                        pauseOnHover: false,
                        restartDelay: 2500
                    }
                });
            });


            $(document).ready(function () {

                var flag = false;
                var scroll;

                $(window).scroll(function () {
                    scroll = $(window).scrollTop();
                    if (scroll > 120) {
                        if (!flag) {
                            $(".menuP").css({"background-color": "rgb(54,156,197)"});
                            $(".menu").css({"border-bottom": "1px solid #fff"});

                            flag = true;
                        }
                    } else {
                        if (flag) {
                            $(".menuP").css({"background-color": "transparent"});
                            $(".menu").css({"border-bottom": "transparent"});

                            flag = false;
                        }
                    }
                });
            });

            $(window).load(function () {
                $('.post-module').hover(function () {
                    $(this).find('.description').stop().animate({
                        height: "toggle",
                        opacity: "toggle"
                    }, 300);
                });
            });

            $(function () {
                $("#menuF li").on("click", function () {
                    var i = $(this).index();
                    $("#formularios form").hide();
                    $("#formularios form").eq(i).show();
                    $("#menuF li a").removeClass("active").attr('href', 'http://localhost:8080/WORK-INC-WODY2/ConsultarNoticias?#openModal');
                    $(this).find("#menuF").addClass("active").attr('href', 'http://localhost:8080/WORK-INC-WODY2/ConsultarNoticias?#openModal');
                });
            });
            $(function () {
                $("#reg").on("click", function () {
                    $("#formularios form").hide();
                    $("#form_register").show();
                    $("#reg").attr('href', 'http://localhost:8080/WORK-INC-WODY2/ConsultarNoticias?#openModal');
                });
            });

 


        </script>
        <script>
            new WOW().init();
        </script>
    </body>
</html>
