<%-- 
    Document   : muestra2
    Created on : 21/11/2018, 09:42:55 PM
    Author     : mauga
--%>

<%@page import="java.util.Base64"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.working.modelos.Noticia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta name="viewport" content="initial-scale=1">
        <meta charset="UTF-8">
        <title>Noticias</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <script src="//use.typekit.net/xyl8bgh.js"></script>
<script>try{Typekit.load();}catch(e){}</script>
<link href="Disegno/CSS/style.css" rel="stylesheet" type="text/css"/>

      


    </head>
    <%
        List<Noticia> todaslasnoticias;
        todaslasnoticias = (List<Noticia>) request.getAttribute("Todos");
        int numerodenoticias = 0;
        ArrayList<Noticia> NoticiasTodas = new ArrayList<Noticia>();
        Noticia no;

        for (Noticia n : todaslasnoticias) {
            String titulo = n.getTitulo();
            String noticia = n.getNoticia();
            Blob imagen = n.getImagen();
            String categoria = n.getCategoria();
            no = new Noticia(titulo, noticia, imagen, categoria);
            NoticiasTodas.add(n);
            numerodenoticias = numerodenoticias + 1;
        }
    %>
    <body>
        <script>
            function eliminar(Eliminar) {
                if (confirm('¿Estas seguro de la noticia?')) {
                    document.Eliminar.submit();
                } else {
                    return false;
                }
            }
        </script>
        <div class="container-fluid mt-4">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true">Subir</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="history-tab" data-toggle="tab" href="#history" role="tab" aria-controls="notify" aria-selected="true">Historial</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="notify-tab" data-toggle="tab" href="#notify" role="tab" aria-controls="notify" aria-selected="true">Visualizaciones</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labbelledby="profile-tab">
                    <form action="guardaNoticia" method="post" enctype="multipart/form-data">

                        <div class="row">
                            <div class="col"></div>
                            <div class="col-lg-6 col-md-8 col-sm-12 pt-4">
                                <h4> Noticias</h4>
                                <hr/>
                                <div class="form-row">
                                    <div class="form-group col-lg-14 col-md-12">
                                        <label for="titulo">Titulo</label>
                                        <input class="form-control" id="titulo" name="titulo">
                                    </div>
                                    <div class="form-group col-lg-14 col-md-12">
                                        <label for="Noticia">Noticia</label>
                                        <textarea class="form-control" name="Noticia" id="Noticia" rows="3"></textarea>
                                    </div>
                                    <div class="form-group col-lg-14 col-md-12">
                                        <label for="titulo">Categoria</label>
                                        <input class="form-control" id="Categoria" name="Categoria">
                                    </div>
                                    <div class="form-group col-lg-14 col-md-12">
                                        <label for="imagen">Subir Imagen</label>
                                        <input type="file" class="form-control-file" id="imagen" name="imagen">
                                    </div>

                                    <button class="btn btn-primary btn-block">Save</button>
                                </div>
                            </div>

                            <div class="col"></div>
                        </div>
                    </form>
                </div>
                <div class="tab-pane fade" id="history" role="tabpanel" aria-labelledby="history-tab">
                    <%
                        for (int i = 0; i <= numerodenoticias - 1; i++) {
                    %>
                    <%Noticia ni = NoticiasTodas.get(i);%>
                    <div class="row my-4">
                        <div class="col"></div>
                        <div class="col-lg-8 col-md-10 col-sm-12">
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Titulo</th>
                                        <th scope="col">Noticia</th>
                                        <th scope="col">Categoria</th>
                                        <th scope="col">Eliminar</th>
                                        <th scope="col">Modificar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><%out.print(ni.getTitulo());%></td>
                                        <td><%out.print(ni.getNoticia());%></td>
                                        <td><%out.print(ni.getCategoria());%></td>


                                        <td><form action="BorrarNoticia" method="post" onsubmit="return eliminar(this)" name="Eliminar"> 
                                                <input type="text" class="form-control" id="id_noticia" name="id_noticia" value="<%out.print(ni.getId());%>" hidden>
                                                <input type="submit" class="btn btn-danger" value="Eliminar"></form></td>
                                        <td><form action="LlamarNoticia" method="post" name="modificar"><input type="hidden" id="titulo" name="titulo" value="<%out.print(ni.getTitulo());%>">
                                                <input type="submit" class="btn btn-info" value="Modificar"></form></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="col"></div>
                    </div>
                    <% }%>
                </div>
                <div class="tab-pane fade" id="notify" role="tabpanel" aria-labelledby="notify-tab">
                    <div class="row">
                        <div class="col"></div>
                        <div class="col-lg-6 col-md-8 col-sm-12 pt-4">
                            <center><h4>Noticias</h4></center>
                            <div class="container">
                                <div class="info">
                                </div>
                                <%
                                    for (int i = 0; i <= numerodenoticias - 1; i++) {
                                %>
                                <%
                                    Noticia ni = NoticiasTodas.get(i);

                                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                    byte[] buf = new byte[1024];
                                    Blob blob = ni.getImagen();
                                    InputStream in = blob.getBinaryStream();
                                    int n = 0;
                                    while ((n = in.read(buf)) >= 0) {
                                        baos.write(buf, 0, n);
                                    }
                                    in.close();
                                    byte[] bytes = baos.toByteArray();
                                    byte[] encodedBytes = Base64.getEncoder().encode(bytes);
                                    String base64Encoded = new String(encodedBytes, "UTF-8");
                                %>
                                <!-- Normal Demo-->
                                <div class="column">
                                    <!-- Post-->
                                    <div class="post-module">
                                        <!-- Thumbnail-->
                                        <div class="thumbnail">
                
                                            <%out.println("<div><img src='data:image/jpg;base64," + base64Encoded + "' alt='Imagen ID:' ></div>");%>
                                        </div>
                                        <!-- Post Content-->
                                        <div class="post-content">
                                            <div class="category"><%out.print(ni.getCategoria());%></div>
                                            <h1 class="title"><%out.print(ni.getTitulo());%></h1>
                                            <h2 class="sub_title"></h2>
                                            <p class="description"><%out.print(ni.getNoticia());%></p>
                                        </div>
                                    </div>
                                </div>
                                <%}%>
                            </div>
                        </div>
                        <div class="col"></div>
                    </div>
                </div>
            </div>
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>
       
        <script src="../Disegno/js/index.js" type="text/javascript"></script>

    </body>

</html>


