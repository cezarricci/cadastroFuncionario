package com.pagamentos.cadastrofuncionario.controller;

import com.pagamentos.cadastrofuncionario.dto.FuncionarioPostDto;
import com.pagamentos.cadastrofuncionario.dto.FuncionarioResponseDto;
import com.pagamentos.cadastrofuncionario.entity.Funcionario;
import com.pagamentos.cadastrofuncionario.service.FuncionarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService){ this.funcionarioService = funcionarioService;}

    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> save(@RequestBody FuncionarioPostDto funcionarioPost){

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioPost.getNome());
        funcionario.setEndereco(funcionarioPost.getEndereco());
        funcionario.setBonusSalarial(funcionarioPost.getBonusSalarial());
        funcionario.setDataContratacao(funcionarioPost.getDataContratacao());
        funcionario.setDataNascimento(funcionarioPost.getDataNascimento());

        //save

        funcionarioService.save(funcionario);

        FuncionarioResponseDto funcionarioResponse = new FuncionarioResponseDto();
        funcionarioResponse.setIdFuncionario(funcionario.getIdFuncionario());
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioResponse);

    }

   // @GetMapping(value = "/{idFuncionario}")
   // public FuncionarioPostDto getById()

}
