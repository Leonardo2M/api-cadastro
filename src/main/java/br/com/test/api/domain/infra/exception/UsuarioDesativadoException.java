package br.com.test.api.domain.infra.exception;

public class UsuarioDesativadoException extends RuntimeException{

    public UsuarioDesativadoException(String msg) {
        super(msg);
    }
}
