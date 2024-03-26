package com.cuscatlan.springboot.app.productos.models.service;

import java.util.List;

import com.cuscatlan.springboot.app.productos.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	public Producto finById(Long id);
	public Producto save(Producto producto);
	public void deleteById(Long id);
	

}
