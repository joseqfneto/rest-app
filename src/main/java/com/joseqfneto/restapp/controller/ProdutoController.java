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
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable Long id) {
        Optional<Produto> produto = produtoSevice.findById(id);
        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoSevice.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Object> post(@RequestBody @Valid ProdutoDto produtoDto) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoSevice.save(produto));
    }

    @PutMapping("/save/{id}")
    public ResponseEntity<Object> update(@RequestBody @Valid ProdutoDto produtoDto,
            @PathVariable(name = "id") Long id) {
        Optional<Produto> produtoOpt = produtoSevice.findById(id);

        if (produtoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }

        Produto produto = produtoOpt.get();
        BeanUtils.copyProperties(produtoDto, produto);
        produto.setId(id);

        return ResponseEntity.status(HttpStatus.OK).body(produtoSevice.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        Optional<Produto> produto = produtoSevice.findById(id);
        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Produto excluído!");
    }
}
