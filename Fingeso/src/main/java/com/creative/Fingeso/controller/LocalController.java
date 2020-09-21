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

    @GetMapping("/locales")
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

    @GetMapping("/locales/{id}")
    public ResponseEntity<Local> getLocalById(@PathVariable("id") String id) {
        Optional<Local> localData = localRepository.findById(id);

        if (localData.isPresent()) {
            return new ResponseEntity<>(localData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/locales")
    public ResponseEntity<Local> createLocal(@RequestBody Local local) {
        try {
            Local _local = localRepository.save(new Local( local.getDireccion(),local.getNombre(),local.getAdministrador(),local.getCodigo(),local.getIDLocal(),local.getTiempoEstimadoPorPersona(),local.getInicioHorarioAtencion(),local.getTerminoHorarioAtencion(),local.getMaximoPersonas(),local.getTiempoEsperaMaximo(),local.getCola()));
            return new ResponseEntity<>(_local, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/localess/{id}")
    public ResponseEntity<Local> updateLocal(@PathVariable("id") String id, @RequestBody Local local) {
        Optional<Local> localData = localRepository.findById(id);

        if (localData.isPresent()) {
            Local _local = localData.get();
            _local.setNombre(local.getNombre());
            _local.setDireccion(local.getDireccion());
            _local.setAdministrador(local.getAdministrador());
            _local.setCodigo(local.getCodigo());
            _local.setIDLocal(local.getIDLocal());
            _local.setTiempoEstimadoPorPersona(local.getTiempoEstimadoPorPersona());
            _local.setInicioHorarioAtencion(local.getInicioHorarioAtencion());
            _local.setTiempoEstimadoPorPersona(local.getTerminoHorarioAtencion());
            _local.setMaximoPersonas(local.getMaximoPersonas());
            _local.setTiempoEsperaMaximo(local.getTiempoEsperaMaximo());
            _local.setCola(local.getCola());
            return new ResponseEntity<>(localRepository.save(_local), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/locales/{id}")
    public ResponseEntity<HttpStatus> deleteLocal(@PathVariable("id") String id) {
        try {
            localRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/locales")
    public ResponseEntity<HttpStatus> deleteAllLocales() {
        try {
            localRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/locales/nombre")
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
