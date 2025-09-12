package gestion_academico.sistema_de_gestion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gestion_academico.sistema_de_gestion.Entitie.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    // Puedes agregar métodos personalizados aquí si lo necesitas
}
