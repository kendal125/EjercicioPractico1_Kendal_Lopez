package com.Caso.Caso1.service;

import com.Caso.Caso1.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    List<Categoria> listarTodas();             // Listar todas las categorías
    void guardarCategoria(Categoria categoria);
    Categoria obtenerCategoriaPorId(Long id);
    void eliminarCategoria(Long id);
}