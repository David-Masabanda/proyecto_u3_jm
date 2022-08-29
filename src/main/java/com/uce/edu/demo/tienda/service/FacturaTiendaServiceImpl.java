package com.uce.edu.demo.tienda.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tienda.repository.IClienteTiendaRepository;
import com.uce.edu.demo.tienda.repository.IFacturaTiendaRepository;
import com.uce.edu.demo.tienda.repository.IProductoTiendaRepository;
import com.uce.edu.demo.tienda.repository.modelo.ClienteTienda;
import com.uce.edu.demo.tienda.repository.modelo.DetalleFactura;
import com.uce.edu.demo.tienda.repository.modelo.FacturaTienda;
import com.uce.edu.demo.tienda.repository.modelo.ProductoTienda;

@Service
public class FacturaTiendaServiceImpl implements IFacturaTiendaService{

	@Autowired
	private IClienteTiendaRepository clienteRepository;
	
	@Autowired
	private IFacturaTiendaRepository facturaRepository;
	
	@Autowired
	private IProductoTiendaRepository productoRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal generarFactura(String cedula, String numeroFactura, List<String> codigos) {
		
		ClienteTienda cliente=this.clienteRepository.buscarPorCedula(cedula);
		
		FacturaTienda factura=new FacturaTienda();
		factura.setFecha(LocalDateTime.now());
		factura.setNumero(numeroFactura);
		factura.setCliente(cliente);

		BigDecimal total=new BigDecimal(0);
		//Integer cantidadProductos=0;
		List<DetalleFactura> detalles=new ArrayList<>();
		
		for(String item: codigos) {
			ProductoTienda producto=this.productoRepository.buscarProducto(item);
			
			DetalleFactura detalle=new DetalleFactura();
			detalle.setCantidad(1);
			detalle.setSubtotal(producto.getPrecio());
			detalle.setFactura(factura);
			detalle.setProducto(producto);
			
			total=total.add(producto.getPrecio());
			producto.setStock(producto.getStock()-1);
			this.productoRepository.actualizar(producto);
			
			detalles.add(detalle);
		}
		
		factura.setTotal(total);
		factura.setDetalles(detalles);
		this.facturaRepository.insertarFactura(factura);
		
		return total;
	}

}
