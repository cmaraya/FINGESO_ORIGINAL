package com.creative.Fingeso.controller;

import com.creative.Fingeso.document.Cola;
import com.creative.Fingeso.repository.ColaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ColaController {
    @Autowired
    ColaRepository colaRepository;

    @GetMapping("/colas")
    public ResponseEntity<List<Cola>> getAllCola(@RequestParam(required = false) String usuariosCola) {
        try {
            List<Cola> colas = new ArrayList<Cola>();

            if (usuariosCola == null)
                colaRepository.findAll().forEach(colas::add);
            else
                colaRepository.findByUsuariosCola(usuariosCola).forEach(colas::add);

            if (colas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(colas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/colas/{id}")
    public ResponseEntity<Cola> getColaById(@PathVariable("id") String id) {
        Optional<Cola> localData = colaRepository.findById(id);

        if (localData.isPresent()) {
            return new ResponseEntity<>(localData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/colas")
    public ResponseEntity<Cola> createCola(@RequestBody Cola cola) {
        try {
            Cola _cola = colaRepository.save(new Cola(cola.setTamanoMaximo(), cola.setTiempoPorUsuario(),cola.setContador()));
            return new ResponseEntity<>(_cola, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/colas/{id}")
    public ResponseEntity<Cola> updateCola(@PathVariable("id") String id, @RequestBody Cola cola) {
        Optional<Cola> localData = colaRepository.findById(id);

        if (localData.isPresent()) {
            Cola _cola = localData.get();
            _cola.setTamanoMaximo(cola.getTamanoMaximo());
            _cola.setTiempoPorUsuario(cola.getTiempoPorUsuario());
            _cola.setContador(cola.getContador());
            return new ResponseEntity<>(colaRepository.save(_cola), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/colas/{id}")
    public ResponseEntity<HttpStatus> deleteCola(@PathVariable("id") String id) {
        try {
            colaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/cola")
    public ResponseEntity<HttpStatus> deleteAllColas() {
        try {
            colaRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
