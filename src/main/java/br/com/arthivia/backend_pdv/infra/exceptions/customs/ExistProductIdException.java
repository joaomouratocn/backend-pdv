package br.com.arthivia.backend_pdv.infra.exceptions.customs;

public class ExistProductIdException extends RuntimeException{
    public ExistProductIdException(String message){super(message);}
}
