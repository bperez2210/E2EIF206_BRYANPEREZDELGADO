--Nombre: database-kaytes.sql
spool database-kaytes.log
conn system/root


PROMPT ---> BORRANDO/CREANDO TABLESPACE
drop tablespace KAYTES_DATOS including contents and datafiles;
CREATE TABLESPACE KAYTES_DATOS
datafile 'C:\Negocio\Kaytes\KAYTES_DATOS.DBF'
SIZE 100M REUSE AUTOEXTEND ON;


PROMPT ---> BORRANDO/CREANDO USUARIO ADMIN
drop user admin cascade;
create user admin identified by kaytes;
grant dba to admin;


PROMPT --> CONECTANDO USUARIO ADMIN
conn admin/kaytes


PROMPT --> CREACION DE TABLAS
create table Marca(
    PK_IDMarca number(5) not null,
    nombre varchar2(25) not null
)tablespace KAYTES_DATOS;

create table Producto(
    PK_IDProducto number(5) not null,
    tipo_producto varchar2(10) not null
)tablespace KAYTES_DATOS;

create table Articulo(
    PK_IDArticulo number(5) not null,
    codigo number(5) not null,
    FK_IDMarca number(5) not null,
    FK_IDProducto number(5) not null,
    talla number(2) null,
    genero varchar2(15) null,
    color varchar2(8) not null,
    precio number(6,4) not null,
    estado varchar2(15) not null
)tablespace KAYTES_DATOS;


PROMPT --> CREACION DE PRIMARY KEYS
alter table Marca add constraint
pk_marca primary key (PK_IDMarca) using index tablespace KAYTES_DATOS;

alter table Producto add constraint
pk_producto primary key (PK_IDproducto) using index tablespace KAYTES_DATOS;

alter table Articulo add constraint
pk_articulo primary key (PK_IDArticulo) using index tablespace KAYTES_DATOS;


PROMPT --> ASIGNANDO SEQUENCE
CREATE SEQUENCE marca_seq START WITH 1;
CREATE SEQUENCE producto_seq START WITH 1;
CREATE SEQUENCE articulo_seq START WITH 1;


PROMPT --> CREANDO AUTOINCREMENTABLES
create  OR REPLACE trigger trg_marc
      before insert on Marca
      for each row

    begin
      select marca_seq.nextval
        into :new.PK_IDMarca
        from dual;
    end;
 /

 create  OR REPLACE trigger trg_prod
       before insert on Producto
       for each row

     begin
       select producto_seq.nextval
         into :new.PK_IDProducto
         from dual;
     end;
  /

  create  OR REPLACE trigger trg_art
        before insert on Articulo
        for each row

      begin
        select articulo_seq.nextval
          into :new.PK_IDArticulo
          from dual;
      end;
   /


PROMPT --> CREACION DE FOREIGN KEYS
alter table Articulo add constraint
fk_marca foreign key (FK_IDMarca) references Marca(PK_IDMarca);

alter table Articulo add constraint
fk_producto foreign key (FK_IDProducto) references Producto(PK_IDProducto);


PROMPT --> CREACION DE UKs
create unique index uk_marca_nombre on Marca (nombre) tablespace KAYTES_DATOS;

create unique index uk_producto_tipo on Producto (tipo_producto) tablespace KAYTES_DATOS;


PROMPT ---> CREACION DE CKs
alter table Articulo add constraint
ck_talla_art check ( talla between 1 and 60);

alter table Articulo add constraint
ck_precio_art check (precio >= 0);

alter table Articulo add constraint
ck_genero_art check (genero in ('Hombre','Mujer','Niño','Niña','UNISEX'));

alter table Articulo add constraint
ck_estado_art check (estado in ('VENDIDO','EXHIBICIÓN','APARTADO','BODEGA','CAMBIO'));
