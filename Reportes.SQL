select * from  direccion;
select * from proveedor;
select * from producto;

SELECT razon_social, COUNT(producto.id) AS cantidad
FROM proveedor INNER JOIN producto ON proveedor.id = producto.id_proveedor
GROUP BY razon_social;

SELECT nit, razon_social, concat(direccion.cll_cra," ",direccion.numero," ",direccion.barrio," ",direccion.ciudad) as direccion,telefono, nombre, valor_unitario, stock
FROM proveedor INNER JOIN producto ON proveedor.nit = producto.id_proveedor
INNER JOIN direccion ON proveedor.direccion_id = direccion.id
WHERE stock > 30;





