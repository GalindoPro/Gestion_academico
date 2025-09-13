package gestion_academico.sistema_de_gestion.DTOs;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ReporteTopCursosDTO {
    private String nombreCurso;
    private Double promedio;

    public ReporteTopCursosDTO(String nombreCurso, Double promedio) {
        this.nombreCurso = nombreCurso;
        this.promedio = promedio;
    }

    public String getNombreCurso() {
        return nombreCurso != null ? nombreCurso : "Sin datos";
    }

    public Double getPromedio() {
        return promedio != null ? promedio : 0.0;
    }
}
