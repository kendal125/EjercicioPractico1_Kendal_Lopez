package com.Caso.Caso1.service.impl;

import com.Caso.Caso1.domain.Servicio;
import com.Caso.Caso1.repository.ServicioRepository;
import com.Caso.Caso1.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> listarTodos() {
        return servicioRepository.findAll();
    }

    @Override
    public Optional<Servicio> obtenerPorId(Long id) {
        return servicioRepository.findById(id);
    }

    @Override
    public void guardar(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    public void eliminar(Long id) {
        servicioRepository.deleteById(id);
    }
}