select count(1)
from nomina
where id <> :id and documentoempleado = :documentoempleado and periodo = :periodo and companiaid = :companiaid