package com.cuscatlan.springboot.app.productos.models.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.cuscatlan.springboot.app.productos.models.dao.ProductoDao;
import com.cuscatlan.springboot.app.productos.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//INICIO
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
	    ResponseEntity<Producto[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com" + "/products", Producto[].class);
	    return Arrays.asList(responseEntity.getBody());
	}


	@Override
	@Transactional(readOnly = true)
	public Producto finById(Long id) {
	    return restTemplate.getForObject("https://fakestoreapi.com" + "/products/{id}", Producto.class, id);
	}


	
	//FIN


	@Autowired
	private ProductoDao productoDao;
	
	/*
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>)productoDao.findAll();
	}
	*/

	/*
	@Override
	@Transactional(readOnly = true)
	public Producto finById(Long id) {
		return productoDao.findById(id).orElse(null);
	}
	*/

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		productoDao.deleteById(id);
	}

}
