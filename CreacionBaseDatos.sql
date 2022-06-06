drop  database  if exists proyectoProgramacion; 
create database proyectoProgramacion;
use proyectoProgramacion;

CREATE TABLE usuario (
    nombreUsuario VARCHAR(30) NOT NULL PRIMARY KEY,
    contraseña    VARCHAR(20) NOT NULL,
    email         VARCHAR(100) NOT NULL,
    provincia     VARCHAR(40)
);

CREATE TABLE empresa (
    nombreEmpresa VARCHAR(30) NOT NULL PRIMARY KEY,
    cif           VARCHAR(9) NOT NULL,
    presupuesto   NUMERIC(8, 2),
    nombreUsuario VARCHAR(30) NOT NULL,
    foreign key (nombreUsuario) references usuario(nombreUsuario)
);



CREATE TABLE campo (
    nombreCampo   VARCHAR(30) NOT NULL PRIMARY KEY,
    provincia     VARCHAR(30) NOT NULL,
    superficie    NUMERIC(6, 2) NOT NULL,
    plantacion    VARCHAR(50) NOT NULL,
    nombreEmpresa VARCHAR(30) NOT NULL,
    foreign key (nombreEmpresa) references empresa(nombreEmpresa)
);
CREATE TABLE tractor (
    marcaTractor    VARCHAR(30),
    modeloTractor   VARCHAR(30),
    añoAdquisicion  int(4),
    nombreEmpresa   VARCHAR(30) NOT NULL,
    
    primary key (marcaTractor, modeloTractor)
);

CREATE TABLE actividad (
    nombreActividad VARCHAR(30) NOT NULL, 
    duracion        NUMERIC(2) NOT NULL,
    descripcion     VARCHAR(255),
    nombreEmpresa   VARCHAR(30) NOT NULL,
    nombreCampo varchar(30) not null,
    modeloTractor varchar(30) not null,
    modeloApero varchar(30) not null,
    foreign key (nombreEmpresa) references empresa(nombreEmpresa),
    foreign key (nombrecampo) references campo(nombreCampo),
    primary key(nombreActividad, nombreCampo)
    
);



CREATE TABLE apero (
    nombreApero     VARCHAR(30) PRIMARY KEY,
    modeloApero     VARCHAR(50),
    añoAdquisicion  INT(4),
    tipoapero       VARCHAR(40),
    nombreEmpresa   VARCHAR(30) NOT NULL
);


ALTER TABLE apero
    ADD CONSTRAINT apero_empresa_fk FOREIGN KEY ( nombreEmpresa )
        REFERENCES empresa ( nombreEmpresa );


CREATE TABLE proveedor (
    nombreProveedor VARCHAR(30) PRIMARY KEY,
    telefono        NUMERIC(9)
);





CREATE TABLE empresa_proveedor (
    nombreEmpresa   VARCHAR(30) NOT NULL,
    nombreProveedor VARCHAR(30) NOT NULL
);

ALTER TABLE empresa_proveedor ADD CONSTRAINT empresa_proveedor_pk PRIMARY KEY ( nombreempresa,
                                                                                nombreproveedor );

ALTER TABLE empresa_proveedor
    ADD CONSTRAINT empresa_proveedor_empresa_fk FOREIGN KEY ( nombreEmpresa )
        REFERENCES empresa ( nombreEmpresa );

ALTER TABLE empresa_proveedor
    ADD CONSTRAINT empresa_proveedor_proveedor_fk FOREIGN KEY ( nombreProveedor )
        REFERENCES proveedor ( nombreProveedor );


CREATE TABLE producto (
    nombreProducto  VARCHAR(30) PRIMARY KEY,
    precio          NUMERIC(8, 2),
    tipo            VARCHAR(50) NOT NULL,
    nombreActividad VARCHAR(50) NOT NULL,
	foreign key (nombreActividad) references actividad(nombreActividad)
);






CREATE TABLE proveedor_producto (
    nombreProveedor VARCHAR(30) NOT NULL,
    nombreProducto  VARCHAR(30) NOT NULL
);

ALTER TABLE proveedor_producto ADD CONSTRAINT proveedor_producto_pk PRIMARY KEY ( nombreProveedor,
                                                                                  nombreProducto );
																				
ALTER TABLE proveedor_producto
    ADD CONSTRAINT proveedor_produ_prove_fk FOREIGN KEY ( nombreProveedor )
        REFERENCES proveedor ( nombreProveedor );

ALTER TABLE proveedor_producto
    ADD CONSTRAINT proveedor_productofk FOREIGN KEY ( nombreProducto )
        REFERENCES producto ( nombreProducto );


CREATE TABLE trabajador (
    nombreTrabajador VARCHAR(30) PRIMARY KEY,
    apellido         VARCHAR(30),
    dni              VARCHAR(9),
    sueldo           NUMERIC(6, 2),
    nombreEmpresa    VARCHAR(30) NOT NULL,
    foreign key (nombreEmpresa) references empresa(nombreEmpresa)
);






ALTER TABLE tractor
    ADD CONSTRAINT tractor_empresa_fk FOREIGN KEY ( nombreEmpresa )
        REFERENCES empresa ( nombreEmpresa );
