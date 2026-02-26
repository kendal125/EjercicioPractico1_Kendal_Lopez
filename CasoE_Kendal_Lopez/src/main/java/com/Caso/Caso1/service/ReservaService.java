package com.Caso.Caso1.service;

import com.Caso.Caso1.domain.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    List<Reserva> listarTodas();

    Optional<Reserva> obtenerPorId(Long id);

    Reserva guardar(Reserva reserva);

    Reserva actualizar(Long id, Reserva reserva);

    void eliminar(Long id);
}