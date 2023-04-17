package com.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.model.Factura;
import com.inventario.repository.IFacturaRepository;

@Service
public class FacturaService {
	@Autowired
	private IFacturaRepository facturaRepository;
	

    public List<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }

    public Factura buscarFacturaPorId(Long id) {
        return facturaRepository.findById(id).get();
    }

    public Factura crearFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura actualizarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public void eliminarFactura(Long id) {

        facturaRepository.deleteById(id);

    }
	
	
}
