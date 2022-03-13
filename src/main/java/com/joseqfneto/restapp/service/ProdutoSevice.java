package com.joseqfneto.restapp.service;

import com.joseqfneto.restapp.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoSevice {

    @Autowired
    ProdutoRepository produtoRepository;

    

}
