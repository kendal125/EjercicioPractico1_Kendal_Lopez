package com.Caso.Caso1.controller;

import com.Caso.Caso1.domain.Categoria;
import com.Caso.Caso1.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Listado de categorías
    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listarTodas()); // CORREGIDO
        return "Categoria"; // Thymeleaf busca Categoria.html
    }

    // Formulario para agregar nueva categoría
    @GetMapping("/nuevo")
    public String nuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "Modifica"; // Thymeleaf busca Modifica.html
    }

    // Guardar categoría (nuevo o editado)
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    // Editar categoría
    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model) {
        Categoria cat = categoriaService.obtenerCategoriaPorId(id);
        model.addAttribute("categoria", cat);
        return "Modifica";
    }

    // Eliminar categoría
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categorias";
    }
}