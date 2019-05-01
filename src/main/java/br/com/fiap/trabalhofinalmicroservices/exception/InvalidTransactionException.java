package br.com.fiap.trabalhofinalmicroservices.exception;

public class InvalidTransactionException extends RuntimeException{
    public InvalidTransactionException() { super(); }
    public InvalidTransactionException(final String message) { super(message); }
}
