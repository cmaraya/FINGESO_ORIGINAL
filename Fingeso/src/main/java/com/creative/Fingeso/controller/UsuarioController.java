package com.creative.Fingeso.controller;

import com.creative.Fingeso.document.Usuario;
import com.creative.Fingeso.repository.UsuarioRepository;
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
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuario(@RequestParam(required = false) int ticket) {
        try {
            List<Usuario> usuarios = new ArrayList<Usuario>();

            if (ticket == null)
                usuarioRepository.findAll().forEach(usuarios::add);
            else
                usuarioRepository.findByTicket(ticket).forEach(usuarios::add);

            if (usuarios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") String id) {
        Optional<Usuario> localData = usuarioRepository.findById(id);

        if (localData.isPresent()) {
            return new ResponseEntity<>(localData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario _usuario = usuarioRepository.save(new Usuario(usuario.getNombreUsuario, usuario.getTelefono,usuario.getTicket));
            return new ResponseEntity<>(_usuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") String id, @RequestBody Usuario usuario) {
        Optional<Usuario> localData = usuarioRepository.findById(id);
        if (localData.isPresent()) {
            Usuario _usuario = localData.get();
            _usuario.setNombreUsuario(usuario.getNombreUsuario());
            _usuario.setTelefono(usuario.getTelefono());
            _usuario.setTicket(usuario.getTicket());
            return new ResponseEntity<>(usuarioRepository.save(_usuario), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable("id") String id) {
        try {
            usuarioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/usuarios")
    public ResponseEntity<HttpStatus> deleteAllUsuario() {
        try {
            usuarioRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuarios/nombre")
    public ResponseEntity<List<Usuario>> findByNombre(@RequestParam(required = false) String nombre) {
        try {
            List<Usuario> usuarios = new ArrayList<Usuario>();

            if (nombre == null)
                usuarioRepository.findAll().forEach(usuarios::add);
            else
                usuarioRepository.findByNombre(nombre).forEach(ususarios::add);

            if (usuarios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
