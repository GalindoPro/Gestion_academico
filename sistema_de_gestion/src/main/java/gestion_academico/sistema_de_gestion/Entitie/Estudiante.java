package gestion_academico.sistema_de_gestion.Entitie;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    private String nombre;
    private String apellido;

    @Column(unique = true, nullable = false)
    private String email;

    private String telefono;
}