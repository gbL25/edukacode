package br.com.edukacode.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DadosListagemLead> listarLeads() {
        return repository.findAll().stream().map(DadosListagemLead::new).toList();
    }

    @PutMapping
    public void atulizarLead() {

    }

    @DeleteMapping
    public void excluirLead() {

    }
}
