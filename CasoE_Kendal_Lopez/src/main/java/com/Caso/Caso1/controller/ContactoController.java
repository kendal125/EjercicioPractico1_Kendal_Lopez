package com.Caso.Caso1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {

    @GetMapping("/contacto")
    public String mostrarFormulario(Model model) {
        // Solo interfaz, no se guarda en base de datos
        return "contacto";
    }
}