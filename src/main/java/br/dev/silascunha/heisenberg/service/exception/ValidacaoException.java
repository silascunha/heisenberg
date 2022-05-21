package br.dev.silascunha.heisenberg.service.exception;

public class ValidacaoException extends RuntimeException {

    public ValidacaoException(String msg) {
        super(msg);
    }

    public ValidacaoException(String msg, Throwable e) {
        super(msg, e);
    }
}
