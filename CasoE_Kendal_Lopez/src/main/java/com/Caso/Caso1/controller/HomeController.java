package com.Caso.Caso1.controller;

import com.Caso.Caso1.domain.Servicio;
import com.Caso.Caso1.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/")
    public String index(Model model) {
        // Mostrar los 3 últimos servicios agregados como promoción
        model.addAttribute("serviciosDestacados", servicioService.listarTodos());
        return "Principal";
    }
}