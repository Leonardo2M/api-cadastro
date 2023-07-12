package br.com.test.api.domain.infra.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

    public EntidadeNaoEncontradaException(String msg) {
        super(msg);
    }
}
