--CREAR LA BASE DE DATOS
create database Proyecto_Cafeteria

--CREAR TABLA USUARIO PARA GUARDAR LOS DATOS DE USUARIO
create table Usuario(
id_usuario int IDENTITY(1,1),
nombre VARCHAR(30),
apellido VARCHAR(30),
usuario_ingreso VARCHAR(25),
contrasenia VARCHAR(30),
correo VARCHAR(30),
telefono VARCHAR(10),
cedula VARCHAR(10),
rol VARCHAR(15),
CONSTRAINT[PK_user] PRIMARY KEY CLUSTERED(id_usuario asc)
)
--Realizar un registro manual en la tabla Usuario para poder ingresar al sistema cuando pida un usuario y contraseña
--el cual seran usuario: Mariana02   contraseña: mariana123
insert into Usuario (nombre, apellido, usuario_ingreso, contrasenia, correo, telefono, cedula, rol) values ('Mariana', 'Rodrigez', 'Mariana02' , 'mariana123', 'mariana@gmail.com', '0947852485', '0957892154', 'Administrador');


--CREAR TABLA MENU PARA GUARDAR LOS DATOS DE UN MENU
create table Menu(
id_menu int IDENTITY(1,1),
nombre VARCHAR(50),
precio DECIMAL(7,2),
categoria VARCHAR(50),
calorias DECIMAL(5,2),
ingredientes VARCHAR(100),
descripcion VARCHAR(100),
estado VARCHAR(10),
CONSTRAINT[PK_menu] PRIMARY KEY CLUSTERED(id_menu asc)
)


--CREAR TABLA PEDIDO PARA GUARDAR LOS DATOS DE UN PEDIDO
create table Pedido(
id_pedido int,
nombres_Cliente VARCHAR(70),
total DECIMAL(7,2),
CONSTRAINT[PK_pedido] PRIMARY KEY CLUSTERED(id_pedido asc)
)


--CREAR TABLA DETALLE PEDIDO PARA GUARDAR LOS DATOS DE UN CONTENIDO DE DICHO PEDIDO
create table Detalle_Pedido(
id_detalle_pedido int IDENTITY(1,1),
id_pedido int,
menu VARCHAR(70),
precio DECIMAL(5,2),
cantidad int,
subtotal DECIMAL(5,2),
CONSTRAINT[PK_detalle_pedido] PRIMARY KEY CLUSTERED(id_detalle_pedido asc)
)


--CREAR TABLA PROPINA PARA GUARDAR LAS DIFERENTE PROPINAS QUE SE OTORGA EN CIERTAS VENTAS
create table Propina(
id_NroPedido int,
valor DECIMAL(7,2),
CONSTRAINT[PK_NroPedido] PRIMARY KEY CLUSTERED(id_NroPedido asc)
)


--CREAR TABLA PROVEEDOR PARA GUARDAR LOS DATOS DE PROVEEDORES
create table Proveedor(
id_Proveedor int IDENTITY(1,1),
nombre VARCHAR(70),
contacto VARCHAR(70),
correo VARCHAR(70),
CONSTRAINT[PK_Proveedor] PRIMARY KEY CLUSTERED(id_Proveedor asc)
)


--CREAR TABLA INGREDIENTE PARA GUARDAR LOS DATOS DE UN INGREDIENTE
create table Ingrediente(
id_ingrediente_registro int IDENTITY(1,1),
nombre VARCHAR(70),
proveedor VARCHAR(70),
cantidad int,
costo DECIMAL(7,2),
medida VARCHAR(5),
detalles VARCHAR(100),
CONSTRAINT[PK_Ingrediente] PRIMARY KEY CLUSTERED(id_ingrediente_registro asc)
)


--CREAR TABLA RESERVA PARA GUARDAR LOS DATOS DE UNA RESERVA
create table Reserva(
id_reserva int IDENTITY(1,1),
NroReserva int,
cliente VARCHAR(70),
telefono VARCHAR(70),
cantidad int,
dia int,
mes int,
anio int,
CONSTRAINT[PK_Reserva] PRIMARY KEY CLUSTERED(id_reserva asc)
)


--CREAR TABLA TURNO PARA GUARDAR LOS DATOS DE UN TURNO
create table Turno(
id_turno int IDENTITY(1,1),
nombreEmpleado VARCHAR(70),
tipoTurno VARCHAR(20),
mes int,
anio int,
CONSTRAINT[PK_Turno] PRIMARY KEY CLUSTERED(id_turno asc)
)
