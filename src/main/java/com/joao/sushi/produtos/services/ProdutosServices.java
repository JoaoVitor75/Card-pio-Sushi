package com.joao.sushi.produtos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.sushi.produtos.converter.ProdutosConverter;
import com.joao.sushi.produtos.dto.ProdutosDTO;
import com.joao.sushi.produtos.orm.ProdutosORM;
import com.joao.sushi.produtos.repository.ProdutosRepository;

@Service
public class ProdutosServices {
    @Autowired
    private ProdutosRepository repository;

    @Autowired
    private ProdutosConverter converter;

    public ProdutosDTO findByid(Long id) {
        ProdutosORM produtosORM = repository.findById(id.toString()).get();
        ProdutosDTO produtosDTO = converter.ormToDto(produtosORM);
        return produtosDTO;
    };

    public ProdutosDTO createDto(ProdutosDTO produtosDTO) {
        ProdutosORM produtosORM = converter.dtoToOrm(produtosDTO);
        repository.save(produtosORM);
        return converter.ormToDto(produtosORM,produtosDTO);
    }

}
