delimiter $$;
create procedure suma (inout valorSuma int, inout valorResta int, out valorProducto int, out valorDivision int)
begin
    set valorSuma = valor1 + valor2;
    set valorProducto = valor1 * valor2;
    set valorResta = valor1 - valor2;
    set valorDivision = valor1 / valor2;
end 
$$;


set @resul1 = 5;
set @resul2 = 7;


call suma(@resul1, @resul2, @resul3, @resul4);

select @resul1, ' ', @resul2, ' ', @resul3, ' ', @resul4;
