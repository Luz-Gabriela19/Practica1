package com.estudiante.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity // Marca esta clase como una entidad JPA (representa una tabla)
@Table(name = "estudiantes") // Nombre real de la tabla en la base de datos
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L; // Buenas prácticas para Serializable

    public Estudiantes() {
    } // Constructor vacío (requerido por JPA)

    @Id // Indica que es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El valor se genera automáticamente (autoincremental)
    @Column(name = "id") // Nombre de la columna en la tabla
    private Long id;

    @Column(name = "nombre", length = 100) // Limita la longitud de la columna a 100 caracteres
    private String nombre;

    @Column(name = "apellido", length = 100) // Igual que el nombre, pero para apellido
    private String apellido;

    @Column(name = "email", length = 100, nullable = false, unique = true) 
    // El email es obligatorio (no puede ser null) y debe ser único
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Formato JSON de la fecha
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE) // Solo guarda la fecha (sin hora)
    private Date fechaNacimiento;

    @Column(name = "numero_inscripcion", length = 50 , nullable = false, unique = true) 
    // Número de inscripción obligatorio y único
    private String numeroInscripcion;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(String numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }
}
