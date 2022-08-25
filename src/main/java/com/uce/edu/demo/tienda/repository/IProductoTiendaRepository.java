package com.uce.edu.demo.tienda.repository;

import com.uce.edu.demo.tienda.repository.modelo.ProductoTienda;

public interface IProductoTiendaRepository {

	public ProductoTienda buscarProducto(String codigo);
	public void actualizar(ProductoTienda p);
}
