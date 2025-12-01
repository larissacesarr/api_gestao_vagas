package br.com.larissacesar.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobDTO {

    @Schema(example = "Vaga para desenvolvedor Java Pleno", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "Gympass, plano de saude", requiredMode = Schema.RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "PLENO", requiredMode = Schema.RequiredMode.REQUIRED)
    private String level;
}
