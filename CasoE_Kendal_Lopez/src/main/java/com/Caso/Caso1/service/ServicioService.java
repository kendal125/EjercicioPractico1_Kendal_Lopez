package com.Caso.Caso1.service;

import com.Caso.Caso1.domain.Servicio;
import java.util.List;
import java.util.Optional;

public interface ServicioService {
    List<Servicio> listarTodos();           
    Optional<Servicio> obtenerPorId(Long id); 
    void guardar(Servicio servicio);         
    void eliminar(Long id);                 
}