drop database if exists WORKINC;
create database WORKINC;
use WORKINC;

create table Usuariow(
Id_usuariow int(3) not null auto_increment primary key,
Nombre varchar(30),
Apat varchar(30),
Amat varchar(30),
Edad int(3),
Genero varchar(30),
Correo varchar(60),
Contra varchar(30),
Profesion varchar(60),
Num_Ced_Prof varchar(8),/*La cedula profesional tiene un maximo de 8 caracteres*/
Universidad varchar(80),
telefono varchar(20),
imagen longblob,
TipoUsuario varchar(30)
);
create table Experiencia(
Id_experiencia int(3)not null auto_increment primary key,
Id_usuariow int(3),
puesto nvarchar(200),
empresa nvarchar(200),
funcion varchar(300),
inicio date,
final date,
foreign key (Id_usuariow) references Usuariow (Id_usuariow)
);

create table Escolaridad(
Id_escolaridad int(3) not null auto_increment primary key,
Id_usuariow int(3),
Escuela varchar(200),
Carrera varchar(200),
inicio date,
final date,
foreign key (Id_usuariow) references Usuariow (Id_usuariow)
);

create table Idiomas(
id_idiomas int not null auto_increment primary key,
Id_usuariow int,
idioma varchar(100),
nivelhabla nvarchar(100),
nivelescrito nvarchar(100),
nivelescucha nvarchar(100),
certificado nvarchar(100),
foreign key (Id_usuariow) references Usuariow (Id_usuariow)
);

create table software(
id_software int not null auto_increment primary key,
Id_usuariow int,
software varchar(100),
año year,
constancia varchar(100),
foreign key (Id_usuariow) references Usuariow (Id_usuarioW)
);

create table Habilidades(
id_habilidad int not null auto_increment primary key,
Id_usuariow int(3),
Habilidad varchar(500),
foreign key (Id_usuariow) references Usuariow (Id_usuarioW)
);

create table Cursos(
id_cursos int not null auto_increment primary key,
Id_usuariow int(3),
Nombre_Curso varchar(120),
año year,
duracion int,
foreign key (Id_usuariow) references Usuariow (Id_usuarioW)
);

create table Proyectos(

Id_proyecto int(3) not null auto_increment primary key,
Nombre_proyecto varchar(60),
Idea_principal varchar(60),
Categoria varchar(60),
Monto int(10),
imagen longblob,
Visitas int(10),
Id_donacion int(3),
Id_usuariow int(3),
NumDeProfesionistas int(1),
foreign key (Id_usuariow) references  Usuariow(Id_usuariow)
);



create table Profesionistas_req(
Id_proyecto int(3),
Tipo_profesionista varchar(120),
StatusOcupacion varchar(120),
foreign key (Id_proyecto) references Proyectos(Id_proyecto)
);

select * from Profesionistas_req;

create table Profesionistas_unid(
Id_proyecto int(3),
Id_usuario int(3) not null,
PuestoIndicado varchar(50),
foreign key (Id_proyecto) references Proyectos (Id_proyecto),
foreign key (Id_usuario) references  Usuariow (Id_usuariow)
);




create table Profesionistas_Solicitud_Union(
Id_proyecto int(3),
Id_usuario int(3) not null,
foreign key (Id_proyecto) references Proyectos (Id_proyecto),
foreign key (Id_usuario) references  Usuariow (Id_usuariow)
);






create table Comentarios(
Id_comentario int(3) not null auto_increment primary key,
Id_proyecto int(3),
Fecha_comen timestamp default current_timestamp,
Contenido_comen varchar(360),
foreign key (Id_proyecto) references Proyectos(Id_proyecto)
);


create table Cat_mod_impac(
Id_mod_impac int(3) not null  primary key,
Nombre_impac varchar(60),
Info_impac varchar(360)
);

create table faqs(
Id_Pregunta int(4)not null auto_increment primary key,
Pregunta varchar(900),
estado varchar(60),
respuesta varchar(500),
IDautorpregunta int(3),
FechaPregunta datetime default current_timestamp,
foreign key (IDautorpregunta) references Usuariow(Id_usuariow)
);




create table Cat_mod_eco(
Id_mod_eco int(3) not null  primary key,
Nombre_eco varchar(60),
Info_eco varchar(360)
);




create table Juegos(
Tipo_proyecto varchar(60),
Area varchar(60),
Id_mod_impac int(3),
Id_mod_eco int(3),
foreign key (Id_mod_impac) references Cat_mod_impac (Id_mod_impac),
foreign key (Id_mod_eco) references Cat_mod_eco (Id_mod_eco)
);




create table noticias(
Id_noticias int(4) not null auto_increment primary key,
Noticia varchar(900),
Categoria varchar(100),
Titulo varchar(50),
imagen longblob,
IDAutorNoticias int(3),

foreign key (IDAutorNoticias) references Usuariow(Id_usuariow),
FechaNoticia datetime default current_timestamp

);


create table TareasProyectos(
Id_Tarea int(4) not null auto_increment primary key,
Id_ProyectoT int,
id_UsuarioT int,
TituloT varchar(100),
DescripcionT varchar(300),
ImportanciaT varchar(100),
DuracionDias int,
foreign key (Id_ProyectoT) references Proyectos(Id_proyecto),
foreign key (id_UsuarioT) references Usuariow(Id_usuariow)
);

create table EventosReporte(
Folio varchar(8)  not null  primary key,
ModuloE varchar(100),
DescripcionE varchar(400),
UsuarioFalla varchar(100),
EstadoE varchar(100),
EtiquetaE varchar(100),
Id_Usuario_Operador int,
Fecha datetime default current_timestamp,
Id_IngenieroAsignado int,
Asignacion varchar(100),
solucion varchar(400),
foreign key (Id_Usuario_Operador) references Usuariow(Id_usuariow)
);




create table tickets(
Folio varchar(8) not null primary key,
Id_usuariow int,
EstadoRevision varchar(60),
Id_ResponsableRevision int,
FechaCreacion datetime default current_timestamp,
Modulo varchar(60),
DescripcionProblema varchar(400),
Respuesta varchar(400),
foreign key (Id_usuariow) references  Usuariow(Id_usuariow),
foreign key (Id_ResponsableRevision) references  Usuariow(Id_usuariow)
);


