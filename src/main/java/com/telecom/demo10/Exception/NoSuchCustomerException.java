package com.telecom.demo10.Exception;


public class NoSuchCustomerException extends Exception {
    private static final long serialVersionUID = 1L;
    public NoSuchCustomerException() {
        super();
    }
    public NoSuchCustomerException(String errors) {
        super(errors);
    }
}
