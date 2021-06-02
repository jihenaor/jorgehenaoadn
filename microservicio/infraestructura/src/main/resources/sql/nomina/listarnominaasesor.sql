select
c.tipodocumento,
c.numerodocumento,
c.razonsocial,
c.analistaid,
n.id,
n.documentoempleado,
n.periodo,
n.valor,
n.companiaid
from compania c inner join nomina n on c.id = n.companiaid