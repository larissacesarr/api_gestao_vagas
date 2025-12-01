package br.com.larissacesar.gestao_vagas.modules.company.repositories;

import br.com.larissacesar.gestao_vagas.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

    // "contains" é usado para busca parcial, equivalente ao SQL "LIKE '%value%'"

    // select * from job where description like '%filter%'

    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);
}
