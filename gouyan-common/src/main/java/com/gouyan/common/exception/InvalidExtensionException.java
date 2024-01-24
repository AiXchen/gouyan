package com.gouyan.common.exception;

/**
 * @author Aixchen
 * @date 2024/1/24 17:43
 */
public class InvalidExtensionException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public InvalidExtensionException(){

    }

    public InvalidExtensionException(String message){
        super(message);
    }

}
