package com.joseqfneto.restapp.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.joseqfneto.restapp.dto.ProdutoDto;
import com.joseqfneto.restapp.entity.Produto;
import com.joseqfneto.restapp.service.ProdutoSevice;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoSevice produtoSevice;

    @GetMapping
    public ResponseEntity<Object> list() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoSevice.findAll());
    }

    
}
