package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api") //URI de acesso
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*") //Com o * permito que qualquer dominio acesse minha api, mas acaso seja para um especifico usasse o dominio ex: /http:www.google.com
public class ProdutoResource {
    //Injeção da classe ProdutoRepository para uso do BD(Para que possamos usar os métodos e conectar ao BD)
    @Autowired
    ProdutoRepository produtoRepository;

    //Método que retorna todos os produtos em uma lista
    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna lista de produtos")
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    } 

    //Método que retorna um produto pelo seu id
    @GetMapping("/produtos/{id}")
    @ApiOperation(value = "Retorna um produto único pelos seu id")
    public Produto listarProdutoUnico(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id); //findById método usado para realizar essa consulta foi declarado na classe ProdutoRepository
    }

    @PostMapping("/produtos")
    @ApiOperation(value = "Salva um produto")
    public Produto salvarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produtos")
    @ApiOperation(value = "Deleta um produto")
    public void deletarProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    @PutMapping("/produtos")
    @ApiOperation(value = "Atualiza um produto")
    public Produto atualizarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);

    }

}


