<%-- 
    Document   : VisualizarNoticias
    Created on : 20/03/2019, 10:00:16 PM
    Author     : Hp
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="com.working.modelos.Noticia"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="com.working.modelos.Noticia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href="Disegno/CSS/index.css" rel="stylesheet" type="text/css"/>
        <link href="Disegno/CSS/animate.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="Disegno/icon/style.css">
         <script type="text/javascript" src="Validacion/ValidaAlta.js"></script>
          <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    </head>
    <body>

            <h1 class="text-center">Las noticias más importantes</h1>

        <%
            List<Noticia> todaslasnoticias;
            todaslasnoticias = (List<Noticia>)request.getAttribute("Todos");
            int numerodenoticias=0;
            ArrayList<Noticia> NoticiasTodas= new ArrayList<Noticia>();
            Noticia no;
            
            for(Noticia n : todaslasnoticias){
               String titulo=n.getTitulo();
               String noticia=n.getNoticia();
               Blob imagen= n.getImagen();
               String Categoria = n.getCategoria();
               
               no= new Noticia(titulo, noticia, imagen, Categoria);
               NoticiasTodas.add(n);
               numerodenoticias=numerodenoticias+1;
            }
        %>
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
    </body>
     <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
     <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="Disegno/js/jquery.slides.js" type="text/javascript"></script>
        <script src="Disegno/js/wow.min.js" type="text/javascript"></script>
</html>
