package gestion_academico.sistema_de_gestion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gestion_academico.sistema_de_gestion.Entitie.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Ejemplo: List<Curso> findByProfesorId(Long idProfesor);
}
