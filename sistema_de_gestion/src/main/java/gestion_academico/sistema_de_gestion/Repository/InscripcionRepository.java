package gestion_academico.sistema_de_gestion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gestion_academico.sistema_de_gestion.Entitie.Inscripcion;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    // Buscar todas las inscripciones de un estudiante (relación ManyToOne)
    List<Inscripcion> findByEstudiante_IdEstudiante(Long idEstudiante);

    // Buscar todas las inscripciones de un curso (relación ManyToOne)
    List<Inscripcion> findByCurso_IdCurso(Long idCurso);

    // Buscar inscripciones por fecha exacta
    List<Inscripcion> findByFechaInscripcion(LocalDate fechaInscripcion);

    // Buscar inscripciones entre dos fechas
    List<Inscripcion> findByFechaInscripcionBetween(LocalDate inicio, LocalDate fin);
}
