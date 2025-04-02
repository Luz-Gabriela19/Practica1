package com.estudiante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Importa anotaciones REST

import com.estudiante.services.EstudiantesService;
import com.estudiante.entity.Estudiantes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // Indica que es un controlador REST
@RequestMapping("/API/universidad") // Ruta base para todos los endpoints
public class EstudiantesController {

    @Autowired // Inyecta automáticamente el servicio de estudiantes
    private EstudiantesService estudianteService;

    // Obtener todos los estudiantes
    @GetMapping(value = "/estudiantes")
    public ResponseEntity<Object> get() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Estudiantes> list = estudianteService.findAll(); // Llama al servicio para traer todos los estudiantes
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un estudiante por su ID
    @GetMapping(value = "/estudiantes/{id}")
    public ResponseEntity<Object> getEstudianteById(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Estudiantes data = estudianteService.findById(id); // Busca estudiante por ID
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Crear un nuevo estudiante
    @PostMapping(value = "/estudiantes")
    public ResponseEntity<Object> createEstudiante(@RequestBody Estudiantes estudiante) {
        Map<String, Object> map = new HashMap<>();
        try {
            System.out.println("Datos recibidos: " + estudiante); // Solo para debug en consola
            Estudiantes res = estudianteService.save(estudiante); // Guarda el nuevo estudiante
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un estudiante existente
    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<Object> updateEstudiante(@RequestBody Estudiantes estudiante, @PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Estudiantes currentEstudiante = estudianteService.findById(id); // Busca el estudiante actual
            // Actualiza los campos
            currentEstudiante.setNombre(estudiante.getNombre());
            currentEstudiante.setApellido(estudiante.getApellido());
            currentEstudiante.setEmail(estudiante.getEmail());
            currentEstudiante.setFechaNacimiento(estudiante.getFechaNacimiento());
            currentEstudiante.setNumeroInscripcion(estudiante.getNumeroInscripcion());

            Estudiantes res = estudianteService.save(currentEstudiante); // Guarda los cambios
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un estudiante por ID
    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Object> deleteEstudiante(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Estudiantes currentEstudiante = estudianteService.findById(id); // Busca el estudiante
            estudianteService.delete(currentEstudiante); // Elimina el estudiante
            map.put("deleted", true); // Respuesta de éxito
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
