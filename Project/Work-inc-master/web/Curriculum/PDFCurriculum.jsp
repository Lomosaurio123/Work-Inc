<%-- 
    Document   : REPORTEDENUN
    Created on : 4/05/2018, 07:41:39 PM
    Author     : nayei
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.working.modelos.Cursos"%>
<%@page import="com.working.dao.CursoDaoSQL"%>
<%@page import="com.working.dao.CursoDaoSQL"%>
<%@page import="com.working.modelos.Habilidades"%>
<%@page import="com.working.dao.HabilidadesDaoSQL"%>
<%@page import="com.working.dao.HabilidadesDaoSQL"%>
<%@page import="com.working.modelos.Software"%>
<%@page import="com.working.dao.SoftwareDaoSQL"%>
<%@page import="com.working.modelos.Idioma"%>
<%@page import="com.working.dao.IdiomaDaoSQL"%>
<%@page import="com.working.dao.EscolaridadDaoSQL"%>
<%@page import="com.working.modelos.Escolaridad"%>
<%@page import="com.working.modelos.Experiencia"%>
<%@page import="com.working.dao.ExperienciaDaoSQL"%>
<%@page import="com.working.dao.ExperienciaDaoSQL"%>
<%@page import="com.working.dao.UsuarioDaoSQL"%>
<%@page import="com.working.idao.iUsuarioDao"%>
<%@page import="com.working.idao.iUsuarioDao"%>
<%@page import="com.working.modelos.Usuario"%>
<%@page import="com.itextpdf.text.pdf.PdfPCell"%>
<%@page import="com.itextpdf.text.pdf.draw.LineSeparator"%>
<%@page import="com.itextpdf.text.pdf.PdfContentByte"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.itextpdf.text.pdf.PdfPTable" %>
<%@page import="com.itextpdf.text.Document" %>
<%@page import="com.itextpdf.text.Paragraph" %>
<%@page import="com.itextpdf.text.pdf.PdfWriter" %>
<%@page import="java.io.IOException" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="com.itextpdf.text.*" %>
<%@page import="java.util.List" %>
<%@page import="java.io.*;" %>
<%@page import="java.sql.*;" %>
<%@page import="com.itextpdf.text.Rectangle;" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
          
            
            
            try{
                //CREACION DEL PDF
                response.setContentType("application/pdf");
                Document documento=new Document();
                //FileOutputStream ficheropdf=new FileOutputStream("e:\\pruebas\\BENESTARE.pdf");
                OutputStream ficheropdf= response.getOutputStream();
                PdfWriter.getInstance(documento, ficheropdf).setInitialLeading(20);
                documento.open();
                
                //Consulta de con DAO

            String mail = request.getParameter("mail");
            //Traer las experiencias
            ExperienciaDaoSQL xp = new ExperienciaDaoSQL();
            List<Experiencia> exps = xp.traeExperiencia(mail);
            
            //traer escolaridad
            EscolaridadDaoSQL esco = new EscolaridadDaoSQL();
            List<Escolaridad> escola = esco.traeEscolaridad(mail);
            
            IdiomaDaoSQL idi = new IdiomaDaoSQL();
            List<Idioma> idio = idi.traeIdioma(mail);
            
            SoftwareDaoSQL sof = new SoftwareDaoSQL();
            List<Software> soft = sof.traeSoftware(mail);
            
            HabilidadesDaoSQL Hab = new HabilidadesDaoSQL();
            List<Habilidades> Habi = Hab.traeHabilidades(mail);
            
            CursoDaoSQL cur = new CursoDaoSQL();
            List<Cursos> curso = cur.traeCursos(mail);
                
                 //////DISEÑO DEL PDF
                Rectangle rect = new Rectangle(36, 20, 559, 806);
                rect.setBorder(Rectangle.BOX);
                rect.setBorderWidth(2);
                documento.add(rect);
                /*
              try{
                  Image foto=Image.getInstance("d:\\BENESTARE\\PDFDENUN\\web\\letras.png");
                  foto.scaleToFit(110,110);
                  foto.setAlignment(Chunk.ALIGN_LEFT);
                  documento.add(foto); 
                  
              }
              catch(Exception e){
                  
                 e.printStackTrace();   
              }
              */

              Font fuentes=new Font(Font.FontFamily.HELVETICA , 15 , Font.NORMAL);
              Paragraph p= new Paragraph();
              Chunk c = new Chunk();
              p.setAlignment(Element.ALIGN_CENTER);
              c.append("CURRICULUM");
              c.setFont(fuentes);
              p.add(c);
              documento.add(p);
            
            Rectangle pagesize = new Rectangle(300, 300);
                PdfPTable table = new PdfPTable(1);
                table.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.setWidthPercentage(30);
               Font white = new Font();
                white.setColor(BaseColor.WHITE);
                PdfPCell cell = new PdfPCell(new Phrase(" Folio" , white));
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderWidth(2f);
                table.addCell(cell);
                PdfPCell cellTwo = new PdfPCell(new Phrase("1"));
                cellTwo.setBorderWidth(2f);
                table.addCell(cellTwo);
                documento.add(table);
                
                
            int numxp = 0;
            ArrayList<Experiencia> ATexperiencia = new ArrayList<Experiencia>();
            Experiencia exp;

            for (Experiencia xp1 : exps) {
                int id_xp = xp1.getId_experiencia();
                String empres = xp1.getEmpresa();
                String puest = xp1.getPuesto();
                String funcio = xp1.getFuncion();
                String inici = xp1.getInicio();
                String fi = xp1.getFin();
                exp = new Experiencia(id_xp, puest, empres, funcio, inici, fi);
                ATexperiencia.add(exp);
                numxp = numxp + 1;
            }                         
            LineSeparator separator = new LineSeparator();
                separator.setLineWidth(1);
                Chunk linebreak = new Chunk(separator);
                 documento.add(linebreak);
              Paragraph p1= new Paragraph();
              Chunk c1= new Chunk();
              p1.setAlignment(Element.ALIGN_CENTER);
              c1.append("DATOS DEL EXPERIENCIA");
              c1.setFont(fuentes);
              p1.add(c1);
              documento.add(p1);
              
        for (int i = 0; i <= numxp - 1; i++) {
        Experiencia XPdesp = ATexperiencia.get(i);
        documento.add(linebreak);
        PdfPTable table1 = new PdfPTable(30); 
        table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table1.setTotalWidth(documento.getPageSize().getWidth() - 80);
        table1.setLockedWidth(true);
        PdfPCell cdelito = new PdfPCell(new Phrase("Nombre empresa:  "+XPdesp.getEmpresa()+""));
        cdelito.setUseVariableBorders(true);
        cdelito.setColspan(10);
        table1.addCell(cdelito);
       /** PdfPCell workType = new PdfPCell(new Phrase("'"+extorcion+"'"));
        workType.setUseVariableBorders(true);
        workType.setColspan(9);
        table1.addCell(workType);*/
        
        PdfPCell clugar = new PdfPCell(new Phrase("Puesto: "+XPdesp.getPuesto()+""));
        clugar.setUseVariableBorders(true);
        clugar.setColspan(10);
        //clugar.setBorder(PdfPCell.NO_BORDER);
        table1.addCell(clugar);
        PdfPCell chora = new PdfPCell(new Phrase("Funcion :"+XPdesp.getFuncion()+" "));
        chora.setColspan(10);
        table1.addCell(chora); 
        documento.add(table1);
        
       //Paragraph espacio = new Paragraph(Chunk.NEWLINE);
       //documento.add(espacio);

        PdfPTable table2 = new PdfPTable(30); 
        table2.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table2.setTotalWidth(documento.getPageSize().getWidth() - 80);
        table2.setLockedWidth(true);

        PdfPCell supervisor = new PdfPCell(new Phrase("Fecha de inicio : "+XPdesp.getInicio() +" "));
        supervisor.setColspan(15);
        table2.addCell(supervisor);
        PdfPCell paySlipMonth = new PdfPCell(new Phrase("Fecha de terminio: " + XPdesp.getFin()+""));
        paySlipMonth.setColspan(15);
        table2.addCell(paySlipMonth);     
        documento.add(table2);
       
        }
        /////////////////////////////////////////////////////////////////////////
        
            int numidi = 0;
            ArrayList<Idioma> ATIdioma = new ArrayList<Idioma>();
            Idioma idim;

            for (Idioma idm : idio) {
                int id_idio = idm.getId_idioma();
                String idioma = idm.getIdioma();
                String habla = idm.getNivelhabla();
                String escrito = idm.getNivelescrito();
                String escucha = idm.getNivelescucha();
                String certificado = idm.getCertificado();
                idim = new Idioma(id_idio, idioma, habla, escrito, escucha, certificado);
                ATIdioma.add(idim);
                numidi = numidi + 1;
            }
            
              Paragraph p2= new Paragraph();
              Chunk c2= new Chunk();
              p2.setAlignment(Element.ALIGN_CENTER);
              c2.append("DATOS DE IDIOMAS");
              c2.setFont(fuentes);
              p2.add(c2);
              documento.add(p2);
              
        for (int i = 0; i <= numidi - 1; i++) {
        Idioma idiodesp = ATIdioma.get(i);
        documento.add(linebreak);
        PdfPTable table1 = new PdfPTable(30); 
        table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table1.setTotalWidth(documento.getPageSize().getWidth() - 80);
        table1.setLockedWidth(true);
        PdfPCell cdelito = new PdfPCell(new Phrase("Idioma:  "+idiodesp.getIdioma()+""));
        cdelito.setUseVariableBorders(true);
        cdelito.setColspan(10);
        table1.addCell(cdelito);
       /** PdfPCell workType = new PdfPCell(new Phrase("'"+extorcion+"'"));
        workType.setUseVariableBorders(true);
        workType.setColspan(9);
        table1.addCell(workType);*/
        
        PdfPCell clugar = new PdfPCell(new Phrase("Nivel escrito: "+idiodesp.getNivelescrito()+""));
        clugar.setUseVariableBorders(true);
        clugar.setColspan(10);
        table1.addCell(clugar);
        PdfPCell chora = new PdfPCell(new Phrase("Nivel de habla:"+idiodesp.getNivelescucha()+" "));
        chora.setColspan(10);
        table1.addCell(chora); 
        documento.add(table1);

        PdfPTable table2 = new PdfPTable(30); 
        table2.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table2.setTotalWidth(documento.getPageSize().getWidth() - 80);
        table2.setLockedWidth(true);

        PdfPCell clugar2 = new PdfPCell(new Phrase("Nivel escrito: "+idiodesp.getNivelescrito()+""));
        clugar2.setUseVariableBorders(true);
        clugar2.setColspan(15);
        table2.addCell(clugar2);
        PdfPCell chora2 = new PdfPCell(new Phrase("Nivel de habla:"+idiodesp.getNivelescucha()+" "));
        chora2.setColspan(15);
        table2.addCell(chora2); 
        documento.add(table2);
       
        } 
        
        /////////////////////////////////////////////////////////////////////////
        
            int numhab= 0;
            ArrayList<Habilidades> ATHabilidades = new ArrayList<Habilidades>();
            Habilidades habil;

            for (Habilidades hab : Habi) {
                int id_hab = hab.getId_habilidad();
                String habilidad = hab.getHabilidad();
                habil = new Habilidades(id_hab, habilidad);
                ATHabilidades.add(habil);
                numhab = numhab + 1;
            }
            
        Paragraph p3= new Paragraph();
        Chunk c3= new Chunk();
        p3.setAlignment(Element.ALIGN_CENTER);
        c3.append("DATOS DE HABILIDADES");
        c3.setFont(fuentes);
        p3.add(c3);
        documento.add(p3);
              
        for (int i = 0; i <= numhab - 1; i++) {
        Habilidades Habdesp = ATHabilidades.get(i);
        documento.add(linebreak);
        PdfPTable table1 = new PdfPTable(20); 
        table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table1.setTotalWidth(documento.getPageSize().getWidth() - 80);
        table1.setLockedWidth(true);
        PdfPCell cdelito = new PdfPCell(new Phrase("Habilidad: "+Habdesp.getHabilidad()+""));
        cdelito.setUseVariableBorders(true);
        cdelito.setColspan(20);
        table1.addCell(cdelito);
        documento.add(table1);
       /** PdfPCell workType = new PdfPCell(new Phrase("'"+extorcion+"'"));
        workType.setUseVariableBorders(true);
        workType.setColspan(9);
        table1.addCell(workType);*/
        }
        
        /////////////////////////////////////////////////////////////////////////
        
            int numesco = 0;
            ArrayList<Escolaridad> ATesco = new ArrayList<Escolaridad>();
            Escolaridad escol;

            for (Escolaridad escolar : escola ) {
                int id_esco = escolar.getId_escolaridad();
                String escuela = escolar.getEscuela();
                String carrera = escolar.getCarrera();
                String inicio = escolar.getInicio();
                String fin = escolar.getFin();
                escol = new Escolaridad(id_esco, escuela, carrera, inicio, fin);
                ATesco.add(escol);
                numesco = numesco + 1;
            }
            
              Paragraph p4= new Paragraph();
              Chunk c4= new Chunk();
              p4.setAlignment(Element.ALIGN_CENTER);
              c4.append("DATOS DE ESCOLARIDAD");
              c4.setFont(fuentes);
              p4.add(c4);
              documento.add(p4);
              
        for (int i = 0; i <= numesco - 1; i++) {
        Escolaridad ESdesp = ATesco.get(i);
        documento.add(linebreak);
        PdfPTable table1 = new PdfPTable(30); 
        table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table1.setTotalWidth(documento.getPageSize().getWidth() - 80);
        table1.setLockedWidth(true);
        PdfPCell cdelito = new PdfPCell(new Phrase("Carrera:  "+ESdesp.getCarrera()+""));
        cdelito.setUseVariableBorders(true);
        cdelito.setColspan(15);
        table1.addCell(cdelito);
       /** PdfPCell workType = new PdfPCell(new Phrase("'"+extorcion+"'"));
        workType.setUseVariableBorders(true);
        workType.setColspan(9);
        table1.addCell(workType);*/
        
        PdfPCell clugar = new PdfPCell(new Phrase("Escuela "+ESdesp.getEscuela()+""));
        clugar.setUseVariableBorders(true);
        clugar.setColspan(15);
        table1.addCell(clugar);
        documento.add(table1);

        PdfPTable table2 = new PdfPTable(30); 
        table2.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table2.setTotalWidth(documento.getPageSize().getWidth() - 80);
        table2.setLockedWidth(true);

        PdfPCell clugar2 = new PdfPCell(new Phrase("Inicio: "+ESdesp.getInicio()+""));
        clugar2.setUseVariableBorders(true);
        clugar2.setColspan(15);
        table2.addCell(clugar2);
        PdfPCell chora2 = new PdfPCell(new Phrase("Fin: "+ESdesp.getFin()+" "));
        chora2.setColspan(15);
        table2.addCell(chora2); 
        documento.add(table2);
       
        }
        
        /////////////////////////////////////////////////////////////////////////
        
            int numsftw = 0;
                ArrayList<Software> ATSoftware = new ArrayList<Software>();
                Software sf;

                for (Software sftw : soft) {
                    int id_software = sftw.getId_software();
                    String softw = sftw.getSoftware();
                    String año = sftw.getAño();
                    String constancia = sftw.getConstancia();
                    sf = new Software(id_software, softw, año, constancia);
                    ATSoftware.add(sf);
                    numsftw = numsftw + 1;
                }
            
              Paragraph p5= new Paragraph();
              Chunk c5= new Chunk();
              p5.setAlignment(Element.ALIGN_CENTER);
              c5.append("DATOS DE SOFTWARE");
              c5.setFont(fuentes);
              p5.add(c2);
              documento.add(p5);
              
        for (int i = 0; i <= numsftw - 1; i++) {
        Software softw = ATSoftware.get(i);
        documento.add(linebreak);
        PdfPTable table1 = new PdfPTable(30); 
        table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table1.setTotalWidth(documento.getPageSize().getWidth() - 80);
        table1.setLockedWidth(true);
        PdfPCell cdelito = new PdfPCell(new Phrase("Software:  "+softw.getSoftware()+""));
        cdelito.setUseVariableBorders(true);
        cdelito.setColspan(10);
        table1.addCell(cdelito);
       /** PdfPCell workType = new PdfPCell(new Phrase("'"+extorcion+"'"));
        workType.setUseVariableBorders(true);
        workType.setColspan(9);
        table1.addCell(workType);*/
        
        PdfPCell clugar = new PdfPCell(new Phrase("Año : "+softw.getAño()+""));
        clugar.setUseVariableBorders(true);
        clugar.setColspan(10);
        table1.addCell(clugar);
        PdfPCell chora = new PdfPCell(new Phrase("Constancia:"+softw.getConstancia()+" "));
        chora.setColspan(10);
        table1.addCell(chora); 
        documento.add(table1);
       
        } 
        
        
       int numcur= 0;
        ArrayList<Cursos> ATCursos = new ArrayList<Cursos>();
        Cursos cursoss;

        for (Cursos curss : curso) {
            int id_cursos = curss.getId_cursos();
            String nombre_curso = curss.getNombre_curso();
            String año = curss.getAño();
            int duracion = curss.getDuracion();
            cursoss = new Cursos(id_cursos, nombre_curso, año, duracion);
            ATCursos.add(cursoss);
            numcur = numcur + 1;
        }
            
              Paragraph p6= new Paragraph();
              Chunk c6= new Chunk();
              p6.setAlignment(Element.ALIGN_CENTER);
              c6.append("DATOS DE IDIOMAS");
              c6.setFont(fuentes);
              p6.add(c6);
              documento.add(p6);
              
       for (int i = 0; i <= numcur - 1; i++) {
        Cursos curs = ATCursos.get(i);
        documento.add(linebreak);
        PdfPTable table1 = new PdfPTable(30); 
        table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table1.setTotalWidth(documento.getPageSize().getWidth() - 80);
        table1.setLockedWidth(true);
        PdfPCell cdelito = new PdfPCell(new Phrase("Nombre curso:  "+curs.getNombre_curso()+""));
        cdelito.setUseVariableBorders(true);
        cdelito.setColspan(10);
        table1.addCell(cdelito);
       /** PdfPCell workType = new PdfPCell(new Phrase("'"+extorcion+"'"));
        workType.setUseVariableBorders(true);
        workType.setColspan(9);
        table1.addCell(workType);*/
        
        PdfPCell clugar = new PdfPCell(new Phrase("Duracion "+curs.getDuracion()+""));
        clugar.setUseVariableBorders(true);
        clugar.setColspan(10);
        table1.addCell(clugar);
        PdfPCell chora = new PdfPCell(new Phrase("Año:"+curs.getAño()+" "));
        chora.setColspan(10);
        table1.addCell(chora); 
        documento.add(table1);
       
        } 
                 
         documento.close();
            
            }catch(Exception e){
                 out.println("error es" +e.getMessage());
            }
    
               
            %>
        <h1>Hello World!</h1>
    </body>
</html>
