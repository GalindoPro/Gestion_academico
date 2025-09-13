package gestion_academico.sistema_de_gestion.DTOs;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ReporteCursosPorProfesorDTO {
    private String nombreProfesor;
    private Long cantidadCursos;

    public ReporteCursosPorProfesorDTO(String nombreProfesor, Long cantidadCursos) {
        this.nombreProfesor = nombreProfesor;
        this.cantidadCursos = cantidadCursos;
    }

    public String getNombreProfesor() {
        return nombreProfesor != null ? nombreProfesor : "Sin datos";
    }

    public Long getCantidadCursos() {
        return cantidadCursos != null ? cantidadCursos : 0L;
    }
}
