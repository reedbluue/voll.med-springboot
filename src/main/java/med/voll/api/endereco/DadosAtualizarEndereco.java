package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizarEndereco(
    String logradouro,
    String bairro,
    @Pattern(regexp = "\\d{8}")
    String cep,
    String cidade,
    @Pattern(regexp = "[A-Z]{2}")
    String uf,
    String numero,
    String complemento
) {}
