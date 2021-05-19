update compania
set tipodocumento = :tipodocumento,
	numerodocumento = :numerodocumento,
	razonsocial = :razonsocial,
	fecha_creacion = :fechaCreacion
where id = :id