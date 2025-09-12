package gestion_academico.sistema_de_gestion.DTOs;

import lombok.Data;
import java.time.LocalDate;

@Data
public class InscripcionDTO {
    private Long idEstudiante;
    private Long idCurso;
    private LocalDate fechaInscripcion;
}
