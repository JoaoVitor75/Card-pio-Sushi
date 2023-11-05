package com.joao.sushi.produtos.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.joao.sushi.produtos.dto.ProdutosDTO;
import com.joao.sushi.produtos.orm.ProdutosORM;

@Component
public class ProdutosConverter {

    public ProdutosORM dtoToOrm(ProdutosDTO dto, ProdutosORM orm) {
        if (dto.getId() != null) {
            orm.setId((dto.getId()));
        }
        orm.setNome(dto.getNome());
        orm.setDescricao(dto.getDescricao());
        orm.setPreco(dto.getPreco());
        orm.setDisponivel(dto.isDisponivel());
        return orm;
    }

    public ProdutosORM dtoToOrm(ProdutosDTO dto) {
        return dtoToOrm(dto, new ProdutosORM());
    }

    public ProdutosDTO ormToDto(ProdutosORM orm, ProdutosDTO dto) {

        dto.setId(orm.getId());
        dto.setNome(orm.getNome());
        dto.setDescricao(orm.getDescricao());
        dto.setPreco(orm.getPreco());
        dto.setDisponivel(orm.isDisponivel());
        return dto;
    }

    public ProdutosDTO ormToDto(ProdutosORM orm) {
        return ormToDto(orm, new ProdutosDTO());
    }

    public List<ProdutosORM> dtoListToOrmList(List<ProdutosDTO> dtoList) {
        if (dtoList == null)
            return null;
        return dtoList.stream().map(this::dtoToOrm).collect(Collectors.toList());
    }

    public List<ProdutosDTO> ormListToDtoList(List<ProdutosORM> ormList) {
        if (ormList == null)
            return null;
        return ormList.stream().map(this::ormToDto).collect(Collectors.toList());
    }

}
