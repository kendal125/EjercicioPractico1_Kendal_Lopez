package com.Caso.Caso1.controller;

import com.Caso.Caso1.domain.Servicio;
import com.Caso.Caso1.service.CategoriaService;
import com.Caso.Caso1.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("servicios", servicioService.listarTodos());
        return "servicio/listado"; // templates/servicio/listado.html
    }

    @GetMapping("/nuevo")
    public String crearForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "servicio/formulario"; // templates/servicio/formulario.html
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Servicio servicio) {
        servicioService.guardar(servicio);
        return "redirect:/servicios";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        servicioService.obtenerPorId(id).ifPresent(s -> model.addAttribute("servicio", s));
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "servicio/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        servicioService.eliminar(id);
        return "redirect:/servicios";
    }
}