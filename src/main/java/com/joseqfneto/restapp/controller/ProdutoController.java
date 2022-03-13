package com.joseqfneto.restapp.controller;

import com.joseqfneto.restapp.service.ProdutoSevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoSevice produtoSevice;

    
}
