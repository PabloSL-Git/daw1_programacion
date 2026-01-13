-- ejemplo profeasora
-- departamanetos malaga

select departamentos.nomde, codpostal
from departamentos join centros
	on departamentos.numce = centros.numce -- using(numce)
where left (centros.codpostal,2) = '29'
order by departamentos.nomde asc;