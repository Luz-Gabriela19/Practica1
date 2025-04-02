package com.estudiante.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.estudiante.entity.Estudiantes;

@Repository // Marca esta interfaz como un componente que Spring gestionará (bean)
public interface EstudiantesDAO extends JpaRepository<Estudiantes, Long> {
    // Hereda de JpaRepository y obtiene automáticamente métodos CRUD (findAll, findById, save, delete, etc.)
}