use WORKINC;
drop procedure if exists GuardaUsuario;
delimiter **
create procedure GuardaUsuario(in id nvarchar(40), nombree varchar(30), in apatt varchar(30), in amatt varchar(30),in eda int(3)
,in gener varchar(30),in correoo varchar(60), in contraa varchar(30), in confircontraa varchar(30), in cedulaa varchar(8), in profesioon varchar(60),uni nvarchar(80), in telefonoo varchar(20), in CodigoAdmin varchar(100) )
begin
declare existe int;
declare mjs nvarchar(50);
declare idper int;
declare tipousu varchar(100);

  
set existe = (select count(*) from Usuariow where correo = correoo );
	set idper = (select Id_usuariow from usuariow where correo = correoo);
	if(id = 'alta')then
		
			if(existe = 0)then
				
            
            if(CodigoAdmin='OVEJA'||CodigoAdmin='VACA'||CodigoAdmin='BUHO'||CodigoAdmin='OCELOTE'||CodigoAdmin='ELEFANTE')then
            
				if(CodigoAdmin='OVEJA')then
					set tipousu = 'Operador';
				else
					if(CodigoAdmin='VACA')then
						set tipousu = 'GeerenteSoft';
					else
						if(CodigoAdmin='BUHO')then
							set tipousu = 'IngenieroSoft';
                            else
                            if(CodigoAdmin='OCELOTE')then
								set tipousu = 'EditorFAQS';
							else
                                if(CodigoAdmin='ELEFANTE')then
									set tipousu = 'IngMantenimiento';
                                end if;
                            end if;
						end if;
				
					end if;
				
				end if;
					
				else
					set tipousu = 'UsuarioNormal';
            end if;
            
            
				INSERT INTO Usuariow(Nombre, Apat, Amat, Edad, Genero,Profesion,Num_Ced_Prof,Universidad,Correo, Contra, telefono,TipoUsuario) 
				values (nombree, apatt, amatt, eda, gener,profesioon,cedulaa,uni,correoo, contraa, telefonoo,tipousu);
				set mjs = 'Persona registrada';
			else
				set mjs = 'Persona ya esta registro';
			end if;
	else
		if(id = 'actualiza')then
			if(existe != 0)then
			update Usuariow set  Nombre = nombree, Apat = apatt, Amat = amatt , Edad = eda , Genero = gener ,Profesion = profesioon,Num_Ced_Prof = cedulaa , Universidad = uni ,Correo = correoo, Contra = contraa
			where id_Usuariow = idper;
			set mjs = 'Persona actualizada';
            else
				set mjs ='persona no registrada';
            end if;
        end if;
	end if;
select idper as usuario, mjs as mensaje;
end**
select * from usuariow**
call GuardaUsuario('alta','Rodrigo','Lopez','Lopez',17,'femenino','a&#x40;gmail.com','123','123','333','LICENCIATURA COMO MÉDICO CIRUJANO','UNIVERSIDAD NACIONAL AUTÓNOMA DE MÉXICO','5543123','UsuarioNormal')**
call GuardaUsuario('alta','Juan','Beltran','Garcia',17,'femenino','juan-bel&#x40;hotmail.com','123','123','333','LICENCIATURA COMO MÉDICO CIRUJANO','UNIVERSIDAD NACIONAL AUTÓNOMA DE MÉXICO','5543123','VACA')**
call GuardaUsuario('alta','Mauricio','Hernandez','Lom',18,'femenino','mau&#x40;gmail.com','123','123','333','LICENCIATURA COMO MÉDICO CIRUJANO','UNIVERSIDAD NACIONAL AUTÓNOMA DE MÉXICO','5543123','BUHO')**
call GuardaUsuario('alta','Ismael','German','Martinez',17,'femenino','isma&#x40;gmail.com','123','123','333','LICENCIATURA COMO MÉDICO CIRUJANO','UNIVERSIDAD NACIONAL AUTÓNOMA DE MÉXICO','5543123','OVEJA')**
call GuardaUsuario('alta','Maribel','De la Cruz','SantaAna',17,'femenino','maribel&#x40;gmail.com','123','123','333','LICENCIATURA COMO MÉDICO CIRUJANO','UNIVERSIDAD NACIONAL AUTÓNOMA DE MÉXICO','5543123','OCELOTE')**
call GuardaUsuario('alta','Daniela','Vera','Garcia',17,'femenino','mantenimiento&#x40;gmail.com','123','123','333','LICENCIATURA COMO MÉDICO CIRUJANO','UNIVERSIDAD NACIONAL AUTÓNOMA DE MÉXICO','5543123','ELEFANTE')**

/*///////////////////  PROCEDIMIENTO PARA CONSULTAR////////////////////*/

use WORKINC;
drop procedure if exists spBuscaUsuario;
delimiter **
create procedure spBuscaUsuario(
in id varchar(30),in mail varchar(100), in pass nvarchar(100))
begin
	declare msj varchar(80);
    declare existe int;
    declare idper int;
    declare corr varchar(50);
    declare pasw varchar(50);
    set idper = (select Id_usuariow from Usuariow where correo = mail);
    set existe = (select count(*) from Usuariow where correo = mail and contra = pass);
	if(id = 'login')then
			if(existe = 1)then 		
					set pasw = (select contra from Usuariow where correo = mail);
					if(pasw = pass)then
						set msj = 'usuario correcto';
						select idper as usuario , msj as mensaje, mail as correo , pass as contra;
					else
						set msj = 'Contraseña incorrecta';
						select idper as usuario , msj as mensaje, mail as correo , pass as contra;
					end if;
			else
					set msj = 'El correo no existe';
					select idper as usuario , msj as mensaje, mail as correo  , pass as contra;
			end if;
        else 
			if(id = 'eliminar')then
						if(existe = 1)then
							/*elimnar todos los registros de las demas tablas*/
                            delete from experiencia where id_usuariow=idper;
                            delete from Escolaridad where id_usuariow=idper;
                            delete from Idiomas where id_usuariow=idper;
                            delete from software where id_usuariow=idper;
                            delete from habilidades where id_usuariow=idper;
                            delete from cursos where id_usuariow=idper;
                            delete from Proyectos where id_usuariow=idper;
                            delete from Profesionistas_unid where id_usuario=idper;
                            delete from Profesionistas_Solicitud_Union where id_usuario=idper;
							delete from Usuariow where id_usuariow=idper;
							set msj = 'Persona eliminada';
							select idper as usuario , msj as mensaje, mail as correo ;
						else
							set msj = 'El correo no existe';
							select idper as usuario , msj as mensaje, mail as correo ;
						end if;
                else
					if(id = 'buscar')then
						if(existe = 1)then							
                            set msj = 'Usuario encontrado';
                            select * from Usuariow where Id_usuariow = idper;
                            else
								set msj = 'El correo no existe';
								select idper as usuario , msj as mensaje, mail as correo ;
						end if;
                    end if;
			end if;
	end if;
end;**
select*from usuariow**
call spBuscaUsuario('buscar','a&#x40;gmail.com','123')**
/*//////////////// Curriculums //////////////*/
use WORKINC;
drop procedure if exists AltaExperiencia;
delimiter ** 
create procedure AltaExperiencia(in id nvarchar(50),in id_xp int,in mail nvarchar(100),in puest nvarchar(200),in empre nvarchar(200),in func nvarchar(300),in ini date, in fin date)
begin 
declare existe int;
declare existeXP int;
declare mjs nvarchar(50);
declare idper int;
declare idXP int;
declare updateidXP int;
set idper = (select id_usuariow from usuariow where correo=mail);
    if(idper !=0)then
		if(id = 'alta')then
			set existeXP =  (select count(*) from experiencia where id_usuariow = idper and puesto = puest and empresa = empre and funcion = func and inicio = ini and final = fin);
			if(existeXP =0)then
			INSERT INTO Experiencia(id_usuariow,puesto,empresa,funcion,inicio,final) 
			values (idper,puest,empre, func,ini,fin);
			set mjs = 'Experiencia registrada';
            select  existeXP as experiencia, mjs as mensaje;
			else
				set mjs = 'Experiencia ya esta registrada';
                select  existeXP as experiencia, mjs as mensaje;
			end if;
		else
			if(id = 'actualiza')then
				set existeXP =  (select count(*) from experiencia where id_experiencia = id_xp);
				if(existeXP != 0)then
					update experiencia set puesto=puest,empresa=empre,funcion=func,inicio=ini,final= fin
					where Id_experiencia = id_xp and id_usuariow = idper;
				set mjs = 'Experiencia actualizada';
                select  existeXP as experiencia, mjs as mensaje;
				else
					set mjs ='Experiencia no existe';
                    select  existeXP as experiencia, mjs as mensaje;
				end if;				                
            end if;
		end if;
	else
	set mjs = 'el usuario no existe';
	select  existeXP as experiencia, mjs as mensaje; 
	end if;
