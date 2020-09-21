package com.creative.Fingeso.repository;

import com.creative.Fingeso.document.Aviso;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
import java.util.List;

@Repository
@CrossOrigin(value = {})
public interface LocalRepository extends MongoRepository<Aviso, String> {

    //Algunas busquedas
    List<Aviso> findByTiempoRestante(int tiempoRestante);
    List<Aviso> findByTelefono(int telefono);

}
