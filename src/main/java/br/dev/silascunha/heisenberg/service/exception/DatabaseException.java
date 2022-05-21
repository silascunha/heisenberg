package br.dev.silascunha.heisenberg.service.exception;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String msg) {
        super(msg);
    }

    public DatabaseException(String msg, Throwable e) {
        super(msg, e);
    }
}