end**
call AltaExperiencia('borrar',1,'a&#x40;gmail.com','','','','2013-04-12','2013-01-01')**
select* from experiencia**

use WORKINC;
drop procedure if exists BusquedaExperiencia;
delimiter ** 
create procedure BusquedaExperiencia(in id nvarchar(50),in mail nvarchar(100), in id_xp int)
begin 
declare existe int;
declare idper int;
declare mjs nvarchar(50);

		set idper = (select id_usuariow from usuariow where correo=mail);
		if(id='consulta')then
		select * from experiencia where id_usuariow = idper;
        else
			if(id='borrar')then
            delete from experiencia where id_experiencia = id_xp;
                    set mjs = 'experiencia borrarada';
                    select  id_xp as experiencia, mjs as mensaje;
            end if;
		end if;
end**
call BusquedaExperiencia('consulta','a&#x40;gmail.com',0)**


/*///////////// PROCEDURE ESCOLARIDAD ALTA Y CAMBIO/////////////*/
use WORKINC;
drop procedure if exists AltaEscolaridad;
delimiter ** 
create procedure AltaEscolaridad(in id nvarchar(50),in id_escue int, in mail nvarchar(100), in escu nvarchar(200),in carre nvarchar(200), in ini date,in fin date)
begin 
declare existe int;
declare existeES int;
declare mjs nvarchar(50);
declare idper int;
	set idper = (select Id_usuariow from Usuariow where correo = mail);
    if(idper !=0)then
		if(id = 'alta')then
        set existeES =  (select count(*) from escolaridad where id_usuariow = idper and escuela = escu and carrera = carre and inicio = ini and final = fin);
				if(existeES =0)then
				INSERT INTO escolaridad(id_usuariow,escuela,carrera,inicio,final) 
				values (idper,escu,carre,ini,fin);
				set mjs = 'Escolaridad registrada';
                select  existeES as escolaridad, mjs as mensaje;
				else
					set mjs = 'Escolaridad ya esta registrada';
                    select  existeES as escolaridad, mjs as mensaje;
				end if;
		else
			if(id='actualiza')then
				set existeES =  (select count(*) from escolaridad where id_escolaridad = id_escue);
				if(existeES != 0)then
					update escolaridad set escuela = escu, carrera = carre,inicio=ini,final= fin
					where Id_escolaridad = id_escue and id_usuariow = idper;
				set mjs = 'Escolaridad actualizada';
                select  existeES as escolaridad, mjs as mensaje;
				else
					set mjs ='Escolaridad no existe';
                    select  existeES as escolaridad, mjs as mensaje;
				end if;
            end if;    
		end if;
	else
	set mjs = 'el usuario no existe';
	end if;
end**
call AltaEscolaridad('alta',0,'a&#x40;gmail.com','batiz juan de dios','programacion','2001-01-10','2001-03-08')**
select*from escolaridad**

use WORKINC;
drop procedure if exists BusquedaEscolaridad;
delimiter ** 
create procedure BusquedaEscolaridad(in id nvarchar(50),in mail nvarchar(100), in id_esco int)
begin 
declare existe int;
declare idper int;
declare mjs nvarchar(50);
		set idper = (select id_usuariow from usuariow where correo=mail);
		if(id='consulta')then
		select * from escolaridad where id_usuariow = idper;
        else
			if(id='borrar')then
            delete from escolaridad where Id_escolaridad = id_esco; 
			set mjs='escolaridad borrada';
			select  id_esco as escolaridad, mjs as mensaje;
            end if;
		end if;
end**
call BusquedaEscolaridad('consulta','a&#x40;gmail.com',2)**

/*///////////// PROCEDURE IDIOMAS ALTA Y CAMBIO/////////////*/
use WORKINC;
drop procedure if exists Altaidiomas;
delimiter ** 
create procedure Altaidiomas(in id nvarchar(50),in id_ido int, in mail nvarchar(100), in idiom nvarchar(200),in nivehabla nvarchar(100),in niveescrito nvarchar(100),in niveescucha nvarchar(100), in certi nvarchar(150))
begin 
declare existeIDIO int;
declare mjs nvarchar(50);
declare idper int;
	set idper = (select Id_usuariow from Usuariow where correo = mail);
    if(idper !=0)then
		if(id = 'alta')then
			set existeIDIO =  (select count(*) from idiomas where id_usuariow = idper and idioma = idiom and nivelhabla = nivehabla and nivelescrito = niveescrito and nivelescucha = niveescucha and certificado = certi);
			if(existeIDIO =0)then
			INSERT INTO idiomas(id_usuariow,idioma,nivelhabla,nivelescrito,nivelescucha,certificado) 
			values (idper,idiom,nivehabla,niveescrito,niveescucha,certi);
			set mjs = 'idioma registrado';
			select  existeIDIO as idioma, mjs as mensaje;
			else
				set mjs = 'Idioma ya registrado';
				select  existeIDIO as idioma, mjs as mensaje;
			end if;
            else
            if(id='actualiza')then
			set existeIDIO =  (select count(*) from idiomas where id_idiomas = id_ido);
			if(existeIDIO != 0)then
				update idiomas set idioma= idiom, nivelhabla = nivehabla, nivelescrito = niveescrito, nivelescucha=niveescucha, certificado = certi
				where id_idiomas = id_ido and id_usuariow = idper;
			set mjs = 'idioma actualizado';
            select  existeIDIO as idioma, mjs as mensaje;
			else
				set mjs ='idioma no existe';
                select  existeSOFT as software, mjs as mensaje;
			end if;
            end if;
        end if;
	else
	set mjs = 'el usuario no existe';
    select  existeIDIO as 
    idioma, mjs as mensaje;
	end if;

end**
call Altaidiomas('alta',0,'a&#x40;gmail.com','frances','leve','medio','avanzado','topperware')**
select*from idiomas**
/*Aui no permito que la id_usuariow cambie porque se supone no debe de cambiar*/
use WORKINC;
drop procedure if exists BusquedaIdioma;
delimiter ** 
create procedure BusquedaIdioma(in id nvarchar(50),in mail nvarchar(100), in id_idio int)
begin 
declare existe int;
declare idper int;
declare mjs nvarchar(50);
		set idper = (select id_usuariow from usuariow where correo=mail);
		if(id='consulta')then
		select * from idiomas where id_usuariow = idper;
        else
			if(id='borrar')then
            delete from idiomas where id_idiomas = id_idio; 
			set mjs='idioma borrado';
			select  id_esco as idioma, mjs as mensaje;
            end if;
		end if;
end**
call BusquedaIdioma('consulta','a&#x40;gmail.com',0)**

