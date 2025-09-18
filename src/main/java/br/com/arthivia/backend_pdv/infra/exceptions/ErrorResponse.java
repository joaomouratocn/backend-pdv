package br.com.arthivia.backend_pdv.infra.exceptions;

public record ErrorResponse(
        int statusCode,
        String message
){}
