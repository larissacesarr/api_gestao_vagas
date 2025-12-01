package br.com.larissacesar.gestao_vagas.modules.candidate.useCases;

import br.com.larissacesar.gestao_vagas.exceptions.UserNotFoundException;
import br.com.larissacesar.gestao_vagas.modules.candidate.dto.ProfileCandidateRespondeDTO;
import br.com.larissacesar.gestao_vagas.modules.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateRespondeDTO execute(UUID idCandidate){
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw  new UserNotFoundException();
                });

        return ProfileCandidateRespondeDTO.builder()
                .description(candidate.getDescription())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();
    }
}
