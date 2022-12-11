package com.example.demo.domain.exception;

/**
 * リソースが見つからない場合の例外
 */
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 12325345353566L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
