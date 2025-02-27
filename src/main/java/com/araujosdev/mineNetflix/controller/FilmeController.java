package com.araujosdev.mineNetflix.controller;

import com.araujosdev.mineNetflix.model.Filme;
import com.araujosdev.mineNetflix.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public String listarFilmes(Model model) {
        var filmes = filmeRepository.findAll();
        System.out.println("Filmes encontrados: " + filmes);
        model.addAttribute("filmes", filmes);
        return "index";
    }


    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionar(Model model) {
        model.addAttribute("filme", new Filme()); // Nome no singular
        return "adicionar-filme";
    }

    @PostMapping("/adicionar")
    public String adicionarFilme(@ModelAttribute Filme filme) {
        filmeRepository.save(filme);
        System.out.println("Filme salvo: " + filme); // Verificação no console
        return "redirect:/"; // Redireciona para a listagem
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Filme não encontrado"));
        model.addAttribute("filme", filme);
        return "editar-filme";
    }

    @PostMapping("/editar/{id}")
    public String editarFilme(@PathVariable Long id, @ModelAttribute Filme filme) {
        filme.setId(id);
        filmeRepository.save(filme);
        return "redirect:/";
    }

    @GetMapping("/excluir/{id}")
    public String excluirFilme(@PathVariable Long id) {
        filmeRepository.deleteById(id);
        return "redirect:/";
    }
}

