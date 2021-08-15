<%@page import="com.working.modelos.Noticia"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.ByteArrayOutputStream"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="initial-scale=1">
        <meta charset="UTF-8">
        <title>Noticias</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
    </head>
    <%
        Noticia n= (Noticia) request.getAttribute("NoticiaSeleccionada");
        ByteArrayOutputStream baos= new ByteArrayOutputStream();
                    byte[] buf= new byte[1024];
                    Blob blob = n.getImagen();
                    InputStream in= blob.getBinaryStream();
                    int nu =0;
                    while((nu=in.read(buf))>=0){
                        baos.write(buf,0,nu);
                    }
                    in.close();
                    byte[] bytes = baos.toByteArray();
                    byte[] encodedBytes= Base64.getEncoder().encode(bytes);
                    String base64Encoded = new String(encodedBytes, "UTF-8");
    %>
    <body>

        <div class="container-fluid mt-4">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true">Modificar</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labbelledby="profile-tab">
                    <form action="ModificarNoticia" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col"></div>
                            <div class="col-lg-6 col-md-8 col-sm-12 pt-4">
                                <center> <h4>Modificar Noticias</h4></center>
                                <input type="text" class="form-control" id="id_noticia" name="id_noticia" value="<%out.print(n.getId());%>" hidden>
                                <hr/>
                                <div class="form-row">
                                    <div class="form-group col-lg-14 col-md-12">
                                        <label for="titulo">Titulo</label>
                                        <input type="text" class="form-control" id="titulo" name="titulo" value="<%out.print(n.getTitulo());%>">
                                    </div>
                                    <div class="form-group col-lg-14 col-md-12">
                                        <label for="Noticia">Noticia</label>
                                        <textarea class="form-control" name="Noticia" id="Noticia" rows="3" ><%out.print(n.getNoticia());%></textarea>
                                    </div>
                                    <div class="form-group col-lg-14 col-md-12">
                                        <label for="titulo">Categoria</label>
                                        <input type="text" class="form-control" id="Categoria" name="Categoria" value="<%out.print(n.getCategoria());%>">
                                    </div>
                                    <div class="form-group col-lg-14 col-md-12">
                                        <label for="imagen">Subir Imagen</label>
                                        <input type="file" class="form-control-file" id="imagen" name="imagen">
                                        <%out.println("<div><img src='data:image/jpg;base64,"+base64Encoded+"' alt='Imagen ID:' ></div>");%>
                                    </div>

                                    <input type="submit" value="Guardar" class="btn btn-primary btn-block">
                                </div>
                            </div>

                            <div class="col"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>



    </body>
</html>