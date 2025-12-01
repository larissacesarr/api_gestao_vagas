package br.com.larissacesar.gestao_vagas.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateRespondeDTO {

    @Schema(example = "Desenvolvedora Full Stack com 5 anos de experiência em Java e React.")
    private String description;

    @Schema(example = "maria_silva")
    private String username;

    @Schema(example = "maria@gmail.com")
    private String email;
    private UUID id;

    @Schema(example = "Maria Silva")
    private String name;
}
