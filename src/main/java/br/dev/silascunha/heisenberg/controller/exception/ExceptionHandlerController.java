package br.dev.silascunha.heisenberg.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import br.dev.silascunha.heisenberg.service.exception.DatabaseException;
import br.dev.silascunha.heisenberg.service.exception.ValidacaoException;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.dev.silascunha.heisenberg.service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ControllerAdvice
public class ExceptionHandlerController {
    

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RespostaErro> recursoNaoEncontrado(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        RespostaErro respostaErro = RespostaErro.builder()
                .erro("Recurso não encontrado")
                .mensagem(e.getMessage())
                .momento(Instant.now())
                .caminho(request.getRequestURI())
                .status(status.value())
                .build();

        return ResponseEntity.status(status).body(respostaErro);
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<RespostaErro> validacaoException(ValidacaoException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        RespostaErro respostaErro = RespostaErro.builder()
                .erro("Erro de validação")
                .mensagem(e.getMessage())
                .momento(Instant.now())
                .caminho(request.getRequestURI())
                .status(status.value())
                .build();

        return ResponseEntity.status(status).body(respostaErro);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<RespostaErro> validacaoException(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        RespostaErro respostaErro = RespostaErro.builder()
                .erro("Erro de banco de dados")
                .mensagem(e.getMessage())
                .momento(Instant.now())
                .caminho(request.getRequestURI())
                .status(status.value())
                .build();

        return ResponseEntity.status(status).body(respostaErro);
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class RespostaErro {

        private String erro;
        private String mensagem;
        private String caminho;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        private Instant momento;
        private Integer status;

    }
}
