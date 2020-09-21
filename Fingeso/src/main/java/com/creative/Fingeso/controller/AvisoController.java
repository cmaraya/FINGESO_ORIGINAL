package com.creative.Fingeso.controller;

import com.creative.Fingeso.document.Aviso;
import com.creative.Fingeso.repository.AvisoRepository;
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
public class AvisoController {
    @Autowired
    AvisoRepository avisoRepository;

    @GetMapping("/avisos")
    public ResponseEntity<List<Aviso>> getAllAviso(@RequestParam(required = false) int tiempoRestante) {
        try {
            List<Aviso> avisos = new ArrayList<Aviso>();

            if (tiempoRestante == null)
                avisoRepository.findAll().forEach(avisos::add);
            else
                avisoRepository.findByTiempoRestante(tiempoRestante).forEach(avisos::add);

            if (avisos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(avisos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/avisos/{id}")
    public ResponseEntity<Aviso> getAvisoById(@PathVariable("id") String id) {
        Optional<Aviso> localData = avisoRepository.findById(id);

        if (localData.isPresent()) {
            return new ResponseEntity<>(localData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/avisos")
    public ResponseEntity<Aviso> createAviso(@RequestBody Aviso aviso) {
        try {
        Aviso _aviso = avisoRepository.save(new Aviso(aviso.getTelefono(), aviso.getTiempoRestante(),aviso.getComunicado()));
            return new ResponseEntity<>(_aviso, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/avisos/{id}")
    public ResponseEntity<Aviso> updateAviso(@PathVariable("id") String id, @RequestBody Aviso aviso) {
        Optional<Aviso> localData = avisoRepository.findById(id);

        if (localData.isPresent()) {
        Aviso _aviso = localData.get();
        _aviso.setTelefono(aviso.getTelefono());
        _aviso.setTiempoRestante(aviso.getTiempoRestante());
        _aviso.setComunicado(aviso.getComunicado());

            return new ResponseEntity<>(avisoRepository.save(_aviso), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/avisos/{id}")
    public ResponseEntity<HttpStatus> deleteAviso(@PathVariable("id") String id) {
        try {
            avisoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/avisos")
    public ResponseEntity<HttpStatus> deleteAllAvisos() {
        try {
            avisoRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/avisos/telefono")
    public ResponseEntity<List<Aviso>> findByNombre(@RequestParam(required = false) int telefono) {
        try {
            List<Aviso> avisos = new ArrayList<Aviso>();

            if (telefono == null)
                avisoRepository.findAll().forEach(avisos::add);
            else
                avisoRepository.findByTelefono(telefono).forEach(avisos::add);

            if (avisos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(avisos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
