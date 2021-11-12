create table Producto (
    codProducto varchar(32),
    idColor varchar(32),
    nombre varchar(255),
    stock int,
    talla varchar(4),
    PRIMARY key (codProducto,idColor)
    
);

create table Usuario(
    codTienda varchar(32) PRIMARY KEY,
    contraseña varchar(32)
);

create table Talla(
    nombre varchar(32) PRIMARY KEY
);

create table Pedido(
    codPedido varchar(32) PRIMARY KEY
);

create table Historial(
	codTienda varchar(32),
	codPedido varchar(32),
	PRIMARY key (codTienda,codPedido),
    FOREIGN KEY (codTienda) references Usuario(codTienda),
    FOREIGN KEY (codPedido) references Pedido(codPedido)
);

create table Tiene(
	nombre varchar(32),
	codProducto varchar(32),
    idColor varchar(32),
	PRIMARY key (nombre,codProducto,idColor),
    FOREIGN KEY (nombre) references Talla(nombre),
    FOREIGN KEY (codProducto,idColor) references Producto(codProducto,idColor)
);

create table Comprar(
	codPedido varchar(32),
	codProducto varchar(32),
    idColor varchar(32),
	PRIMARY key (codPedido,codProducto,idColor),
    FOREIGN KEY (codPedido) references Pedido(codPedido),
    FOREIGN KEY (codProducto,idColor) references Producto(codProducto,idColor)
);