use WORKINC;
drop procedure if exists Altasoftware;
delimiter ** 
create procedure Altasoftware(in id nvarchar(50),in id_soft int, in mail nvarchar(100), in soft nvarchar(100),in ano year,in conts nvarchar(100))
begin 
declare existeSOFT int;
declare mjs nvarchar(50);
declare idper int;
	set idper = (select Id_usuariow from Usuariow where correo = mail);
    if(idper !=0)then
		if(id = 'alta')then
			set existeSOFT =  (select count(*) from software where id_usuariow = idper and software= soft and año = ano and constancia = conts);
				if(existeSOFT =0)then
				INSERT INTO software(id_usuariow,software,año,constancia) 
				values (idper,soft,ano,conts);
				set mjs = 'software registrado';
                select  existeSOFT as software, mjs as mensaje;
				else
					set mjs = 'software ya registrado';
                    select  existeSOFT as software, mjs as mensaje;
				end if;
		else
			if(id='actualiza')then
			set existeSOFT =  (select count(*) from software where id_software = id_soft);
			if(existeSOFT != 0)then
				update software set software = soft, año = ano,constancia = conts
				where id_software = id_soft and id_usuariow = idper;
			set mjs = 'software actualizado';
            select  existeSOFT as software, mjs as mensaje;
			else
				set mjs ='software no existe';
                select  existeSOFT as software, mjs as mensaje;
			end if;
            end if;
		end if;
	else
	set mjs = 'el usuario no existe';
    select  existeSOFT as software, mjs as mensaje;
	end if;
end**
call Altasoftware('alta',0,'ro&#x40;gmail.com','powerpont','2001','oxford')**
select*from software**

use WORKINC;
drop procedure if exists Busquedasoftware;
delimiter ** 
create procedure Busquedasoftware(in id nvarchar(50),in mail nvarchar(100), in id_soft int)
begin 
declare existe int;
declare idper int;
declare mjs nvarchar(50);
		set idper = (select id_usuariow from usuariow where correo=mail);
		if(id='consulta')then
		select*from software where id_usuariow = idper;
		else
			if(id='borrar')then
			delete from software  where id_software = id_soft;
			set mjs='software borrado';
			select  id_soft as software, mjs as mensaje;
			end if;
		end if;
end**
call Busquedasoftware('consulta','a&#x40;gmail.com',0)**

use WORKINC;
drop procedure if exists Altahabilidad;
delimiter ** 
create procedure Altahabilidad(in id nvarchar(50),in id_hab int, in mail nvarchar(100), in hab nvarchar(500))
begin 
declare existeHAB int;
declare mjs nvarchar(50);
declare idper int;
	set idper = (select Id_usuariow from Usuariow where correo = mail);
    if(idper !=0)then
		if(id_hab = 0)then
			set existeHAB =  (select count(*) from habilidades where id_usuariow = idper and habilidad = hab);
			if(existeHAB =0)then
			INSERT INTO habilidades(id_usuariow,habilidad) 
			values (idper,hab);
			set mjs = 'habilidad registrada';
            select  existeHAB as habilidad, mjs as mensaje;
			else
				set mjs = 'habilidad ya registrada';
                select  existeHAB as habilidad, mjs as mensaje;
			end if;
		else
			if(id='actualiza')then
            set existeHAB =  (select count(*) from habilidades where id_habilidad = id_hab);
			if(existeHAB != 0)then
				update habilidades set habilidad = hab
				where id_habilidad = id_hab and id_usuariow = idper;
			set mjs = 'habilidad actualizada';
            select  existeHAB as habilidad, mjs as mensaje;
			else
				set mjs ='habilidad no existe';
                select  existeHAB as habilidad, mjs as mensaje;
			end if;
            end if;
		end if;
	else
	set mjs = 'el usuario no existe';
    select  existeHAB as habilidad, mjs as mensaje;
	end if;
end**
call Altahabilidad('alta',0,'a&#x40;gmail.com','soydfg bien')**
select*from habilidades**

use WORKINC;
drop procedure if exists Busquedahabilidad;
delimiter ** 
create procedure Busquedahabilidad(in id nvarchar(50),in mail nvarchar(100), in id_hab int)
begin 
declare existe int;
declare idper int;
declare mjs nvarchar(50);
		set idper = (select id_usuariow from usuariow where correo=mail);
		if(id='consulta')then
		select*from habilidades where id_usuariow = idper;
		else
			if(id='borrar')then
			delete from habilidades where id_habilidad = id_hab;
			set mjs = 'habilidad borrada';
			select  id_hab as habilidad, mjs as mensaje;
			end if;
		end if;
end**
call Busquedahabilidad('consulta','a&#x40;gmail.com',2)**



use WORKINC;
drop procedure if exists Altacursos;
delimiter ** 
create procedure Altacursos(in id nvarchar(50),in  id_cur int, in mail nvarchar(100), in nomcur nvarchar(500), in ano year, in durac int)
begin 
declare existeCUR int;
declare mjs nvarchar(50);
declare idper int;
	set idper = (select Id_usuariow from Usuariow where correo = mail);
    if(idper !=0)then
		if(id = 'alta')then
			set existeCUR =  (select count(*) from cursos where id_usuariow = idper and nombre_curso = nomcur and año = ano and duracion = durac);
			if(existeCUR =0)then
			INSERT INTO cursos(id_usuariow,nombre_curso,año,duracion) 
			values (idper,nomcur,ano,durac);
			set mjs = 'curso registrado';
            select  existeCUR as curso, mjs as mensaje;
			else
				set mjs = 'curso ya registrado';
                select  existeCUR as curso, mjs as mensaje;
			end if;
		else
			if(id='actualiza')then
			set existeCUR =  (select count(*) from cursos where id_cursos = id_cur);
			if(existeCUR != 0)then
				update cursos set nombre_curso = nomcur, año = ano,duracion = durac
				where id_cursos = id_cur and id_usuariow = idper;
			set mjs = 'curso actualizado';
            select  existeCUR as curso, mjs as mensaje;
			else
				set mjs ='curso no existe';
                select  existeCUR as curso, mjs as mensaje;
			end if;
            end if;
		end if;
	else
	set mjs = 'el usuario no existe';
    select  existeCUR as curso, mjs as mensaje;
	end if;
end**
call Altacursos('borrar',0,'a&#x40;gmail.com','soy bien cabron','2001',30)**
select*from cursos**

use WORKINC;
drop procedure if exists BusquedaCursos;
delimiter ** 
create procedure BusquedaCursos(in id nvarchar(50),in mail nvarchar(100), in id_cur int)
begin 
declare existe int;
declare idper int;
declare mjs nvarchar(50);
		set idper = (select id_usuariow from usuariow where correo=mail);
		if(id='consulta')then
		select*from cursos where id_usuariow = idper;
		else
			if(id='borrar')then
			delete from cursos where id_cursos = id_cur;
			set mjs = 'curso borrado';
			select  id_cur as curso, mjs as mensaje;
			end if;
		end if;
end**
call BusquedaCursos('consulta','a&#x40;gmail.com',0)**

use WORKINC;
drop procedure if exists EntraUsuario;
delimiter **
create procedure EntraUsuario( in correoo varchar(30), in contraaa varchar(30) )
begin

select * from usuariow where Correo=correoo and Contra=contraaa;

end**


/*///////////////////////PROCEDIMIENTO CONSULTAR CORREO REPETIDO /////////////////////////*/

use WORKINC;
drop procedure if exists ConsultaCorreo;
delimiter **
create procedure ConsultaCorreo( in correoo varchar(60) )
begin

select * from Usuario where correoo = Correo;

end**

/*////////////////////PROCEDIMIENTO PARA ALTA DE PROYECTO*/

