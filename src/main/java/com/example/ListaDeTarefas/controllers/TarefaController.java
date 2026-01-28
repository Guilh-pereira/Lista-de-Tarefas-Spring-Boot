package com.example.ListaDeTarefas.controllers;

import com.example.ListaDeTarefas.models.TarefaModel;
import com.example.ListaDeTarefas.repositories.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping({"", "/", "/home"})
    public String showHomePage(Model model) {
        model.addAttribute("tarefas", tarefaRepository.findAll());
        return "index";
    }

    @PostMapping("/criar")
    public String criar(@RequestParam String texto) {
        TarefaModel novaTarefa = TarefaModel.builder()
                .texto(texto)
                .ativo(false)
                .build();

        tarefaRepository.save(novaTarefa);
        return "redirect:/";
    }

    @GetMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id) {
        TarefaModel tarefaAtiva = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada: " + id));
        tarefaAtiva.setAtivo(!tarefaAtiva.getAtivo());
        tarefaRepository.save(tarefaAtiva);
        return "redirect:/";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        TarefaModel tarefaAtiva = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada: " + id));
        tarefaRepository.delete(tarefaAtiva);
        return "redirect:/";
    }
}
