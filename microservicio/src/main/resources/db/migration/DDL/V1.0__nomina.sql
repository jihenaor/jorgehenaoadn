CREATE TABLE nomina (
  id INT NOT NULL AUTO_INCREMENT,
  documentoempleado varchar(16) not null,
  periodo varchar(6) not null,
  valor double not null,
  companiaid int(11),
  fecha_creacion datetime null,
  PRIMARY KEY (id)
 );