create table compania (
 id int(11) not null auto_increment,
 tipodocumento varchar(2) not null,
 numerodocumento varchar(16) not null,
 razonsocial varchar(80) not null,
 fecha_creacion datetime null,
 primary key (id)
);