use WORKINC;
drop procedure if exists GuardaProyecto;
delimiter **
create procedure GuardaProyecto( in nombreproyecto varchar(60), in ideaproyecto varchar(60), in categoria varchar(60), in montopro int(10), in correocreador varchar(60), in img longblob, in NumeroRequeridos int(1))
begin
 
 declare id_usuario_creador int;
 
 set id_usuario_creador =(select (Id_usuariow) from usuariow where Correo= correocreador);
 select id_usuario_creador;


INSERT INTO Proyectos(Nombre_proyecto, Idea_principal, Categoria, Monto,Id_usuariow,imagen,NumDeProfesionistas) 
values(nombreproyecto,ideaproyecto, categoria, montopro, (select (Id_usuariow) from usuariow where Correo= correocreador), img,NumeroRequeridos);

end**

use WORKINC;
drop procedure if exists InsertaUsuariosRequeridos;
delimiter **
create procedure InsertaUsuariosRequeridos( in NombreProyect varchar(60),in IdeaProyect varchar(60), in MontoProyecto int(10), in CategoriaProyect varchar(60),in CorreoCreador varchar(60), in StatusPuesto varchar(120), in NombreProfesion varchar(120) )
begin
declare id_usuario int;
declare Id_ProyectoCon int(3);

set id_usuario=(select  Id_usuariow from Usuariow where Correo = CorreoCreador);
set Id_ProyectoCon=(select Id_proyecto from Proyectos where Nombre_proyecto = NombreProyect and Idea_principal =IdeaProyect and Monto=MontoProyecto and Categoria =CategoriaProyect and Id_usuariow= id_usuario);

INSERT INTO Profesionistas_req(Id_proyecto ,Tipo_profesionista ,StatusOcupacion ) 
values(Id_ProyectoCon,NombreProfesion,StatusPuesto);


end**






/*/////////////////////////PROYECTO CONSULTATODOSPROYECTOS ///////////////////////////*/
use WORKINC;
drop procedure if exists TraeProyecto;
delimiter **
create procedure TraeProyecto(in id int(1), in correoo varchar(40) )
begin
declare id_usuario int;

if(id = 0)then

	select * from Proyectos;
	else
		if(id =1)then
				/*set id_usuario = (select Id_usuariow from Usuariow where Correo = correo);*/
                
                select * from Proyectos where Id_usuariow =(select Id_usuariow from Usuariow where Correo = correoo);
		
		end if;
end if;
 
end**



/**************PROCEDIMIENTO PARA CONSULTAR UN PROYECTO **********/
use WORKINC;
drop procedure if exists ConsultaProyecto;
delimiter **
create procedure ConsultaProyecto( in NombreProyect varchar(60),in IdeaProyect varchar(60),in CategoriaProyect varchar(60), in MontoProyecto int(10),in CorreoCreador varchar(60) )
begin
	
declare id_usuario int;
set id_usuario=(select  Id_usuariow from Usuariow where Correo = CorreoCreador);


select * from Proyectos where Nombre_proyecto = NombreProyect and IdeaProyect = Idea_principal and Categoria=CategoriaProyect and Monto=MontoProyecto ;



end**


/*******************PROCEDIMIENTO PARA ACTUALIZAR PROYECTO**************/

use WORKINC;
drop procedure if exists ActualizaProyecto;
delimiter **
create procedure ActualizaProyecto( in NombreProyect varchar(60),in IdeaProyect varchar(60),in CategoriaProyect varchar(60), in MontoProyecto int(10),in CorreoCreador varchar(60), in img longblob, in Identificador int(4) )
begin
	
declare id_usuario int;
set id_usuario=(select  Id_usuariow from Usuariow where Correo = CorreoCreador);

update Proyectos set  Nombre_proyecto  = NombreProyect, Idea_principal  = IdeaProyect, Categoria  = CategoriaProyect , Monto  = MontoProyecto , imagen  = img 
			where Id_proyecto =Identificador;

end**


/************PROCEDIIENTO PARA ENVIAR PETICION DE UNION A UN PROYECTO ***********/
use WORKINC;
drop procedure if exists UnionProyecto;
delimiter **
create procedure UnionProyecto( in CorreoUsuarioUnion varchar(60),in InformacionProyecto int)
begin
declare mjs nvarchar(50);
declare id_usuario int;
declare Id_Usuario_Proyecto int;

set id_usuario=(select  Id_usuariow from Usuariow where Correo = CorreoUsuarioUnion);

set Id_Usuario_Proyecto =(select Id_usuariow from  Proyectos where Id_proyecto =InformacionProyecto);

if(id_usuario !=Id_Usuario_Proyecto) then
	insert into Profesionistas_Solicitud_Union (Id_proyecto, Id_usuario) values(InformacionProyecto, id_usuario);
else

set mjs = 'No se puede hacer esta solicitud';
    
end if;

end**


/************ VISTA PARA OBTENER DATOS DE USUAERIOS****************/

use WORKINC;
drop view if exists UnionDatosUsuarioSolicitud;
create view as UnionDatosUsuarioSolicitud

select Usuariow.Nombre , Usuariow.Apat, Usuariow.Amat, Usuariow.Amat,  Usuariow.Correo , Usuariow.Profesion from Usuariow inner join Profesionistas_Solicitud_Union on 





/******************PROCEDIMIENTO PARA TRAER A USUARIOS INTERESADOS EN UNIRSE A PROYECTO  *************************/

use WORKINC;
drop procedure if exists TraerUsuarioPeticionUnion;
delimiter **
create procedure TraerUsuarioPeticionUnion(  in NombreProyect varchar(60),in IdeaProyect varchar(60),in CategoriaProyect varchar(60), in MontoProyecto int(10),in CorreoCreador varchar(60) )
begin
	
declare id_usuarioo int;
declare id_Proyectoo int;
declare EstadoUsr int;

set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = CorreoCreador);
set id_Proyectoo=(select  Id_proyecto  from Proyectos where Nombre_proyecto=NombreProyect and Idea_principal =IdeaProyect and  Categoria =CategoriaProyect and Monto= MontoProyecto and Id_usuariow = id_usuarioo);

select Usuariow.Nombre , Usuariow.Apat, Usuariow.Amat,  Usuariow.Correo , Usuariow.Profesion from Usuariow inner join Profesionistas_Solicitud_Union on Usuariow.Id_usuariow = Profesionistas_Solicitud_Union.Id_usuario where Profesionistas_Solicitud_Union.Id_proyecto =id_Proyectoo ;

end**



/*******************PROCEDIMIENTO PARA TRAER LOS PUESTOS REQUERIDOS***********************/




use WORKINC;
drop procedure if exists TraerPuestosReq;
delimiter **
create procedure TraerPuestosReq(  in NombreProyect varchar(60),in IdeaProyect varchar(60),in CategoriaProyect varchar(60), in MontoProyecto int(10),in CorreoCreador varchar(60) )
begin
	
declare id_usuario int;
declare id_Proyectoo int;

set id_usuario=(select  Id_usuariow from Usuariow where Correo = CorreoCreador);

set id_Proyectoo=(select  Id_proyecto  from Proyectos where Nombre_proyecto=NombreProyect and Idea_principal =IdeaProyect and  Categoria =CategoriaProyect and Monto= MontoProyecto and Id_usuariow = id_usuario);

select * from Profesionistas_req where id_Proyectoo=Id_proyecto;

end**








/*****************PROCEDIMIENTO PARA CONSULTAR USUARIOS UNIDOS EN PROYECTOS********************/



