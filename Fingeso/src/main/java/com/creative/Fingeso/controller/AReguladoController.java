package com.creative.Fingeso.controller;

import com.creative.Fingeso.document.Local;
import com.creative.Fingeso.repository.LocalRepository;
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
public class LocalController {
    @Autowired
    LocalRepository localRepository;

    @GetMapping("/AvisosRegulados")
    public ResponseEntity<List<Local>> getAllLocal(@RequestParam(required = false) String direccion) {
        try {
            List<Local> locales = new ArrayList<Local>();

            if (direccion == null)
                localRepository.findAll().forEach(locales::add);
            else
                localRepository.findByDireccionContaining(direccion).forEach(locales::add);

            if (locales.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(locales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/AvisosRegulados/{id}")
    public ResponseEntity<Local> getLocalById(@PathVariable("id") String id) {
        Optional<Local> localData = localRepository.findById(id);

        if (localData.isPresent()) {
            return new ResponseEntity<>(localData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/AvisosRegulados")
    public ResponseEntity<Local> createLocal(@RequestBody Local local) {
        try {
            Local _local = localRepository.save(new Local(local.getNombre(), local.getDireccion()));
            return new ResponseEntity<>(_local, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/AvisosRegulados/{id}")
    public ResponseEntity<Local> updateLocal(@PathVariable("id") String id, @RequestBody Local local) {
        Optional<Local> localData = localRepository.findById(id);

        if (localData.isPresent()) {
            Local _local = localData.get();
            _local.setNombre(local.getNombre());
            _local.setDireccion(local.getDireccion());
            return new ResponseEntity<>(localRepository.save(_local), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/AvisosRegulados/{id}")
    public ResponseEntity<HttpStatus> deleteLocal(@PathVariable("id") String id) {
        try {
            localRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/AvisosRegulados")
    public ResponseEntity<HttpStatus> deleteAllLocales() {
        try {
            localRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/AvisosRegulados/nombre")
    public ResponseEntity<List<Local>> findByNombre(@RequestParam(required = false) String nombre) {
        try {
            List<Local> locales = new ArrayList<Local>();

            if (nombre == null)
                localRepository.findAll().forEach(locales::add);
            else
                localRepository.findByNombre(nombre).forEach(locales::add);

            if (locales.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(locales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
