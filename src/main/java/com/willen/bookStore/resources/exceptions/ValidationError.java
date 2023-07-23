package com.willen.bookStore.resources.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(LocalDateTime timestemp, Integer status, String error, String path) {
        super(timestemp, status, error, path);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addErros(String fieldName, String message) {
        this.erros.add(new FieldMessage(fieldName, message));
    }
}
