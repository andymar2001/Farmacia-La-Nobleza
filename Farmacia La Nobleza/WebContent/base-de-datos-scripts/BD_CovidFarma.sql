DROP DATABASE if exists CovidFarma;
CREATE DATABASE CovidFarma;
use CovidFarma;

create table Categoria(
Id_Categoria		int not null,
Nombre_Categoria	varchar(50) not null,
Descripcion  		varchar(150) null,
Estado CHAR(1) NOT NULL DEFAULT 'A' CHECK(Estado like 'A' OR Estado like 'I'),
primary key (Id_Categoria)
);

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

create table tb_Producto(
Id_Producto			int auto_increment not null,
Nom_producto		varchar(20) not null,
Id_Proveedor 		int,
Id_Categoria		int,
U_Medida			varchar(100) not null,
Precio_Unidad		decimal(10,0) not null,
Unidades_Existencia int null,
Estado CHAR(1) NOT NULL DEFAULT 'A' CHECK( Estado like 'A' OR Estado like 'I'),
primary key (Id_Producto),
foreign key (Id_Categoria) references Categoria(Id_Categoria),
foreign key (Id_Proveedor) references Proveedor(Id_Proveedor)
);

create table tipo_us(
id_tipo_usario int not null primary key auto_increment,
nombre_tipo varchar(20) not null,
detalle_tipo varchar(100)
);

/*SOLO ADMINISTRADOR PUEDE CRUD*/
INSERT INTO tipo_us VALUES(null,'administrador','Encargado de la administración de la pagina');
INSERT INTO tipo_us VALUES(null,'repartidor','Encargado de repartir');
INSERT INTO tipo_us VALUES(null,'cliente','Encargado de estar de miron');

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
id_tipo_usario int not null,
primary key (Dni_Usuario),
foreign key(id_tipo_usario) references tipo_us(id_tipo_usario)
);
INSERT INTO Usuario VALUES('12345678','Admin','Admin','2020-01-01','123456789','987654321','admin@cibertec.edu.pe','admin',default,1);

create table Pedido(
Id_Pedido			int not null,
FechaPedido 		datetime NOT NULL,
FechaEntrega 		datetime not NULL,
FechaEnvio 			datetime not NULL,
Envio 				char(1) NULL,
Cargo 				decimal(10, 0) NULL,
Destinatario 		varchar(40) NULL,
DireccionDestinatario varchar(60) NULL,
CiudadDestinatario 	varchar(15) NULL,
RegionDestinatario 	varchar(15) NULL,
CodPostalDestinatario varchar(10) NULL,
Dni_Usuario			char(8) not null,
Estado CHAR(1) NOT NULL DEFAULT 'A' CHECK(Estado like 'A' OR Estado like 'I'),
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


