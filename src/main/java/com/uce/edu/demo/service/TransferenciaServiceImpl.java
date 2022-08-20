package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;


@Service
public class TransferenciaServiceImpl implements ITransferenciaService{
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String numOrigen, String numDestino, BigDecimal monto) {
		// 0.Buscar la cuenta Origen(obtener saldo)
		CuentaBancaria ctaOrigen=this.bancariaRepository.buscarPorNumero(numOrigen);
		// 1.Restar el monto a la cuenta origen
		BigDecimal saldoOrigen=ctaOrigen.getSaldo();
		BigDecimal saldoFinal=saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.bancariaRepository.actualizar(ctaOrigen);
		
		// 0.Buscar la cuenta Destino(obtener saldo)
		CuentaBancaria ctaDestino=this.bancariaRepository.buscarPorNumero(numDestino);
		// 2.Sumar el monto a la cuenta destino
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.bancariaRepository.actualizar(ctaDestino);
		
		// 3.Insertar transferencia
		Transferencia t=new Transferencia();
		t.setCuentaDestino(ctaDestino);
		t.setCuentaOrigen(ctaOrigen);
		t.setFecha(LocalDateTime.now());
		t.setMonto(monto);
		this.transferenciaRepository.insertar(t);
		
		if(monto.compareTo(saldoOrigen)>0) {
			throw new RuntimeException();
		}
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
	}

}
