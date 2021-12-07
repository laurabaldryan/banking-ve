package edu.tumo.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such bank")  // 404
public class BankNotFoundException extends RuntimeException {

    public BankNotFoundException() {
        super("Bank not found.");
    }

    public BankNotFoundException(Throwable e) {
        super("Bank not found.", e);
    }
}
