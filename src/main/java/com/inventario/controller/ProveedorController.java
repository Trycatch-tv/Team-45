package com.inventario.controller;

import java.util.List;

import jakarta.validation.Valid;
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

import com.inventario.model.Proveedor;
import com.inventario.service.ProveedorService;




@RestController
@CrossOrigin
@RequestMapping("/api/proveedor")
public class ProveedorController {

	
	private final ProveedorService proveedorService;

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Proveedor>> listarProveedor() {
        return ResponseEntity.ok(proveedorService.listarProveedores());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> buscarProveedoresPorId(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(proveedorService.buscarProveedorPorId(id));
        }

        catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/")
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody @Valid Proveedor proveedor) {
        try {
        	Proveedor proveedorCreado = proveedorService.crearProveedor(proveedor);
            return ResponseEntity.ok(proveedorCreado);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> editarProveedor(@PathVariable Long id, @RequestBody @Valid Proveedor proveedor) {
        try {
        	Proveedor proveedorExistente = proveedorService.buscarProveedorPorId(id);

            if (proveedor.getCiudad()!= null &&!proveedor.getCiudad().isEmpty())
                proveedorExistente.setCiudad(proveedor.getCiudad());

            if (proveedor.getDireccion()!= null &&!proveedor.getDireccion().isEmpty())
                proveedorExistente.setDireccion(proveedor.getDireccion());
            
            if (proveedor.getDocumento()!= null &&!proveedor.getDocumento().isEmpty())
                proveedorExistente.setDocumento(proveedor.getDocumento());

            if (proveedor.getNombre()!= null &&!proveedor.getNombre().isEmpty())
                proveedorExistente.setNombre(proveedor.getNombre());

            proveedorExistente.setTelefono(proveedor.getTelefono());

            proveedorService.actualizarProveedor(proveedorExistente);

            return ResponseEntity.ok(proveedorExistente);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Proveedor> eliminarProveedor(@PathVariable Long id) {

        try {
        	Proveedor proveedorEliminar = proveedorService.buscarProveedorPorId(id);

            proveedorService.eliminarProveedor(id);
            return ResponseEntity.ok(proveedorEliminar);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


	
}
