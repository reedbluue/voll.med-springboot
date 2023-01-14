package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medico")
public class MedicoController {

  @Autowired
  private MedicoRepository medicoRepository;

  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastroMedico dadosCadastroMedico) {
    medicoRepository.save(new Medico(dadosCadastroMedico));
  }

  @GetMapping
  public Page<DadosListagemMedico> listarTodos(@PageableDefault(size = 25, sort = {"nome"}) Pageable paginacao) {
    return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
  }

  @PutMapping
  @Transactional
  public Medico atualizar(@RequestBody @Valid DadosAtualizarMedico dados) {
    Medico medico = medicoRepository.findById(dados.id()).get();
    medico.atualizarDados(dados);
    return medico;
  }

  @DeleteMapping("/{id}")
  @Transactional
  public void deletar(@PathVariable Long id) {
    Medico medico = medicoRepository.findById(id).get();
    medico.desativar();
  }
}
