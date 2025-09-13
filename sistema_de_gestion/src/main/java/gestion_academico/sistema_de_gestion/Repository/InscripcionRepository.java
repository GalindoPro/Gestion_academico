package gestion_academico.sistema_de_gestion.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import gestion_academico.sistema_de_gestion.Entitie.Inscripcion;
import gestion_academico.sistema_de_gestion.DTOs.ReportePromedioPorCursoDTO;
import gestion_academico.sistema_de_gestion.DTOs.ReporteInscripcionesPorCicloDTO;
import gestion_academico.sistema_de_gestion.DTOs.ReporteTopCursosDTO;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    List<Inscripcion> findByEstudiante_IdEstudiante(Long idEstudiante);
    List<Inscripcion> findByCurso_IdCurso(Long idCurso);
    List<Inscripcion> findByFechaInscripcion(LocalDate fechaInscripcion);
    List<Inscripcion> findByFechaInscripcionBetween(LocalDate inicio, LocalDate fin);

    @Query("SELECT NEW gestion_academico.sistema_de_gestion.DTOs.ReportePromedioPorCursoDTO(c.nombreCurso, AVG(i.notaFinal)) " +
           "FROM Inscripcion i JOIN i.curso c GROUP BY c.nombreCurso")
    List<ReportePromedioPorCursoDTO> promedioNotasPorCurso();

    @Query("SELECT NEW gestion_academico.sistema_de_gestion.DTOs.ReporteInscripcionesPorCicloDTO(i.cicloAcademico, COUNT(i.estudiante)) " +
           "FROM Inscripcion i GROUP BY i.cicloAcademico")
    List<ReporteInscripcionesPorCicloDTO> contarEstudiantesPorCiclo();

    @Query("SELECT NEW gestion_academico.sistema_de_gestion.DTOs.ReporteTopCursosDTO(c.nombreCurso, AVG(i.notaFinal)) " +
           "FROM Inscripcion i JOIN i.curso c GROUP BY c.nombreCurso ORDER BY AVG(i.notaFinal) DESC")
    List<ReporteTopCursosDTO> topCursosPorPromedio(Pageable pageable);
}