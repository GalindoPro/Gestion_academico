package gestion_academico.sistema_de_gestion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gestion_academico.sistema_de_gestion.Entitie.*;

public interface Repository extends JpaRepository<Profesor, Long> {}
