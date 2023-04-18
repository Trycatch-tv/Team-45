package com.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.model.Factura;
import com.inventario.service.FacturaService;



@RestController
@CrossOrigin
@RequestMapping("/api/factura")
public class FacturaController {
	@Autowired
	private FacturaService facturaService;
	

    @GetMapping("/")
    public ResponseEntity<List<Factura>> listarFacturas() {
        return ResponseEntity.ok(facturaService.listarFacturas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Factura> buscarFacturaPorId(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(facturaService.buscarFacturaPorId(id));
        }

        catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/")
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
        try {
        	Factura facturaCreada = facturaService.crearFactura(factura);
            return ResponseEntity.ok(facturaCreada);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Factura> editarFactura(@PathVariable Long id, @RequestBody Factura factura) {
        try {
            Factura facturaExistente = facturaService.buscarFacturaPorId(id);

            if (factura.getFecha()!= null &&!factura.getFecha().isEmpty())
                facturaExistente.setFecha(factura.getFecha());

            if (factura.getHora()!= null &&!factura.getHora().isEmpty())
            facturaExistente.setFecha(factura.getFecha());

            if (factura.getComentario()!= null &&!factura.getComentario().isEmpty())
            facturaExistente.setComentario(factura.getComentario());


            facturaService.actualizarFactura(facturaExistente);

            return ResponseEntity.ok(facturaExistente);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Factura> eliminarFactura(@PathVariable Long id) {

        try {
            Factura facturaEliminar = facturaService.buscarFacturaPorId(id);

            facturaService.eliminarFactura(id);
            return ResponseEntity.ok(facturaEliminar);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


}
