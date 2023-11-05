package com.joao.sushi.produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.sushi.produtos.dto.ProdutosDTO;
import com.joao.sushi.produtos.services.ProdutosServices;

@RestController
@RequestMapping(value = "/Menu")
public class ProdutosController {
    @Autowired
    private ProdutosServices services;

    @GetMapping(value = "/{id}")
    public ProdutosDTO findById(@PathVariable Long id) {
        return services.findByid(id);
    }

    @PostMapping
    public ResponseEntity creaEntity(@RequestBody ProdutosDTO cProdutosDTO) {
        return ResponseEntity.ok().body(services.createDto(cProdutosDTO));
    }

    @GetMapping
    public List<ProdutosDTO> getAll() {
        return services.getAll();
    }

}
