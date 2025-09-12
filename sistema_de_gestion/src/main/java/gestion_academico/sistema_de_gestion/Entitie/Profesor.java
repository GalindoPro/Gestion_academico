package gestion_academico.sistema_de_gestion.Entitie;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesor;

    private String nombre;
    private String apellido;

    @Column(unique = true, nullable = false)
    private String email;

    private String telefono;
}
