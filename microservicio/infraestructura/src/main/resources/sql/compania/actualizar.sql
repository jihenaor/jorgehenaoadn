update compania
set tipodocumento = :tipodocumento,
	numerodocumento = :numerodocumento,
	razonsocial = :razonsocial,
	analistaid = :analistaid,
	fecha_creacion = :fechaCreacion
where id = :id