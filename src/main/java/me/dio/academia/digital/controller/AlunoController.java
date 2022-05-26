package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public List<Aluno> getAll(){
        return service.getAll();
    }

    @GetMapping("/nascimento")
    public List<Aluno> getDataDeNascimento(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento){
        return service.getDataDeNascimento(dataDeNascimento);
    }
    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form){
        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id){
        return service.getAllAvaliacaoFisicaId(id);
    }

    //Precisa fazer o tratamento pois caso esteja associado ao Avaliação fisica vai retornar erro de FK
    @DeleteMapping("/{id}")
    public void  delete(@PathVariable Long id){
        service.delete(id);

    }
}