use WORKINC;
drop procedure if exists TraeUsuariosUnidos;
delimiter **
create procedure TraeUsuariosUnidos(  in NombreProyect varchar(60),in IdeaProyect varchar(60),in CategoriaProyect varchar(60), in MontoProyecto int(10),in CorreoCreador varchar(60) )
begin
	
declare id_usuarioo int;
declare id_Proyectoo int;

set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = CorreoCreador);
set id_Proyectoo=(select  Id_proyecto  from Proyectos where Nombre_proyecto=NombreProyect and Idea_principal =IdeaProyect and  Categoria =CategoriaProyect and Monto= MontoProyecto and Id_usuariow = id_usuarioo);

select Usuariow.Nombre , Usuariow.Apat, Usuariow.Amat,  Usuariow.Correo , Usuariow.Profesion from Usuariow inner join Profesionistas_unid on Usuariow.Id_usuariow = Profesionistas_unid.Id_usuario where Profesionistas_unid.Id_proyecto =id_Proyectoo ;

end**










/*******************PROCEDIMIENTO PARA ACEPTAR UN PUESTO **************/


use WORKINC;
drop procedure if exists administrarsolicitudesUnion;
delimiter **
create procedure administrarsolicitudesUnion(in CorreoUsrAceptado varchar(50),in infoproyecto int, in PuestoAsignado varchar(50) )
begin 

declare id_usuario_aceptado int;
 
set id_usuario_aceptado =(select (Id_usuariow) from usuariow where Correo= CorreoUsrAceptado);
 
insert into Profesionistas_unid(Id_proyecto ,Id_usuario ,PuestoIndicado ) values (infoproyecto, id_usuario_aceptado,PuestoAsignado);

update Profesionistas_req set StatusOcupacion='Ocupado'
 where Tipo_profesionista=PuestoAsignado;
 
 delete from Profesionistas_Solicitud_Union where Profesionistas_Solicitud_Union.Id_usuario  =id_usuario_aceptado and Profesionistas_Solicitud_Union.Id_proyecto =infoproyecto;

end**

/****************PROCEDIMIENTO PARA RECHAZAR SOLICITUDES DE PROYECTOS****************/

use WORKINC;
drop procedure if exists RechazaUnionProyecto;
delimiter **
create procedure RechazaUnionProyecto(in CorreoUsRechazado varchar(100), in Infoproyecto int )
begin 

declare id_usuario_rechazado int;
 
set id_usuario_rechazado =(select (Id_usuariow) from usuariow where Correo= CorreoUsRechazado);
 
 delete from Profesionistas_Solicitud_Union where Profesionistas_Solicitud_Union.Id_usuario  =id_usuario_rechazado and Profesionistas_Solicitud_Union.Id_proyecto =Infoproyecto;

end**



/*************PROCEDIMIENTO PARA CREAR UNA TAREA***************/



use WORKINC;
drop procedure if exists CrearTareaProyecto;
delimiter **
create procedure CrearTareaProyecto(in tituloo varchar(100), in Descripcion varchar(200), in importancia varchar(100), in CorreoUsrA varchar(100), in Dias int, in Infoproyecto int )
begin 

declare id_usuario_selecc int;
 
set id_usuario_selecc =(select (Id_usuariow) from usuariow where Correo= CorreoUsrA);
 
 insert into TareasProyectos (Id_ProyectoT ,id_UsuarioT ,TituloT ,DescripcionT ,ImportanciaT ,DuracionDias ) 
 values(Infoproyecto, id_usuario_selecc, tituloo, Descripcion, importancia, Dias);

end**


/*****************PROCEDIMIENTO PARA TRAER TAREAS***************/





use WORKINC;
drop procedure if exists TraerTareaProyecto;
delimiter **
create procedure TraerTareaProyecto(  in NombreProyect varchar(60),in IdeaProyect varchar(60),in CategoriaProyect varchar(60), in MontoProyecto int(10),in CorreoCreador varchar(60) )
begin
	
declare id_usuarioo int;
declare id_Proyectoo int;

set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = CorreoCreador);
set id_Proyectoo=(select  Id_proyecto  from Proyectos where Nombre_proyecto=NombreProyect and Idea_principal =IdeaProyect and  Categoria =CategoriaProyect and Monto= MontoProyecto and Id_usuariow = id_usuarioo);

select Usuariow.Nombre , Usuariow.Apat, Usuariow.Amat,  Usuariow.Correo , TareasProyectos.TituloT ,  
TareasProyectos.DescripcionT ,  TareasProyectos.ImportanciaT ,   TareasProyectos.DuracionDias   from Usuariow inner join TareasProyectos on Usuariow.Id_usuariow = TareasProyectos.id_UsuarioT 
 where TareasProyectos.Id_ProyectoT  =id_Proyectoo ;

end**



use WORKINC;
drop procedure if exists SubirPregunta;
delimiter **
create procedure  SubirPregunta(in id nvarchar(10),in Preguntaa varchar(900), in id_pregun int)
begin 
declare existeCUR int;
declare msj nvarchar(50);
declare existe int;
set existeCUR =  (select count(*) from faqs where Pregunta = Preguntaa);
			if(existeCUR = 0)then
					if(id = 'alta')then
					Insert into faqs(Pregunta, estado)
					values(Preguntaa,'pendiente');
					set msj = 'pregunta alta';
					else
							if(id='modificar')then
							
								update faqs set Pregunta = Preguntaa where Id_pregunta = id_pregun;
								set msj='pregunta actualiza';
							end if;
					end if;
                else
                set msj='pregunta repetida';
				end if;
select msj as mensaje;
end**
call SubirPregunta('modificar','Que pedo?',9)**
select * from faqs**

/*///////////////// PROCEDIMIENTO PARA SUBIR LAS RESPUESTAS DE LAS FAQS /////////*/
use WORKINC;
drop procedure if exists SubirRespuesta;
delimiter **
create procedure  SubirRespuesta(in respuestaa varchar(900), in id_pregun int)
begin 
declare msj nvarchar(100);
declare existe int;
set existe =  (select count(*) from faqs where Respuesta = respuestaa);
if(existe = 0)then
update faqs set Respuesta = respuestaa, estado = 'visto' where Id_pregunta = id_pregun;
set msj = 'respuestasi';
select msj as mensaje;
else	
set msj = 'respuesta repetida';
select msj as mensaje;
end if;
end**
call SubirRespuesta('sada',3)**
select*from faqs**
/*delete from respuestaFaqs where id_pregunta=1;*/

/*///////////////// PROCEDIMIENTO PARA SUBIR LAS PREGUNTAS DE LAS FAQS /////////*/
use WORKINC;
drop procedure if exists MostrarPreguntas;
delimiter **
create procedure MostrarPreguntas()
begin 

select * from faqs;

end**
call MostrarPreguntas()**

use WORKINC;
drop procedure if exists Pregunta;
delimiter **
create procedure Pregunta(in ask nvarchar(200))
begin 

select Id_Pregunta from faqs where Pregunta= ask; 

end**
call Pregunta('¿Qué puedo hacer en caso de haber olvidado mi contraseña para acceder a la página?')**


use WORKINC;
drop procedure if exists borrarPreguntas;
delimiter **
create procedure borrarPreguntas(in idpregun int)
begin 
declare msj nvarchar(80);
delete from faqs where Id_pregunta = idpregun;
set msj = 'eliminado';
select msj as mensaje;
end**
call borrarPreguntas(6)**


