DROP DATABASE if exists farmanobleza;
CREATE DATABASE farmanobleza;
use farmanobleza;

create table Categoria(
Id_Categoria		int not null,
Nombre_Categoria	varchar(50) not null,
Descripcion  		varchar(150) null,
Estado CHAR(1) NOT NULL DEFAULT 'A' CHECK(Estado like 'A' OR Estado like 'I'),
primary key (Id_Categoria)
);

insert into Categoria values(1,'HOGAR','PRODUCTOS PARA EL HOGAR','A');
insert into Categoria values(2,'VITAMINAS Y SUPLEMENTOS','PRODUCTOS VITAMINICOS','A');
insert into Categoria values(3,'INFANTIL Y MATERNIDAD','PRODUCTOS PARA NIÑOS Y RECIEN NACIDOS','A');
insert into Categoria values(4,'MEDICINA Y ORTOPEDIA','PASTILLAS Y DROGAS','A');
insert into Categoria values(5,'CUIDADO PERSONAL','JABONES,PASTAS DENTALES,HILOS DENTALES','A');

create table Proveedor(
Id_Proveedor		int not null,
Nombre_Cia			varchar(40) not null,
Nombre_Contacto		varchar(30) not null,
Cargo_Contacto		varchar(30) not null,
Direccion			varchar(60) not null,
Telefono			varchar(24) not null,
Estado CHAR(1) NOT NULL DEFAULT 'A' CHECK( Estado like 'A' OR Estado like 'I'),
primary key (Id_Proveedor)
);

INSERT INTO PROVEEDOR values(1,'BAYER','LUIS RETTO','ADMINISTRADOR','AV. EJERCITO #356','044123456',default);

create table tb_Producto(
Id_Producto			int auto_increment not null,
Nom_producto		varchar(100) not null,
Id_Proveedor 		int,
Id_Categoria		int,
U_Medida			varchar(100) not null,
Precio_Unidad		decimal(10,0) not null,
Unidades_Existencia int null,
Fecha_Vencimiento   date not null,
Estado CHAR(1) NOT NULL DEFAULT 'A' CHECK( Estado like 'A' OR Estado like 'I'),
primary key (Id_Producto),
foreign key (Id_Categoria) references Categoria(Id_Categoria),
foreign key (Id_Proveedor) references Proveedor(Id_Proveedor)
);

INSERT INTO TB_PRODUCTO valueS(NULL,'BICARBONATO DE SODIO',1,1,'SOBRE 100MG',3.5,100,'2021-01-01','A');
INSERT INTO TB_PRODUCTO valueS(NULL,'TOMATODO',1,1,'UNIDAD',43.5,10,'2021-01-01','A');
INSERT INTO TB_PRODUCTO valueS(NULL,'KIDKAL',1,2,'BOTELLA 1L',105.5,5,'2021-01-01','A');
INSERT INTO TB_PRODUCTO valueS(NULL,'VITAMINA A,C Y D',1,2,'BOTELLA 1.5L',15.5,70,'2021-01-01','A');
INSERT INTO TB_PRODUCTO valueS(NULL,'BIBERON DE PLASTICO',1,3,'UNIDAD',25.5,60,'2021-01-01','A');
INSERT INTO TB_PRODUCTO valueS(NULL,'PAÑALES PAMPERS',1,3,'PACK DE 3 U.',6.5,4,'2021-01-01','A');
INSERT INTO TB_PRODUCTO valueS(NULL,'ASPIRINA',1,4,'UNIDAD',105.5,60,'2021-01-01','A');
INSERT INTO TB_PRODUCTO valueS(NULL,'IVERMECTINA',1,4,'BOTELLA X 10ML',500.5,60,'2021-01-01','A');
INSERT INTO TB_PRODUCTO valueS(NULL,'KERATINA',1,5,'POMO X 100U',50.5,60,'2021-01-01','A');
INSERT INTO TB_PRODUCTO valueS(NULL,'DESODORONTE REXONA',1,5,'SPRAY DE 500ML',15.5,60,'2021-01-01','A');

create table tipo_us(
id_tipo_usuario int not null primary key auto_increment,
nombre_tipo varchar(20) not null,
detalle_tipo varchar(100)
);

/*SOLO ADMINISTRADOR PUEDE CRUD*/
INSERT INTO tipo_us VALUES(null,'administrador','Encargado de la administración de la pagina');
INSERT INTO tipo_us VALUES(null,'repartidor','Encargado de repartir');
INSERT INTO tipo_us VALUES(null,'cliente','Encargado de mirar los productos y despues comprar');

create table Usuario(
Dni_Usuario			char(8) not null,
Nombre_Usuario		varchar(50) not  null,
Apellido_Usuario	varchar(50) not null,
Fec_Nac_Usuario		date not null,
Celular_Usuario	char(9) not null,
Telefono_Usuario	varchar(9) null,
Correo_Usuario		varchar(25) not null,
Contrasena	varchar(20) not null,
Estado CHAR(1) NOT NULL DEFAULT 'A' CHECK(Estado like 'A' OR Estado like 'I'),
id_tipo_usuario int not null,
primary key (Dni_Usuario),
foreign key(id_tipo_usuario) references tipo_us(id_tipo_usuario)
);
INSERT INTO Usuario VALUES('12345678','Admin','Admin','2020-01-01','123456789','987654321','admin@cibertec.edu.pe','admin',default,1);

create table Pedido(
Id_Pedido			int not null auto_increment,
Dni_Usuario			char(8) not null,
FechaPedido 		date NOT NULL,
FechaEntrega 		date NULL,
FechaEnvio 			date NULL,
-- D= DELIVERY / T = EN TIENDA --
Envio 				char(1) NOT NULL CHECK(Envio like 'D' or Envio like 'T'),
Cargo 				decimal(10, 0) NULL,
DireccionDestinatario varchar(60) NULL,
CiudadDestinatario 	varchar(15) NULL,
RegionDestinatario 	varchar(15) NULL,
-- Estado C= EN CARRITO / E = ESPERA DE PAGO / P = PAGADO / F = FINALIZADO / R = EN REPARTO / A = ANULADO --
Estado CHAR(1) NOT NULL DEFAULT 'C' CHECK(Estado like 'C' OR Estado like 'E' or Estado like 'P' or Estado like 'F' or Estado like 'A' OR Estado like 'R'),
primary key (Id_Pedido),
foreign key (Dni_Usuario) references Usuario(Dni_Usuario)
);

create table Detalle_pedido(
Id_Producto			int not null REFERENCES tb_Producto(Id_Producto),
Id_Pedido			int not null REFERENCES Pedido(Id_Pedido),
Precio_Unidad		decimal(10,0) not null,
Cantidad			int not null,
Descuento			float null,
/*foreign key (Id_Producto) references tb_Producto(Id_Producto),
foreign key (Id_Pedido) references Pedido(Id_Pedido),*/
PRIMARY KEY(Id_Producto	,Id_Pedido),
FOREIGN KEY (Id_Producto) REFERENCES tb_Producto(Id_Producto) ON DELETE RESTRICT ON UPDATE CASCADE,
FOREIGN KEY (Id_Pedido) REFERENCES Pedido(Id_Pedido) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table Boleta(
id_boleta			int primary key auto_increment,
Dni_Usuario			char(8) not null,
Id_Pedido			int not null,
Monto_total			decimal(10,0) not null,
-- A = ANULADA / V = VIGENTE --
Estado				char(1) check (Estado like 'V' or Estado like 'A'),
foreign key (Dni_Usuario) references Usuario(Dni_Usuario),
foreign key (Id_Pedido) references Pedido(Id_Pedido) 
);


