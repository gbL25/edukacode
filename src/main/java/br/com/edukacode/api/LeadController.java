package br.com.edukacode.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        repository.save(new Lead(null, dados.nome(),dados.email(),dados.telefone(), dados.cpf()));
        return "Lead criado com sucesso!";
    }

    @GetMapping
    public Page<DadosListagemLead> listarLeads(@PageableDefault(size= 5, sort={"nome"})Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemLead::new);
    }

    @PutMapping
    public void atulizarLead() {

    }

    @DeleteMapping
    public void excluirLead() {

    }
}
