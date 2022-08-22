package com.uce.edu.demo.tienda.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tienda.repository.IClienteTiendaRepository;
import com.uce.edu.demo.tienda.repository.IDetalleFacturaRepository;
import com.uce.edu.demo.tienda.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.tienda.repository.IFacturaTiendaRepository;
import com.uce.edu.demo.tienda.repository.IProductoTiendaRepository;
import com.uce.edu.demo.tienda.repository.modelo.ClienteTienda;
import com.uce.edu.demo.tienda.repository.modelo.DetalleFactura;
import com.uce.edu.demo.tienda.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.tienda.repository.modelo.FacturaTienda;
import com.uce.edu.demo.tienda.repository.modelo.ProductoTienda;

@Service
public class GestorTiendaServiceImpl implements IGestorTiendaService{

	@Autowired
	private IClienteTiendaRepository clienteRepository;
	
	@Autowired
	private IProductoTiendaRepository productoRepository;
	
	@Autowired
	private IFacturaTiendaRepository facturaRepository;
	
	@Autowired
	private IDetalleFacturaRepository detalleRepository;
	
	@Autowired
	private IFacturaElectronicaRepository facturaElectronicaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void crearFactura(String cedula, String numeroFactura, List<String> codigos) {
		ClienteTienda cliente=this.clienteRepository.buscarPorCedula(cedula);
		
		FacturaTienda factura=new FacturaTienda();
		factura.setFecha(LocalDateTime.now());
		factura.setNumero(numeroFactura);
		factura.setCliente(cliente);
		this.facturaRepository.insertarFactura(factura);
	

		BigDecimal total=new BigDecimal(0);
		Integer cantidadProductos=0;
		for(String item: codigos) {
			ProductoTienda producto=this.productoRepository.buscarProducto(item);

			total=total.add(producto.getPrecio());
			
			DetalleFactura detalle=new DetalleFactura();
			detalle.setCantidad(1);
			detalle.setSubtotal(producto.getPrecio());
			detalle.setFactura(factura);
			detalle.setProducto(producto);
			
			this.detalleRepository.insertar(detalle);
			
			cantidadProductos++;
			
			//Actualiza el stock
			Integer cantidad=producto.getStock();
			if(cantidad<0) {
				throw new RuntimeException();
			}else {
				int valor=this.productoRepository.actualizarStock(item);
				System.out.println("Se actualizo: "+valor);
			}
		}
		
	
		factura.setTotal(total);
		this.facturaRepository.actualizar(factura);
		
		FacturaElectronica facturaElectronica=new FacturaElectronica();
		facturaElectronica.setFecha(LocalDateTime.now());
		facturaElectronica.setMonto(total);
		facturaElectronica.setNumero(numeroFactura);
		facturaElectronica.setNumeroDetalles(cantidadProductos);
		
		this.facturaElectronicaRepository.insertarFactura(facturaElectronica);
		
	}

}
