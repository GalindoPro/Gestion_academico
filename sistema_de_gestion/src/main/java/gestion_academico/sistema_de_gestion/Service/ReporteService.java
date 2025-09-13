package gestion_academico.sistema_de_gestion.Service;

import gestion_academico.sistema_de_gestion.DTOs.*;
import gestion_academico.sistema_de_gestion.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final CursoRepository cursoRepo;
    private final InscripcionRepository inscripcionRepo;

    public List<ReporteCursosPorProfesorDTO> cursosPorProfesor() {
        return cursoRepo.contarCursosPorProfesor();
    }

    public List<ReportePromedioPorCursoDTO> promedioPorCurso() {
        return inscripcionRepo.promedioNotasPorCurso();
    }

    public List<ReporteInscripcionesPorCicloDTO> inscripcionesPorCiclo() {
        return inscripcionRepo.contarEstudiantesPorCiclo();
    }

    public List<ReporteTopCursosDTO> topCursos() {
        return inscripcionRepo.topCursosPorPromedio(PageRequest.of(0, 3));
    }
}
