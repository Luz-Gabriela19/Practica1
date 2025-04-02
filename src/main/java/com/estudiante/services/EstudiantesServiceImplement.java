package com.estudiante.services;

import com.estudiante.DAO.EstudiantesDAO;
import com.estudiante.entity.Estudiantes;

import jakarta.transaction.Transactional; // Importa la anotación para manejar transacciones

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Marca esta clase como un servicio gestionado por Spring
public class EstudiantesServiceImplement implements EstudiantesService {

    @Autowired // Inyecta automáticamente el repositorio EstudiantesDTO
    private EstudiantesDAO estudiantesDao;

    @Override
    @Transactional // Asegura que la operación sea transaccional (se realiza completamente o no se realiza)
    public List<Estudiantes> findAll() {
        return (List<Estudiantes>) estudiantesDao.findAll(); // Llama al método findAll del repositorio
    }

    @Override
    @Transactional // Transaccional para que si algo falla, se deshaga todo
    public Estudiantes findById(Long id) {
        return estudiantesDao.findById(id).orElse(null); // Busca un estudiante por ID, retorna null si no lo encuentra
    }

    @Override
    @Transactional // Transaccional para guardar cambios de manera segura
    public Estudiantes save(Estudiantes estudiante) {
        return estudiantesDao.save(estudiante); // Guarda el estudiante (nuevo o actualizado)
    }

    @Override
    @Transactional // Transaccional para eliminar un estudiante de forma segura
    public void delete(Estudiantes estudiante) {
        estudiantesDao.delete(estudiante); // Elimina el estudiante
    }
}
