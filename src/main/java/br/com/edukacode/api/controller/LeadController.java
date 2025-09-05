package br.com.edukacode.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edukacode.api.dto.DadosAtualizacaoLead;
import br.com.edukacode.api.dto.DadosCadastroLead;
import br.com.edukacode.api.dto.DadosListagemLead;
import br.com.edukacode.api.entities.Lead;
import br.com.edukacode.api.repository.LeadRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/lead")
public class LeadController {

    //Injeção de dependência
    @Autowired
    private LeadRepository repository;

    @PostMapping
    public String criarLead(@RequestBody @Valid DadosCadastroLead dados) {
        System.out.println("Lead cria com os dados: " + dados);
        repository.save(new Lead(null, dados.nome(), dados.email(), dados.telefone(), dados.cpf()));
        return "Lead criado com sucesso!";
    }

    @GetMapping
    public Page<DadosListagemLead> listarLeads(@PageableDefault(size = 25, sort = {"email"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemLead::new);
    }

    @PutMapping
    @Transactional
    public void atulizarLead(@RequestBody DadosAtualizacaoLead dados) {
        var lead = repository.getReferenceById(dados.id());
        lead.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirLead(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
