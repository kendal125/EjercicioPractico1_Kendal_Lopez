package com.Caso.Caso1.controller;

import com.Caso.Caso1.domain.Reserva;
import com.Caso.Caso1.service.ReservaService;
import com.Caso.Caso1.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", reservaService.listarTodas());
        return "reserva/listado";
    }

    @GetMapping("/nuevo")
    public String crearForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("servicios", servicioService.listarTodos());
        return "reserva/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        reservaService.obtenerPorId(id).ifPresent(r -> model.addAttribute("reserva", r));
        model.addAttribute("servicios", servicioService.listarTodos());
        return "reserva/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
        return "redirect:/reservas";
    }
}