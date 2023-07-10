package br.com.test.api.domain.exception;

public class UsuarioDesativadoException extends RuntimeException{

    public UsuarioDesativadoException(String msg) {
        super(msg);
    }
}
