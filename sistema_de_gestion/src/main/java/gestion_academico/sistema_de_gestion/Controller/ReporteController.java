package gestion_academico.sistema_de_gestion.Controller;

import gestion_academico.sistema_de_gestion.DTOs.*;
import gestion_academico.sistema_de_gestion.Service.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    @GetMapping("/cursos-por-profesor")
    public List<ReporteCursosPorProfesorDTO> cursosPorProfesor() {
        return reporteService.cursosPorProfesor();
    }

    @GetMapping("/promedio-por-curso")
    public List<ReportePromedioPorCursoDTO> promedioPorCurso() {
        return reporteService.promedioPorCurso();
    }

    @GetMapping("/inscripciones-por-ciclo")
    public List<ReporteInscripcionesPorCicloDTO> inscripcionesPorCiclo() {
        return reporteService.inscripcionesPorCiclo();
    }

    @GetMapping("/top-cursos")
    public List<ReporteTopCursosDTO> topCursos() {
        return reporteService.topCursos();
    }
}