use WORKINC;
drop procedure if exists SubirNoticia;
delimiter ** 
create procedure SubirNoticia(in Noticiaa varchar(900),in Tituloo varchar(50),in imageen mediumblob,in categoriaaa varchar(100))
begin 

INSERT INTO noticias(Noticia,Titulo,imagen,Categoria)
values(Noticiaa,Tituloo,imageen,categoriaaa);


end**

/*////////////////// PROCEDIMIENTO PARA OBTENER NOTICIAS PREVIAS //////////////*/

use WORKINC;
drop procedure if exists TraerNoticia;
delimiter **
create procedure TraerNoticia()
begin 

select * from noticias;

end**

/*/////////////////PROCEDIMIENTO PARA OBTENER NOTICIAS //////////////*/

use WORKINC;
drop procedure if exists TraerNoticiaPrevia;
delimiter **
create procedure TraerNoticiaprevia(in tituloo varchar(100))
begin 


select * from Noticias where Titulo=tituloo;

end**

/*/////////// PROCESO PARA TRAER DATOS DE UNA NOTICA CON EL TITULO ///////*/

use WORKINC;
drop procedure if exists TraerNoticiaDatos;
delimiter **
create procedure TraerNoticiaDatos (in tituloo varchar(50))
begin

select * from noticias where Titulo=tituloo;

end**

/*/////// PROCESO PARA TRAER NOTICIAS ORDENADAS POR LA FECHA /////*/

use WORKINC;
drop procedure if exists TraerNoticiaLimitada;
delimiter **
create procedure TraerNoticiaLimitada()
begin 

select Noticia,Titulo,imagen,Categoria from noticias order by FechaNoticia desc limit 4;

end**

/*/////// PROCEDIMIENTO PARA MODIFICAR NOTICIAS ////////*/

use WORKINC;
drop procedure if exists ModificarNoticia;
delimiter **
create procedure ModificarNoticia(in id int(200),in Noticiaa varchar(900),in Tituloo varchar(50),in imageen longblob,in categoriaaa varchar(100))
begin 

update noticias set Titulo=Tituloo, Noticia=Noticiaa,Categoria=categoriaaa, imagen=imageen where Id_noticias=id;

end**

/*///// PROCEDIMIENTO PARA ELIMINAR NOTICIAS ////////*/

use WORKINC;
drop procedure if exists BorrarNoticia;
delimiter **
create procedure BorrarNoticia(in id int(200))
begin 

delete from noticias where Id_noticias=id;

end**

/************PROCEDIMIENTO PARA TRAER A PROYECTOS A LOS QUE UN USUARIO ESTE UNIDO***********/


use WORKINC;
drop procedure if exists TraerProyectoUsuarioUnido;
delimiter **
create procedure TraerProyectoUsuarioUnido(in CorreoUsuarioEnProyectos varchar(100))
begin 

declare id_usuarioo int;


set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = CorreoUsuarioEnProyectos);

select Proyectos.Nombre_proyecto  , Proyectos.Idea_principal , Proyectos.Categoria ,  Proyectos.Monto  , Proyectos.imagen,  Proyectos.Id_proyecto 
from Proyectos inner join Profesionistas_unid on Proyectos.Id_proyecto  = Profesionistas_unid.Id_proyecto  
 where Profesionistas_unid.Id_usuario   =id_usuarioo ;



end**


/*****************PROCEDIMIENTO PARA TRAER TAREAS ASIGNADAS A UN USUARIO EN ESPECIFICO**************/

use WORKINC;
drop procedure if exists TraerTareaProyectoARealizar;
delimiter **
create procedure TraerTareaProyectoARealizar(  in Informacionproyect int, in CorreoUsr varchar(100))
begin
	
declare id_usuarioo int;

set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = CorreoUsr);

select * from TareasProyectos where Id_ProyectoT =Informacionproyect and id_UsuarioT =id_usuarioo;
end**

/*************************PROCEDIMIENTO PARA BORRAR TAREA**********************/



use WORKINC;
drop procedure if exists BorraTarea;
delimiter **
create procedure BorraTarea( in CorreoUsr varchar(100) ,in InformacionTarea int)
begin
	
declare id_usuarioo int;

set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = CorreoUsr);


Delete from TareasProyectos where TareasProyectos.Id_Tarea  =InformacionTarea and TareasProyectos.id_UsuarioT  =id_usuarioo ;

end**


/***************PROCEDIMIENTO PARA HACER ALTA DE REPORTE DE EVENTO**********/



use WORKINC;
drop procedure if exists AltaReporteEvento;
delimiter **
create procedure AltaReporteEvento( in Modulo varchar(100), in Descripcion  varchar(400), in Usuario varchar(100), in EstadoRep varchar(100), in Etiqueta varchar(100), in foli varchar(8), in correoOperador varchar(100)  )
begin

declare id_usuarioo int;

set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = correoOperador);

insert into EventosReporte(Folio, ModuloE,DescripcionE, UsuarioFalla,EstadoE,EtiquetaE, Id_Usuario_Operador,Asignacion   ) values(foli,Modulo,Descripcion,Usuario, EstadoRep,Etiqueta, id_usuarioo,'Sin asignacion');

end**

/**************************PROCEDIMIENTO PARA TRAER DEVUELTA LOS REPORTES*********************/



use WORKINC;
drop procedure if exists ConsultaReporteEvento;
delimiter **
create procedure ConsultaReporteEvento( in id int, in CorreoOperador varchar(100)  )
begin

declare id_usuarioo int;


set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = CorreoOperador);



if(id=1)then

select EventosReporte.Folio   , EventosReporte.ModuloE  , EventosReporte.DescripcionE  ,  EventosReporte.UsuarioFalla   , EventosReporte.EstadoE , 
 EventosReporte.EtiquetaE, EventosReporte.Fecha,   Usuariow.Nombre, Usuariow.Apat, Usuariow.Amat, EventosReporte.Id_IngenieroAsignado, EventosReporte.Asignacion,EventosReporte.solucion
from EventosReporte inner join Usuariow on EventosReporte.Id_Usuario_Operador  = Usuariow.Id_usuariow ;

else
if(id=2)then

select EventosReporte.Folio   , EventosReporte.ModuloE  , EventosReporte.DescripcionE  ,  EventosReporte.UsuarioFalla   , EventosReporte.EstadoE , 
 EventosReporte.EtiquetaE, EventosReporte.Fecha,   Usuariow.Nombre, Usuariow.Apat, Usuariow.Amat, EventosReporte.Id_IngenieroAsignado, EventosReporte.Asignacion, EventosReporte.solucion
from EventosReporte inner join Usuariow on EventosReporte.Id_Usuario_Operador  = Usuariow.Id_usuariow where  EventosReporte.Id_IngenieroAsignado  =id_usuarioo;
else

if(id=3)then
select EventosReporte.Folio   , EventosReporte.ModuloE  , EventosReporte.DescripcionE  ,  EventosReporte.UsuarioFalla   , EventosReporte.EstadoE , 
 EventosReporte.EtiquetaE, EventosReporte.Fecha,   Usuariow.Nombre, Usuariow.Apat, Usuariow.Amat, EventosReporte.Id_IngenieroAsignado, EventosReporte.Asignacion, EventosReporte.solucion
