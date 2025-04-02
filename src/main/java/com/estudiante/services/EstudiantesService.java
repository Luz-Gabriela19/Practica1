package com.estudiante.services;

import com.estudiante.entity.Estudiantes;
import java.util.List;

public interface EstudiantesService {

    // Obtiene todos los estudiantes
    public List<Estudiantes> findAll();

    // Guarda un estudiante (crear o actualizar)
    public Estudiantes save(Estudiantes estudiante);

    // Busca un estudiante por su ID
    public Estudiantes findById(Long id);

    // Elimina un estudiante
    public void delete(Estudiantes estudiante);
}
