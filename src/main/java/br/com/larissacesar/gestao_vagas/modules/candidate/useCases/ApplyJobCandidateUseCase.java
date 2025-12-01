package br.com.larissacesar.gestao_vagas.modules.candidate.useCases;

import br.com.larissacesar.gestao_vagas.exceptions.JobNotFoundException;
import br.com.larissacesar.gestao_vagas.exceptions.UserNotFoundException;
import br.com.larissacesar.gestao_vagas.modules.candidate.entities.ApplyJobEntity;
import br.com.larissacesar.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import br.com.larissacesar.gestao_vagas.modules.candidate.repository.CandidateRepository;
import br.com.larissacesar.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    // ID do candidate
    // ID da vaga
    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        // Validar se o candidato existe
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        // Validar se a vaga existe
        this.jobRepository.findById(idJob)
                .orElseThrow(() -> {
                    throw new JobNotFoundException();
                });

        // Candidato se inscreve na vaga
        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob)
                .build();
        applyJob = applyJobRepository.save(applyJob);
        return applyJob;

    }
}