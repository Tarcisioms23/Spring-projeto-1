package com.projetos.projeto1.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.projeto1.repository.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.projetos.projeto1.models.Produto;

@RestController
@RequestMapping(value="/api/projeto_1")
@Api(value ="API - REST PRODUTOS")
@CrossOrigin(origins = "*")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Esse Metodo Retorna Lista de produtos")
	public List<Produto> listProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Esse Metodo Retorna produto por id")
	public Produto idProduto(@PathVariable(value ="id") long id){
		return produtoRepository.findById(id);
	}
	
	
	@PostMapping("/produto")
	@ApiOperation(value = "Esse Metodo que salva um produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value = "Esse Metodo atualiza um produto")
	public Produto alteraProduto(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value = "Esse Metodo deleta um produto")
	public String deleteProduto(@RequestBody Produto produto) {
		 produtoRepository.delete(produto);
		 return "Produto deletado com sucesso";
	}
}