from EventosReporte inner join Usuariow on EventosReporte.Id_Usuario_Operador  = Usuariow.Id_usuariow;
else
select EventosReporte.Folio   , EventosReporte.ModuloE  , EventosReporte.DescripcionE  ,  EventosReporte.UsuarioFalla   , EventosReporte.EstadoE , 
 EventosReporte.EtiquetaE, EventosReporte.Fecha,   Usuariow.Nombre, Usuariow.Apat, Usuariow.Amat, EventosReporte.solucion
from EventosReporte inner join Usuariow on EventosReporte.Id_Usuario_Operador   = Usuariow.Id_usuariow  
 where EventosReporte.Id_Usuario_Operador   =id_usuarioo ; 
 end if;

end if;
 end if;
end**

/**PROCEDIMIENTO PARA ACTUALIZAR  REPORTE DE EVENTO**/



use WORKINC;
drop procedure if exists ModificaReporteEvento;
delimiter **
create procedure ModificaReporteEvento( in Modulo varchar(100), in Descripcion  varchar(400), in Usuario varchar(100), in EstadoRep varchar(100), in Etiqueta varchar(100), in foli varchar(8), in correoOperador varchar(100)  )
begin

declare id_usuarioo int;

set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = correoOperador);


update EventosReporte set ModuloE=Modulo, DescripcionE=Descripcion,UsuarioFalla=Usuario, EstadoE=EstadoRep,EtiquetaE =Etiqueta   where Folio=foli and Id_Usuario_Operador= id_usuarioo;


end**

/***********PROCEDIMIENTO PARA TRAER A LOS USUARIOS QUE SEAN INGENIEROS DE SOFTWARE*****/




use WORKINC;
drop procedure if exists ConsultaIngenierosSoft;
delimiter **
create procedure ConsultaIngenierosSoft( in id int, in correoGerente varchar(100))
begin

declare tipousu varchar(100);

set tipousu=(select  TipoUsuario from Usuariow where Correo = correoGerente);

if(tipousu='GeerenteSoft')then
select * from Usuariow where TipoUsuario='IngenieroSoft';

end if;

end**


/*PROCEDIMIENTO PARA ASIGNAR INGENIEROS A LOS REPORTES*/



use WORKINC;
drop procedure if exists AsignacionIngeniero;
delimiter **
create procedure AsignacionIngeniero( in folioreporte varchar(8), in correoingasignado varchar(100))
begin

declare id_usuarioo int;

set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = correoingasignado);

update EventosReporte set Id_IngenieroAsignado=id_usuarioo, Asignacion='Asignado'  where Folio=folioreporte;


end**

/*PROCEDIMIENTO PARA CONSULTAR UN INGENIERO MEDIANTE SU INFORMACION(ID)*/


use WORKINC;
drop procedure if exists ConsultaInfoIng;
delimiter **
create procedure ConsultaInfoIng( in id int, in InfoIngSoft int)
begin


select * from Usuariow where Id_usuariow= InfoIngSoft;



end**

/*PROCEDIMIENTO PARA ELIMINAR REPORTE DE EVENTO*/

use WORKINC;
drop procedure if exists EliminaReporteEvento;
delimiter **
create procedure EliminaReporteEvento( in FolioRepEliminar varchar(8) ,in CorreoGerenteElimino varchar(100)  )
begin
	
declare id_usuarioo int;
declare Puesto_Usuario varchar(100);

set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = CorreoGerenteElimino);
set Puesto_Usuario =(select  TipoUsuario from Usuariow where Id_usuariow = id_usuarioo);
if(Puesto_Usuario='GeerenteSoft')then
Delete from EventosReporte where Folio =FolioRepEliminar ;

end if;



end**

/*PROCEDIMIENTO PARA CERRAR REPORTE DE EVENTO*/
use WORKINC;
drop procedure if exists CerrarReporteDeEvento;
delimiter **
create procedure CerrarReporteDeEvento(in foliocerrar varchar(8), in solucionreporte varchar(400))
begin
	
    update EventosReporte  set EstadoE ='Solucionado', solucion=solucionreporte where Folio = foliocerrar;

end **

/*PROCEDIMIENTO PARA ASIGNAR AL AREA DE MANTENIMIENTO UN REPORTE*/



use WORKINC;
drop procedure if exists AsignarMantenimientoReporte;
delimiter **
create procedure AsignarMantenimientoReporte(in folioReporteMantenimiento varchar(8))
begin
	
    update EventosReporte  set EstadoE ='Mantenimiento' where Folio = folioReporteMantenimiento;

end **





/*PROCEDIMIENTO PARA GUARDAR UN TICKET*/


use WORKINC;
drop procedure if exists GuardaTicket;
delimiter **
create procedure GuardaTicket( in Modulo varchar(100), in Descripcion  varchar(400), in CorreoUsrTicket varchar(100), in folio varchar(8))
begin

declare id_usuarioo int;

set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = CorreoUsrTicket);

insert into tickets(Folio , Id_usuariow ,EstadoRevision , Modulo ,DescripcionProblema ) values(folio,id_usuarioo,'Pendiente',Modulo,Descripcion);

end**

/*PROCEDIMIENTO PARA CONSULTAR LOS TICKETS GENERADOS POR UN USUARIO*/


use WORKINC;
drop procedure if exists ConsultaTicket;
delimiter **
create procedure ConsultaTicket( in id int, in correousticket varchar(100))
begin

declare id_usuarioo int;


if(id=2)then

select * from tickets where EstadoRevision ='Pendiente';
else
if(id=3)then
set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = correousticket);
select * from tickets where Id_ResponsableRevision=id_usuarioo;

else
set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = correousticket);
select * from tickets where Id_usuariow=id_usuarioo;

end if;

end if;


/*select tickets.Folio   , tickets.EstadoRevision   , tickets.Id_ResponsableRevision  ,  tickets.FechaCreacion    , tickets.Modulo  , 
 tickets.DescripcionProblema , tickets.Respuesta  , Usuariow.Nombre, Usuariow.Apat, Usuariow.Amat
from tickets inner join Usuariow on tickets.Id_ResponsableRevision = Usuariow.Id_usuariow  
 where tickets.Id_usuariow =id_usuarioo ;*/

end**


/*PROCEDIMIENTO PARA ASIGNAR UN TICKET A UN USUARIO*/



use WORKINC;
drop procedure if exists AsignaTicket;
delimiter **
create procedure AsignaTicket( in folioTicket varchar(8), in correoAdminAsignado varchar(100))
begin

declare id_usuarioo int;

set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = correoAdminAsignado);

update tickets set Id_ResponsableRevision=id_usuarioo, EstadoRevision='En proceso'  where Folio=folioTicket;


end**

/*PROCEDIMIENTO PARA RESPONDER TICKETS */



use WORKINC;
drop procedure if exists RespondeTicket;
delimiter **
create procedure RespondeTicket( in folioTicket varchar(8), in correoAdminAsignado varchar(100), in RespuestTicket varchar(400))
begin

declare id_usuarioo int;

set id_usuarioo=(select  Id_usuariow from Usuariow where Correo = correoAdminAsignado);

update tickets set Respuesta=RespuestTicket, EstadoRevision='Solucionado'  where Folio=folioTicket;


end**

/*PROCEDIMIENTO PARA TRAER LOS REPORTES DE MANTENIMIENTO*/

use WORKINC;
drop procedure if exists TraeReporteMantenimiento;
delimiter **
create procedure TraeReporteMantenimiento( in id int, in correoIngMantenimiento varchar(100))
begin


select * from EventosReporte where EstadoE='Mantenimiento';


end**






