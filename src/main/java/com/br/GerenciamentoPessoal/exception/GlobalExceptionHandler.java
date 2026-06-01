package com.br.GerenciamentoPessoal.exception;

import com.br.GerenciamentoPessoal.dto.ErroRespostaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroRespostaDTO> tratarNaoEncontrado(
            RecursoNaoEncontradoException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        new ErroRespostaDTO(
                                ex.getMessage(),
                                HttpStatus.NOT_FOUND.value()
                        )
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroRespostaDTO> tratarValidacao(
            MethodArgumentNotValidException ex) {

        String mensagem = ex.getBindingResult()
                .getFieldError() != null
                ? ex.getBindingResult().getFieldError().getDefaultMessage()
                : "Dados inválidos";

        return ResponseEntity.badRequest()
                .body(
                        new ErroRespostaDTO(
                                mensagem,
                                HttpStatus.BAD_REQUEST.value()
                        )
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroRespostaDTO> tratarErroGenerico(
            Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        new ErroRespostaDTO(
                                "Erro interno do servidor",
                                HttpStatus.INTERNAL_SERVER_ERROR.value()
                        )
                );
    }
}