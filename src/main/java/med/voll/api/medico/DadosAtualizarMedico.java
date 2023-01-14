package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosAtualizarEndereco;

public record DadosAtualizarMedico(
    @NotNull
    Long id,
    String nome,
    @Pattern(regexp = "\\d{11}")
    String telefone,
    @Valid
    DadosAtualizarEndereco endereco
) {}
