update nomina
set documentoempleado = :documentoempleado,
	periodo = :periodo,
	valor = :valor,
	companiaid = :companiaid,
	fecha_creacion = :fechaCreacion
where id = :id