package gestion_academico.sistema_de_gestion.Entitie;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"estudiante", "curso"})
@EqualsAndHashCode(exclude = {"estudiante", "curso"})
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    private LocalDate fechaInscripcion;

    // Si usas notaFinal y cicloAcademico en tus consultas, agrégalos aquí:
    private Double notaFinal;
    private String cicloAcademico;
}