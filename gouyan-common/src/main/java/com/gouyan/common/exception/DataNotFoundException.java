package com.gouyan.common.exception;

/**
 * @author Aixchen
 * @date 2024/1/24 17:43
 */
public class DataNotFoundException extends RuntimeException{

    static final long serialVersionUID = -7034897190745456227L;

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
