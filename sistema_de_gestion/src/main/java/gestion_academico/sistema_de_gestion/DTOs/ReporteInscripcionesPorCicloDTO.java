package gestion_academico.sistema_de_gestion.DTOs;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ReporteInscripcionesPorCicloDTO {
    private String ciclo;
    private Long cantidadEstudiantes;

    public ReporteInscripcionesPorCicloDTO(String ciclo, Long cantidadEstudiantes) {
        this.ciclo = ciclo;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public String getCiclo() {
        return ciclo != null ? ciclo : "Sin datos";
    }

    public Long getCantidadEstudiantes() {
        return cantidadEstudiantes != null ? cantidadEstudiantes : 0L;
    }
}
