package com.joao.sushi.produtos.services;

import java.util.ArrayList;
import java.util.List;

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
        return converter.ormToDto(produtosORM, produtosDTO);
    }

    public List<ProdutosDTO> getAll() {
        List<ProdutosORM> produtosORMList = repository.findAll();
        List<ProdutosDTO> produtosDTOList = new ArrayList<>();

        for (ProdutosORM produtosORM : produtosORMList) {
            ProdutosDTO produtosDTO = converter.ormToDto(produtosORM);
            produtosDTOList.add(produtosDTO);
        }

        return produtosDTOList;

    }

    public void deleteById(Long id) {
        repository.deleteById(id.toString());
    }

    public ProdutosDTO updateById(ProdutosDTO produtosDTO) {
        ProdutosORM produtosORM = repository.findById(produtosDTO.getId().toString()).orElse(null);

        if (produtosORM != null) {
            converter.dtoToOrm(produtosDTO, produtosORM);
            repository.save(produtosORM);
            return produtosDTO;
            
        } else {
            // Tratar o caso em que o produto com o ID fornecido não foi encontrado
            return null; // Ou lançar uma exceção, dependendo do que deseja fazer
        }
    }
}
