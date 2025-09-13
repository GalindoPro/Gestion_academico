package gestion_academico.sistema_de_gestion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import gestion_academico.sistema_de_gestion.Entitie.Curso;
import gestion_academico.sistema_de_gestion.DTOs.ReporteCursosPorProfesorDTO;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    // Buscar cursos por ID de profesor (correcto: profesor.idProfesor)
    List<Curso> findByProfesor_IdProfesor(Long idProfesor);

    // Reporte: cantidad de cursos por profesor
    @Query("SELECT NEW gestion_academico.sistema_de_gestion.DTOs.ReporteCursosPorProfesorDTO(p.nombre, COUNT(c)) " +
           "FROM Curso c JOIN c.profesor p GROUP BY p.nombre")
    List<ReporteCursosPorProfesorDTO> contarCursosPorProfesor();
}