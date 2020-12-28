package com.joaovfsousa.bank_account_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidDataException extends RuntimeException {

    public InvalidDataException() {
        super(String.format("Invalid data. Check for duplicated cpfs and e-mails"));
    }
}