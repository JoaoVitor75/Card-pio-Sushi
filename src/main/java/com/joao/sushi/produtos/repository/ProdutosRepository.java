package com.joao.sushi.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.sushi.produtos.orm.ProdutosORM;

public interface ProdutosRepository extends JpaRepository <ProdutosORM, String>{
    
}
