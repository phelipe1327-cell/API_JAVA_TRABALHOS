package org.serratec.aula03.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<String> erros = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            erros.add(error.getField() + ": " + error.getDefaultMessage());
        }

        ErroResposta erroResposta = new ErroResposta(
                status.value(),
                "Existem campos inválidos, confira o preenchimento",
                LocalDateTime.now(),
                erros
        );

        return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<String> erros = new ArrayList<>();

        erros.add("Erro na leitura do JSON. Verifique se os campos foram preenchidos corretamente.");
        erros.add("Para tipoCliente use PF ou PJ.");
        erros.add("Para statusCliente use ATIVO, INATIVO ou BLOQUEADO.");

        ErroResposta erroResposta = new ErroResposta(
                status.value(),
                "JSON inválido ou campo com valor incorreto",
                LocalDateTime.now(),
                erros
        );

        return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
    }
}