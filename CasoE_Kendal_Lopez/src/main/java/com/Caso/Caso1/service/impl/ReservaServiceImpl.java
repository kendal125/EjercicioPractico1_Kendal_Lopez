package com.Caso.Caso1.service.impl;

import com.Caso.Caso1.domain.Reserva;
import com.Caso.Caso1.repository.ReservaRepository;
import com.Caso.Caso1.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> obtenerPorId(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva actualizar(Long id, Reserva reserva) {
        Optional<Reserva> existente = reservaRepository.findById(id);
        if (existente.isPresent()) {
            Reserva r = existente.get();
            r.setNombreCliente(reserva.getNombreCliente());
            r.setFecha(reserva.getFecha());
            r.setServicio(reserva.getServicio());
            return reservaRepository.save(r);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }
}